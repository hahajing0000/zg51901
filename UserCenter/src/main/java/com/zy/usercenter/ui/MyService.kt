package com.zy.usercenter.ui

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.zy.common.zg1901eventbus.ObserverUtils

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("123", "onStartCommand: server start")

        ObserverUtils.getFinalObservable("")!!.notifyAll("1","2")

        return START_STICKY
    }
}
