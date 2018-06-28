package by.kizin.konstantin.resttask.controller.exceptionHandler;

import by.kizin.konstantin.resttask.entity.errorModel.*;
import by.kizin.konstantin.resttask.repository.exception.EntityAlreadyExistException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

 @ExceptionHandler({EntityNotFoundException.class})
 public ResponseEntity<ErrorResponseObject> handleEntityNotFound(EntityNotFoundException ex, HttpServletRequest request
                                                                  ){

     ErrorResponseObject errorResponseObject = new ErrorResponseObject();
     errorResponseObject.setPath(request.getServletPath());
     errorResponseObject.setStatus(404);
     errorResponseObject.setError("NOT FOUND");
     errorResponseObject.setMessage(ex.getMessage());
     errorResponseObject.setTimeStamp(LocalTime.now().toString());
     SubError subError = new EntityNotFoundObject(
             HttpStatus.NOT_FOUND,
             ex.getMessage(),
             ex.getCause());
     return new ResponseEntity<ErrorResponseObject>(errorResponseObject,HttpStatus.NOT_FOUND);
 }

    @ExceptionHandler({EntityAlreadyExistException.class})
    public ResponseEntity<EntityAlreadyExistObject> handleUserAlreadyExist(EntityAlreadyExistException ex){
        return new ResponseEntity<>(
            new EntityAlreadyExistObject(ex.getObjectName(),
                                         ex.getFieldName(),
                                         ex.getMessage(),
                                         HttpStatus.BAD_REQUEST),
                                         HttpStatus.BAD_REQUEST);
 }

    @Override
    public ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ErrorResponseObject errorResponseObject = new ErrorResponseObject();

        errorResponseObject.setMessage(ex.getMessage());
        errorResponseObject.setStatus(400);
        errorResponseObject.setError(ex.getErrorCode());
        errorResponseObject.setPath(request.getContextPath());

        MisMatchTypeErrorObject misMatchTypeErrorObject
                = new MisMatchTypeErrorObject((String) ex.getValue(),ex.getRequiredType().getName());

        List<SubError> subErrors = new ArrayList<>(1);
        subErrors.add(misMatchTypeErrorObject);
        errorResponseObject.setSubErrors(subErrors);
        return new ResponseEntity<>(errorResponseObject,HttpStatus.BAD_REQUEST);
    }







}
