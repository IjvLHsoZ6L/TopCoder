import java.util.*;

public class LongLongTripDiv1 {

  public String isAble(int N, int[] A, int[] B, int[] D, long T) {

    int E = A.length;

    int modulo = Integer.MAX_VALUE;
    for (int i = 0; i < E; i++)
      if (A[i] == 0 || B[i] == 0 || A[i] == N - 1 || B[i] == N - 1)
        modulo = Math.min(modulo, 2 * D[i]);

    if (modulo == Integer.MAX_VALUE)
      return "Impossible";

    ArrayList<ArrayList<Edge>> edge = new ArrayList<ArrayList<Edge>>(N);
    for (int i = 0; i < N; i++)
      edge.add(i, new ArrayList<Edge>());
    for (int i = 0; i < E; i++) {
      edge.get(A[i]).add(new Edge(B[i], D[i]));
      edge.get(B[i]).add(new Edge(A[i], D[i]));
    }

    boolean[][] checked = new boolean[N][modulo];

    int remainderOfT = (int)(T % modulo);

    PriorityQueue<Triple> queue = new PriorityQueue<Triple>();
    queue.add(new Triple(0, 0, 0L));

    while (!queue.isEmpty()) {
      Triple t0 = queue.poll();
      if (!checked[t0.vertex][t0.remainder]) {
        if (t0.vertex == N - 1 && t0.remainder == remainderOfT)
          return "Possible";
        for (Edge e : edge.get(t0.vertex)) {
          Triple t1 = new Triple(e.target, (t0.remainder + e.cost) % modulo, t0.cost + e.cost);
          if (!checked[t1.vertex][t1.remainder] && t1.cost <= T)
            queue.add(t1);
        }
        checked[t0.vertex][t0.remainder] = true;
      }
    }

    return "Impossible";
  }

  class Edge {
    int target;
    int cost;
    Edge(int target, int cost) {
      this.target = target;
      this.cost = cost;
    }
  }

  class Triple implements Comparable<Triple> {
    int vertex;
    int remainder;
    long cost;
    Triple(int vertex, int remainder, long cost) {
      this.vertex = vertex;
      this.remainder = remainder;
      this.cost = cost;
    }
    public int compareTo(Triple that) {
      return Long.valueOf(cost).compareTo(that.cost);
    }
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      LongLongTripDiv1Harness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        LongLongTripDiv1Harness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class LongLongTripDiv1Harness {
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

  static boolean compareOutput(String expected, String result) { return expected.equals(result); }
  static String formatResult(String res) {
    return String.format("\"%s\"", res);
  }

  static int verifyCase(int casenum, String expected, String received) { 
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
                int N                     = 3;
                int[] A                   = {0,0,1};
                int[] B                   = {2,1,2};
                int[] D                   = {7,6,5};
                long T                    = 11;
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new LongLongTripDiv1().isAble(N, A, B, D, T));
      }
      case 1: {
                int N                     = 3;
                int[] A                   = {0,0,1};
                int[] B                   = {2,1,2};
                int[] D                   = {7,6,5};
                long T                    = 25;
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new LongLongTripDiv1().isAble(N, A, B, D, T));
      }
      case 2: {
                int N                     = 2;
                int[] A                   = {0};
                int[] B                   = {1};
                int[] D                   = {1};
                long T                    = 9;
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new LongLongTripDiv1().isAble(N, A, B, D, T));
      }
      case 3: {
                int N                     = 2;
                int[] A                   = {1};
                int[] B                   = {0};
                int[] D                   = {1};
                long T                    = 1000000000000000000L;
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new LongLongTripDiv1().isAble(N, A, B, D, T));
      }
      case 4: {
                int N                     = 4;
                int[] A                   = {0,0,1};
                int[] B                   = {2,1,2};
                int[] D                   = {10,10,10};
                long T                    = 1000;
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new LongLongTripDiv1().isAble(N, A, B, D, T));
      }
      case 5: {
                int N                     = 9;
                int[] A                   = {4,8,5,8,3,6,2,6,7,6,6};
                int[] B                   = {2,7,1,5,1,3,1,1,5,4,2};
                int[] D                   = {6580,8822,1968,673,1394,9337,5486,1746,5229,4092,195};
                long T                    = 937186357646035002L;
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new LongLongTripDiv1().isAble(N, A, B, D, T));
      }

      // custom cases

      case 6: {
                int N                     = 50;
                int[] A                   = {34, 34, 37, 19, 20, 44, 38, 21, 42, 34, 38, 15, 26, 41, 29, 19, 35, 38, 21, 28, 34, 38, 20, 36, 30, 23, 33, 30, 38, 31, 36, 39, 48, 31, 48, 49, 26, 34, 17, 10, 38, 33, 20, 42, 45, 24, 34, 41, 44, 47};
                int[] B                   = {33, 32, 36, 17, 14, 4, 19, 20, 18, 13, 30, 4, 3, 16, 10, 0, 29, 24, 10, 25, 29, 36, 5, 32, 8, 18, 30, 19, 31, 14, 8, 24, 9, 2, 28, 11, 6, 28, 13, 7, 32, 24, 18, 25, 24, 16, 10, 12, 35, 27};
                int[] D                   = {8777, 5590, 7705, 19, 4969, 7487, 1267, 663, 6375, 7699, 9822, 8028, 4416, 4228, 9842, 8410, 159, 936, 3766, 4762, 7762, 2833, 273, 1220, 6195, 8804, 5255, 8132, 517, 2305, 7684, 7475, 5114, 2412, 5545, 5709, 1760, 3806, 4673, 3793, 1173, 216, 5230, 3514, 7144, 1481, 6510, 8306, 9185, 5050};
                long T                    = 935059511052851210L;
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new LongLongTripDiv1().isAble(N, A, B, D, T));
      }
      /*      case 7: {
              int N                     = ;
              int[] A                   = ;
              int[] B                   = ;
              int[] D                   = ;
              long T                    = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new LongLongTripDiv1().isAble(N, A, B, D, T));
              }*/
      /*      case 8: {
              int N                     = ;
              int[] A                   = ;
              int[] B                   = ;
              int[] D                   = ;
              long T                    = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new LongLongTripDiv1().isAble(N, A, B, D, T));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
