import java.util.*;

public class DrivingPlans {

  public int count(int N, int[] A, int[] B, int[] C) {

    int source = 1,
        target = N;

    ArrayList<ArrayList<Integer>> neighbors = new ArrayList<ArrayList<Integer>>(N + 1);
    for (int i = 0; i <= N; i++)
      neighbors.add(i, new ArrayList<Integer>());
    for (int i = 0; i < A.length; i++) {
      neighbors.get(A[i]).add(B[i]);
      neighbors.get(B[i]).add(A[i]);
    }

    int[][] costs = new int[N + 1][N + 1];
    for (int i = 0; i < A.length; i++) {
      costs[A[i]][B[i]] = C[i];
      costs[B[i]][A[i]] = C[i];
    }

    int[] minimalCost = new int[N + 1];
    Arrays.fill(minimalCost, Integer.MAX_VALUE);
    minimalCost[source] = 0;

    ArrayList<TreeSet<Integer>> previous = new ArrayList<TreeSet<Integer>>(N + 1);
    for (int i = 0; i <= N; i++)
      previous.add(i, new TreeSet<Integer>());

    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.addLast(source);

    while (!queue.isEmpty()) {
      int i = queue.removeFirst();
      for (int j : neighbors.get(i)) {
        if (minimalCost[j] > minimalCost[i] + costs[i][j]) {
          minimalCost[j] = minimalCost[i] + costs[i][j];
          queue.addLast(j);
          previous.get(j).clear();
          previous.get(j).add(i);
        }
        else if (minimalCost[j] == minimalCost[i] + costs[i][j]) {
          previous.get(j).add(i);
        }
      }
    }

    TreeSet<Integer> passes = new TreeSet<Integer>();
    passes.add(target);
    queue.clear();
    queue.addLast(target);
    while (!queue.isEmpty()) {
      int i = queue.removeFirst();
      for (int j : previous.get(i)) {
        if (costs[i][j] == 0)
          return -1;
        if (passes.add(j))
          queue.addLast(j);
      }
    }

    int modulo = 1000000009;
    int undefined = -1;
    int[] ways = new int[N + 1];
    Arrays.fill(ways, undefined);
    queue.clear();
    queue.addAll(passes);
    while (!queue.isEmpty()) {
      int i = queue.removeFirst();
      if (i == source) {
        ways[i] = 1;
      }
      else {
        int sum = 0;
        boolean complete = true;
        for (int j : previous.get(i)) {
          if (complete && ways[j] != undefined)
            sum = (sum + ways[j]) % modulo;
          else
            complete = false;
        }
        if (complete)
          ways[i] = sum;
        else
          queue.addLast(i);
      }
    }

    return ways[target];
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      DrivingPlansHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        DrivingPlansHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class DrivingPlansHarness {
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
                int N                     = 4;
                int[] A                   = {1,1,2,3};
                int[] B                   = {2,3,4,4};
                int[] C                   = {1,1,1,1};
                int expected__            = 2;

                return verifyCase(casenum__, expected__, new DrivingPlans().count(N, A, B, C));
      }
      case 1: {
                int N                     = 4;
                int[] A                   = {1,1,2,3};
                int[] B                   = {2,3,4,4};
                int[] C                   = {1,1,1,0};
                int expected__            = -1;

                return verifyCase(casenum__, expected__, new DrivingPlans().count(N, A, B, C));
      }
      case 2: {
                int N                     = 7;
                int[] A                   = {1,1,2,3,4,4,5,6};
                int[] B                   = {2,3,4,4,5,6,7,7};
                int[] C                   = {1,1,2,2,3,3,4,4};
                int expected__            = 4;

                return verifyCase(casenum__, expected__, new DrivingPlans().count(N, A, B, C));
      }

      // custom cases

      /*      case 3: {
              int N                     = ;
              int[] A                   = ;
              int[] B                   = ;
              int[] C                   = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new DrivingPlans().count(N, A, B, C));
              }*/
      /*      case 4: {
              int N                     = ;
              int[] A                   = ;
              int[] B                   = ;
              int[] C                   = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new DrivingPlans().count(N, A, B, C));
              }*/
      /*      case 5: {
              int N                     = ;
              int[] A                   = ;
              int[] B                   = ;
              int[] C                   = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new DrivingPlans().count(N, A, B, C));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
