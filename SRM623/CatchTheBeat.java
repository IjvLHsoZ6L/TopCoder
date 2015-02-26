import java.util.*;

public class CatchTheBeat {

  long[] x, y;

  public int maxCatched(int n, int x0, int y0, int a, int b, int c, int d, int mod1, int mod2, int offset) {

    x = new long[n];
    x[0] = x0;
    for (int i = 1; i < n; i++)
      x[i] = (x[i - 1] * a + b) % mod1;
    for (int i = 0; i < n; i++)
      x[i] -= offset;

    y = new long[n];
    y[0] = y0;
    for (int i = 1; i < n; i++)
      y[i] = (y[i - 1] * c + d) % mod2;

    Comparator<Integer> comp =
      new Comparator<Integer>() {
        public int compare(Integer i, Integer j) {
          long du = (y[i] + x[i]) - (y[j] + x[j]);
          long dv = (y[i] - x[i]) - (y[j] - x[j]);
          if (du < 0)
            return -1;
          else if (du > 0)
            return 1;
          else if (dv < 0)
            return -1;
          else if (dv > 0)
            return 1;
          else
            return 0;
        }
      };

    Integer[] order = new Integer[n];
    for (int i = 0; i < n; i++)
      order[i] = i;
    Arrays.sort(order, comp);

    long[] chain = new long[n + 1];
    Arrays.fill(chain, Long.MAX_VALUE);
    chain[0] = 0;

    int max = 0;
    for (int i = 0; i < n; i++) {
      long u = y[order[i]] + x[order[i]],
           v = y[order[i]] - x[order[i]];
      if (u >= 0 && v >= 0) {
        int left = 0,
            right = i + 1;
        while (right - left > 1) {
          int center = (left + right) / 2;
          if (chain[center] <= v)
            left = center;
          else
            right = center;
        }
        chain[right] = v;
        max = Math.max(max, right);
      }
    }

    return max;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      CatchTheBeatHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        CatchTheBeatHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class CatchTheBeatHarness {
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

  static boolean compareOutput(int expected, int result) { return expected == result; }
  static String formatResult(int res) {
    return String.format("%d", res);
  }

  static int verifyCase(int casenum, int expected, int received) { 
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
                int n                     = 3;
                int x0                    = 0;
                int y0                    = 0;
                int a                     = 1;
                int b                     = 1;
                int c                     = 1;
                int d                     = 1;
                int mod1                  = 100;
                int mod2                  = 100;
                int offset                = 1;
                int expected__            = 2;

                return verifyCase(casenum__, expected__, new CatchTheBeat().maxCatched(n, x0, y0, a, b, c, d, mod1, mod2, offset));
      }
      case 1: {
                int n                     = 1;
                int x0                    = 0;
                int y0                    = 1234;
                int a                     = 0;
                int b                     = 0;
                int c                     = 0;
                int d                     = 0;
                int mod1                  = 1000000000;
                int mod2                  = 1000000000;
                int offset                = 1000;
                int expected__            = 1;

                return verifyCase(casenum__, expected__, new CatchTheBeat().maxCatched(n, x0, y0, a, b, c, d, mod1, mod2, offset));
      }
      case 2: {
                int n                     = 1;
                int x0                    = 0;
                int y0                    = 999;
                int a                     = 0;
                int b                     = 0;
                int c                     = 0;
                int d                     = 0;
                int mod1                  = 1000000000;
                int mod2                  = 1000000000;
                int offset                = 1000;
                int expected__            = 0;

                return verifyCase(casenum__, expected__, new CatchTheBeat().maxCatched(n, x0, y0, a, b, c, d, mod1, mod2, offset));
      }
      case 3: {
                int n                     = 100;
                int x0                    = 0;
                int y0                    = 0;
                int a                     = 1;
                int b                     = 1;
                int c                     = 1;
                int d                     = 1;
                int mod1                  = 3;
                int mod2                  = 58585858;
                int offset                = 1;
                int expected__            = 66;

                return verifyCase(casenum__, expected__, new CatchTheBeat().maxCatched(n, x0, y0, a, b, c, d, mod1, mod2, offset));
      }
      case 4: {
                int n                     = 500000;
                int x0                    = 123456;
                int y0                    = 0;
                int a                     = 1;
                int b                     = 0;
                int c                     = 1;
                int d                     = 1;
                int mod1                  = 1000000000;
                int mod2                  = 1000000000;
                int offset                = 0;
                int expected__            = 376544;

                return verifyCase(casenum__, expected__, new CatchTheBeat().maxCatched(n, x0, y0, a, b, c, d, mod1, mod2, offset));
      }
      case 5: {
                int n                     = 500000;
                int x0                    = 0;
                int y0                    = 0;
                int a                     = 0;
                int b                     = 0;
                int c                     = 0;
                int d                     = 0;
                int mod1                  = 1;
                int mod2                  = 1;
                int offset                = 0;
                int expected__            = 500000;

                return verifyCase(casenum__, expected__, new CatchTheBeat().maxCatched(n, x0, y0, a, b, c, d, mod1, mod2, offset));
      }
      case 6: {
                int n                     = 10;
                int x0                    = 999999957;
                int y0                    = 79;
                int a                     = 993948167;
                int b                     = 24597383;
                int c                     = 212151897;
                int d                     = 999940854;
                int mod1                  = 999999986;
                int mod2                  = 999940855;
                int offset                = 3404;
                int expected__            = 3;

                return verifyCase(casenum__, expected__, new CatchTheBeat().maxCatched(n, x0, y0, a, b, c, d, mod1, mod2, offset));
      }

      // custom cases

      /*      case 7: {
              int n                     = ;
              int x0                    = ;
              int y0                    = ;
              int a                     = ;
              int b                     = ;
              int c                     = ;
              int d                     = ;
              int mod1                  = ;
              int mod2                  = ;
              int offset                = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new CatchTheBeat().maxCatched(n, x0, y0, a, b, c, d, mod1, mod2, offset));
              }*/
      /*      case 8: {
              int n                     = ;
              int x0                    = ;
              int y0                    = ;
              int a                     = ;
              int b                     = ;
              int c                     = ;
              int d                     = ;
              int mod1                  = ;
              int mod2                  = ;
              int offset                = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new CatchTheBeat().maxCatched(n, x0, y0, a, b, c, d, mod1, mod2, offset));
              }*/
      /*      case 9: {
              int n                     = ;
              int x0                    = ;
              int y0                    = ;
              int a                     = ;
              int b                     = ;
              int c                     = ;
              int d                     = ;
              int mod1                  = ;
              int mod2                  = ;
              int offset                = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new CatchTheBeat().maxCatched(n, x0, y0, a, b, c, d, mod1, mod2, offset));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
