package com.lyj.xh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lyj.xh.base.BaseModel;
import com.lyj.xh.net.HttpClient;
import com.lyj.xh.net.NovateResponse;
import com.lyj.xh.net.exception.Throwabled;
import com.google.gson.Gson;
import com.lyj.xh.net.Novate;
import com.lyj.xh.net.exception.Throwabled;
import com.lyj.xh.network.IpResult;
import com.lyj.xh.network.MyApiService;
import com.lyj.xh.network.SouguBean;
import com.lyj.xh.network.net.BaseResponse;
import com.lyj.xh.network.net.BaseSubscriber;
import com.lyj.xh.network.net.CallBack;
import com.lyj.xh.network.net.ExceptionHandle;
import com.lyj.xh.network.net.RetrofitClient;
import com.lyj.xh.network.net.ExceptionHandle.ResponeThrowable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;


public class MainActivity extends AppCompatActivity {

    private View btn, btn_get, btn_post, btn_json, btn_download, btn_upload, btn_myApi, btn_changeHostApi;

    private Novate novate;
    private Map<String, Object> parameters = new HashMap<String, Object>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.bt_getdata);

        btn_get = findViewById(R.id.bt_get);
        btn_post = findViewById(R.id.bt_post);
        btn_json = findViewById(R.id.bt_json);
        btn_download = findViewById(R.id.bt_download);
        btn_upload = findViewById(R.id.bt_upload);
        btn_myApi = findViewById(R.id.bt_my_api);
        btn_changeHostApi = findViewById(R.id.bt_changeHostApi);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //"http://ip.taobao.com/service/getIpInfo.php?ip=21.22.11.33";
                performTest();

            }
        });


    }

    private void performTest() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        HttpClient.getInstance(MainActivity.this,headers).getNovate().isNullBody("bOrganization/advertising", new Novate.ResponseCallBack<NovateResponse<BaseModel>>() {
            @Override
            public void onStart() {

            }
            @Override
            public void onCompleted() {

            }
            @Override
            public void onError(Throwable e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSuccee(NovateResponse<BaseModel> response) {
                Toast.makeText(MainActivity.this, response.getData().getFileURLs(), Toast.LENGTH_SHORT).show();
            }
        });

//        novate = new Novate.Builder(this)
//                .addHeader(headers)
//                .connectTimeout(5)
//                .baseUrl(BuildConfig.SERVER_HOST)
//                .addHeader(headers)
//                .addLog(true)
//                .build();
//
//        //http://apis.baidu.com/apistore/weatherservice/cityname?cityname=上海
//        novate.test("bOrganization/advertising", null,
//                new BaseSubscriber<ResponseBody>(MainActivity.this) {
//                    @Override
//                    public void onError(Throwabled e) {
//                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onNext(ResponseBody responseBody) {
//                        try {
//                            Toast.makeText(MainActivity.this, new String(responseBody.bytes()), Toast.LENGTH_SHORT).show();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });

    }

}