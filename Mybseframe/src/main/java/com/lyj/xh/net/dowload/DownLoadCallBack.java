package com.lyj.xh.net.dowload;
import com.lyj.xh.net.exception.Throwabled;
/**
 * Created by lyj on 2017/3/27 0027.
 */

public abstract class DownLoadCallBack {
    public void onStart(String key){}

    public void onCancel(){}

    public void onCompleted(){}


    /** Note : the Fun run not MainThred
     * @param e
     */
    abstract public void onError(Throwabled e);

    public void onProgress(String key, long fileSizeDownloaded, long  totalSize ){}

    /**  Note : the Fun run UIThred
     * @param path
     * @param name
     * @param fileSize
     */
    abstract public void onSucess(String key, String path, String name, long fileSize);
}
