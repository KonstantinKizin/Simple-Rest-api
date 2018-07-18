package by.kizin.konstantin.resttask.service.client.uiscom.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AuthResponse implements Serializable {

    private final String jsonrpc = "2.0";

    private int id;

    @JsonProperty("access_token")
    private String accessToken;

    private long expire;

    @JsonProperty("app_id")
    private long appId;


    public String getJsonrpc() {
        return jsonrpc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "jsonrpc='" + jsonrpc + '\'' +
                ", id=" + id +
                ", accessToken='" + accessToken + '\'' +
                ", expire=" + expire +
                ", appId=" + appId +
                '}';
    }
}
