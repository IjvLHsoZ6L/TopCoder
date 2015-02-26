public class InterestingNumber {

  public String isInteresting(String x) {

    int l = x.length();

    for (int D = 0; D <= 9; D++) {
      int count = 0,
          first = 0,
          second = 0;
      for (int i = 0; i < l; i++) {
        if (x.charAt(i) == '0' + D) {
          count++;
          if (count == 1)
            first = i;
          else if (count == 2)
            second = i;
        }
      }
      if (count == 0) {
        continue;
      }
      else if (count == 2) {
        if (second - first - 1 == D)
          continue;
        else
          return "Not interesting";
      }
      else {
        return "Not interesting";
      }
    }
    return "Interesting";
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      InterestingNumberHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        InterestingNumberHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class InterestingNumberHarness {
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
                String x                  = "2002";
                String expected__         = "Interesting";

                return verifyCase(casenum__, expected__, new InterestingNumber().isInteresting(x));
      }
      case 1: {
                String x                  = "1001";
                String expected__         = "Not interesting";

                return verifyCase(casenum__, expected__, new InterestingNumber().isInteresting(x));
      }
      case 2: {
                String x                  = "41312432";
                String expected__         = "Interesting";

                return verifyCase(casenum__, expected__, new InterestingNumber().isInteresting(x));
      }
      case 3: {
                String x                  = "611";
                String expected__         = "Not interesting";

                return verifyCase(casenum__, expected__, new InterestingNumber().isInteresting(x));
      }
      case 4: {
                String x                  = "64200246";
                String expected__         = "Interesting";

                return verifyCase(casenum__, expected__, new InterestingNumber().isInteresting(x));
      }
      case 5: {
                String x                  = "631413164";
                String expected__         = "Not interesting";

                return verifyCase(casenum__, expected__, new InterestingNumber().isInteresting(x));
      }

      // custom cases

      /*      case 6: {
              String x                  = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new InterestingNumber().isInteresting(x));
              }*/
      /*      case 7: {
              String x                  = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new InterestingNumber().isInteresting(x));
              }*/
      /*      case 8: {
              String x                  = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new InterestingNumber().isInteresting(x));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
