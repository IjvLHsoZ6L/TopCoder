import java.util.*;

public class MinimumSquare {

  public long minArea(int[] x, int[] y, int K) {

    int N = x.length;

    int[] X = Arrays.copyOf(x, N + 1);
    X[N] = Integer.MAX_VALUE;
    Arrays.sort(X);

    int[] Y = Arrays.copyOf(y, N + 1);
    Y[N] = Integer.MAX_VALUE;
    Arrays.sort(Y);

    int[][] count = new int[N + 1][N + 1];
    for (int i = 0; i <= N; i++)
      for (int j = 0; j <= N; j++)
        for (int k = 0; k < N; k++)
          if (x[k] < X[i] && y[k] < Y[j])
            count[i][j]++;

    long minArea = Long.MAX_VALUE;
    for (int i = 0; i < N; i++)
      for (int ii = i + 1; ii <= N; ii++)
        for (int j = 0; j < N; j++)
          for (int jj = j + 1; jj <= N; jj++)
            if (count[ii][jj] - count[ii][j] - count[i][jj] + count[i][j] >= K)
              minArea = Math.min(minArea, square(Math.max(X[ii - 1] - X[i], Y[jj - 1] - Y[j]) + 2));

    return minArea;
  }

  long square(long a) {
    return a * a;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      MinimumSquareHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        MinimumSquareHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class MinimumSquareHarness {
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
                int[] x                   = {0, 3};
                int[] y                   = {0, 7};
                int K                     = 2;
                long expected__           = 81;

                return verifyCase(casenum__, expected__, new MinimumSquare().minArea(x, y, K));
      }
      case 1: {
                int[] x                   = {-4, 3, 1};
                int[] y                   = {3 , -1, -2};
                int K                     = 2;
                long expected__           = 16;

                return verifyCase(casenum__, expected__, new MinimumSquare().minArea(x, y, K));
      }
      case 2: {
                int[] x                   = {0, 0, 1, 1, 2, 2};
                int[] y                   = {0, 1, 0, 1, 0, 1};
                int K                     = 4;
                long expected__           = 9;

                return verifyCase(casenum__, expected__, new MinimumSquare().minArea(x, y, K));
      }
      case 3: {
                int[] x                   = {1000000000, 1000000000, 1000000000, -1000000000, -1000000000, -1000000000};
                int[] y                   = {1000000000, 0, -1000000000, 1000000000, 0, -1000000000};
                int K                     = 3;
                long expected__           = 4000000008000000004L;

                return verifyCase(casenum__, expected__, new MinimumSquare().minArea(x, y, K));
      }
      case 4: {
                int[] x                   = {-47881, 28623, 1769, -38328, -16737, 16653, -23181, 37360, 41429, 26282, 254, 728, 8299, -41080, -29498, 17488, -23937, -11, 33319, 25232};
                int[] y                   = {-46462, 48985, -43820, -19587, -33593, -28337, 13667, -48131, -5568, -2332, -41918, -31370, -3695, 42599, -37788, -40096, 39049, 25045, -2122, 3874};
                int K                     = 8;
                long expected__           = 1695545329;

                return verifyCase(casenum__, expected__, new MinimumSquare().minArea(x, y, K));
      }

      // custom cases

      /*      case 5: {
              int[] x                   = ;
              int[] y                   = ;
              int K                     = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new MinimumSquare().minArea(x, y, K));
              }*/
      /*      case 6: {
              int[] x                   = ;
              int[] y                   = ;
              int K                     = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new MinimumSquare().minArea(x, y, K));
              }*/
      /*      case 7: {
              int[] x                   = ;
              int[] y                   = ;
              int K                     = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new MinimumSquare().minArea(x, y, K));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
