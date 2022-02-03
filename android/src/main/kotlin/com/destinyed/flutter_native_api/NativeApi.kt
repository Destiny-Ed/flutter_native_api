package com.destinyed.flutter_native_api

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.print.PrintHelper

class NativeApi(var context : Context) {


    // Show WhatsApp Function
    fun launchExternalApp(appPackage: String) {
        try {
            var intent = context.packageManager.getLaunchIntentForPackage(appPackage);
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "$appPackage Can't Be Found On Your Device", Toast.LENGTH_LONG).show()

            openPlayStore(appPackage);

        }
    }


    //Open Playstore if user does not have the app install
    fun openPlayStore(appPackage: String) {
        //open with playstore app if installed
        try {
            var path = "market://details?id=$appPackage"
            var uri = Uri.parse(path)
            var intent = Intent(Intent.ACTION_VIEW, uri)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)

        } catch (e: ActivityNotFoundException) {
            //open with browser if playstore app is not installed
            var path = "https://play.google.com/store/apps/details?id=$appPackage"
            var uri = Uri.parse(path)
            var intent = Intent(Intent.ACTION_VIEW, uri)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    fun shareImage(image: String?) {
//        var arr: Any = arrayOf(imageUri, "hello")
        var intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/*"

        intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(image))
        context.startActivity(Intent.createChooser(intent, "Share Image"))
    }

    fun shareText(text: String?) {
//        var arr: Any = arrayOf(imageUri, "hello")
        var intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"

        intent.putExtra(Intent.EXTRA_TEXT, text)
        context.startActivity(Intent.createChooser(intent, "Share Text via"))
    }

    fun shareTextAndFile(text: String?, imageOrVideo : String?) {
//        var arr: Any = arrayOf(imageUri, "hello")
        var intent = Intent(Intent.ACTION_SEND)
        intent.type = "*/*"

        intent.putExtra(Intent.EXTRA_TEXT, text)
        intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(imageOrVideo))
        context.startActivity(Intent.createChooser(intent, "Share via"))
    }

    fun shareVideo(video: String?) {
        var intent = Intent(Intent.ACTION_SEND)
        intent.type = "video/*"

        intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(video))
        context.startActivity(Intent.createChooser(intent, "Share Video via..."))
    }

    fun printImage(imageUri: String?, imageTitle: String?) {
        PrintHelper(context).apply {
            PrintHelper.SCALE_MODE_FIT
        }.also {
            var bitmap = BitmapFactory.decodeFile(imageUri)
            it.printBitmap(imageTitle!!, bitmap)
        }
    }
}