package com.lyj.xh.net.exception;

/**
 * Created by Administrator on 2017/3/27 0027.
 */

public class ServerException  extends RuntimeException {

    public int code;
    public String message;

    public ServerException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
