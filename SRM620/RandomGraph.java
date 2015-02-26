public class RandomGraph {

  public double probability(int n, int p) {

    double c = (double) p / 1000D,
           d = 1D - c;

    double[] P = new double[n + 1];
    for (int i = 0; i <= 3 && i <= n; i++)
      P[i] = 1D;

    for (int i = 4; i <= n; i++)
      P[i] =
        Math.pow(d, i - 1) * P[i - 1] +
        (i - 1) * c * Math.pow(d, 2 * (i - 2)) * P[i - 2] +
        (i - 1) * (i - 2) / 2 * (c * c * c + 3 * c * c * d) * Math.pow(d, 3 * (i - 3)) * P[i - 3];

    return 1D - P[n];
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      RandomGraphHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        RandomGraphHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class RandomGraphHarness {
  public static void run_test(int casenum) {
    if (casenum != -1) {
      if (runTestCase(casenum) == -1)
        System.err.println("Illegal input! Test case " + casenum + " does not exist.");
      return;
    }

    int correct = 0, total = 0;
    for (int i=0;; ++i) {
      int x = runTestCase(i);
      if (x == -1) {
        if (i >= 100) break;
        continue;
      }
      correct += x;
      ++total;
    }

    if (total == 0) {
      System.err.println("No test cases run.");
    } else if (correct < total) {
      System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
    } else {
      System.err.println("All " + total + " tests passed!");
    }
  }

  static final double MAX_DOUBLE_ERROR = 1E-9;
  static boolean compareOutput(double expected, double result){ if(Double.isNaN(expected)){ return Double.isNaN(result); }else if(Double.isInfinite(expected)){ if(expected > 0){ return result > 0 && Double.isInfinite(result); }else{ return result < 0 && Double.isInfinite(result); } }else if(Double.isNaN(result) || Double.isInfinite(result)){ return false; }else if(Math.abs(result - expected) < MAX_DOUBLE_ERROR){ return true; }else{ double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); return result > min && result < max; } }
  static double relativeError(double expected, double result) { if (Double.isNaN(expected) || Double.isInfinite(expected) || Double.isNaN(result) || Double.isInfinite(result) || expected == 0) return 0; return Math.abs(result-expected) / Math.abs(expected); }

  static String formatResult(double res) {
    return String.format("%.10g", res);
  }

  static int verifyCase(int casenum, double expected, double received) { 
    System.err.print("Example " + casenum + "... ");
    if (compareOutput(expected, received)) {
      System.err.print("PASSED");
      double rerr = relativeError(expected, received);
      if (rerr > 0) System.err.printf(" (relative error %g)", rerr);
      System.err.println();
      return 1;
    } else {
      System.err.println("FAILED");
      System.err.println("    Expected: " + formatResult(expected)); 
      System.err.println("    Received: " + formatResult(received)); 
      return 0;
    }
  }

  static int runTestCase(int casenum__) {
    switch(casenum__) {
      case 0: {
                int n                     = 7;
                int p                     = 0;
                double expected__         = 0.0;

                return verifyCase(casenum__, expected__, new RandomGraph().probability(n, p));
      }
      case 1: {
                int n                     = 3;
                int p                     = 620;
                double expected__         = 0.0;

                return verifyCase(casenum__, expected__, new RandomGraph().probability(n, p));
      }
      case 2: {
                int n                     = 4;
                int p                     = 500;
                double expected__         = 0.59375;

                return verifyCase(casenum__, expected__, new RandomGraph().probability(n, p));
      }
      case 3: {
                int n                     = 8;
                int p                     = 100;
                double expected__         = 0.33566851611343496;

                return verifyCase(casenum__, expected__, new RandomGraph().probability(n, p));
      }
      case 4: {
                int n                     = 15;
                int p                     = 50;
                double expected__         = 0.5686761670525845;

                return verifyCase(casenum__, expected__, new RandomGraph().probability(n, p));
      }
      case 5: {
                int n                     = 50;
                int p                     = 10;
                double expected__         = 0.7494276522159893;

                return verifyCase(casenum__, expected__, new RandomGraph().probability(n, p));
      }
      case 6: {
                int n                     = 50;
                int p                     = 1000;
                double expected__         = 1.0;

                return verifyCase(casenum__, expected__, new RandomGraph().probability(n, p));
      }

      // custom cases

      /*      case 7: {
              int n                     = ;
              int p                     = ;
              double expected__         = ;

              return verifyCase(casenum__, expected__, new RandomGraph().probability(n, p));
              }*/
      /*      case 8: {
              int n                     = ;
              int p                     = ;
              double expected__         = ;

              return verifyCase(casenum__, expected__, new RandomGraph().probability(n, p));
              }*/
      /*      case 9: {
              int n                     = ;
              int p                     = ;
              double expected__         = ;

              return verifyCase(casenum__, expected__, new RandomGraph().probability(n, p));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
