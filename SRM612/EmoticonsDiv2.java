public class EmoticonsDiv2 {

  public int printSmiles(int smiles) {

    int[][] minimumTime = new int[smiles + 1][smiles + 1];
    for (int i = 0; i <= smiles; i++)
      for (int j = 0; j <= smiles; j++)
        minimumTime[i][j] = Integer.MAX_VALUE;
    minimumTime[1][0] = 0;
    for (int i = 0; i <= smiles; i++) {
      for (int j = 0; j <= smiles; j++) {
        if (minimumTime[i][j] < Integer.MAX_VALUE) {
          if (minimumTime[i][j] + 1 < minimumTime[i][i])
            minimumTime[i][i] = minimumTime[i][j] + 1;
          if (i + j <= smiles && minimumTime[i][j] + 1 < minimumTime[i + j][j])
            minimumTime[i + j][j] = minimumTime[i][j] + 1;
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int j = 0; j <= smiles; j++)
      if (minimumTime[smiles][j] >= 0 && minimumTime[smiles][j] < min)
        min = minimumTime[smiles][j];
    return min;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      EmoticonsDiv2Harness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        EmoticonsDiv2Harness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class EmoticonsDiv2Harness {
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
                int smiles                = 2;
                int expected__            = 2;

                return verifyCase(casenum__, expected__, new EmoticonsDiv2().printSmiles(smiles));
      }
      case 1: {
                int smiles                = 6;
                int expected__            = 5;

                return verifyCase(casenum__, expected__, new EmoticonsDiv2().printSmiles(smiles));
      }
      case 2: {
                int smiles                = 11;
                int expected__            = 11;

                return verifyCase(casenum__, expected__, new EmoticonsDiv2().printSmiles(smiles));
      }
      case 3: {
                int smiles                = 16;
                int expected__            = 8;

                return verifyCase(casenum__, expected__, new EmoticonsDiv2().printSmiles(smiles));
      }
      case 4: {
                int smiles                = 1000;
                int expected__            = 21;

                return verifyCase(casenum__, expected__, new EmoticonsDiv2().printSmiles(smiles));
      }

      // custom cases

      /*      case 5: {
              int smiles                = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new EmoticonsDiv2().printSmiles(smiles));
              }*/
      /*      case 6: {
              int smiles                = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new EmoticonsDiv2().printSmiles(smiles));
              }*/
      /*      case 7: {
              int smiles                = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new EmoticonsDiv2().printSmiles(smiles));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
