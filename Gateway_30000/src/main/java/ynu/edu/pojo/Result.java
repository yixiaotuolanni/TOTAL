package ynu.edu.pojo;

import org.springframework.http.HttpStatus;

public class Result {
    HttpStatus status;
    String token;
    Object Message;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getMessage() {
        return Message;
    }

    public void setMessage(Object message) {
        Message = message;
    }
}
