public class NumbersChallenge {

  public int MinNumber(int[] S) {
    int N = S.length,
        sumOfAll = 0;
    for (int n : S)
      sumOfAll += n;
    boolean[] possible = new boolean[sumOfAll + 1];
    possible[0] = true;
    for (int n : S)
      for (int s = sumOfAll - n; s >= 0; s--)
        if (possible[s])
          possible[s + n] = true;
    int s = 1;
    while (s <= sumOfAll && possible[s])
      s++;
    return s;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      NumbersChallengeHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        NumbersChallengeHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class NumbersChallengeHarness {
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
                int[] S                   = {5, 1, 2};
                int expected__            = 4;

                return verifyCase(casenum__, expected__, new NumbersChallenge().MinNumber(S));
      }
      case 1: {
                int[] S                   = {2, 1, 4};
                int expected__            = 8;

                return verifyCase(casenum__, expected__, new NumbersChallenge().MinNumber(S));
      }
      case 2: {
                int[] S                   = {2, 1, 2, 7};
                int expected__            = 6;

                return verifyCase(casenum__, expected__, new NumbersChallenge().MinNumber(S));
      }
      case 3: {
                int[] S                   = {94512, 2, 87654, 81316, 6, 5, 6, 37151, 6, 139, 1, 36, 307, 1, 377, 101, 8, 37, 58, 1};
                int expected__            = 1092;

                return verifyCase(casenum__, expected__, new NumbersChallenge().MinNumber(S));
      }
      case 4: {
                int[] S                   = {883, 66392, 3531, 28257, 1, 14131, 57, 1, 25, 88474, 4, 1, 110, 6, 1769, 220, 442, 7064, 7, 13};
                int expected__            = 56523;

                return verifyCase(casenum__, expected__, new NumbersChallenge().MinNumber(S));
      }

      // custom cases

      /*      case 5: {
              int[] S                   = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new NumbersChallenge().MinNumber(S));
              }*/
      /*      case 6: {
              int[] S                   = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new NumbersChallenge().MinNumber(S));
              }*/
      /*      case 7: {
              int[] S                   = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new NumbersChallenge().MinNumber(S));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
