package com.chen.entity;

import java.io.Serializable;

/**
 * Created by tian on 2017/5/16 上午11:03
 */
public class JsonResult implements Serializable{

    private int success;
    private Object data;
    private String message;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonResult() {
        success = 1;
        data = null;
        message = null;
    }

    public JsonResult(int success, Object data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }
}
