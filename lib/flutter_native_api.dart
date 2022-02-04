
import 'dart:async';

import 'package:flutter/services.dart';

class FlutterNativeApi {
  static const MethodChannel platform =
      const MethodChannel('flutter_native_api');

  static launchExternalApp(String? appPackageName) async {
    try {
      final result = await platform
          .invokeMethod('launchExternalApp', {"appPackage": appPackageName});
      print(result);
    } on PlatformException catch (e) {
      print("Failed to launch app : '${e.message}'.");
    }
  }

  static openAppStore(String? appPackageName) async {
    try {
      final result = await platform
          .invokeMethod('openAppStore', {"appPackage": appPackageName});
      print(result);
    } on PlatformException catch (e) {
      print("Failed to launch app : '${e.message}'.");
    }
  }



  static printImage(String? image, String? imageTitle) async {
    try {
      final int result = await platform
          .invokeMethod('printImage', {"image": image, "title": imageTitle});
      print(result);
    } on PlatformException catch (e) {
      print("Error occurred: '${e.message}'.");
    }
  }

  static shareImage(String? image) async {
    try {
      final int result =
      await platform.invokeMethod('shareImage', {"image": image});
      print(result);
    } on PlatformException catch (e) {
      print("Error occurred: '${e.message}'.");
    }
  }

  static shareMultiple(String? imageOrVideo, String? text) async {
    try {
      final int result =
      await platform.invokeMethod('shareMultiple', {"imageOrVideo": imageOrVideo, "text" : text});
      print(result);
    } on PlatformException catch (e) {
      print("Error occurred: '${e.message}'.");
    }
  }

  static shareText(String? text) async {
    try {
      final int result =
      await platform.invokeMethod('shareText', {"text": text});
      print(result);
    } on PlatformException catch (e) {
      print("Error occurred: '${e.message}'.");
    }
  }
//shareVideo

  static shareVideo(String? video) async {
    try {
      final int result =
      await platform.invokeMethod('shareVideo', {"video": video});
      print(result);
    } on PlatformException catch (e) {
      print("Failed to get battery level: '${e.message}'.");
    }
  }

}
