#import "FlutterNativeApiPlugin.h"
#if __has_include(<flutter_native_api/flutter_native_api-Swift.h>)
#import <flutter_native_api/flutter_native_api-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "flutter_native_api-Swift.h"
#endif

@implementation FlutterNativeApiPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterNativeApiPlugin registerWithRegistrar:registrar];
}
@end
