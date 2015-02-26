public class UniformBoard {

  public int getBoard(String[] boardStrs, int K) {
    int N = boardStrs.length;
    char[][] board = new char[N][N];
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        board[i][j] = boardStrs[i].charAt(j);
    int[][] apples = new int[N + 1][N + 1];
    int[][] peers = new int[N + 1][N + 1];
    int[][] empties = new int[N + 1][N + 1];
    for (int i = 0; i <= N; i++) {
      apples[i][0] = 0;
      apples[0][i] = 0;
      peers[i][0] = 0;
      peers[0][i] = 0;
      empties[i][0] = 0;
      empties[0][i] = 0;
    }
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        apples[i][j] = apples[i - 1][j] + apples[i][j - 1] - apples[i - 1][j - 1];
        peers[i][j] = peers[i - 1][j] + peers[i][j - 1] - peers[i - 1][j - 1];
        empties[i][j] = empties[i - 1][j] + empties[i][j - 1] - empties[i - 1][j - 1];
        switch (board[i - 1][j - 1]) {
          case 'A': apples[i][j]++; break;
          case 'P': peers[i][j]++; break;
          case '.': empties[i][j]++; break;
        }
      }
    }
    int max = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int w = 1; i + w <= N; w++) {
          for (int h = 1; j + h <= N; h++) {
            int a = apples[i + w][j + h] - apples[i + w][j] - apples[i][j + h] + apples[i][j],
                p = peers[i + w][j + h] - peers[i + w][j] - peers[i][j + h] + peers[i][j],
                e = empties[i + w][j + h] - empties[i + w][j] - empties[i][j + h] + empties[i][j];
            if (empties[N][N] == 0) {
              if (a == w * h && w * h > max)
                max = w * h;
            }
            else if (apples[N][N] >= w * h) {
              if (2 * p + e <= K && w * h > max)
                max = w * h;
            }
          }
        }
      }
    }
    return max;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      UniformBoardHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        UniformBoardHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class UniformBoardHarness {
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
                String[] board            = {"AP",
                  ".A"};
                int K                     = 0;
                int expected__            = 1;

                return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
      }
      case 1: {
                String[] board            = {"AP",
                  ".A"};
                int K                     = 1;
                int expected__            = 2;

                return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
      }
      case 2: {
                String[] board            = {"PPP",
                  "APA",
                  "A.P"};
                int K                     = 2;
                int expected__            = 3;

                return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
      }
      case 3: {
                String[] board            = {"AAA",
                  "PPP",
                  "AAA"};
                int K                     = 10;
                int expected__            = 3;

                return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
      }
      case 4: {
                String[] board            = {"."};
                int K                     = 1000;
                int expected__            = 0;

                return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
      }
      case 5: {
                String[] board            = {"PPAAPA..AP",
                  "PPA.APAP..",
                  "..P.AA.PPP",
                  "P.P..APAA.",
                  "P.P..P.APA",
                  "PPA..AP.AA",
                  "APP..AAPAA",
                  "P.P.AP...P",
                  ".P.A.PAPPA",
                  "..PAPAP..P"};
                int K                     = 10;
                int expected__            = 15;

                return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
      }

      // custom cases

      /*      case 6: {
              String[] board            = ;
              int K                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
              }*/
      /*      case 7: {
              String[] board            = ;
              int K                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
              }*/
      /*      case 8: {
              String[] board            = ;
              int K                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
