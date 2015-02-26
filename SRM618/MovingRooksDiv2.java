public class MovingRooksDiv2 {

  public String move(int[] Y1, int[] Y2) {

    for (int i = 0, n = Y1.length; i + 1 < n; i++) {
      if (Y1[i] < Y2[i])
        return "Impossible";
      while (Y1[i] > Y2[i]) {
        int temp = Y1[i],
            j = i + 1;
        while (Y1[j] < Y2[i] || Y1[j] > Y1[i])
          j++;
        Y1[i] = Y1[j];
        Y1[j] = temp;
      }
    }

    return "Possible";
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      MovingRooksDiv2Harness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        MovingRooksDiv2Harness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class MovingRooksDiv2Harness {
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
                int[] Y1                  = {0};
                int[] Y2                  = {0};
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new MovingRooksDiv2().move(Y1, Y2));
      }
      case 1: {
                int[] Y1                  = {1,0};
                int[] Y2                  = {0,1};
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new MovingRooksDiv2().move(Y1, Y2));
      }
      case 2: {
                int[] Y1                  = {0,1};
                int[] Y2                  = {1,0};
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new MovingRooksDiv2().move(Y1, Y2));
      }
      case 3: {
                int[] Y1                  = {3,1,2,0};
                int[] Y2                  = {0,2,1,3};
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new MovingRooksDiv2().move(Y1, Y2));
      }
      case 4: {
                int[] Y1                  = {3,1,2,0};
                int[] Y2                  = {3,2,0,1};
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new MovingRooksDiv2().move(Y1, Y2));
      }

      // custom cases

      /*      case 5: {
              int[] Y1                  = ;
              int[] Y2                  = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new MovingRooksDiv2().move(Y1, Y2));
              }*/
      /*      case 6: {
              int[] Y1                  = ;
              int[] Y2                  = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new MovingRooksDiv2().move(Y1, Y2));
              }*/
      /*      case 7: {
              int[] Y1                  = ;
              int[] Y2                  = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new MovingRooksDiv2().move(Y1, Y2));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
