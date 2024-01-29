package com.example.unitconvertorcompose.utils

import android.content.Context
import com.example.flutteraddtoappgradle.ConvertorApp
import io.flutter.plugin.common.MethodChannel
import org.json.JSONObject

class CreateInstance {


    companion object {
        private val FLUTTER_CHANNEL = "com.example.flutter_module"


        fun openFlutterPage(counter: Int) {
            println("openFlutterPage ")
            val json = JSONObject()
            json.put("counter", counter.toString())
            println("openFlutterPage ${json.toString()}")

            val methodChannel = MethodChannel(
                ConvertorApp.flutterEngine.dartExecutor.binaryMessenger,
                FLUTTER_CHANNEL,
             )
             methodChannel.invokeMethod("getFromNative", json.toString())
        }
    }

}