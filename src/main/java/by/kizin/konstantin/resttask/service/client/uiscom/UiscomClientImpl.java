package by.kizin.konstantin.resttask.service.client.uiscom;

import by.kizin.konstantin.resttask.service.client.uiscom.entity.AuthResponse;
import by.kizin.konstantin.resttask.service.client.uiscom.entity.Methods;
import by.kizin.konstantin.resttask.service.client.uiscom.entity.RequestObject;
import by.kizin.konstantin.resttask.service.client.uiscom.entity.UiscomTelephonyOptions;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class UiscomClientImpl implements UiscomClient {


    private final static String PARAMETER_ACCESS_TOKEN = "access_token";

    private final static String PARAMETER_USER_ID = "user_id";

    @Override
    public void authorization(final UiscomTelephonyOptions options) {

        try {

            final Map<String, Object> params = new HashMap<>();
            params.put("login", options.getLogin());
            params.put("password", options.getPassword());

            RequestObject requestObject = new RequestObject();
            requestObject.setMethod(Methods.LOGIN);
            requestObject.setParams(params);
            HttpResponse response = makePostRequest(requestObject);
            String responseEntityAsString = getEntityAsJson(response);
            AuthResponse authResponse = new ObjectMapper().readValue(responseEntityAsString, AuthResponse.class);

            Integer id = authResponse.getId();
            String token = authResponse.getAccessToken();

            if(id==null || token == null){
                throw new UiscomAuthException();
            }

            options.setAccessToken(token);
            options.setId(id);

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public String[] getVirtualNumbersForSipLine(UiscomTelephonyOptions options) {

        try {
            final Map<String, Object> params = getMapWithMandatoryParams(options);

            RequestObject requestObject = new RequestObject();
            requestObject.setMethod(Methods.GET_SIP_LINE_VIRTUAL_NUMBERS);
            requestObject.setParams(params);
            HttpResponse response = makePostRequest(requestObject);
            String responseEntityAsString = getEntityAsJson(response);
            String[] virtualNumbers = new ObjectMapper().readValue(responseEntityAsString, String[].class);
            return virtualNumbers;

        }catch (Exception e){
            return null;
        }

    }




    private HttpResponse makePostRequest(final RequestObject requestObject){
        return null;
    }

    private String getEntityAsJson(final HttpResponse response){
        return null;
    }

    private Map<String,Object> getMapWithMandatoryParams(UiscomTelephonyOptions options){

        final Map<String,Object> map = new HashMap<>();
        map.put(PARAMETER_ACCESS_TOKEN,options.getAccessToken());
        map.put(PARAMETER_USER_ID,options.getId());
        return map;

    }


}
