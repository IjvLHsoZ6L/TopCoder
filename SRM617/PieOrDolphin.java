import java.util.*;

public class PieOrDolphin {

  public int[] Distribute(int[] choice1, int[] choice2) {

    int M = 50,
        N = choice1.length;

    ArrayList<TreeSet<Integer>> edges = new ArrayList<TreeSet<Integer>>(M);
    for (int i = 0; i < M; i++)
      edges.add(i, new TreeSet<Integer>());
    for (int i = 0; i < N; i++) {
      edges.get(choice1[i]).add(i);
      edges.get(choice2[i]).add(i);
    }

    int[] result = new int[N];

    for (int start = 0; start < M; start++) {
      for (boolean startDirection = true; !edges.get(start).isEmpty(); startDirection = !startDirection) {
        for (int current = start, next; !edges.get(current).isEmpty(); current = next) {
          int day = edges.get(current).pollFirst();
          boolean direction = (choice1[day] == current);
          next = (direction ? choice2[day] : choice1[day]);
          edges.get(next).remove(day);
          if (startDirection ^ direction)
            result[day] = 1;
          else
            result[day] = 2;
        }
      }
    }

    return result;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      PieOrDolphinHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        PieOrDolphinHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class PieOrDolphinHarness {
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
                int[] choice1             = {10, 20, 10};
                int[] choice2             = {20, 30, 20};
                int[] expected__          = {2, 2, 1 };

                return verifyCase(casenum__, expected__, new PieOrDolphin().Distribute(choice1, choice2));
      }
      case 1: {
                int[] choice1             = {0, 0};
                int[] choice2             = {1, 1};
                int[] expected__          = {2, 1 };

                return verifyCase(casenum__, expected__, new PieOrDolphin().Distribute(choice1, choice2));
      }
      case 2: {
                int[] choice1             = {0, 1, 2, 3, 5, 6, 7, 8};
                int[] choice2             = {8, 7, 6, 5, 3, 2, 1, 0};
                int[] expected__          = {2, 2, 2, 2, 2, 2, 2, 2 };

                return verifyCase(casenum__, expected__, new PieOrDolphin().Distribute(choice1, choice2));
      }
      case 3: {
                int[] choice1             = {49, 0, 48, 1};
                int[] choice2             = {3, 4, 5, 6};
                int[] expected__          = {2, 2, 2, 2 };

                return verifyCase(casenum__, expected__, new PieOrDolphin().Distribute(choice1, choice2));
      }
      case 4: {
                int[] choice1             = {21,4,14,0,31,46,1,34,2,3,27,19,47,46,17,11,41,12,31,0,34,18,8,14,23,40,0,18,48,35,42,24,25,32,25,44,17,6,44,34,12,39,43,39,26, 34,10,6,13,2,40,15,16,32,32,29,1,23,8,10,49,22,10,15,40,20,0,30,1,43,33,42,28,39,28,4,38,11,5,1,47,12,0,22,20,33,33,34,18,8,23,6};
                int[] choice2             = {25,5,39,20,44,47,11,49,42,17,25,15,23,11,32,17,24,4,11,47,27,41,40,0,49,27,5,28,6,11,18,0,17,1,0,32,45,28,17,5,13,40,40,25,33, 7,8,32,12,0,39,30,8,39,23,9,8,34,34,37,5,1,24,23,0,29,11,42,29,40,24,18,37,1,21,0,31,47,23,33,45,48,31,11,40,45,24,22,19,26,37,39};
                int[] expected__          = {2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 1, 2, 2, 1, 2, 1, 2, 1, 1, 2, 2, 1, 1, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 2, 1, 2, 2, 2, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 1, 1, 2, 1, 1, 2, 2, 2, 1 };

                return verifyCase(casenum__, expected__, new PieOrDolphin().Distribute(choice1, choice2));
      }

      // custom cases

      /*      case 5: {
              int[] choice1             = ;
              int[] choice2             = ;
              int[] expected__          = ;

              return verifyCase(casenum__, expected__, new PieOrDolphin().Distribute(choice1, choice2));
              }*/
      /*      case 6: {
              int[] choice1             = ;
              int[] choice2             = ;
              int[] expected__          = ;

              return verifyCase(casenum__, expected__, new PieOrDolphin().Distribute(choice1, choice2));
              }*/
      /*      case 7: {
              int[] choice1             = ;
              int[] choice2             = ;
              int[] expected__          = ;

              return verifyCase(casenum__, expected__, new PieOrDolphin().Distribute(choice1, choice2));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
