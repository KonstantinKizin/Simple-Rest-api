package by.kizin.konstantin.resttask.service.client;
import java.util.Optional;


public class MyCustomException extends Exception {


    private final MyFunctionInterface functional;
    private final String[] methodParams;

    public MyCustomException(MyFunctionInterface functionInterface, String... methodParams){
        this.functional = functionInterface;
        this.methodParams = methodParams;
    }

    public MyFunctionInterface getFunctional() {
        return functional;
    }

    public String[] getMethodParams() {
        return methodParams;
    }
}
