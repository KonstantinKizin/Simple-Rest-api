package by.kizin.konstantin.resttask.entity.errorModel;

import org.springframework.http.HttpStatus;

public class EntityAlreadyExistObject extends SubError {

    private String fieldName;

    private String objectName;

    private String message;

    private HttpStatus status;

    public EntityAlreadyExistObject(String fieldName, String objectName, String message, HttpStatus status) {
        this.fieldName = fieldName;
        this.objectName = objectName;
        this.message = message;
        this.status = status;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
