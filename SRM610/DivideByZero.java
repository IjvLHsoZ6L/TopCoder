public class DivideByZero {

  public int CountNumbers(int[] numbers) {
    boolean[] onPaper = new boolean[100 + 1];
    for (int n : numbers)
      onPaper[n] = true;
    while (true) {
      boolean changed = false;
      for (int a = 2; a <= 100; a++) {
        if (onPaper[a]) {
          for (int b = 2; b < a; b++) {
            if (onPaper[b]) {
              int c = a / b;
              if (!onPaper[c]) {
                onPaper[c] = true;
                changed = true;
              }
            }
          }
        }
      }
      if (!changed)
        break;
    }
    int count = 0;
    for (int n = 0; n <= 100; n++)
      if (onPaper[n])
        count++;
    return count;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      DivideByZeroHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        DivideByZeroHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class DivideByZeroHarness {
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
                int[] numbers             = {9, 2};
                int expected__            = 3;

                return verifyCase(casenum__, expected__, new DivideByZero().CountNumbers(numbers));
      }
      case 1: {
                int[] numbers             = {8, 2};
                int expected__            = 3;

                return verifyCase(casenum__, expected__, new DivideByZero().CountNumbers(numbers));
      }
      case 2: {
                int[] numbers             = {50};
                int expected__            = 1;

                return verifyCase(casenum__, expected__, new DivideByZero().CountNumbers(numbers));
      }
      case 3: {
                int[] numbers             = {1, 5, 8, 30, 15, 4};
                int expected__            = 11;

                return verifyCase(casenum__, expected__, new DivideByZero().CountNumbers(numbers));
      }
      case 4: {
                int[] numbers             = {1, 2, 4, 8, 16, 32, 64};
                int expected__            = 7;

                return verifyCase(casenum__, expected__, new DivideByZero().CountNumbers(numbers));
      }
      case 5: {
                int[] numbers             = {6, 2, 18};
                int expected__            = 7;

                return verifyCase(casenum__, expected__, new DivideByZero().CountNumbers(numbers));
      }

      // custom cases

      /*      case 6: {
              int[] numbers             = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new DivideByZero().CountNumbers(numbers));
              }*/
      /*      case 7: {
              int[] numbers             = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new DivideByZero().CountNumbers(numbers));
              }*/
      /*      case 8: {
              int[] numbers             = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new DivideByZero().CountNumbers(numbers));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
