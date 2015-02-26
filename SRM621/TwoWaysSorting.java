public class TwoWaysSorting {

  public String sortingMethod(String[] stringList) {

    boolean lexicographically = true,
            lengths = true;
    for (int i = 0, n = stringList.length; i + 1 < n; i++) {
      lexicographically &= stringList[i].compareTo(stringList[i + 1]) < 0;
      lengths &= stringList[i].length() < stringList[i + 1].length();
    }
    if (lexicographically) {
      if (lengths)
        return "both";
      else
        return "lexicographically";
    }
    else {
      if (lengths)
        return "lengths";
      else
        return "none";
    }
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      TwoWaysSortingHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        TwoWaysSortingHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class TwoWaysSortingHarness {
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

  static boolean compareOutput(String expected, String result) { return expected.equals(result); }
  static String formatResult(String res) {
    return String.format("\"%s\"", res);
  }

  static int verifyCase(int casenum, String expected, String received) { 
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
                String[] stringList       = {"a", "aa", "bbb"};
                String expected__         = "both";

                return verifyCase(casenum__, expected__, new TwoWaysSorting().sortingMethod(stringList));
      }
      case 1: {
                String[] stringList       = {"c", "bb", "aaa"};
                String expected__         = "lengths";

                return verifyCase(casenum__, expected__, new TwoWaysSorting().sortingMethod(stringList));
      }
      case 2: {
                String[] stringList       = {"etdfgfh", "aio"};
                String expected__         = "none";

                return verifyCase(casenum__, expected__, new TwoWaysSorting().sortingMethod(stringList));
      }
      case 3: {
                String[] stringList       = {"aaa", "z"};
                String expected__         = "lexicographically";

                return verifyCase(casenum__, expected__, new TwoWaysSorting().sortingMethod(stringList));
      }
      case 4: {
                String[] stringList       = {"z"};
                String expected__         = "both";

                return verifyCase(casenum__, expected__, new TwoWaysSorting().sortingMethod(stringList));
      }
      case 5: {
                String[] stringList       = {"abcdef", "bcdef", "cdef", "def", "ef", "f", "topcoder"};
                String expected__         = "lexicographically";

                return verifyCase(casenum__, expected__, new TwoWaysSorting().sortingMethod(stringList));
      }

      // custom cases

      /*      case 6: {
              String[] stringList       = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new TwoWaysSorting().sortingMethod(stringList));
              }*/
      /*      case 7: {
              String[] stringList       = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new TwoWaysSorting().sortingMethod(stringList));
              }*/
      /*      case 8: {
              String[] stringList       = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new TwoWaysSorting().sortingMethod(stringList));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
