package by.kizin.konstantin.resttask.service.client;

import java.util.Optional;

public class OnlinePbxClientImpl  {

    public String method1(String dateStart,String dateEnd,String validate) throws MyCustomException {
        validate(validate,method1());
        return method1().getMethod(dateStart,dateEnd);
    }

    public void method2(String x, String y){
        method2().getMethod(x,y);
    }

    private MyFunctionInterface<Optional> method2(){
        return new MyFunctionInterface<Optional>() {
            @Override
            public Optional getMethod(String... params) {
                System.out.println("method2 make!");
                return Optional.empty();
            }
        };
    }

    private MyFunctionInterface<String> method1(){
        return new MyFunctionInterface<String>() {
            @Override
            public String getMethod(String... params) {
                return String.valueOf(params.length);
            }
        };
    }

    public void validate(Object response, MyFunctionInterface method, String... methodParams) throws MyCustomException {
        if(response.equals("throw")){
            throw new MyCustomException(method,methodParams);
        }
    }




    public static void main(String[] args) throws MyCustomException {

        OnlinePbxClientImpl client = new OnlinePbxClientImpl();

        try {
            client.method1("A","B","throw");
        } catch (MyCustomException e) {
            String s = client.method1("A", "B", "Not");
            System.out.println(s);
        }
    }

}
