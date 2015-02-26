public class ColorfulCoinsEasy {

  public String isPossible(int[] values) {

    int coins = values.length;

    int[] ratio = new int[coins - 1];
    for (int i = 0; i + 1 < coins; i++)
      ratio[i] = values[i + 1] / values[i];

    int max = 0;
    for (int i = 0; i + 1 < coins; i++)
      if (ratio[i] > max)
        max = ratio[i];

    boolean[] used = new boolean[max];
    for (int i = 0; i + 1 < coins; i++) {
      for (int j = ratio[i] - 1; true; j--) {
        if (j <= 0)
          return "Impossible";
        if (!used[j]) {
          used[j] = true;
          break;
        }
      }
    }
    return "Possible";
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      ColorfulCoinsEasyHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        ColorfulCoinsEasyHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class ColorfulCoinsEasyHarness {
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
                int[] values              = {1};
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new ColorfulCoinsEasy().isPossible(values));
      }
      case 1: {
                int[] values              = {1, 3};
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new ColorfulCoinsEasy().isPossible(values));
      }
      case 2: {
                int[] values              = {1, 2, 4};
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new ColorfulCoinsEasy().isPossible(values));
      }
      case 3: {
                int[] values              = {1, 5, 15, 90};
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new ColorfulCoinsEasy().isPossible(values));
      }
      case 4: {
                int[] values              = {1, 4, 20, 60, 180, 1440, 5760};
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new ColorfulCoinsEasy().isPossible(values));
      }
      case 5: {
                int[] values              = {1, 7, 21, 105, 630, 3150, 18900};
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new ColorfulCoinsEasy().isPossible(values));
      }
      case 6: {
                int[] values              = {1, 10, 30, 300, 900, 9000, 18000};
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new ColorfulCoinsEasy().isPossible(values));
      }
      case 7: {
                int[] values              = {1, 2, 10, 40, 200, 1000, 4000, 20000};
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new ColorfulCoinsEasy().isPossible(values));
      }

      // custom cases

      /*      case 8: {
              int[] values              = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new ColorfulCoinsEasy().isPossible(values));
              }*/
      /*      case 9: {
              int[] values              = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new ColorfulCoinsEasy().isPossible(values));
              }*/
      /*      case 10: {
              int[] values              = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new ColorfulCoinsEasy().isPossible(values));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
