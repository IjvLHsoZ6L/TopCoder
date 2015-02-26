public class TaroString {

  public String getAnswer(String S) {

    boolean found = false;
    int l = S.length();
    for (int i = 0; i < l; i++)
      if (S.charAt(i) == 'C')
        for (int j = i + 1; j < l; j++)
          if (S.charAt(j) == 'A')
            for (int k = j + 1; k < l; k++)
              if (S.charAt(k) == 'T')
                found = true;

    if (found) {
      int c = 0,
          a = 0,
          t = 0;
      for (int i = 0; i < l; i++) {
        switch (S.charAt(i)) {
          case 'C': c++; break;
          case 'A': a++; break;
          case 'T': t++; break;
          default: ;
        }
      }
      if (c == 1 && a == 1 && t == 1)
        return "Possible";
    }
    return "Impossible";
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      TaroStringHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        TaroStringHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class TaroStringHarness {
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
                String S                  = "XCYAZTX";
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new TaroString().getAnswer(S));
      }
      case 1: {
                String S                  = "CTA";
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new TaroString().getAnswer(S));
      }
      case 2: {
                String S                  = "ACBBAT";
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new TaroString().getAnswer(S));
      }
      case 3: {
                String S                  = "SGHDJHFIOPUFUHCHIOJBHAUINUIT";
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new TaroString().getAnswer(S));
      }
      case 4: {
                String S                  = "CCCATT";
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new TaroString().getAnswer(S));
      }

      // custom cases

      /*      case 5: {
              String S                  = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new TaroString().getAnswer(S));
              }*/
      /*      case 6: {
              String S                  = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new TaroString().getAnswer(S));
              }*/
      /*      case 7: {
              String S                  = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new TaroString().getAnswer(S));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
