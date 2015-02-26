import java.util.ArrayList;

public class MinimumSquareEasy {

  public long minArea(int[] x, int[] y) {

    int N = x.length,
        sideMin = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int xMin = Integer.MAX_VALUE,
            xMax = Integer.MIN_VALUE,
            yMin = Integer.MAX_VALUE,
            yMax = Integer.MIN_VALUE;
        for (int k = 0; k < N; k++) {
          if (k != i && k != j) {
            if (x[k] < xMin)
              xMin = x[k];
            if (x[k] > xMax)
              xMax = x[k];
            if (y[k] < yMin)
              yMin = y[k];
            if (y[k] > yMax)
              yMax = y[k];
          }
        }
        int side = Math.max(xMax - xMin, yMax - yMin) + 2;
        if (side < sideMin)
          sideMin = side;
      }
    }

    return (long) sideMin * (long) sideMin;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      MinimumSquareEasyHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        MinimumSquareEasyHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class MinimumSquareEasyHarness {
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

  static boolean compareOutput(long expected, long result) { return expected == result; }
  static String formatResult(long res) {
    return String.format("%d", res);
  }

  static int verifyCase(int casenum, long expected, long received) { 
    System.err.print("Example " + casenum + "... ");
    if (compareOutput(expected, received)) {
      System.err.println("PASSED");
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
                int[] x                   = {0, 1, 2};
                int[] y                   = {0, 1, 5};
                long expected__           = 4;

                return verifyCase(casenum__, expected__, new MinimumSquareEasy().minArea(x, y));
      }
      case 1: {
                int[] x                   = {-1, -1, 0, 2, 0};
                int[] y                   = {-2, -1, 0, -1, -2};
                long expected__           = 9;

                return verifyCase(casenum__, expected__, new MinimumSquareEasy().minArea(x, y));
      }
      case 2: {
                int[] x                   = {1000000000, -1000000000, 1000000000, -1000000000};
                int[] y                   = {1000000000, 1000000000, -1000000000, -1000000000};
                long expected__           = 4000000008000000004L;

                return verifyCase(casenum__, expected__, new MinimumSquareEasy().minArea(x, y));
      }
      case 3: {
                int[] x                   = {93, 34, 12, -11, -7, -21, 51, -22, 59, 74, -19, 29, -56, -95, -96, 9, 44, -37, -54, -21};
                int[] y                   = {64, 12, -43, 20, 55, 74, -20, -54, 24, 20, -18, 77, 86, 22, 47, -24, -33, -57, 5, 7};
                long expected__           = 22801;

                return verifyCase(casenum__, expected__, new MinimumSquareEasy().minArea(x, y));
      }

      // custom cases

      /*      case 4: {
              int[] x                   = ;
              int[] y                   = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new MinimumSquareEasy().minArea(x, y));
              }*/
      /*      case 5: {
              int[] x                   = ;
              int[] y                   = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new MinimumSquareEasy().minArea(x, y));
              }*/
      /*      case 6: {
              int[] x                   = ;
              int[] y                   = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new MinimumSquareEasy().minArea(x, y));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
