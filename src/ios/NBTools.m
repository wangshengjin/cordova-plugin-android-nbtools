//
//  NBTools
//
//  Created by wangshengjin on 18-08-15.
//
//

#import "NBTools.h"
#import <Cordova/CDV.h>

@implementation NBTools
- (void)isPad:(CDVInvokedUrlCommand*)command {
    Boolean boo = [self getIsPad];
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:boo];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)isPadFromscreen:(CDVInvokedUrlCommand*)command {
    Boolean boo = [self getIsPad];
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:boo];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)hideBottomNavigationBar:(CDVInvokedUrlCommand*)command {
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:TRUE];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId]; 
}

- (Boolean)getIsPad {
    NSString* deviceType = [UIDevice currentDevice].model;
    NSLog(@"deviceType = %@", deviceType);
//    1. iPhone Simulator
//    2.iPad Simulator
//    3.iPod touch
//    4.iPad
//    5.iPhone
    Boolean boo = FALSE;
    if([deviceType isEqualToString:@"iPad"]) {
        boo = TRUE;
    }
    return boo;
}

@end
