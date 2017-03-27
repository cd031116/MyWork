package com.lyj.xh.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.lyj.xh.BuildConfig;
import com.lyj.xh.interf.*;
import com.lyj.xh.interf.BaseApiService;
import com.lyj.xh.net.exception.NovateException;
import com.lyj.xh.network.net.*;
import com.lyj.xh.utils.Utils;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lyj on 2017/3/27 0027.
 */

public class HttpClient {
    private static Context mContext;
    private Novate novate;
    public  static HttpClient instance;

    private   HttpClient(){

    }


    public static HttpClient getInstance(Context context,Map<String, String> headers) {
        if (context != null) {
            mContext = context;
            instance=new HttpClient(mContext,headers);
        }
     return instance ;
    }


    private HttpClient(Context context, Map<String, String> headers) {
        novate = new Novate.Builder(mContext)
                .addHeader(headers)
                .connectTimeout(5)
                .baseUrl(BuildConfig.SERVER_HOST)
                .addHeader(headers)
                .addLog(true)
                .build();

    }

    public Novate getNovate() {
        return novate;
    }
}
