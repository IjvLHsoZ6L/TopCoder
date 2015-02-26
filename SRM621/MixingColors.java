public class MixingColors {

  public int minColors(int[] colors) {
    int N = colors.length,
        DIM = 32;
    int[][] matrix = new int[N][DIM];
    for (int i = 0; i < N; i++)
      for (int j = 0, c = colors[i]; c > 0; j++, c /= 2)
        matrix[i][j] = c % 2;
    int r = 0;
    for (int j0 = 0; r < N && j0 < DIM; j0++) {
      int i0 = r;
      while (i0 < N && matrix[i0][j0] == 0)
        i0++;
      if (i0 < N) {
        if (i0 > r)
          for (int j = j0; j < DIM; j++)
            matrix[r][j] = (matrix[r][j] + matrix[i0][j]) % 2;
        for (int i = r + 1; i < N; i++)
          if (matrix[i][j0] != 0)
            for (int j = j0; j < DIM; j++)
              matrix[i][j] = (matrix[i][j] + matrix[r][j]) % 2;
        r++;
      }
    }
    return r;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      MixingColorsHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        MixingColorsHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class MixingColorsHarness {
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
                int[] colors              = {1, 7, 3};
                int expected__            = 3;

                return verifyCase(casenum__, expected__, new MixingColors().minColors(colors));
      }
      case 1: {
                int[] colors              = {10};
                int expected__            = 1;

                return verifyCase(casenum__, expected__, new MixingColors().minColors(colors));
      }
      case 2: {
                int[] colors              = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
                int expected__            = 4;

                return verifyCase(casenum__, expected__, new MixingColors().minColors(colors));
      }
      case 3: {
                int[] colors              = {534, 251, 76, 468, 909, 410, 264, 387, 102, 982, 199, 111, 659, 386, 151};
                int expected__            = 10;

                return verifyCase(casenum__, expected__, new MixingColors().minColors(colors));
      }
      case 4: {
                int[] colors              = {4, 8, 16, 32, 64, 128, 256, 512, 1024};
                int expected__            = 9;

                return verifyCase(casenum__, expected__, new MixingColors().minColors(colors));
      }

      // custom cases

      /*      case 5: {
              int[] colors              = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new MixingColors().minColors(colors));
              }*/
      /*      case 6: {
              int[] colors              = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new MixingColors().minColors(colors));
              }*/
      /*      case 7: {
              int[] colors              = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new MixingColors().minColors(colors));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
