package by.kizin.konstantin.resttask.service.client;

import by.kizin.konstantin.resttask.service.client.command.TelepthonyOptions;

import java.util.function.Function;

public class AuthExpiredException extends RuntimeException {

    private Function function;

    private TelepthonyOptions options;

    private String body;

    public AuthExpiredException(String body, Function function, TelepthonyOptions options){
        this.function = function;
        this.options = options;
        this.body = body;
    }

    public Function getFunction() {
        return function;
    }

    public TelepthonyOptions getOptions() {
        return options;
    }

    public String getBody() {
        return body;
    }
}
