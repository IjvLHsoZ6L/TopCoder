import java.util.*;

public class GoodCompanyDivTwo {

  public int countGood(int[] superior, int[] workType) {

    int N = superior.length;

    ArrayList<ArrayList<Integer>> department = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < N; i++) {
      department.add(i, new ArrayList<Integer>());
      department.get(i).add(i);
    }
    for (int i = 1; i < N; i++)
      department.get(superior[i]).add(i);

    int count = 0;
    for (int i = 0; i < N; i++) {
      boolean good = true;
      TreeSet<Integer> types = new TreeSet<Integer>();
      for (int j : department.get(i))
        good &= types.add(workType[j]);
      if (good)
        count++;
    }

    return count;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      GoodCompanyDivTwoHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        GoodCompanyDivTwoHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class GoodCompanyDivTwoHarness {
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
                int[] superior            = {-1, 0};
                int[] workType            = {1, 2};
                int expected__            = 2;

                return verifyCase(casenum__, expected__, new GoodCompanyDivTwo().countGood(superior, workType));
      }
      case 1: {
                int[] superior            = {-1, 0};
                int[] workType            = {1, 1};
                int expected__            = 1;

                return verifyCase(casenum__, expected__, new GoodCompanyDivTwo().countGood(superior, workType));
      }
      case 2: {
                int[] superior            = {-1, 0, 1, 1};
                int[] workType            = {1, 4, 3, 2};
                int expected__            = 4;

                return verifyCase(casenum__, expected__, new GoodCompanyDivTwo().countGood(superior, workType));
      }
      case 3: {
                int[] superior            = {-1, 0, 1, 0, 0};
                int[] workType            = {3, 3, 5, 2, 2};
                int expected__            = 4;

                return verifyCase(casenum__, expected__, new GoodCompanyDivTwo().countGood(superior, workType));
      }
      case 4: {
                int[] superior            = {-1, 0, 1, 1, 1, 0, 2, 5};
                int[] workType            = {1, 1, 2, 3, 4, 5, 3, 3};
                int expected__            = 7;

                return verifyCase(casenum__, expected__, new GoodCompanyDivTwo().countGood(superior, workType));
      }
      case 5: {
                int[] superior            = {-1, 0, 0, 1, 1, 3, 0, 2, 0, 5, 2, 5, 5, 6, 1, 2, 11, 12, 10, 4, 7, 16, 10, 9, 12, 18, 15, 23, 20, 7, 4};
                int[] workType            = {4, 6, 4, 7, 7, 1, 2, 8, 1, 7, 2, 4, 2, 9, 11, 1, 10, 11, 4, 6, 11, 7, 2, 8, 9, 9, 10, 10, 9, 8, 8};
                int expected__            = 27;

                return verifyCase(casenum__, expected__, new GoodCompanyDivTwo().countGood(superior, workType));
      }

      // custom cases

      /*      case 6: {
              int[] superior            = ;
              int[] workType            = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new GoodCompanyDivTwo().countGood(superior, workType));
              }*/
      /*      case 7: {
              int[] superior            = ;
              int[] workType            = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new GoodCompanyDivTwo().countGood(superior, workType));
              }*/
      /*      case 8: {
              int[] superior            = ;
              int[] workType            = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new GoodCompanyDivTwo().countGood(superior, workType));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
