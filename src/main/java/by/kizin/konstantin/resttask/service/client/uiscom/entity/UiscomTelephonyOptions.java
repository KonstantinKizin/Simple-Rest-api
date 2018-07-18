package by.kizin.konstantin.resttask.service.client.uiscom.entity;

import java.io.Serializable;
import java.util.Date;

public class UiscomTelephonyOptions implements Serializable {

    private String login;

    private String password;

    private String accessToken;

    private int id;

    private Date expiredAt;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    @Override
    public String toString() {
        return "UiscomTelephonyOptions{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", id=" + id +
                ", expiredAt=" + expiredAt +
                '}';
    }
}
