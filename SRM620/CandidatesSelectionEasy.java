public class CandidatesSelectionEasy {

  public int[] sort(String[] score, int x) {

    int n = score.length;

    int[] result = new int[n];
    for (int j = 0; j < n; j++)
      result[j] = j;

    for (int i = n; i > 0; i--) {
      for (int j = 0; j + 1 < i; j++) {
        if (score[result[j]].charAt(x) > score[result[j + 1]].charAt(x)) {
          int temp = result[j];
          result[j] = result[j + 1];
          result[j + 1] = temp;
        }
      }
    }

    return result;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      CandidatesSelectionEasyHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        CandidatesSelectionEasyHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class CandidatesSelectionEasyHarness {
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

  static boolean compareOutput(int[] expected, int[] result) { if (expected.length != result.length) return false; for (int i=0; i<expected.length; ++i) if (expected[i] != result[i]) return false; return true; }

  static String formatResult(int[] res) {
    String ret = "";
    ret += "{";
    for (int i=0; i<res.length; ++i) {
      if (i > 0) ret += ",";
      ret += String.format(" %d", res[i]);
    }
    ret += " }";
    return ret;
  }

  static int verifyCase(int casenum, int[] expected, int[] received) { 
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
                String[] score            = {"ACB", "BAC", "CBA"};
                int x                     = 1;
                int[] expected__          = {1, 2, 0 };

                return verifyCase(casenum__, expected__, new CandidatesSelectionEasy().sort(score, x));
      }
      case 1: {
                String[] score            = {"A", "C", "B", "C", "A"};
                int x                     = 0;
                int[] expected__          = {0, 4, 2, 1, 3 };

                return verifyCase(casenum__, expected__, new CandidatesSelectionEasy().sort(score, x));
      }
      case 2: {
                String[] score            = {"LAX","BUR","ONT","LGB","SAN","SNA","SFO","OAK","SJC"};
                int x                     = 2;
                int[] expected__          = {5, 3, 8, 7, 4, 6, 1, 2, 0 };

                return verifyCase(casenum__, expected__, new CandidatesSelectionEasy().sort(score, x));
      }
      case 3: {
                String[] score            = {"BBCBABAC","BCBACABA","CCCBAACB","CACABABB","AABBBBCC"};
                int x                     = 6;
                int[] expected__          = {0, 1, 3, 2, 4 };

                return verifyCase(casenum__, expected__, new CandidatesSelectionEasy().sort(score, x));
      }
      case 4: {
                String[] score            = {"XXYWZWWYXZ","YZZZYWYZYW","ZYZZWZYYWW","ZWZWZWZXYW","ZYXWZXWYXY","YXXXZWXWXW","XWWYZWXYXY","XYYXYWYXWY","ZZYXZYZXYY","WXZXWYZWYY"};
                int x                     = 3;
                int[] expected__          = {0, 3, 4, 5, 7, 8, 9, 6, 1, 2 };

                return verifyCase(casenum__, expected__, new CandidatesSelectionEasy().sort(score, x));
      }
      case 5: {
                String[] score            = {"X"};
                int x                     = 0;
                int[] expected__          = {0 };

                return verifyCase(casenum__, expected__, new CandidatesSelectionEasy().sort(score, x));
      }

      // custom cases

      /*      case 6: {
              String[] score            = ;
              int x                     = ;
              int[] expected__          = ;

              return verifyCase(casenum__, expected__, new CandidatesSelectionEasy().sort(score, x));
              }*/
      /*      case 7: {
              String[] score            = ;
              int x                     = ;
              int[] expected__          = ;

              return verifyCase(casenum__, expected__, new CandidatesSelectionEasy().sort(score, x));
              }*/
      /*      case 8: {
              String[] score            = ;
              int x                     = ;
              int[] expected__          = ;

              return verifyCase(casenum__, expected__, new CandidatesSelectionEasy().sort(score, x));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
