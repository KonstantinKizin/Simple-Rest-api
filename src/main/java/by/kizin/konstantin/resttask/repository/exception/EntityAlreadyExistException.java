package by.kizin.konstantin.resttask.repository.exception;

public class EntityAlreadyExistException extends RepositoryException {

    private String objectName;

    private String fieldName;

    private String fieldValue;

    public EntityAlreadyExistException() {
        super();
    }

    public EntityAlreadyExistException(String message) {
        super(message);
    }

    public EntityAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityAlreadyExistException(Throwable cause) {
        super(cause);
    }

    protected EntityAlreadyExistException(String message, Throwable cause,
                                  boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public EntityAlreadyExistException(String message, Throwable cause, String objectName,String field,String fieldValue) {
        super(message, cause);
        this.objectName = objectName;
        this.fieldName = field;
        this.fieldValue = fieldValue;
    }

    public EntityAlreadyExistException(String objectName,String field,String fieldValue){
        this.objectName = objectName;
        this.fieldName = field;
        this.fieldValue = fieldValue;
    }

    @Override
    public String getMessage() {
        return objectName+" with "+fieldName+" ='"+fieldValue+"' already exists.";
    }

    public String getObjectName() {
        return objectName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }


}
