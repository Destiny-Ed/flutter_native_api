package com.destinyed.flutter_native_api

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.net.Uri
import android.os.Build
import android.os.CancellationSignal
import android.provider.MediaStore
import android.util.Size
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startActivity
import androidx.print.PrintHelper

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar
import java.io.File

/** FlutterNativeApiPlugin */
class FlutterNativeApiPlugin : FlutterPlugin, MethodCallHandler, ActivityAware {
    /// The MethodChannel that will the communication between Flutter and native Android
    ///
    /// This local reference serves to register the plugin with the Flutter Engine and unregister it
    /// when the Flutter Engine is detached from the Activity
    private lateinit var channel: MethodChannel

    var context : Context? = null


    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "flutter_native_api")
        channel.setMethodCallHandler(this)

        context = flutterPluginBinding.applicationContext
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
//    if (call.method == "getPlatformVersion") {
//      result.success("Android ${android.os.Build.VERSION.RELEASE}")
//    } else {
//      result.notImplemented()
//    }
        ///Use When instead of if
        when (call.method) {
            "launchExternalApp" -> {

                val appPackage = call.argument<String>("appPackage")

                NativeApi(context!!).launchExternalApp(appPackage!!)
            }
            "openAppStore" -> {

                val appPackage = call.argument<String>("appPackage")

                NativeApi(context!!).openPlayStore(appPackage!!)
            }
            "printImage" -> {
                val image = call.argument<String>("image")
                val title = call.argument<String>("title")

                NativeApi(context!!).printImage(image!!, title);
            }
            "shareMultiple" -> {
                val image = call.argument<String>("imageOrVideo")
                val title = call.argument<String>("text")

                NativeApi(context!!).shareTextAndFile(title, image);
            }
            "shareImage" -> {
                val image = call.argument<String>("image")

                NativeApi(context!!).shareImage(image!!)
            }
            "shareText" -> {
                val text = call.argument<String>("text")

                NativeApi(context!!).shareText(text!!)
            }
            "shareVideo" -> {
                val video = call.argument<String>("video")

                NativeApi(context!!).shareVideo(video);
            }
            else -> {
                result.notImplemented();
            }
        }
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
        context = null
    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        context = binding.activity
    }

    override fun onDetachedFromActivityForConfigChanges() {
        context = null
    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
        context = binding.activity
    }

    override fun onDetachedFromActivity() {
        context = null
    }


}
