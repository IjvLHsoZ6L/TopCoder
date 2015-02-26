import java.util.*;

public class GoodCompanyDivOne {

  public int minimumCost(int[] superior, int[] training) {

    Arrays.sort(training);

    int N = superior.length,
        K = training.length;

    ArrayList<ArrayList<Integer>> children = new ArrayList<ArrayList<Integer>>(N);
    for (int i = 0; i < N; i++)
      children.add(i, new ArrayList<Integer>());
    for (int i = 1; i < N; i++)
      children.get(superior[i]).add(i);

    int[][] minimumCost = new int[N][K];
    for (int i = N - 1; i >= 0; i--) {
      for (int x = 0; x < K; x++) {

        Network network = new Network(N + K);
        for (int j : children.get(i))
          network.addEdge(network.source, j, 0);
        for (int y = 0; y < K; y++)
          if (y != x)
            network.addEdge(N + y, network.target, 0);
        for (int j : children.get(i)) {
          for (int y = 0; y < K; y++) {
            if (y != x) {
              int cost = Integer.MAX_VALUE;
              for (int z = 0; z < K; z++)
                if (minimumCost[j][z] != -1)
                  cost = Math.min(cost, minimumCost[j][z] + (z == y ? (y == 0 ? training[1] : training[0]) : training[y]));
              if (cost < Integer.MAX_VALUE)
                network.addEdge(j, N + y, cost);
            }
          }
        }

        minimumCost[i][x] = network.minimumCost(children.get(i).size());
        if (minimumCost[i][x] != -1)
          minimumCost[i][x] += training[x];
      }
    }

    int minimum = Integer.MAX_VALUE;
    for (int x = 0; x < K; x++)
      if (minimumCost[0][x] != -1)
        minimum = Math.min(minimum, minimumCost[0][x] + (x == 0 ? training[1] : training[0]));

    return minimum < Integer.MAX_VALUE ? minimum : -1;
  }

  static class Network {

    class Edge {
      int start,
          end,
          cost;
      Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
      }
    }

    int V,
        source,
        target;
    ArrayList<ArrayList<Edge>> edges;

    Network(int V) {
      this.V = V;
      source = V;
      target = V + 1;
      edges = new ArrayList<ArrayList<Edge>>(V + 2);
      for (int i = 0; i < V + 2; i++)
        edges.add(i, new ArrayList<Edge>());
    }

    void addEdge(int start, int end, int cost) {
      edges.get(start).add(new Edge(start, end, cost));
    }

    int minimumCost(int flow) {

      int sum = 0;
      for (int count = 0; count < flow; count++) {

        int[] minimumCost = new int[V + 2];
        Arrays.fill(minimumCost, Integer.MAX_VALUE);
        minimumCost[source] = 0;

        int[] previous = new int[V + 2];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        queue.addLast(source);
        while (!queue.isEmpty()) {
          int start = queue.removeFirst();
          for (Edge edge : edges.get(start)) {
            if (minimumCost[start] + edge.cost < minimumCost[edge.end]) {
              minimumCost[edge.end] = minimumCost[start] + edge.cost;
              previous[edge.end] = start;
              queue.addLast(edge.end);
            }
          }
        }

        if (minimumCost[target] == Integer.MAX_VALUE)
          return -1;

        LinkedList<Integer> route = new LinkedList<Integer>();
        route.addLast(target);
        while (route.getFirst() != source)
          route.addFirst(previous[route.getFirst()]);

        while (route.getFirst() != target) {
          int start = route.removeFirst();
          for (int i = 0; i < edges.get(start).size(); i++) {
            if (edges.get(start).get(i).end == route.getFirst()) {
              Edge edge = edges.get(start).remove(i);
              addEdge(edge.end, edge.start, -edge.cost);
              sum += edge.cost;
              break;
            }
          }
        }
      }
      return sum;
    }
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      GoodCompanyDivOneHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        GoodCompanyDivOneHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class GoodCompanyDivOneHarness {
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
                int[] superior            = {-1};
                int[] training            = {1, 2};
                int expected__            = 3;

                return verifyCase(casenum__, expected__, new GoodCompanyDivOne().minimumCost(superior, training));
      }
      case 1: {
                int[] superior            = {-1, 0, 0};
                int[] training            = {1, 2, 3};
                int expected__            = 10;

                return verifyCase(casenum__, expected__, new GoodCompanyDivOne().minimumCost(superior, training));
      }
      case 2: {
                int[] superior            = {-1, 0, 0, 0};
                int[] training            = {1, 2, 3};
                int expected__            = -1;

                return verifyCase(casenum__, expected__, new GoodCompanyDivOne().minimumCost(superior, training));
      }
      case 3: {
                int[] superior            = {-1, 0, 0, 2, 2, 2, 1, 1, 6, 0, 5, 4, 11, 10, 3, 6, 11, 7, 0, 2, 13, 14, 2, 10, 9, 11, 22, 10, 3};
                int[] training            = {4, 2, 6, 6, 8, 3, 3, 1, 1, 5, 8, 6, 8, 2, 4};
                int expected__            = 71;

                return verifyCase(casenum__, expected__, new GoodCompanyDivOne().minimumCost(superior, training));
      }

      // custom cases

      /*      case 4: {
              int[] superior            = ;
              int[] training            = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new GoodCompanyDivOne().minimumCost(superior, training));
              }*/
      /*      case 5: {
              int[] superior            = ;
              int[] training            = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new GoodCompanyDivOne().minimumCost(superior, training));
              }*/
      /*      case 6: {
              int[] superior            = ;
              int[] training            = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new GoodCompanyDivOne().minimumCost(superior, training));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
