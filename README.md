# cordova-plugin-nbtools
android和ios 系统上的一些工具类,后期用到了会陆续添加
* cordova plugin add https://github.com/wangshengjin/cordova-plugin-nbtools.git
## 目前提供的可用方法：
### 通用
* window.plugins.NBTools.isPad // android官方提供是手机还是平板的判断方法
### android专用
* window.plugins.NBTools.isPadFromscreen // 通过分辨率判断手机还是平板的
* window.plugins.NBTools.hideBottomNavigationBar // 隐藏底部虚拟按钮
