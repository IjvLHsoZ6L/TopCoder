public class BoxesDiv2 {

  public int findSize(int[] candyCounts) {
    int boxes = candyCounts.length;
    int boxCounts[] = new int[32];
    for (int i = 0; i < boxes; i++) {
      int j = 0;
      while ((1 << j) < candyCounts[i])
        j++;
      boxCounts[j]++;
    }
    int minIdx = 0;
    while (true) {
      while (boxCounts[minIdx] == 0)
        minIdx++;
      if (boxes == 1)
        return 1 << minIdx;
      int q = boxCounts[minIdx] / 2,
          r = boxCounts[minIdx] % 2;
      minIdx++;
      boxCounts[minIdx] += q + r;
      boxes -= q;
    }
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      BoxesDiv2Harness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        BoxesDiv2Harness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class BoxesDiv2Harness {
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
                int[] candyCounts         = {8,8};
                int expected__            = 16;

                return verifyCase(casenum__, expected__, new BoxesDiv2().findSize(candyCounts));
      }
      case 1: {
                int[] candyCounts         = {5,6};
                int expected__            = 16;

                return verifyCase(casenum__, expected__, new BoxesDiv2().findSize(candyCounts));
      }
      case 2: {
                int[] candyCounts         = {1,7};
                int expected__            = 16;

                return verifyCase(casenum__, expected__, new BoxesDiv2().findSize(candyCounts));
      }
      case 3: {
                int[] candyCounts         = {1,1,13,1,1};
                int expected__            = 32;

                return verifyCase(casenum__, expected__, new BoxesDiv2().findSize(candyCounts));
      }
      case 4: {
                int[] candyCounts         = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32};
                int expected__            = 1024;

                return verifyCase(casenum__, expected__, new BoxesDiv2().findSize(candyCounts));
      }

      // custom cases

      /*      case 5: {
              int[] candyCounts         = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new BoxesDiv2().findSize(candyCounts));
              }*/
      /*      case 6: {
              int[] candyCounts         = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new BoxesDiv2().findSize(candyCounts));
              }*/
      /*      case 7: {
              int[] candyCounts         = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new BoxesDiv2().findSize(candyCounts));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
