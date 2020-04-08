//
//  AppDelegate.swift
//  mix_flutter_ios
//
//  Created by TradWang on 2020/4/8.
//  Copyright © 2020 TradWang. All rights reserved.
//

import UIKit
import Flutter
import FlutterPluginRegistrant

@UIApplicationMain
@objc class AppDelegate:FlutterAppDelegate {
    
    override func application(_ application: UIApplication,didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
      
      let router = PlatformRouterImp.init();
      FlutterBoostPlugin.sharedInstance().startFlutter(with: router, onStart: { (engine) in});
      
      self.window = UIWindow.init(frame: UIScreen.main.bounds)
      let viewController = ViewController.init()
      let navi = UINavigationController.init(rootViewController: viewController)
      self.window.rootViewController = navi
      self.window.makeKeyAndVisible()
      
      return true;//super.application(application, didFinishLaunchingWithOptions: launchOptions)
    }

}

