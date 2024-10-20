package com.codes.SpringBoot.Response;

public class ResponseObj {
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseObj(String message) {
        this.message = message;
    }
}
