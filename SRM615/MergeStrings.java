public class MergeStrings {

  public String getmin(String S, String A, String B) {

    int a = A.length(),
        b = B.length();

    String[][] min = new String[a + 1][b + 1];

    for (int i = 0; i <= a; i++) {
      for (int j = 0; j <= b; j++) {

        if (i == 0) {

          if (j == 0) {

            min[i][j] = "";
          }
          else {

            if (
                min[i][j - 1] != null &&
                (S.charAt(i + j - 1) == '?' || S.charAt(i + j - 1) == B.charAt(j - 1))
               )
              min[i][j] = min[i][j - 1] + B.charAt(j - 1);
            else
              min[i][j] = null;
          }
        }
        else {

          if (j == 0) {

            if (
                min[i - 1][j] != null &&
                (S.charAt(i + j - 1) == '?' || S.charAt(i + j - 1) == A.charAt(i - 1))
               )
              min[i][j] = min[i - 1][j] + A.charAt(i - 1);
            else
              min[i][j] = null;
          }
          else {

            String s, t;
            if (
                min[i - 1][j] != null &&
                (S.charAt(i + j - 1) == '?' || S.charAt(i + j - 1) == A.charAt(i - 1))
               )
              s = min[i - 1][j] + A.charAt(i - 1);
            else
              s = null;
            if (
                min[i][j - 1] != null &&
                (S.charAt(i + j - 1) == '?' || S.charAt(i + j - 1) == B.charAt(j - 1))
               )
              t = min[i][j - 1] + B.charAt(j - 1);
            else
              t = null;

            if (s == null) {
              if (t == null)
                min[i][j] = null;
              else
                min[i][j] = t;
            }
            else {
              if (t == null)
                min[i][j] = s;
              else
                min[i][j] = (s.compareTo(t) < 0 ? s : t);
            }
          }
        }
      }
    }

    return (min[a][b] == null ? "" : min[a][b]);
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      MergeStringsHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        MergeStringsHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class MergeStringsHarness {
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
                String S                  = "??CC??";
                String A                  = "ABC";
                String B                  = "BCC";
                String expected__         = "ABCCBC";

                return verifyCase(casenum__, expected__, new MergeStrings().getmin(S, A, B));
      }
      case 1: {
                String S                  = "WHAT?";
                String A                  = "THE";
                String B                  = "WA";
                String expected__         = "";

                return verifyCase(casenum__, expected__, new MergeStrings().getmin(S, A, B));
      }
      case 2: {
                String S                  = "PARROT";
                String A                  = "PARROT";
                String B                  = "";
                String expected__         = "PARROT";

                return verifyCase(casenum__, expected__, new MergeStrings().getmin(S, A, B));
      }
      case 3: {
                String S                  = "???????????";
                String A                  = "AZZAA";
                String B                  = "AZAZZA";
                String expected__         = "AAZAZZAAZZA";

                return verifyCase(casenum__, expected__, new MergeStrings().getmin(S, A, B));
      }
      case 4: {
                String S                  = "????K??????????????D???K???K????????K?????K???????";
                String A                  = "KKKKKDKKKDKKDDKDDDKDKK";
                String B                  = "KDKDDKKKDDKDDKKKDKDKKDDDDDDD";
                String expected__         = "KDKDKDKKKDDKDDKKKDKDKKDKDDDKDDDKKDKKKDKKDDKDDDKDKK";

                return verifyCase(casenum__, expected__, new MergeStrings().getmin(S, A, B));
      }

      // custom cases

      /*      case 5: {
              String S                  = ;
              String A                  = ;
              String B                  = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new MergeStrings().getmin(S, A, B));
              }*/
      /*      case 6: {
              String S                  = ;
              String A                  = ;
              String B                  = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new MergeStrings().getmin(S, A, B));
              }*/
      /*      case 7: {
              String S                  = ;
              String A                  = ;
              String B                  = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new MergeStrings().getmin(S, A, B));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
