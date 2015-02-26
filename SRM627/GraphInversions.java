import java.util.*;

public class GraphInversions {

  int get(int[] bit, int i) {
    int result = 0;
    while (i >= 0) {
      result += bit[i];
      i = (i & (i + 1)) - 1;
    }
    return result;
  }

  void add(int[] bit, int i, int a) {
    while (i < bit.length) {
      bit[i] += a;
      i = i | (i + 1);
    }
  }

  int N;
  int K;
  ArrayList<TreeSet<Integer>> neighbors;
  int[] V;
  boolean[] visitted;
  int[] values;
  int minimumInversions;

  public int getMinimumInversions(int[] A, int[] B, int[] V, int K) {

    this.N = A.length;

    this.K = K;

    this.neighbors = new ArrayList<TreeSet<Integer>>(N);
    for (int i = 0; i < N; i++)
      neighbors.add(i, new TreeSet<Integer>());
    for (int i = 0; i < N; i++) {
      neighbors.get(A[i]).add(B[i]);
      neighbors.get(B[i]).add(A[i]);
    }

    this.V = V;

    this.visitted = new boolean[N];

    this.values = new int[1000 + 1];

    this.minimumInversions = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++)
      search(i, 1, 0);

    return (this.minimumInversions == Integer.MAX_VALUE ? -1 : minimumInversions);
  }

  void search(int i, int length, int inversions) {

    visitted[i] = true;
    add(values, V[i], 1);
    inversions += get(values, V[i] - 1);

    if (length < K) {
      for (int j : neighbors.get(i))
        if (!visitted[j])
          search(j, length + 1, inversions);
    }
    else {
      minimumInversions = Math.min(minimumInversions, inversions);
    }

    visitted[i] = false;
    add(values, V[i], -1);
    inversions -= get(values, V[i] - 1);
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      GraphInversionsHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        GraphInversionsHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class GraphInversionsHarness {
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
                int[] A                   = {0,1,2};
                int[] B                   = {1,2,0};
                int[] V                   = {40,50,60};
                int K                     = 3;
                int expected__            = 0;

                return verifyCase(casenum__, expected__, new GraphInversions().getMinimumInversions(A, B, V, K));
      }
      case 1: {
                int[] A                   = {0,1,2,3};
                int[] B                   = {1,2,3,0};
                int[] V                   = {60,40,50,30};
                int K                     = 3;
                int expected__            = 1;

                return verifyCase(casenum__, expected__, new GraphInversions().getMinimumInversions(A, B, V, K));
      }
      case 2: {
                int[] A                   = {0,1,2,3,0};
                int[] B                   = {1,2,3,0,4};
                int[] V                   = {10,10,10,5,5};
                int K                     = 5;
                int expected__            = 1;

                return verifyCase(casenum__, expected__, new GraphInversions().getMinimumInversions(A, B, V, K));
      }
      case 3: {
                int[] A                   = {0,1,2,3,0,2};
                int[] B                   = {1,2,3,0,4,5};
                int[] V                   = {10,2,5,3,7,1};
                int K                     = 6;
                int expected__            = -1;

                return verifyCase(casenum__, expected__, new GraphInversions().getMinimumInversions(A, B, V, K));
      }
      case 4: {
                int[] A                   = {5,7,7,5,5,7,6,4};
                int[] B                   = {2,0,2,0,1,4,7,3};
                int[] V                   = {15,10,5,30,22,10,5,2};
                int K                     = 6;
                int expected__            = 3;

                return verifyCase(casenum__, expected__, new GraphInversions().getMinimumInversions(A, B, V, K));
      }

      // custom cases

      /*      case 5: {
              int[] A                   = ;
              int[] B                   = ;
              int[] V                   = ;
              int K                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new GraphInversions().getMinimumInversions(A, B, V, K));
              }*/
      /*      case 6: {
              int[] A                   = ;
              int[] B                   = ;
              int[] V                   = ;
              int K                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new GraphInversions().getMinimumInversions(A, B, V, K));
              }*/
      /*      case 7: {
              int[] A                   = ;
              int[] B                   = ;
              int[] V                   = ;
              int K                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new GraphInversions().getMinimumInversions(A, B, V, K));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
