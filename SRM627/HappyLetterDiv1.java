import java.util.*;

public class HappyLetterDiv1 {

  public String getHappyLetters(String letters) {

    int N = letters.length();

    int[] count = new int[26];
    for (int i = 0; i < N; i++)
      count[letters.charAt(i) - 'a']++;

    String result = "";

    for (int i = 0; i < 26; i++) {
      if (count[i] > (N + 1) % 2) {
        boolean flag = true;
        for (int j = 0; flag && j < 26; j++)
          flag = (j == i) || (count[j] < (N + 1) / 2);
        if (flag)
          result += String.valueOf((char)(i + 'a'));
      }
    }

    return result;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      HappyLetterDiv1Harness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        HappyLetterDiv1Harness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class HappyLetterDiv1Harness {
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
                String letters            = "aabbacccc";
                String expected__         = "abc";

                return verifyCase(casenum__, expected__, new HappyLetterDiv1().getHappyLetters(letters));
      }
      case 1: {
                String letters            = "aaaaaaaccdd";
                String expected__         = "a";

                return verifyCase(casenum__, expected__, new HappyLetterDiv1().getHappyLetters(letters));
      }
      case 2: {
                String letters            = "ddabccadb";
                String expected__         = "abcd";

                return verifyCase(casenum__, expected__, new HappyLetterDiv1().getHappyLetters(letters));
      }
      case 3: {
                String letters            = "aaabbb";
                String expected__         = "";

                return verifyCase(casenum__, expected__, new HappyLetterDiv1().getHappyLetters(letters));
      }
      case 4: {
                String letters            = "rdokcogscosn";
                String expected__         = "cos";

                return verifyCase(casenum__, expected__, new HappyLetterDiv1().getHappyLetters(letters));
      }

      // custom cases

      /*      case 5: {
              String letters            = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new HappyLetterDiv1().getHappyLetters(letters));
              }*/
      /*      case 6: {
              String letters            = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new HappyLetterDiv1().getHappyLetters(letters));
              }*/
      /*      case 7: {
              String letters            = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new HappyLetterDiv1().getHappyLetters(letters));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
