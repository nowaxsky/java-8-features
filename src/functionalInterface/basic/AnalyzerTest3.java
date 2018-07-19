package functionalInterface.basic;

public class AnalyzerTest3 {

  static void test(String[] strArr, String keyStr, Analyzer analyzer) {
    for (String str : strArr) {
      if (analyzer.analyze(str, keyStr))
        System.out.println(str);
    }
  }

  // lambda expression
  public static void main(String[] args) {
    String[] strArr = {"abc", "bcd", "efg"};

    test(strArr, "b", (String target, String keyStr) -> {
      return target.contains(keyStr);
    });

    // remove bracket


    // use simple character


  }

}
