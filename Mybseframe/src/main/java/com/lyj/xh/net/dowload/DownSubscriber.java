package com.lyj.xh.net.dowload;

import android.content.Context;
import android.util.Log;
import com.lyj.xh.net.exception.Throwabled;
import com.lyj.xh.net.BaseSubscriber;

/**
 * Created by lyj on 2017/3/27 0027.
 */

public class DownSubscriber <ResponseBody extends okhttp3.ResponseBody> extends BaseSubscriber<ResponseBody> {
    private DownLoadCallBack callBack;
    private Context context;
    private String path;
    private String name;
    private String key;

    public DownSubscriber(String key, String path, String name, DownLoadCallBack callBack, Context context) {
        super(context);
        this.key = key;
        this.path = path;
        this.name = name;
        this.callBack = callBack;
        this.context = context;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (callBack != null) {
           /* if (TextUtils.isEmpty(key)) {
                key = FileUtil.generateFileKey(path, name);
            }*/
            callBack.onStart(key);
        }
    }

    @Override
    public void onCompleted() {
        if (callBack != null) {
            callBack.onCompleted();
        }
    }

    @Override
    public void onError(final Throwabled e) {
        Log.e(NovateDownLoadManager.TAG, "DownSubscriber:>>>> onError:" + e.getMessage());
        callBack.onError(e);
    }

    @Override
    public void onNext(ResponseBody responseBody) {
        Log.d(NovateDownLoadManager.TAG, "DownSubscriber:>>>> onNext");
        new NovateDownLoadManager(callBack).writeResponseBodyToDisk(key, path, name, context, responseBody);

    }
}
