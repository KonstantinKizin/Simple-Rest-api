package by.kizin.konstantin.resttask.entity.errorModel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ValidationErrorObject extends SubError {

    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    public ValidationErrorObject(String object, String message) {
        this.object = object;
        this.message = message;
    }

    public ValidationErrorObject(String object, String field, Object rejectedValue, String message) {
        this.object = object;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValidationErrorObject that = (ValidationErrorObject) o;

        if (object != null ? !object.equals(that.object) : that.object != null) return false;
        if (field != null ? !field.equals(that.field) : that.field != null) return false;
        if (rejectedValue != null ? !rejectedValue.equals(that.rejectedValue) : that.rejectedValue != null)
            return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = object != null ? object.hashCode() : 0;
        result = 31 * result + (field != null ? field.hashCode() : 0);
        result = 31 * result + (rejectedValue != null ? rejectedValue.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ValidationErrorObject{" +
                "object='" + object + '\'' +
                ", field='" + field + '\'' +
                ", rejectedValue=" + rejectedValue +
                ", message='" + message + '\'' +
                '}';
    }
}
