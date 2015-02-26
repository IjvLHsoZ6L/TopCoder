import java.util.*;

public class RectangleCovering {

  public int minimumNumber(int holeH, int holeW, int[] boardH, int[] boardW) {

    ArrayList<Integer> coverH = new ArrayList<Integer>();
    ArrayList<Integer> coverW = new ArrayList<Integer>();

    for (int i = 0, n = boardH.length; i < n; i++) {
      if (Math.min(boardH[i], boardW[i]) > holeH)
        coverH.add(Math.max(boardH[i], boardW[i]));
      else if (Math.max(boardH[i], boardW[i]) > holeH)
        coverH.add(Math.min(boardH[i], boardW[i]));
      if (Math.min(boardH[i], boardW[i]) > holeW)
        coverW.add(Math.max(boardH[i], boardW[i]));
      else if (Math.max(boardH[i], boardW[i]) > holeW)
        coverW.add(Math.min(boardH[i], boardW[i]));
    }

    int minH = 0;
    int minW = 0;
    Collections.sort(coverH);
    Collections.reverse(coverH);
    Collections.sort(coverW);
    Collections.reverse(coverW);

    int sum = 0;
    while (sum < holeW) {
      if (minH == coverH.size()) {
        minH = Integer.MAX_VALUE;
        break;
      }
      sum += coverH.get(minH);
      minH++;
    }

    sum = 0;
    while (sum < holeH) {
      if (minW == coverW.size()) {
        minW = Integer.MAX_VALUE;
        break;
      }
      sum += coverW.get(minW);
      minW++;
    }

    int ret = Math.min(minH, minW);

    return (ret == Integer.MAX_VALUE ? -1 : ret);
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      RectangleCoveringHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        RectangleCoveringHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class RectangleCoveringHarness {
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
                int holeH                 = 5;
                int holeW                 = 5;
                int[] boardH              = {8,8,8};
                int[] boardW              = {2,3,4};
                int expected__            = 2;

                return verifyCase(casenum__, expected__, new RectangleCovering().minimumNumber(holeH, holeW, boardH, boardW));
      }
      case 1: {
                int holeH                 = 10;
                int holeW                 = 10;
                int[] boardH              = {6,6,6,6};
                int[] boardW              = {6,6,6,6};
                int expected__            = -1;

                return verifyCase(casenum__, expected__, new RectangleCovering().minimumNumber(holeH, holeW, boardH, boardW));
      }
      case 2: {
                int holeH                 = 5;
                int holeW                 = 5;
                int[] boardH              = {5};
                int[] boardW              = {5};
                int expected__            = -1;

                return verifyCase(casenum__, expected__, new RectangleCovering().minimumNumber(holeH, holeW, boardH, boardW));
      }
      case 3: {
                int holeH                 = 3;
                int holeW                 = 5;
                int[] boardH              = {6};
                int[] boardW              = {4};
                int expected__            = 1;

                return verifyCase(casenum__, expected__, new RectangleCovering().minimumNumber(holeH, holeW, boardH, boardW));
      }
      case 4: {
                int holeH                 = 10000;
                int holeW                 = 5000;
                int[] boardH              = {12345,12343,12323,12424,1515,6666,6789,1424,11111,25};
                int[] boardW              = {1442,2448,42,1818,3535,3333,3456,7890,1,52};
                int expected__            = 3;

                return verifyCase(casenum__, expected__, new RectangleCovering().minimumNumber(holeH, holeW, boardH, boardW));
      }

      // custom cases

      /*      case 5: {
              int holeH                 = ;
              int holeW                 = ;
              int[] boardH              = ;
              int[] boardW              = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new RectangleCovering().minimumNumber(holeH, holeW, boardH, boardW));
              }*/
      /*      case 6: {
              int holeH                 = ;
              int holeW                 = ;
              int[] boardH              = ;
              int[] boardW              = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new RectangleCovering().minimumNumber(holeH, holeW, boardH, boardW));
              }*/
      /*      case 7: {
              int holeH                 = ;
              int holeW                 = ;
              int[] boardH              = ;
              int[] boardW              = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new RectangleCovering().minimumNumber(holeH, holeW, boardH, boardW));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
