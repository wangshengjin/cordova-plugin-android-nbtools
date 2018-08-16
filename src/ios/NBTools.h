//
//  NBTools
//
//  Created by wangshengjin on 18-08-15.
//
//

#import <Cordova/CDV.h>

@interface NBTools : CDVPlugin

- (void)isPad:(CDVInvokedUrlCommand*)command;
- (void)isPadFromscreen:(CDVInvokedUrlCommand*)command;
- (Boolean)getIsPad;
@end
