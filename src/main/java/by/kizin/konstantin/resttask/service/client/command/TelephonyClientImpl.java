package by.kizin.konstantin.resttask.service.client.command;
import by.kizin.konstantin.resttask.service.client.AuthExpiredException;
import com.sun.deploy.net.HttpResponse;
import java.util.Date;
import java.util.function.Function;


public class TelephonyClientImpl implements TelephocyClient {

    @Override
    public TelephocyHistory getHistoryByUuid(String UUID, TelepthonyOptions options) throws Exception {

            String body = "Some body";
            System.out.println("1) making request from GetHistoryMethod!");

            Function<String,HttpResponse> function = makePostRequest(options);
            HttpResponse response = function.apply(body);
            System.out.println("Response is ready?");
            return null;

    }

    @Override
    public TelephonyRecord getRecordByUuid(String UUI, TelepthonyOptions options) throws Exception {
        return null;

    }


    @Override
    public TelephocyHistory getHistoryByStartAndFinishDates(Date start, Date end, TelepthonyOptions options) throws Exception {

        String body = "Body";
        HttpResponse response = makePostRequest(options).apply(body);
        System.out.println("Response is ready!!");
        return null;

    }



    public void auth(TelepthonyOptions options){
        options.auth = true;

    }



    private void validate(HttpResponse response, TelepthonyOptions options ,  Function function, String body)  {

        if(!options.auth) {
            System.out.println("5)Validate is fail!");
            System.out.println("6)Auth is false! throw exception");
            throw new AuthExpiredException(body, function, options);
        }else {
            System.out.println("Auth is true, all ok!");
        }
    }


    private Function<String,HttpResponse> makePostRequest(TelepthonyOptions options) {

        Function<String,HttpResponse> function = body1 -> {

            System.out.println("2) Creating request with options = "+options.auth);
            System.out.println("3) Adding body body");
            System.out.println("4) Make post request and get some response.");
            HttpResponse response = null;
            validate(response,options,makePostRequest(options), body1);
            System.out.println("Validate passed!");
            return response;

        };
        return function;
    }




    public void handler(AuthExpiredException ex, TelephonyClientImpl
                         client){
        System.out.println("5)Exception was handled!!");
        TelepthonyOptions telepthonyOptions = ex.getOptions();
        client.auth(telepthonyOptions);
        System.out.println("6)Options : "+telepthonyOptions.auth);
        Function<String,HttpResponse> function = ex.getFunction();
        String body = ex.getBody();
        HttpResponse response = function.apply(body);
        System.out.println("7) Got response");


    }


    public static void main(String[] args) throws Exception {

        TelephonyClientImpl client = new TelephonyClientImpl();

        try {
            TelepthonyOptions options = new TelepthonyOptions();
            TelephocyHistory hostory = client.getHistoryByUuid("anyUUid", options);
        }catch (AuthExpiredException ex){
            System.out.println("Handle exception!");
            client.handler(ex,client);
        }

        System.out.println("History got!");

    }
}
