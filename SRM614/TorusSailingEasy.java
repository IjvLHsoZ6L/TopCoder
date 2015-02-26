public class TorusSailingEasy {

  public double expectedTime(int N, int M, int goalX, int goalY) {

    int a = 0,
        b = 0;
    for (int x = 0, y = 0; a < N * M; a++, x = (x + 1) % N, y = (y + 1) % M)
      if (x == goalX && y == goalY)
        break;
    for (int x = 0, y = 0; b < N * M; b++, x = (x - 1 + N) % N, y = (y - 1 + M) % M)
      if (x == goalX && y == goalY)
        break;
    if (a == N * M)
      return -1;

    int days = 0;
    double expected = 0D,
           error = 1E-10;
    double[] probability = new double[a + b + 1],
             prev = new double[a + b + 1];
    probability[a] = 1D;

    while (true) {

      days++;

      double remains = 0D;
      for (int i = 1; i < a + b; i++)
        remains += probability[i];
      if (remains * days < error)
        break;

      for (int i = 1; i < a + b; i++)
        prev[i] = probability[i];
      for (int i = 0; i <= a + b; i++)
        probability[i] = 0D;
      for (int i = 1; i < a + b; i++) {
        probability[i - 1] += .5 * prev[i];
        probability[i + 1] += .5 * prev[i];
      }

      expected += probability[0] * days;
      expected += probability[a + b] * days;
    }

    return expected;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      TorusSailingEasyHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        TorusSailingEasyHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class TorusSailingEasyHarness {
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
                int N                     = 2;
                int M                     = 2;
                int goalX                 = 1;
                int goalY                 = 1;
                double expected__         = 1.0;

                return verifyCase(casenum__, expected__, new TorusSailingEasy().expectedTime(N, M, goalX, goalY));
      }
      case 1: {
                int N                     = 2;
                int M                     = 2;
                int goalX                 = 0;
                int goalY                 = 1;
                double expected__         = -1.0;

                return verifyCase(casenum__, expected__, new TorusSailingEasy().expectedTime(N, M, goalX, goalY));
      }
      case 2: {
                int N                     = 3;
                int M                     = 3;
                int goalX                 = 1;
                int goalY                 = 1;
                double expected__         = 2.0;

                return verifyCase(casenum__, expected__, new TorusSailingEasy().expectedTime(N, M, goalX, goalY));
      }
      case 3: {
                int N                     = 4;
                int M                     = 6;
                int goalX                 = 1;
                int goalY                 = 3;
                double expected__         = 27.0;

                return verifyCase(casenum__, expected__, new TorusSailingEasy().expectedTime(N, M, goalX, goalY));
      }

      // custom cases

      /*      case 4: {
              int N                     = ;
              int M                     = ;
              int goalX                 = ;
              int goalY                 = ;
              double expected__         = ;

              return verifyCase(casenum__, expected__, new TorusSailingEasy().expectedTime(N, M, goalX, goalY));
              }*/
      /*      case 5: {
              int N                     = ;
              int M                     = ;
              int goalX                 = ;
              int goalY                 = ;
              double expected__         = ;

              return verifyCase(casenum__, expected__, new TorusSailingEasy().expectedTime(N, M, goalX, goalY));
              }*/
      /*      case 6: {
              int N                     = ;
              int M                     = ;
              int goalX                 = ;
              int goalY                 = ;
              double expected__         = ;

              return verifyCase(casenum__, expected__, new TorusSailingEasy().expectedTime(N, M, goalX, goalY));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
