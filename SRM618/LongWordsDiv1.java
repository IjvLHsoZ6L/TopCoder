import java.util.*;

public class LongWordsDiv1 {

  public int count(int n) {

    int modulo = 1000000007;

    int[][] pattern = new int[n + 1][n];
    pattern[1][0] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = i - 2, sum = pattern[i - 1][j]; j > 0; j--, sum = (sum + pattern[i - 1][j]) % modulo)
        pattern[i][j - 1] = (pattern[i][j - 1] + sum) % modulo;
      for (int j = 0; j < i - 1; j++)
        pattern[i][j + 1] = (pattern[i][j + 1] + pattern[i - 1][j]) % modulo;
    }

    int answer = 0;
    for (int i = 0; i < n; i++)
      answer = (answer + pattern[n][i]) % modulo;

    for (int i = 1; i <= n; i++)
      answer = product(answer, i, modulo);

    return answer;
  }

  int product(int a, int b, int modulo) {
    int product = 0,
        sum = a;
    while (b > 0) {
      if (b % 2 == 1)
        product = (product + sum) % modulo;
      b /= 2;
      sum = (sum + sum) % modulo;
    }
    return product;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      LongWordsDiv1Harness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        LongWordsDiv1Harness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class LongWordsDiv1Harness {
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
                int n                     = 1;
                int expected__            = 1;

                return verifyCase(casenum__, expected__, new LongWordsDiv1().count(n));
      }
      case 1: {
                int n                     = 2;
                int expected__            = 2;

                return verifyCase(casenum__, expected__, new LongWordsDiv1().count(n));
      }
      case 2: {
                int n                     = 5;
                int expected__            = 1080;

                return verifyCase(casenum__, expected__, new LongWordsDiv1().count(n));
      }
      case 3: {
                int n                     = 100;
                int expected__            = 486425238;

                return verifyCase(casenum__, expected__, new LongWordsDiv1().count(n));
      }

      // custom cases

      /*      case 4: {
              int n                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new LongWordsDiv1().count(n));
              }*/
      /*      case 5: {
              int n                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new LongWordsDiv1().count(n));
              }*/
      /*      case 6: {
              int n                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new LongWordsDiv1().count(n));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
