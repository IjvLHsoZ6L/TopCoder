public class LongLongTripDiv2 {

  public String isAble(long D, int T, int B) {

    if (T <= D && (D - T) % (B - 1) == 0 && (D - T) / (B - 1) <= T)
      return "Possible";
    else
      return "Impossible";
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      LongLongTripDiv2Harness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        LongLongTripDiv2Harness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class LongLongTripDiv2Harness {
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
                long D                    = 10;
                int T                     = 6;
                int B                     = 3;
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new LongLongTripDiv2().isAble(D, T, B));
      }
      case 1: {
                long D                    = 10;
                int T                     = 5;
                int B                     = 3;
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new LongLongTripDiv2().isAble(D, T, B));
      }
      case 2: {
                long D                    = 50;
                int T                     = 100;
                int B                     = 2;
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new LongLongTripDiv2().isAble(D, T, B));
      }
      case 3: {
                long D                    = 120;
                int T                     = 10;
                int B                     = 11;
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new LongLongTripDiv2().isAble(D, T, B));
      }
      case 4: {
                long D                    = 10;
                int T                     = 10;
                int B                     = 9999;
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new LongLongTripDiv2().isAble(D, T, B));
      }
      case 5: {
                long D                    = 1000;
                int T                     = 100;
                int B                     = 10;
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new LongLongTripDiv2().isAble(D, T, B));
      }
      case 6: {
                long D                    = 1000010000100001L;
                int T                     = 1100011;
                int B                     = 1000000000;
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new LongLongTripDiv2().isAble(D, T, B));
      }

      // custom cases

      /*      case 7: {
              long D                    = ;
              int T                     = ;
              int B                     = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new LongLongTripDiv2().isAble(D, T, B));
              }*/
      /*      case 8: {
              long D                    = ;
              int T                     = ;
              int B                     = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new LongLongTripDiv2().isAble(D, T, B));
              }*/
      /*      case 9: {
              long D                    = ;
              int T                     = ;
              int B                     = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new LongLongTripDiv2().isAble(D, T, B));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
