package com.example.zjm.volleydome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.text.RelativeDateTimeFormatter.Direction.THIS;

public class MainActivity extends AppCompatActivity {
    //第一步:声明RequestQueue
    private RequestQueue myQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化RequestQueue,注意:不能直接new
        myQueue = Volley.newRequestQueue(this);
        //第二步:声明StringRequeue,注意有三个参数,分别是:URL地址,请求成功的回调方法Listener和请求失败的回调ErrorListener
        StringRequest request = new StringRequest("https://free-api.heweather.com/v5/weather?city=%E5%8C%97%E4%BA%AC&key=ce4b166107294e9bae58d5fc2a7c2621", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("zjm", response);
                Toast.makeText(MainActivity.this,"恭喜你,请求发送成功",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("zjm", error.getMessage(), error);
                Toast.makeText(MainActivity.this,"请求失败",Toast.LENGTH_LONG).show();
            }
        });
        //第三步:将request添加到queue中
        myQueue.add(request);

    }
}