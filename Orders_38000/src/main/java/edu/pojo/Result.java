package edu.pojo;

import org.springframework.http.HttpStatus;

public class Result<T> {
    HttpStatus status;
    String token;
    T Message;

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

    public void setMessage(T message) {
        Message = message;
    }
}
