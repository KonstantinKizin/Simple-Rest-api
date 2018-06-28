package by.kizin.konstantin.resttask.controller;

import by.kizin.konstantin.resttask.entity.errorModel.ErrorResponseObject;
import by.kizin.konstantin.resttask.entity.errorModel.SubError;
import by.kizin.konstantin.resttask.entity.errorModel.ValidationErrorObject;
import by.kizin.konstantin.resttask.entity.User;
import by.kizin.konstantin.resttask.entity.UserStatus;
import by.kizin.konstantin.resttask.service.UpdateUserStatusResult;
import by.kizin.konstantin.resttask.service.UserService;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalTime;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public @ResponseBody  ResponseEntity<? extends Object> addUser(@ModelAttribute("user") @Valid User user,
                                                                   BindingResult result,
    HttpServletRequest request){

        if(result.hasErrors()){
            ErrorResponseObject responseObject = buildValidationErrorResponseObject(result,request);

            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
        }

        User newUser = service.addUser(user);
        return new ResponseEntity<>(newUser.getId(),HttpStatus.CREATED);
    }



    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable("id") Long id){
        User user = service.getUserById(id);
        return user;
    }



    @RequestMapping(value = "/update/{id}/{status}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<? extends Object> updateUserStatus(@PathVariable("id") Long id, @PathVariable("status")UserStatus status){
            UpdateUserStatusResult result = null;
            result = service.changeUserStatus(id,status);
            return new ResponseEntity<>(result,HttpStatus.OK);

    }


    @RequestMapping(value = "/add" , method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
    public String addUserPage(@ModelAttribute("user") User user, HttpServletResponse response
    ){
        return "addUser";
    }



    private ErrorResponseObject buildValidationErrorResponseObject(BindingResult result,
                                                         HttpServletRequest request){
        ErrorResponseObject responseObject = new ErrorResponseObject();
        responseObject.setStatus(404);
        responseObject.setPath(request.getContextPath());
        responseObject.setError("Validation Error");
        responseObject.setTimeStamp(LocalTime.now().toString());
        responseObject.setMessage("Some field do not valid");

        ArrayList<SubError> subErrors
                = new ArrayList<>();

        result.getFieldErrors().forEach(fieldError -> {
            SubError validationObject = new ValidationErrorObject(
                    fieldError.getObjectName(),
                    fieldError.getField(),
                    fieldError.getRejectedValue(),
                    fieldError.getDefaultMessage()
            );
            subErrors.add(validationObject);
        });

        responseObject.setSubErrors(subErrors);
        return responseObject;
    }



}
