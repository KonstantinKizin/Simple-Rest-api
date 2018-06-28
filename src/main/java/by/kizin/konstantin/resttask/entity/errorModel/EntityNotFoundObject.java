package by.kizin.konstantin.resttask.entity.errorModel;

import org.springframework.http.HttpStatus;

public class EntityNotFoundObject extends SubError {

    private HttpStatus status;

    private String message;

    private String objectName;


    EntityNotFoundObject(){
    }

    public EntityNotFoundObject(HttpStatus status) {

        this.status = status;
    }

    public EntityNotFoundObject(HttpStatus status, Throwable ex) {
        this.status = status;
        this.message = "Unexpected error";
    }

    public EntityNotFoundObject(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }


}
