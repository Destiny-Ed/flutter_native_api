import 'package:flutter/material.dart';
import 'package:flutter_native_api/flutter_native_api.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Flutter native api example app'),
        ),
        body: Container(
          padding: const EdgeInsets.all(20),
          child: ListView(
            children: [
              GestureDetector(
                onTap: () {
                  FlutterNativeApi.shareText("Destiny Ed");
                },
                child: Container(
                  margin: const EdgeInsets.only(bottom: 8),
                  alignment: Alignment.center,
                  color: Colors.blue,
                  child:
                      Text('Share Text', style: TextStyle(color: Colors.white)),
                  padding: const EdgeInsets.all(15),
                ),
              ),
              GestureDetector(
                onTap: () {
                  ///Require the app package name e.g dugget.app
                  ///It wil open app store if the app is not installed
                  FlutterNativeApi.launchExternalApp("dugget.app");
                },
                child: Container(
                  margin: const EdgeInsets.only(bottom: 8),
                  alignment: Alignment.center,
                  color: Colors.blue,
                  child: Text('Launch External App',
                      style: TextStyle(color: Colors.white)),
                  padding: const EdgeInsets.all(15),
                ),
              ),
              GestureDetector(
                onTap: () {
                  ///Require the app package name e.g dugget.app
                  FlutterNativeApi.openAppStore("dugget.app");
                },
                child: Container(
                  margin: const EdgeInsets.only(bottom: 8),
                  alignment: Alignment.center,
                  color: Colors.blue,
                  child: Text('Launch App Store',
                      style: TextStyle(color: Colors.white)),
                  padding: const EdgeInsets.all(15),
                ),
              ),
              GestureDetector(
                onTap: () {
                  ///Require the image file path and image name
                  ///
                  /// You can also convert image to PDF
                  FlutterNativeApi.printImage("imagePath", 'imageTitle');
                },
                child: Container(
                  margin: const EdgeInsets.only(bottom: 8),
                  alignment: Alignment.center,
                  color: Colors.blue,
                  child: Text('Print Image',
                      style: TextStyle(color: Colors.white)),
                  padding: const EdgeInsets.all(15),
                ),
              ),
              GestureDetector(
                onTap: () {
                  ///Require the image file path
                  ///Note:
                  ///Except any image extensions
                  FlutterNativeApi.shareImage("image path");
                },
                child: Container(
                  margin: const EdgeInsets.only(bottom: 8),
                  alignment: Alignment.center,
                  color: Colors.blue,
                  child: Text('Share Image',
                      style: TextStyle(color: Colors.white)),
                  padding: const EdgeInsets.all(15),
                ),
              ),
              GestureDetector(
                onTap: () {
                  ///Require the file path(image or video) and the text to share
                  ///
                  FlutterNativeApi.shareMultiple("file path", 'text');
                },
                child: Container(
                  margin: const EdgeInsets.only(bottom: 8),
                  alignment: Alignment.center,
                  color: Colors.blue,
                  child: Text('Share multiple content',
                      style: TextStyle(color: Colors.white)),
                  padding: const EdgeInsets.all(15),
                ),
              ),
              GestureDetector(
                onTap: () {
                  ///Requires the video file path
                  FlutterNativeApi.shareVideo("video path.mp4");
                },
                child: Container(
                  margin: const EdgeInsets.only(bottom: 8),
                  alignment: Alignment.center,
                  color: Colors.blue,
                  child: Text('Share Video',
                      style: TextStyle(color: Colors.white)),
                  padding: const EdgeInsets.all(15),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
