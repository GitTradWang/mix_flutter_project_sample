import 'package:flutter_boost/flutter_boost.dart';
import 'package:mix_flutter_flutter/constant/page_handler.dart';

const String FLUTTER_PAGE_SUFFIX = "/flutterPage";

const String NATIVE_PAGE_SUFFIX = "/nativePage";

class FlutterRoutesName {
  static const String TEST_PAGE = "$FLUTTER_PAGE_SUFFIX/test";
}

class NativeRoutesName {
  static const String MAIN_PAGE = "$NATIVE_PAGE_SUFFIX/main";
}

class PageRoutes {
  static Map<String, PageBuilder> routes = {
    FlutterRoutesName.TEST_PAGE: testPageHandler,
  };
}
