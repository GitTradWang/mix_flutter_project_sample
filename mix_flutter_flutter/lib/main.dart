import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:mix_flutter_flutter/constant/page_routes.dart';

void main() => runApp(App());

class App extends StatefulWidget {
  @override
  _AppState createState() => _AppState();
}

class _AppState extends State<App> {
  @override
  void initState() {
    super.initState();
    FlutterBoost.singleton.registerPageBuilders(PageRoutes.routes);
    FlutterBoost.singleton
        .addBoostNavigatorObserver(TestBoostNavigatorObserver());
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Boost example',
      builder: FlutterBoost.init(postPush: _onRoutePushed),
      home: Container(color: Colors.white),
      theme: ThemeData(
        primaryColor: Color(0xFF6200EE),
        primaryColorDark: Color(0xFF3700B3),
        accentColor: Color(0xFF03DAC5),
      ),
    );
  }

  void _onRoutePushed(
      String pageName, String uniqueId, Map params, Route route, Future _) {
    print(
        "pageName: $pageName ,uniqueId: $uniqueId ,params: $params ,route: $route");
  }
}

class TestBoostNavigatorObserver extends NavigatorObserver {
  void didPush(Route<dynamic> route, Route<dynamic> previousRoute) {
    print("flutterboost#didPush");
  }

  void didPop(Route<dynamic> route, Route<dynamic> previousRoute) {
    print("flutterboost#didPop");
  }

  void didRemove(Route<dynamic> route, Route<dynamic> previousRoute) {
    print("flutterboost#didRemove");
  }

  void didReplace({Route<dynamic> newRoute, Route<dynamic> oldRoute}) {
    print("flutterboost#didReplace");
  }
}

class TestPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        brightness:Brightness.dark,
        centerTitle: true,
        title: Text("FLUTTER"),
      ),
      body: Container(
        padding: EdgeInsets.all(20),
        child: Center(
          child: Column(
            children: <Widget>[
              InkWell(
                onTap: () => FlutterBoost.singleton.open(
                    FlutterRoutesName.TEST_PAGE,
                    urlParams: {'ccc': 3, "ddd": 4}),
                child: Container(
                  width: 150,
                  height: 40,
                  color: Colors.red,
                  child: Text('通过原生打开Flutter页面'),
                ),
              ),
              SizedBox(
                height: 50,
              ),
              InkWell(
                onTap: () => FlutterBoost.singleton.open(
                    NativeRoutesName.MAIN_PAGE,
                    urlParams: {'ccc': 3, "ddd": 4}),
                child: Container(
                  width: 150,
                  height: 40,
                  color: Colors.red,
                  child: Text('打开原生页面'),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
