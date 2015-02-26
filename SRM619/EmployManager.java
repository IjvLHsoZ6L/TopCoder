import java.util.*;

public class EmployManager {

  public int maximumEarnings(int[] value, String[] earning) {

    int N = value.length;

    int[][] E = new int[N][N];
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        E[i][j] = earning[i].charAt(j) - '0';

    int result = 0;
    for (int i = 0; i < N; i++)
      for (int j = i + 1; j < N; j++)
        result -= E[i][j];

    for (int i = 0; i < N; i++) {
      int benefit = -value[i];
      for (int j = 0; j < N; j++)
        benefit += E[i][j];
      result += Math.max(0, benefit);
    }

    return result;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      EmployManagerHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        EmployManagerHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class EmployManagerHarness {
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
                int[] value               = {1, 1};
                String[] earning          = {"02", "20"};
                int expected__            = 0;

                return verifyCase(casenum__, expected__, new EmployManager().maximumEarnings(value, earning));
      }
      case 1: {
                int[] value               = {2, 2};
                String[] earning          = {"01", "10"};
                int expected__            = -1;

                return verifyCase(casenum__, expected__, new EmployManager().maximumEarnings(value, earning));
      }
      case 2: {
                int[] value               = {1, 2, 3, 4};
                String[] earning          = {"0121", "1021", "2201", "1110"};
                int expected__            = -1;

                return verifyCase(casenum__, expected__, new EmployManager().maximumEarnings(value, earning));
      }
      case 3: {
                int[] value               = {2, 2, 0, 1, 4, 0, 1, 0, 0, 4};
                String[] earning          = {"0100451253",  "1010518123",  "0102989242",  "0020093171",  "4590045480",  "5189400676",  "1893500826",  "2121468008",  "5247872007",  "3321066870"};
                int expected__            = 156;

                return verifyCase(casenum__, expected__, new EmployManager().maximumEarnings(value, earning));
      }

      // custom cases

      /*      case 4: {
              int[] value               = ;
              String[] earning          = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new EmployManager().maximumEarnings(value, earning));
              }*/
      /*      case 5: {
              int[] value               = ;
              String[] earning          = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new EmployManager().maximumEarnings(value, earning));
              }*/
      /*      case 6: {
              int[] value               = ;
              String[] earning          = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new EmployManager().maximumEarnings(value, earning));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
