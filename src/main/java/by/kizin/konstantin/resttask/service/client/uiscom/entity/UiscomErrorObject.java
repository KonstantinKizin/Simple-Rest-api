package by.kizin.konstantin.resttask.service.client.uiscom.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UiscomErrorObject implements Serializable {

    private final String jsonrpc = "2.0";

    private int id;

    private int code;

    private String message;

    @JsonProperty("value")
    private String errorValue;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorValue() {
        return errorValue;
    }

    public void setErrorValue(String errorValue) {
        this.errorValue = errorValue;
    }

    @Override
    public String toString() {
        return "UiscomErrorObject{" +
                "jsonrpc='" + jsonrpc + '\'' +
                ", id=" + id +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", errorValue='" + errorValue + '\'' +
                '}';
    }
}
