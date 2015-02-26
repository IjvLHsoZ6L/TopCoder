import java.util.*;

public class BlockTheBlockPuzzle {

  static final int MAX_VALUE = 10;

  class Edge {
    int from,
        to,
        capacity,
        flow;
    Edge(int f, int t, int c) {
      from = f;
      to = t;
      capacity = c;
      flow = 0;
    }
    Edge reverse;
  }

  class Graph {

    int vertices,
        source,
        target;

    ArrayList<ArrayList<Edge>> edges;

    Graph(int v) {
      vertices = v;
      source = v;
      target = v + 1;
      edges = new ArrayList<ArrayList<Edge>>(vertices + 2);
      for (int i = 0; i < vertices + 2; i++)
        edges.add(i, new ArrayList<Edge>());
    }

    void addEdge(int from, int to, int capacity) {
      Edge edge = new Edge(from, to, capacity),
           reverse = new Edge(to, from, 0);
      edge.reverse = reverse;
      reverse.reverse = edge;
      edges.get(from).add(edge);
      edges.get(to).add(reverse);
    }

    boolean[] checked;

    boolean flow(int from) {
      if (checked[from])
        return false;
      checked[from] = true;
      if (from == target)
        return true;
      for (Edge edge : edges.get(from)) {
        if (edge.flow < edge.capacity && flow(edge.to)) {
          edge.flow++;
          edge.reverse.flow--;
          return true;
        }
      }
      return false;
    }

    int maximumFlow() {
      int flow = 0;
      while (true) {
        checked = new boolean[vertices + 2];
        if (flow(source)) {
          flow++;
          if (flow == MAX_VALUE)
            return -1;
        }
        else {
          return flow;
        }
      }
    }
  }

  int n;

  int in(int i, int j) {
    return (i * n + j) * 2;
  }

  int out(int i, int j) {
    return (i * n + j) * 2 + 1;
  }

  public int minimumHoles(String[] board) {

    n = board.length;

    char[][] B = new char[n][];
    for (int i = 0; i < n; i++)
      B[i] = board[i].toCharArray();

    int[][] C = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        switch (B[i][j]) {
          case '.': C[i][j] = 1; break;
          case 'H': C[i][j] = 0; break;
          case 'b': C[i][j] = MAX_VALUE; break;
          case '$': C[i][j] = MAX_VALUE; break;
        }
      }
    }

    int goal_i, goal_j, i0, j0;
    {
      int k = 0;
      while (B[k / n][k % n] != '$')
        k++;
      goal_i = k / n;
      goal_j = k % n;
      i0 = goal_i % 3;
      j0 = goal_j % 3;
    }

    Graph graph = new Graph(n * n * 2);
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        graph.addEdge(in(i, j), out(i, j), C[i][j]);
    for (int i = i0; i < n; i += 3)
      for (int j = j0; j < n; j += 3)
        if (B[i][j] == 'b')
          graph.addEdge(graph.source, in(i, j), MAX_VALUE);
    graph.addEdge(out(goal_i, goal_j), graph.target, MAX_VALUE);
    for (int i = i0; i + 3 < n; i += 3) {
      for (int j = j0; j < n; j += 3) {
        graph.addEdge(out(i, j), in(i + 1, j), MAX_VALUE);
        graph.addEdge(out(i, j), in(i + 2, j), MAX_VALUE);
        graph.addEdge(out(i + 1, j), in(i + 3, j), MAX_VALUE);
        graph.addEdge(out(i + 2, j), in(i + 3, j), MAX_VALUE);
        graph.addEdge(out(i + 3, j), in(i + 1, j), MAX_VALUE);
        graph.addEdge(out(i + 3, j), in(i + 2, j), MAX_VALUE);
        graph.addEdge(out(i + 1, j), in(i, j), MAX_VALUE);
        graph.addEdge(out(i + 2, j), in(i, j), MAX_VALUE);
      }
    }
    for (int i = i0; i < n; i += 3) {
      for (int j = j0; j + 3 < n; j += 3) {
        graph.addEdge(out(i, j), in(i, j + 1), MAX_VALUE);
        graph.addEdge(out(i, j), in(i, j + 2), MAX_VALUE);
        graph.addEdge(out(i, j + 1), in(i, j + 3), MAX_VALUE);
        graph.addEdge(out(i, j + 2), in(i, j + 3), MAX_VALUE);
        graph.addEdge(out(i, j + 3), in(i, j + 1), MAX_VALUE);
        graph.addEdge(out(i, j + 3), in(i, j + 2), MAX_VALUE);
        graph.addEdge(out(i, j + 1), in(i, j), MAX_VALUE);
        graph.addEdge(out(i, j + 2), in(i, j), MAX_VALUE);
      }
    }

    return graph.maximumFlow();
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      BlockTheBlockPuzzleHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        BlockTheBlockPuzzleHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class BlockTheBlockPuzzleHarness {
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
                String[] board            = {"b..$",
                  "....",
                  "HHHH",
                  "HHHH"};
                int expected__            = 2;

                return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
      }
      case 1: {
                String[] board            = {"............H..",
                  "...............",
                  "...............",
                  "HHH$HHH.....H..",
                  "HHHHHHH........",
                  "HHHHHHHH.......",
                  "......b..H.....",
                  "...............",
                  "...............",
                  "...H..H..H.....",
                  "...............",
                  "...............",
                  "...............",
                  "...............",
                  "..............."};
                int expected__            = 0;

                return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
      }
      case 2: {
                String[] board            = {"............H..",
                  "...............",
                  "...............",
                  "HHH$HHH........",
                  "HHHHHHH........",
                  "HHHHHHHH.......",
                  "......b..H.....",
                  "...............",
                  "...............",
                  "...H..H..H.....",
                  "...............",
                  "...............",
                  "...............",
                  "...............",
                  "..............."};
                int expected__            = 1;

                return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
      }
      case 3: {
                String[] board            = {"b..$...",
                  "...H...",
                  ".......",
                  "b..b..b",
                  "...H...",
                  ".......",
                  "b..b..b"}

                ;
                int expected__            = 4;

                return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
      }
      case 4: {
                String[] board            = {"b..b..b",
                  "..b..b.",
                  ".......",
                  "b..$bbb",
                  ".b.....",
                  "....b..",
                  "b..b..b"}
                ;
                int expected__            = -1;

                return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
      }

      // custom cases

      /*      case 5: {
              String[] board            = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
              }*/
      /*      case 6: {
              String[] board            = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
              }*/
      /*      case 7: {
              String[] board            = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new BlockTheBlockPuzzle().minimumHoles(board));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
