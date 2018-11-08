function NBTools() {
}

NBTools.prototype.isPad = function (successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, "NBTools", "isPad", []);
};

NBTools.prototype.isPadFromscreen = function (successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, "NBTools", "isPadFromscreen", []);
};

NBTools.prototype.hideBottomNavigationBar = function (successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, "NBTools", "hideBottomNavigationBar", []);
};

NBTools.install = function () {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.NBTools = new NBTools();
  return window.plugins.NBTools;
};

cordova.addConstructor(NBTools.install);