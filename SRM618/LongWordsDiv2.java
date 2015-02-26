public class LongWordsDiv2 {

  public String find(String word) {

    int l = word.length();

    for (int i = 0; i + 1 < l; i++)
      if (word.charAt(i) == word.charAt(i + 1))
        return "Dislikes";

    for (int i = 0; i < l; i++)
      for (int j = i + 1; j < l; j++)
        for (int ii = j + 1; ii < l; ii++)
          if (word.charAt(i) == word.charAt(ii))
            for (int jj = ii + 1; jj < l; jj++)
              if (word.charAt(j) == word.charAt(jj))
                return "Dislikes";

    return "Likes";
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      LongWordsDiv2Harness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        LongWordsDiv2Harness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class LongWordsDiv2Harness {
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
                String word               = "AAA";
                String expected__         = "Dislikes";

                return verifyCase(casenum__, expected__, new LongWordsDiv2().find(word));
      }
      case 1: {
                String word               = "ABCBA";
                String expected__         = "Likes";

                return verifyCase(casenum__, expected__, new LongWordsDiv2().find(word));
      }
      case 2: {
                String word               = "ABCBAC";
                String expected__         = "Dislikes";

                return verifyCase(casenum__, expected__, new LongWordsDiv2().find(word));
      }
      case 3: {
                String word               = "TOPCODER";
                String expected__         = "Likes";

                return verifyCase(casenum__, expected__, new LongWordsDiv2().find(word));
      }
      case 4: {
                String word               = "VAMOSGIMNASIA";
                String expected__         = "Dislikes";

                return verifyCase(casenum__, expected__, new LongWordsDiv2().find(word));
      }
      case 5: {
                String word               = "SINGLEROUNDMATCH";
                String expected__         = "Likes";

                return verifyCase(casenum__, expected__, new LongWordsDiv2().find(word));
      }
      case 6: {
                String word               = "DALELOBO";
                String expected__         = "Likes";

                return verifyCase(casenum__, expected__, new LongWordsDiv2().find(word));
      }

      // custom cases

      /*      case 7: {
              String word               = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new LongWordsDiv2().find(word));
              }*/
      /*      case 8: {
              String word               = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new LongWordsDiv2().find(word));
              }*/
      /*      case 9: {
              String word               = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new LongWordsDiv2().find(word));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
