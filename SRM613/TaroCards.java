public class TaroCards {

  public long getNumber(int[] first, int[] second, int K) {

    int N = first.length;
    long[][][] ways = new long[N + 1][K + 1][1 << 11];
    ways[0][0][0] = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j <= K; j++) {
        for (int k = 0; k < (1 << 11); k += 2) {
          ways[i + 1][j][k] += ways[i][j][k];
          int jj = j,
              kk = k;
          if (first[i] > 10)
            jj++;
          else if ((kk & (1 << first[i])) == 0) {
            jj++;
            kk |= (1 << first[i]);
          }
          if ((kk & (1 << second[i])) == 0) {
            jj++;
            kk |= (1 << second[i]);
          }
          if (jj <= K)
            ways[i + 1][jj][kk] += ways[i][j][k];
        }
      }
    }
    long sum = 0;
    for (int j = 0; j <= K; j++)
      for (int k = 0; k < (1 << 11); k += 2)
        sum += ways[N][j][k];
    return sum;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      TaroCardsHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        TaroCardsHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class TaroCardsHarness {
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

  static boolean compareOutput(long expected, long result) { return expected == result; }
  static String formatResult(long res) {
    return String.format("%d", res);
  }

  static int verifyCase(int casenum, long expected, long received) { 
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
                int[] first               = {1, 2};
                int[] second              = {2, 3};
                int K                     = 2;
                long expected__           = 3;

                return verifyCase(casenum__, expected__, new TaroCards().getNumber(first, second, K));
      }
      case 1: {
                int[] first               = {3, 1, 2};
                int[] second              = {1, 1, 1};
                int K                     = 3;
                long expected__           = 8;

                return verifyCase(casenum__, expected__, new TaroCards().getNumber(first, second, K));
      }
      case 2: {
                int[] first               = {4, 2, 1, 3};
                int[] second              = {1, 2, 3, 4};
                int K                     = 5;
                long expected__           = 16;

                return verifyCase(casenum__, expected__, new TaroCards().getNumber(first, second, K));
      }
      case 3: {
                int[] first               = {1, 2, 3, 4, 5, 6, 7};
                int[] second              = {2, 1, 10, 9, 3, 2, 2};
                int K                     = 3;
                long expected__           = 17;

                return verifyCase(casenum__, expected__, new TaroCards().getNumber(first, second, K));
      }
      case 4: {
                int[] first               = {1};
                int[] second              = {2};
                int K                     = 1;
                long expected__           = 1;

                return verifyCase(casenum__, expected__, new TaroCards().getNumber(first, second, K));
      }
      case 5: {
                int[] first               = {6, 20, 1, 11, 19, 14, 2, 8, 15, 21, 9, 10, 4, 16, 12, 17, 13, 22, 7, 18, 3, 5};
                int[] second              = {4, 5, 10, 7, 6, 2, 1, 10, 10, 7, 9, 4, 5, 9, 5, 10, 10, 3, 6, 6, 4, 4};
                int K                     = 14;
                long expected__           = 2239000;

                return verifyCase(casenum__, expected__, new TaroCards().getNumber(first, second, K));
      }

      // custom cases

      /*      case 6: {
              int[] first               = ;
              int[] second              = ;
              int K                     = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new TaroCards().getNumber(first, second, K));
              }*/
      /*      case 7: {
              int[] first               = ;
              int[] second              = ;
              int K                     = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new TaroCards().getNumber(first, second, K));
              }*/
      /*      case 8: {
              int[] first               = ;
              int[] second              = ;
              int K                     = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new TaroCards().getNumber(first, second, K));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
