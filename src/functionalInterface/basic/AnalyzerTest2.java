package functionalInterface.basic;

public class AnalyzerTest2 {

  static void test(String[] strArr, String keyStr, Analyzer analyzer) {
    for (String str : strArr) {
      if (analyzer.analyze(str, keyStr))
        System.out.println(str);
    }
  }

  // anonymous function
  public static void main(String[] args) {
    String[] strArr = {"abc", "bcd", "efg"};

    test(strArr, "b", new Analyzer() {

      @Override
      public boolean analyze(String target, String keyStr) {
        return target.contains(keyStr);
      }

    });
  }

}
