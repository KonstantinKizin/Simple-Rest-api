package by.kizin.konstantin.resttask.entity.errorModel;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ErrorResponseObject {

    private String timeStamp;

    private Integer status;

    private String error;

    private String message;

    private String path;

    private List<? super SubError> subErrors = new ArrayList<>();

    public ErrorResponseObject(String timeStamp, Integer status, String error, String message, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }


    public ErrorResponseObject(){}

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<? super SubError> getSubErrors() {
        return new ArrayList<>(subErrors);
    }

    public void setSubErrors(List<? super SubError> subErrors) {
        this.subErrors = subErrors;
    }

    @Override
    public String toString() {
        return "ErrorResponseObject{" +
                "timeStamp='" + timeStamp + '\'' +
                ", status=" + status +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", subErrors=" + subErrors +
                '}';
    }
}
