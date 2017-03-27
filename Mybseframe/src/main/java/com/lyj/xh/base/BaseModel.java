package com.lyj.xh.base;

import java.io.Serializable;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by lyj on 2017/3/27 0027.
 */

public class BaseModel implements Serializable{

    private String fileURLs;

    public String getFileURLs() {
        return fileURLs;
    }

    public void setFileURLs(String fileURLs) {
        this.fileURLs = fileURLs;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "fileURLs='" + fileURLs + '\'' +
                '}';
    }
}
