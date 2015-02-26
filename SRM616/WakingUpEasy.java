public class WakingUpEasy {

  public int countAlarms(int[] volume, int S) {

    for (int count = 0, length = volume.length; true; count++) {
      S -= volume[count % length];
      if (S <= 0)
        return count + 1;
    }
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      WakingUpEasyHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        WakingUpEasyHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class WakingUpEasyHarness {
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
                int[] volume              = {5, 2, 4};
                int S                     = 13;
                int expected__            = 4;

                return verifyCase(casenum__, expected__, new WakingUpEasy().countAlarms(volume, S));
      }
      case 1: {
                int[] volume              = {5, 2, 4};
                int S                     = 3;
                int expected__            = 1;

                return verifyCase(casenum__, expected__, new WakingUpEasy().countAlarms(volume, S));
      }
      case 2: {
                int[] volume              = {1};
                int S                     = 10000;
                int expected__            = 10000;

                return verifyCase(casenum__, expected__, new WakingUpEasy().countAlarms(volume, S));
      }
      case 3: {
                int[] volume              = {42, 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83, 22, 17, 19, 96, 48, 27, 72, 39, 70, 13, 68, 100, 36, 95, 4, 12, 23, 34, 74, 65, 42, 12, 54, 69};
                int S                     = 9999;
                int expected__            = 203;

                return verifyCase(casenum__, expected__, new WakingUpEasy().countAlarms(volume, S));
      }

      // custom cases

      /*      case 4: {
              int[] volume              = ;
              int S                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new WakingUpEasy().countAlarms(volume, S));
              }*/
      /*      case 5: {
              int[] volume              = ;
              int S                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new WakingUpEasy().countAlarms(volume, S));
              }*/
      /*      case 6: {
              int[] volume              = ;
              int S                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new WakingUpEasy().countAlarms(volume, S));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
