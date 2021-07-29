package com.zy.usercenter.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import com.zy.usercenter.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class RxJava2Activity extends AppCompatActivity {
    private ThreadLocal<String> local=new ThreadLocal<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java2);


        Button btn = (Button) findViewById(R.id.btn_threadlocal_test);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<10;i++){
                    int finalI = i;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            local.set(""+ finalI);
                            String s = local.get();
                            Log.d("123", "run: "+s+"  Thread name ->"+Thread.currentThread().getName());
                        }
                    },"Thread"+finalI).start();
                }
            }
        });






//        Observable.interval(1, TimeUnit.SECONDS)
//                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this)))
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        Log.d("123", "accept: "+aLong);
//                    }
//                });
//
//        startActivity(new Intent(this,RxjavaActivity.class));

    }


}