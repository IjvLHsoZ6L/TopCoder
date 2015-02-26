public class Ethernet {

  int N;
  int[][] edge;
  boolean[] assigned;
  int[] firstDepth;
  int[] secondDepth;
  int[] diameter;

  public int connect(int[] parent, int[] dist, int maxDist) {
    N = parent.length + 1;
    edge = new int[N][N];
    assigned = new boolean[N];
    firstDepth = new int[N];
    secondDepth = new int[N];
    diameter = new int[N];
    for (int i = 1; i < N; i++)
      edge[parent[i - 1]][i] = dist[i - 1];
    int networks = 0;
    while (true) {
      calcDepth();
      if (diameter[0] <= maxDist)
        return networks + 1;
      int i = 0;
      while (diameter[i] > maxDist) {
        for (int j = i + 1; j < N; j++)
          if (!assigned[j] && edge[i][j] > 0)
            if (firstDepth[i] == edge[i][j] + firstDepth[j]) {
              i = j;
              break;
            }
      }
      assign(i);
      networks++;
    }
  }

  void calcDepth() {
    for (int i = N - 1; i >= 0; i--)
      if (!assigned[i]) {
        firstDepth[i] = 0;
        secondDepth[i] = 0;
        diameter[i] = 0;
        for (int j = i + 1; j < N; j++)
          if (!assigned[j] && edge[i][j] > 0) {
            if (edge[i][j] + firstDepth[j] > firstDepth[i]) {
              secondDepth[i] = firstDepth[i];
              firstDepth[i] = edge[i][j] + firstDepth[j];
            }
            else if (edge[i][j] + firstDepth[j] > secondDepth[i])
              secondDepth[i] = edge[i][j] + firstDepth[j];
            if (diameter[j] > diameter[i])
              diameter[i] = diameter[j];
          }
        if (firstDepth[i] + secondDepth[i] > diameter[i])
          diameter[i] = firstDepth[i] + secondDepth[i];
      }
    return;
  }

  void assign(int i) {
    assigned[i] = true;
    for (int j = i + 1; j < N; j++)
      if (!assigned[j] && edge[i][j] > 0)
        assign(j);
    return;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      EthernetHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        EthernetHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class EthernetHarness {
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
                int[] parent              = {0,0,0};
                int[] dist                = {1,1,1};
                int maxDist               = 2;
                int expected__            = 1;

                return verifyCase(casenum__, expected__, new Ethernet().connect(parent, dist, maxDist));
      }
      case 1: {
                int[] parent              = {0,0,0,0,0,0,0};
                int[] dist                = {1,2,3,4,5,6,7};
                int maxDist               = 8;
                int expected__            = 4;

                return verifyCase(casenum__, expected__, new Ethernet().connect(parent, dist, maxDist));
      }
      case 2: {
                int[] parent              = {0,1,2,3,4,5};
                int[] dist                = {1,2,3,4,5,6};
                int maxDist               = 6;
                int expected__            = 3;

                return verifyCase(casenum__, expected__, new Ethernet().connect(parent, dist, maxDist));
      }
      case 3: {
                int[] parent              = {0,0,0,1,1};
                int[] dist                = {1,1,1,1,1};
                int maxDist               = 2;
                int expected__            = 2;

                return verifyCase(casenum__, expected__, new Ethernet().connect(parent, dist, maxDist));
      }
      case 4: {
                int[] parent              = {0,1,0,3,0,5,0,6,0,6,0,6,4,6,9,4,5,5,2,5,2};
                int[] dist                = {93,42,104,105,59,73,161,130,30,81,62,93,131,133,139,5,13,34,25,111,4};
                int maxDist               = 162;
                int expected__            = 11;

                return verifyCase(casenum__, expected__, new Ethernet().connect(parent, dist, maxDist));
      }

      // custom cases

      /*      case 5: {
              int[] parent              = ;
              int[] dist                = ;
              int maxDist               = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new Ethernet().connect(parent, dist, maxDist));
              }*/
      /*      case 6: {
              int[] parent              = ;
              int[] dist                = ;
              int maxDist               = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new Ethernet().connect(parent, dist, maxDist));
              }*/
      /*      case 7: {
              int[] parent              = ;
              int[] dist                = ;
              int maxDist               = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new Ethernet().connect(parent, dist, maxDist));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
