import java.util.ArrayList;

public class ElephantDrinkingEasy {

  public int maxElephants(String[] map) {

    int n = map.length;
    boolean[][] water = new boolean[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        water[i][j] = (map[i].charAt(j) == 'Y');

    ArrayList<Integer> canDrink = new ArrayList<Integer>();
    boolean[][][] uses = new boolean[4 * n][n][n];
    for (int i = 0; i < n; i++) {
      int j = 0;
      while (j < n && !water[i][j])
        j++;
      if (j < n) {
        canDrink.add(i);
        for (int k = 0; k <= j; k++)
          uses[i][i][k] = true;
      }
    }
    for (int i = 0; i < n; i++) {
      int j = n - 1;
      while (j >= 0 && !water[i][j])
        j--;
      if (j >= 0) {
        canDrink.add(n + i);
        for (int k = n - 1; k >= j; k--)
          uses[n + i][i][k] = true;
      }
    }
    for (int j = 0; j < n; j++) {
      int i = 0;
      while (i < n && !water[i][j])
        i++;
      if (i < n) {
        canDrink.add(2 * n + j);
        for (int k = 0; k <= i; k++)
          uses[2 * n + j][k][j] = true;
      }
    }
    for (int j = 0; j < n; j++) {
      int i = n - 1;
      while (i >= 0 && !water[i][j])
        i--;
      if (i >= 0) {
        canDrink.add(3 * n + j);
        for (int k = n - 1; k >= i; k--)
          uses[3 * n + j][k][j] = true;
      }
    }

    boolean[][] intersects = new boolean[4 * n][4 * n];
    for (int i = 0; i < 4 * n; i++)
      for (int j = 0; j < 4 * n; j++)
        for (int x = 0; x < n; x++)
          for (int y = 0; y < n; y++)
            if (uses[i][x][y] && uses[j][x][y])
              intersects[i][j] = true;

    return recursive(intersects, canDrink);
  }

  private int recursive(boolean[][] intersects, ArrayList<Integer> elephants) {
    if (elephants.isEmpty())
      return 0;
    else {
      int elephant = elephants.get(0);
      ArrayList<Integer> restElepahnts = new ArrayList<Integer>();
      ArrayList<Integer> disjointElephants = new ArrayList<Integer>();
      for (int i = 1, l = elephants.size(); i < l; i++) {
        restElepahnts.add(elephants.get(i));
        if (!intersects[elephant][elephants.get(i)])
          disjointElephants.add(elephants.get(i));
      }
      return Math.max(
          recursive(intersects, restElepahnts),
          1 +  recursive(intersects, disjointElephants)
          );
    }
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      ElephantDrinkingEasyHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        ElephantDrinkingEasyHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class ElephantDrinkingEasyHarness {
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
                String[] map              = {"NNNNN",
                  "NNYYN",
                  "NYNNN",
                  "NNYNN",
                  "NNNNN"};
                int expected__            = 4;

                return verifyCase(casenum__, expected__, new ElephantDrinkingEasy().maxElephants(map));
      }
      case 1: {
                String[] map              = {"YYY",
                  "YYY",
                  "YYY"}
                ;
                int expected__            = 8;

                return verifyCase(casenum__, expected__, new ElephantDrinkingEasy().maxElephants(map));
      }
      case 2: {
                String[] map              =  {"YNYN",
                  "NNYY",
                  "YYNN",
                  "YYYY"};
                int expected__            = 10;

                return verifyCase(casenum__, expected__, new ElephantDrinkingEasy().maxElephants(map));
      }
      case 3: {
                String[] map              =  {"YNYN",
                  "YNYY",
                  "YYNN",
                  "YYYY"};
                int expected__            = 10;

                return verifyCase(casenum__, expected__, new ElephantDrinkingEasy().maxElephants(map));
      }
      case 4: {
                String[] map              = {"YYNYN",
                  "NYNNY",
                  "YNYNN",
                  "YYNYY",
                  "YYNNN"};
                int expected__            = 12;

                return verifyCase(casenum__, expected__, new ElephantDrinkingEasy().maxElephants(map));
      }
      case 5: {
                String[] map              = {"YYNYN",
                  "NYNYY",
                  "YNYYN",
                  "YYNYY",
                  "YYNNN"};
                int expected__            = 13;

                return verifyCase(casenum__, expected__, new ElephantDrinkingEasy().maxElephants(map));
      }
      case 6: {
                String[] map              = {"NN",
                  "NN"};
                int expected__            = 0;

                return verifyCase(casenum__, expected__, new ElephantDrinkingEasy().maxElephants(map));
      }

      // custom cases

      /*      case 7: {
              String[] map              = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new ElephantDrinkingEasy().maxElephants(map));
              }*/
      /*      case 8: {
              String[] map              = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new ElephantDrinkingEasy().maxElephants(map));
              }*/
      /*      case 9: {
              String[] map              = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new ElephantDrinkingEasy().maxElephants(map));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
