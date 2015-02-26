public class CandidatesSelection {

  public String possible(String[] score, int[] result) {

    int n = score.length,
        m = score[0].length();
    boolean[] sorted = new boolean[n - 1];

    while (true) {

      boolean completed = true;
      for (int j = 0; j + 1 < n; j++) {
        if (!sorted[j] && result[j] > result[j + 1]) {
          completed = false;
          break;
        }
      }
      if (completed)
        return "Possible";

      boolean changed = false;

      for (int i = 0; i < m; i++) {

        boolean ordered = true,
                proper = false;
        for (int j = 0; j + 1 < n; j++) {
          if (!sorted[j]) {
            if (score[result[j]].charAt(i) > score[result[j + 1]].charAt(i)) {
              ordered = false;
              break;
            }
            if (score[result[j]].charAt(i) < score[result[j + 1]].charAt(i))
              proper = true;
          }
        }

        if (ordered && proper) {
          for (int j = 0; j + 1 < n; j++) {
            sorted[j] |= score[result[j]].charAt(i) < score[result[j + 1]].charAt(i);
          }
          changed = true;
        }
      }

      if (!changed)
        return "Impossible";
    }
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      CandidatesSelectionHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        CandidatesSelectionHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class CandidatesSelectionHarness {
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
                String[] score            = {"CC", "AA", "BB"};
                int[] result              = {1,2,0};
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new CandidatesSelection().possible(score, result));
      }
      case 1: {
                String[] score            = {"BAB", "ABB", "AAB", "ABA"};
                int[] result              = {2,0,1,3};
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new CandidatesSelection().possible(score, result));
      }
      case 2: {
                String[] score            = {"BAB", "ABB", "AAB", "ABA"};
                int[] result              = {0, 1, 3, 2};
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new CandidatesSelection().possible(score, result));
      }
      case 3: {
                String[] score            = {"AAA", "ZZZ"};
                int[] result              = {1, 0};
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new CandidatesSelection().possible(score, result));
      }
      case 4: {
                String[] score            = {"ZZZ", "AAA"};
                int[] result              = {0, 1};
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new CandidatesSelection().possible(score, result));
      }
      case 5: {
                String[] score            = {"ZYYYYX","YXZYXY","ZZZZXX","XZXYYX","ZZZYYZ","ZZXXYZ","ZYZZXZ","XZYYZX"};
                int[] result              = {3,7,1,0,2,5,6,4};
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new CandidatesSelection().possible(score, result));
      }

      // custom cases

      /*      case 6: {
              String[] score            = ;
              int[] result              = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new CandidatesSelection().possible(score, result));
              }*/
      /*      case 7: {
              String[] score            = ;
              int[] result              = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new CandidatesSelection().possible(score, result));
              }*/
      /*      case 8: {
              String[] score            = ;
              int[] result              = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new CandidatesSelection().possible(score, result));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
