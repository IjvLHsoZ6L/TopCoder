import java.util.*;

public class Procrastination {

  public long findFinalAssignee(long n) {
    long h, r;
    for (h = 2; h * h <= n; h++) {
      r = n % h;
      if (r == 0) {
        n++;
      }
      else if (r == 1) {
        n--;
      }
    }
    for (h = n / h; h >= 2; h--) {
      r = n % h;
      if (r == 0) {
        n++;
      }
      else if (r == 1) {
        n--;
      }
    }
    return n;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      ProcrastinationHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        ProcrastinationHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class ProcrastinationHarness {
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
                long n                    = 3;
                long expected__           = 3;

                return verifyCase(casenum__, expected__, new Procrastination().findFinalAssignee(n));
      }
      case 1: {
                long n                    = 8;
                long expected__           = 11;

                return verifyCase(casenum__, expected__, new Procrastination().findFinalAssignee(n));
      }
      case 2: {
                long n                    = 20;
                long expected__           = 20;

                return verifyCase(casenum__, expected__, new Procrastination().findFinalAssignee(n));
      }
      case 3: {
                long n                    = 196248;
                long expected__           = 196259;

                return verifyCase(casenum__, expected__, new Procrastination().findFinalAssignee(n));
      }
      case 4: {
                long n                    = 5587021440L;
                long expected__           = 5587021440L;

                return verifyCase(casenum__, expected__, new Procrastination().findFinalAssignee(n));
      }

      // custom cases

      /*      case 5: {
              long n                    = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new Procrastination().findFinalAssignee(n));
              }*/
      /*      case 6: {
              long n                    = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new Procrastination().findFinalAssignee(n));
              }*/
      /*      case 7: {
              long n                    = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new Procrastination().findFinalAssignee(n));
              }*/
      default:
              return -1;
    }
  }
}

// END CUT HERE
