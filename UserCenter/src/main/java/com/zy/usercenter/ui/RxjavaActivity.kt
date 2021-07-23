package com.zy.usercenter.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.uber.autodispose.AutoDispose
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import com.zy.usercenter.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit
import java.util.function.Consumer

class RxjavaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava)

        Observable.interval(1,TimeUnit.SECONDS)
//            .as(AutoDispose.<Long>autoDisposable(AndroidLifecycleScopeProvider.from(this)))
//            .as(AndroidLifecycleScopeProvider.from(this))
            .subscribe(object :Observer<Long>{
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Long) {
                Log.d("123", "onNext: $t")
            }

            override fun onError(e: Throwable) {
            }

        })
    }
}