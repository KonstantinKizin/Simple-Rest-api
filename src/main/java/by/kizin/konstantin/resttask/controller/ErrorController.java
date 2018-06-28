package by.kizin.konstantin.resttask.controller;

import by.kizin.konstantin.resttask.entity.errorModel.ErrorResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @Autowired
    private ErrorAttributes attributes;

    private final static String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    public ErrorResponseObject error(HttpServletRequest request){
        return buildErrorResponseObject(request);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }


    private ErrorResponseObject buildErrorResponseObject(HttpServletRequest request){

        RequestAttributes requestAttributes = new ServletWebRequest(request);

        Map<String, Object> errorAttributes = this.attributes.getErrorAttributes((WebRequest) requestAttributes, true);

        ErrorResponseObject errorResponseObject = new ErrorResponseObject();
        errorResponseObject.setTimeStamp(errorAttributes.get("timestamp").toString());
        errorResponseObject.setStatus((Integer)errorAttributes.get("status"));
        errorResponseObject.setError((String) errorAttributes.get("error"));
        errorResponseObject.setMessage((String) errorAttributes.get("message"));
        errorResponseObject.setPath((String) errorAttributes.get("path"));

        return errorResponseObject;
    }
}
