package com.example.jwt.lib;

import java.util.HashMap;
import java.util.Map;

public class ResSend {
    private boolean status;
    private int statusCode;
    private String message;
    private Object data;
    private Object token;

    public ResSend(boolean status, int statusCode, String message, Object data, Object token) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
        this.token = token;
    }

//    public Object getRes() {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("status", status);
//        map.put("statusCode", statusCode);
//        map.put("message", message);
//        map.put("data", data);
//        return map;
//    }

    public boolean isStatus() {
        return status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public Object getToken() {
        return token;
    }
}
