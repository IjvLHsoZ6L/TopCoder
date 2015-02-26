public class MicroStrings {

  public String makeMicroString(int A, int D) {

    String str = "";
    for (int n = A; n >= 0; n -= D)
      str += String.valueOf(n);

    return str;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      MicroStringsHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        MicroStringsHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class MicroStringsHarness {
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
                int A                     = 12;
                int D                     = 5;
                String expected__         = "1272";

                return verifyCase(casenum__, expected__, new MicroStrings().makeMicroString(A, D));
      }
      case 1: {
                int A                     = 3;
                int D                     = 2;
                String expected__         = "31";

                return verifyCase(casenum__, expected__, new MicroStrings().makeMicroString(A, D));
      }
      case 2: {
                int A                     = 31;
                int D                     = 40;
                String expected__         = "31";

                return verifyCase(casenum__, expected__, new MicroStrings().makeMicroString(A, D));
      }
      case 3: {
                int A                     = 30;
                int D                     = 6;
                String expected__         = "3024181260";

                return verifyCase(casenum__, expected__, new MicroStrings().makeMicroString(A, D));
      }

      // custom cases

      /*      case 4: {
              int A                     = ;
              int D                     = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new MicroStrings().makeMicroString(A, D));
              }*/
      /*      case 5: {
              int A                     = ;
              int D                     = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new MicroStrings().makeMicroString(A, D));
              }*/
      /*      case 6: {
              int A                     = ;
              int D                     = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new MicroStrings().makeMicroString(A, D));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
