package com.lyj.xh.network.net;

import android.content.Context;
import android.util.Log;
import com.lyj.xh.net.exception.Throwabled;
import com.lyj.xh.net.exception.NovateException;

import rx.Subscriber;

/**
 * BaseSubscriber
 * Created by Tamic on 2016-08-03.
 */
public abstract class BaseSubscriber<T> extends Subscriber<T> {
    private Context context;

    public BaseSubscriber(Context context) {
        this.context = context;
    }

    @Override
    final public void onError(java.lang.Throwable e) {
        Log.v("Novate", e.getMessage());
        if(e instanceof Throwabled){
            Log.e("Novate", "--> e instanceof Throwabled");
            onError((Throwabled)e);
        } else {
            Log.e("Novate", "e !instanceof Throwable");
            onError(new Throwabled(e, NovateException.ERROR.UNKNOWN));
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("Novate", "-->http is start");
        // todo some common as show loadding  and check netWork is NetworkAvailable
        // if  NetworkAvailable no !   must to call onCompleted
    }

    @Override
    public void onCompleted() {
        Log.v("Novate", "-->http is Complete");
        // todo some common as  dismiss loadding
    }
    public abstract void onError(Throwabled e);




}
