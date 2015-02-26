public class LCMSetEasy {

  public String include(int[] S, int x) {

    long lcm = 1;
    for (int i = 0, K = S.length; i < K; i++)
      if (x % S[i] == 0)
        lcm = lcm(lcm, S[i]);
    if (lcm == x)
      return "Possible";
    else
      return "Impossible";
  }

  private long gcd(long a, long b) {
    long c;
    while (b > 0) {
      c = a % b;
      a = b;
      b = c;
    }
    return a;
  }

  private long lcm(long a, long b) {
    return a / gcd(a, b) * b;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      LCMSetEasyHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        LCMSetEasyHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class LCMSetEasyHarness {
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

  static boolean compareOutput(String expected, String result) { return expected.equals(result); }
  static String formatResult(String res) {
    return String.format("\"%s\"", res);
  }

  static int verifyCase(int casenum, String expected, String received) { 
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
                int[] S                   = {2,3,4,5};
                int x                     = 20;
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new LCMSetEasy().include(S, x));
      }
      case 1: {
                int[] S                   = {2,3,4};
                int x                     = 611;
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new LCMSetEasy().include(S, x));
      }
      case 2: {
                int[] S                   = {2,3,4};
                int x                     = 12;
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new LCMSetEasy().include(S, x));
      }
      case 3: {
                int[] S                   = {1,2,3,4,5,6,7,8,9,10};
                int x                     = 24;
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new LCMSetEasy().include(S, x));
      }
      case 4: {
                int[] S                   = {100,200,300,400,500,600};
                int x                     = 2000;
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new LCMSetEasy().include(S, x));
      }
      case 5: {
                int[] S                   = {100,200,300,400,500,600};
                int x                     = 8000;
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new LCMSetEasy().include(S, x));
      }
      case 6: {
                int[] S                   = {1000000000,999999999,999999998};
                int x                     = 999999999;
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new LCMSetEasy().include(S, x));
      }

      // custom cases

      /*      case 7: {
              int[] S                   = ;
              int x                     = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new LCMSetEasy().include(S, x));
              }*/
      /*      case 8: {
              int[] S                   = ;
              int x                     = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new LCMSetEasy().include(S, x));
              }*/
      /*      case 9: {
              int[] S                   = ;
              int x                     = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new LCMSetEasy().include(S, x));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
