package com.zy.kt

import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.util.concurrent.CountDownLatch

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.zy.kt", appContext.packageName)
    }

    @Test
    fun testHandler(){
        val cdl:CountDownLatch= CountDownLatch(1)
        var result:Int=0
        testH({x->
            result=x
            cdl.countDown()
        })

        val msg=Message.obtain()
        msg.arg1=1
        handler?.sendMessage(msg)

        cdl.await()
        assertEquals(1,msg.arg1)

    }

    var handler:Handler?=null
    fun testH(method:(Int)->Unit){
        Looper.prepare()
         handler=object :Handler(){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                method(msg.arg1)
            }
        }
        Looper.loop()
    }

}