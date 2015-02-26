public class SilverbachConjecture {

  public int[] solve(int n) {

    boolean[] prime = new boolean[n];
    for (int i = 2; i < n; i++)
      prime[i] = true;
    for (int i = 2; i * i < n; i++)
      if (prime[i])
        for (int j = i; i * j < n; j++)
          prime[i * j] = false;

    for (int i = 4; i + i <= n; i++)
      if (!prime[i] && !prime[n - i])
        return new int[] { i, n - i };

    return new int[] { 0, 0 };
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      SilverbachConjectureHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        SilverbachConjectureHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class SilverbachConjectureHarness {
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

  static boolean compareOutput(int[] expected, int[] result) { if (expected.length != result.length) return false; for (int i=0; i<expected.length; ++i) if (expected[i] != result[i]) return false; return true; }

  static String formatResult(int[] res) {
    String ret = "";
    ret += "{";
    for (int i=0; i<res.length; ++i) {
      if (i > 0) ret += ",";
      ret += String.format(" %d", res[i]);
    }
    ret += " }";
    return ret;
  }

  static int verifyCase(int casenum, int[] expected, int[] received) { 
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
                int n                     = 20;
                int[] expected__          = {8, 12 };

                return verifyCase(casenum__, expected__, new SilverbachConjecture().solve(n));
      }
      case 1: {
                int n                     = 30;
                int[] expected__          = {15, 15 };

                return verifyCase(casenum__, expected__, new SilverbachConjecture().solve(n));
      }
      case 2: {
                int n                     = 999;
                int[] expected__          = {699, 300 };

                return verifyCase(casenum__, expected__, new SilverbachConjecture().solve(n));
      }
      case 3: {
                int n                     = 45;
                int[] expected__          = {15, 30 };

                return verifyCase(casenum__, expected__, new SilverbachConjecture().solve(n));
      }

      // custom cases

      /*      case 4: {
              int n                     = ;
              int[] expected__          = ;

              return verifyCase(casenum__, expected__, new SilverbachConjecture().solve(n));
              }*/
      /*      case 5: {
              int n                     = ;
              int[] expected__          = ;

              return verifyCase(casenum__, expected__, new SilverbachConjecture().solve(n));
              }*/
      /*      case 6: {
              int n                     = ;
              int[] expected__          = ;

              return verifyCase(casenum__, expected__, new SilverbachConjecture().solve(n));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
