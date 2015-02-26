import java.util.*;

public class CycleColoring {

  public int countColorings(int[] vertexCount, int[] fromVertex, int[] toVertex, int K) {

    int modulo = 1000000007;

    int N = vertexCount.length;

    int maxLength = 0;
    for (int i = 0; i < N; i++) {
      int m = (fromVertex[i] - toVertex[(i - 1 + N) % N] + vertexCount[i]) % vertexCount[i];
      int n = vertexCount[i] - m;
      maxLength = Math.max(maxLength, Math.max(m, n));
    }

    long[][] subcount = new long[maxLength + 1][3];
    subcount[0][0] = 1L;

    for (int i = 0; i < maxLength; i++) {
      subcount[i + 1][0] = (subcount[i][1] + subcount[i][2]) % modulo;
      subcount[i + 1][1] = (subcount[i][0] + subcount[i][2]) % modulo;
      subcount[i + 1][2] = (subcount[i][0] * (K - 2) + subcount[i][1] * (K - 2) + subcount[i][2] * (K - 3)) % modulo;
    }

    long[][] count = new long[N + 1][2];
    count[0][0] = 1L;

    for (int i = 0; i < N; i++) {
      int m = (fromVertex[i] - toVertex[(i - 1 + N) % N] + vertexCount[i]) % vertexCount[i];
      int n = vertexCount[i] - m;
      count[i + 1][0] =
        (count[i][0] * subcount[m][0] % modulo * subcount[n][0] % modulo +
         count[i][1] * subcount[m][1] % modulo * subcount[n][1] % modulo) % modulo;
      count[i + 1][1] =
        (count[i][0] * subcount[m][1] % modulo * subcount[n][1] % modulo * (K - 1) % modulo +
         count[i][1] * subcount[m][0] % modulo * subcount[n][0] % modulo +
         count[i][1] * subcount[m][1] % modulo * subcount[n][1] % modulo * (K - 2) % modulo) % modulo;
    }

    return (int)(count[N][0] * K % modulo);
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      CycleColoringHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        CycleColoringHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class CycleColoringHarness {
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
                int[] vertexCount         = {3, 3};
                int[] fromVertex          = {0, 0};
                int[] toVertex            = {0, 0};
                int K                     = 3;
                int expected__            = 12;

                return verifyCase(casenum__, expected__, new CycleColoring().countColorings(vertexCount, fromVertex, toVertex, K));
      }
      case 1: {
                int[] vertexCount         = {6};
                int[] fromVertex          = {4};
                int[] toVertex            = {1};
                int K                     = 3;
                int expected__            = 12;

                return verifyCase(casenum__, expected__, new CycleColoring().countColorings(vertexCount, fromVertex, toVertex, K));
      }
      case 2: {
                int[] vertexCount         = {3, 3};
                int[] fromVertex          = {0, 1};
                int[] toVertex            = {1, 2};
                int K                     = 3;
                int expected__            = 0;

                return verifyCase(casenum__, expected__, new CycleColoring().countColorings(vertexCount, fromVertex, toVertex, K));
      }
      case 3: {
                int[] vertexCount         = {9, 5};
                int[] fromVertex          = {8, 3};
                int[] toVertex            = {0, 2};
                int K                     = 8;
                int expected__            = 589124602;

                return verifyCase(casenum__, expected__, new CycleColoring().countColorings(vertexCount, fromVertex, toVertex, K));
      }
      case 4: {
                int[] vertexCount         = {14, 15, 16, 17};
                int[] fromVertex          = {5, 10, 4, 6};
                int[] toVertex            = {10, 3, 14, 10};
                int K                     = 614;
                int expected__            = 818050159;

                return verifyCase(casenum__, expected__, new CycleColoring().countColorings(vertexCount, fromVertex, toVertex, K));
      }
      case 5: {
                int[] vertexCount         = {482373, 283712, 883, 12834, 5, 5, 482734, 99912, 35881, 277590};
                int[] fromVertex          = {59283, 49782, 0, 0, 3, 2, 84791, 40017, 2263, 461};
                int[] toVertex            = {150173, 709, 11108, 0, 4, 7, 5902, 712, 190232, 390331};
                int K                     = 479360784;
                int expected__            = 763634309;

                return verifyCase(casenum__, expected__, new CycleColoring().countColorings(vertexCount, fromVertex, toVertex, K));
      }

      // custom cases

      /*      case 6: {
              int[] vertexCount         = ;
              int[] fromVertex          = ;
              int[] toVertex            = ;
              int K                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new CycleColoring().countColorings(vertexCount, fromVertex, toVertex, K));
              }*/
      /*      case 7: {
              int[] vertexCount         = ;
              int[] fromVertex          = ;
              int[] toVertex            = ;
              int K                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new CycleColoring().countColorings(vertexCount, fromVertex, toVertex, K));
              }*/
      /*      case 8: {
              int[] vertexCount         = ;
              int[] fromVertex          = ;
              int[] toVertex            = ;
              int K                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new CycleColoring().countColorings(vertexCount, fromVertex, toVertex, K));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
