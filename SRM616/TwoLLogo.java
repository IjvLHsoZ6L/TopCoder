import java.util.ArrayList;

public class TwoLLogo {

  public long countWays(String[] grid) {

    int N = grid.length,
        M = grid[0].length();

    boolean[][] white = new boolean[N][M];
    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++)
        white[i][j] = (grid[i].charAt(j) == '.');

    ArrayList<LPoint> list = new ArrayList<LPoint>();
    for (int i = 1; i < N; i++) {
      for (int j = 0; j + 1 < M; j++) {
        if (white[i][j] && white[i - 1][j] && white[i][j + 1]) {
          int height = 1, width = 1;
          while (i - height - 1 >= 0 && white[i - height - 1][j])
            height++;
          while (j + width + 1 < M && white[i][j + width + 1])
            width++;
          list.add(new LPoint(i, j, height, width));
        }
      }
    }

    long ways = 0;
    for (int i = 0, size = list.size(); i < size; i++) {
      LPoint a = list.get(i);
      for (int j = i + 1; j < size; j++) {
        LPoint b = list.get(j);
        if (a.y == b.y)
          ways += a.height * Math.min(a.width, b.x - a.x - 1) * b.height * b.width;
        else if (a.x < b.x)
          ways += a.height * a.width * Math.min(b.height, b.y - a.y - 1) * b.width +
            a.height * Math.min(a.width, b.x - a.x - 1) *
            Math.max(0, b.height - b.y + a.y + 1) * b.width;
        else if (a.x == b.x)
          ways += a.height * a.width * Math.min(b.height, b.y - a.y - 1) * b.width;
        else
          ways += a.height * a.width * b.height * b.width;
      }
    }

    return ways;
  }

  static class LPoint {
    int y;
    int x;
    int height;
    int width;
    LPoint(int y, int x, int height, int width) {
      this.y = y;
      this.x = x;
      this.height = height;
      this.width = width;
    }
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      TwoLLogoHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        TwoLLogoHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class TwoLLogoHarness {
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

  static boolean compareOutput(long expected, long result) { return expected == result; }
  static String formatResult(long res) {
    return String.format("%d", res);
  }

  static int verifyCase(int casenum, long expected, long received) { 
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
                String[] grid             = {"....",
                  "...."};
                long expected__           = 1;

                return verifyCase(casenum__, expected__, new TwoLLogo().countWays(grid));
      }
      case 1: {
                String[] grid             = {".##..",
                  "...#.",
                  ".#.#.",
                  "#...#"};
                long expected__           = 3;

                return verifyCase(casenum__, expected__, new TwoLLogo().countWays(grid));
      }
      case 2: {
                String[] grid             = {"..#.",
                  "#.#.",
                  "....",
                  "..#."};
                long expected__           = 4;

                return verifyCase(casenum__, expected__, new TwoLLogo().countWays(grid));
      }
      case 3: {
                String[] grid             = {"..",
                  ".."};
                long expected__           = 0;

                return verifyCase(casenum__, expected__, new TwoLLogo().countWays(grid));
      }
      case 4: {
                String[] grid             = {".#.#",
                  "....",
                  ".#.#",
                  "...."};
                long expected__           = 34;

                return verifyCase(casenum__, expected__, new TwoLLogo().countWays(grid));
      }
      case 5: {
                String[] grid             = {"##############",
                  "##############",
                  "#.############",
                  "#.############",
                  "#.############",
                  "#.############",
                  "#.############",
                  "#.############",
                  "#.#####.######",
                  "#.#####.######",
                  "#.#####.######",
                  "#....##.######",
                  "#######.######",
                  "#######.######",
                  "#######.######",
                  "#######.######",
                  "#######.######",
                  "#######.######",
                  "#######......#",
                  "##############"};
                long expected__           = 1350;

                return verifyCase(casenum__, expected__, new TwoLLogo().countWays(grid));
      }
      case 6: {
                String[] grid             = {"#......",
                  ".#....#",
                  ".#.#...",
                  "#....#.",
                  ".##..#.",
                  ".#.....",
                  ".....#.",
                  ".#.#...",
                  ".#...#.",
                  "..##..."};
                long expected__           = 2386;

                return verifyCase(casenum__, expected__, new TwoLLogo().countWays(grid));
      }
      case 7: {
                String[] grid             = {"...#..........................",
                  "..............................",
                  "..............................",
                  "..................#...#.......",
                  "..................#...........",
                  "..............................",
                  "...........#..................",
                  "..............................",
                  ".....#..#.....................",
                  ".......................#......",
                  "..................#.....#.....",
                  "..............................",
                  "..............................",
                  "..............................",
                  "..............................",
                  "..#...........................",
                  "..............................",
                  "..............................",
                  "..............................",
                  "#............................#",
                  "..............................",
                  ".....#.........#............#.",
                  "..............................",
                  ".........................#....",
                  ".#............................",
                  ".............#................",
                  "..............................",
                  "..............................",
                  ".......................#......",
                  ".............#................"};
                long expected__           = 5020791386L;

                return verifyCase(casenum__, expected__, new TwoLLogo().countWays(grid));
      }

      // custom cases

      /*      case 8: {
              String[] grid             = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new TwoLLogo().countWays(grid));
              }*/
      /*      case 9: {
              String[] grid             = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new TwoLLogo().countWays(grid));
              }*/
      /*      case 10: {
              String[] grid             = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new TwoLLogo().countWays(grid));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
