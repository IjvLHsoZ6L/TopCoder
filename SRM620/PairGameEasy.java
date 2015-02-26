public class PairGameEasy {

  public String able(int a, int b, int c, int d) {

    while (true) {

      if (a == c && b == d)
        return "Able to generate";

      else if (c == d)
        return "Not able to generate";

      else if (c < d)
        d -= c;

      else if (c > d)
        c -= d;
    }
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      PairGameEasyHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        PairGameEasyHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class PairGameEasyHarness {
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
                int a                     = 1;
                int b                     = 2;
                int c                     = 3;
                int d                     = 5;
                String expected__         = "Able to generate";

                return verifyCase(casenum__, expected__, new PairGameEasy().able(a, b, c, d));
      }
      case 1: {
                int a                     = 1;
                int b                     = 2;
                int c                     = 2;
                int d                     = 1;
                String expected__         = "Not able to generate";

                return verifyCase(casenum__, expected__, new PairGameEasy().able(a, b, c, d));
      }
      case 2: {
                int a                     = 2;
                int b                     = 2;
                int c                     = 2;
                int d                     = 999;
                String expected__         = "Not able to generate";

                return verifyCase(casenum__, expected__, new PairGameEasy().able(a, b, c, d));
      }
      case 3: {
                int a                     = 2;
                int b                     = 2;
                int c                     = 2;
                int d                     = 1000;
                String expected__         = "Able to generate";

                return verifyCase(casenum__, expected__, new PairGameEasy().able(a, b, c, d));
      }
      case 4: {
                int a                     = 47;
                int b                     = 58;
                int c                     = 384;
                int d                     = 221;
                String expected__         = "Able to generate";

                return verifyCase(casenum__, expected__, new PairGameEasy().able(a, b, c, d));
      }
      case 5: {
                int a                     = 1000;
                int b                     = 1000;
                int c                     = 1000;
                int d                     = 1000;
                String expected__         = "Able to generate";

                return verifyCase(casenum__, expected__, new PairGameEasy().able(a, b, c, d));
      }

      // custom cases

      /*      case 6: {
              int a                     = ;
              int b                     = ;
              int c                     = ;
              int d                     = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new PairGameEasy().able(a, b, c, d));
              }*/
      /*      case 7: {
              int a                     = ;
              int b                     = ;
              int c                     = ;
              int d                     = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new PairGameEasy().able(a, b, c, d));
              }*/
      /*      case 8: {
              int a                     = ;
              int b                     = ;
              int c                     = ;
              int d                     = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new PairGameEasy().able(a, b, c, d));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
