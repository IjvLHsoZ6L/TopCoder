public class BuildingRoutes {

  public int build(String[] dist, int T) {
    int N = dist.length;
    int[][] distance = new int[N][N];
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        distance[i][j] = dist[i].charAt(j) - '0';
    int[][] buses = new int[N][N];
    int[][] shortest = new int[N][N];
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        shortest[i][j] = distance[i][j];
    while (true) {
      boolean changed = false;
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
          for (int k = 0; k < N; k++)
            if (shortest[i][k] > shortest[i][j] + shortest[j][k]) {
              shortest[i][k] = shortest[i][j] + shortest[j][k];
              changed = true;
            }
      if (!changed)
        break;
    }
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        for (int k = 0; k < N; k++)
          for (int l = 0; l < N; l++)
            if (shortest[i][l] == shortest[i][j] + distance[j][k] + shortest[k][l])
              buses[j][k]++;
    int routes = 0;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (buses[i][j] >= T)
          routes += distance[i][j];
    return routes;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      BuildingRoutesHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        BuildingRoutesHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class BuildingRoutesHarness {
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
                String[] dist             = {"011",
                  "101",
                  "110"};
                int T                     = 1;
                int expected__            = 6;

                return verifyCase(casenum__, expected__, new BuildingRoutes().build(dist, T));
      }
      case 1: {
                String[] dist             = {"033",
                  "309",
                  "390"};
                int T                     = 1;
                int expected__            = 12;

                return verifyCase(casenum__, expected__, new BuildingRoutes().build(dist, T));
      }
      case 2: {
                String[] dist             = {"0123",
                  "1023",
                  "1203",
                  "1230"};
                int T                     = 2;
                int expected__            = 5;

                return verifyCase(casenum__, expected__, new BuildingRoutes().build(dist, T));
      }
      case 3: {
                String[] dist             = {"05789654",
                  "10347583",
                  "65085479",
                  "55602398",
                  "76590934",
                  "57939045",
                  "12345608",
                  "68647640"};
                int T                     = 3;
                int expected__            = 40;

                return verifyCase(casenum__, expected__, new BuildingRoutes().build(dist, T));
      }

      // custom cases

      /*      case 4: {
              String[] dist             = ;
              int T                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new BuildingRoutes().build(dist, T));
              }*/
      /*      case 5: {
              String[] dist             = ;
              int T                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new BuildingRoutes().build(dist, T));
              }*/
      /*      case 6: {
              String[] dist             = ;
              int T                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new BuildingRoutes().build(dist, T));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
