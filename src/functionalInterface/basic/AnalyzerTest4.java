package functionalInterface.basic;

public class AnalyzerTest4 {

  static void test(String[] strArr, String keyStr, Analyzer analyzer) {
    for (String str : strArr) {
      if (analyzer.analyze(str, keyStr))
        System.out.println(str);
    }
  }

  public static void main(String[] args) {
    String[] strArr = {"abc", "bcd", "efg"};

    test(strArr, "b", (t, s) -> t.contains(s));
    test(strArr, "b", (t, s) -> t.startsWith(s));
    test(strArr, "b", (t, s) -> t.endsWith(s));
  }

}
