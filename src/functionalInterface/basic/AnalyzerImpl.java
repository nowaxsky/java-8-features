package functionalInterface.basic;

public class AnalyzerImpl implements Analyzer {

  @Override
  public boolean analyze(String target, String keyStr) {
    return target.contains(keyStr);
  }

}
