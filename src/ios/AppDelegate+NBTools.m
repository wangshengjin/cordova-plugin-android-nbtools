#import "AppDelegate.h"
#import "ZYNetworkAccessibity.h"

- (BOOL)application:(UIApplication*)application didFinishLaunchingWithOptions:(NSDictionary*)launchOptions
{
    [ZYNetworkAccessibity setAlertEnable:YES];
    [ZYNetworkAccessibity setStateDidUpdateNotifier:^(ZYNetworkAccessibleState state) {
        NSLog(@"setStateDidUpdateNotifier > %zd", state);
    }];
    [ZYNetworkAccessibity start];
    return YES;
}

@end