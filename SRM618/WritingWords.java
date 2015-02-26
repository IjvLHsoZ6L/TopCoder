public class WritingWords {

  public int write(String word) {

    int sum = 0;
    for (int i = 0; i < word.length(); i++)
      sum += (int) (word.charAt(i) - 'A') + 1;

    return sum;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      WritingWordsHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        WritingWordsHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class WritingWordsHarness {
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
                String word               = "A";
                int expected__            = 1;

                return verifyCase(casenum__, expected__, new WritingWords().write(word));
      }
      case 1: {
                String word               = "ABC";
                int expected__            = 6;

                return verifyCase(casenum__, expected__, new WritingWords().write(word));
      }
      case 2: {
                String word               = "VAMOSGIMNASIA";
                int expected__            = 143;

                return verifyCase(casenum__, expected__, new WritingWords().write(word));
      }
      case 3: {
                String word               = "TOPCODER";
                int expected__            = 96;

                return verifyCase(casenum__, expected__, new WritingWords().write(word));
      }
      case 4: {
                String word               = "SINGLEROUNDMATCH";
                int expected__            = 183;

                return verifyCase(casenum__, expected__, new WritingWords().write(word));
      }
      case 5: {
                String word               = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
                int expected__            = 1300;

                return verifyCase(casenum__, expected__, new WritingWords().write(word));
      }

      // custom cases

      /*      case 6: {
              String word               = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new WritingWords().write(word));
              }*/
      /*      case 7: {
              String word               = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new WritingWords().write(word));
              }*/
      /*      case 8: {
              String word               = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new WritingWords().write(word));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
