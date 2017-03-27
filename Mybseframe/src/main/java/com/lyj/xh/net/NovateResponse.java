package com.lyj.xh.net;

import android.content.Context;

import com.lyj.xh.net.config.ConfigLoader;

/**
 * Created by lyj on 2017/3/27 0027.
 */

public class NovateResponse<T> {
    //结果码
    private int code = 0;
    /*错误信息:msg, error, message*/
    private String message;
    /*真实数据 data或者result*/
    private T  data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public boolean isOk(Context context) {
        return ConfigLoader.checkSucess(context, getCode());
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NovateResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
