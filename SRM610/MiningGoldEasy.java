public class MiningGoldEasy {

  public int GetMaximumGold(int N, int M, int[] X, int[] Y) {
    int D = X.length;
    int[][][] minLoss = new int[D + 1][D][D];
    for (int d = 1; d <= D; d++)
      for (int i = 0; i < D; i++)
        for (int j = 0; j < D; j++)
          minLoss[d][i][j] = Integer.MAX_VALUE;
    for (int d = 0; d < D; d++) {
      for (int i = 0; i < D; i++) {
        for (int j = 0; j < D; j++) {
          minLoss[d][i][j] += Math.abs(X[i] - X[d]) + Math.abs(Y[j] - Y[d]);
          for (int k = 0; k < D; k++) {
            minLoss[d + 1][k][j] = Math.min(minLoss[d + 1][k][j], minLoss[d][i][j]);
            minLoss[d + 1][i][k] = Math.min(minLoss[d + 1][i][k], minLoss[d][i][j]);
          }
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < D; i++)
      for (int j = 0; j < D; j++)
        if (minLoss[D][i][j] < min)
          min = minLoss[D][i][j];
    return D * (N + M) - min;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      MiningGoldEasyHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        MiningGoldEasyHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class MiningGoldEasyHarness {
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
                int N                     = 2;
                int M                     = 2;
                int[] event_i             = {0};
                int[] event_j             = {0};
                int expected__            = 4;

                return verifyCase(casenum__, expected__, new MiningGoldEasy().GetMaximumGold(N, M, event_i, event_j));
      }
      case 1: {
                int N                     = 2;
                int M                     = 2;
                int[] event_i             = {0, 2};
                int[] event_j             = {0, 1};
                int expected__            = 7;

                return verifyCase(casenum__, expected__, new MiningGoldEasy().GetMaximumGold(N, M, event_i, event_j));
      }
      case 2: {
                int N                     = 3;
                int M                     = 3;
                int[] event_i             = {0, 3, 3};
                int[] event_j             = {0, 3, 0};
                int expected__            = 15;

                return verifyCase(casenum__, expected__, new MiningGoldEasy().GetMaximumGold(N, M, event_i, event_j));
      }
      case 3: {
                int N                     = 3;
                int M                     = 4;
                int[] event_i             = {0, 3};
                int[] event_j             = {4, 1};
                int expected__            = 11;

                return verifyCase(casenum__, expected__, new MiningGoldEasy().GetMaximumGold(N, M, event_i, event_j));
      }
      case 4: {
                int N                     = 5;
                int M                     = 6;
                int[] event_i             = {0, 4, 2, 5, 0};
                int[] event_j             = {3, 4, 5, 6, 0};
                int expected__            = 48;

                return verifyCase(casenum__, expected__, new MiningGoldEasy().GetMaximumGold(N, M, event_i, event_j));
      }
      case 5: {
                int N                     = 557;
                int M                     = 919;
                int[] event_i             = {81, 509, 428, 6, 448, 149, 77, 142, 40, 405, 109, 247};
                int[] event_j             = {653, 887, 770, 477, 53, 637, 201, 863, 576, 393, 512, 243};
                int expected__            = 16255;

                return verifyCase(casenum__, expected__, new MiningGoldEasy().GetMaximumGold(N, M, event_i, event_j));
      }

      // custom cases

      /*      case 6: {
              int N                     = ;
              int M                     = ;
              int[] event_i             = ;
              int[] event_j             = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new MiningGoldEasy().GetMaximumGold(N, M, event_i, event_j));
              }*/
      /*      case 7: {
              int N                     = ;
              int M                     = ;
              int[] event_i             = ;
              int[] event_j             = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new MiningGoldEasy().GetMaximumGold(N, M, event_i, event_j));
              }*/
      /*      case 8: {
              int N                     = ;
              int M                     = ;
              int[] event_i             = ;
              int[] event_j             = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new MiningGoldEasy().GetMaximumGold(N, M, event_i, event_j));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
