package com.lyj.xh.net.exception;

/**
 * Created by lyj on 2017/3/27 0027.
 */

public class Throwabled extends Exception {

    private int code;
    private String message;

    public Throwabled(java.lang.Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
