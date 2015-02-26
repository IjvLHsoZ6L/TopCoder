import java.util.*;

public class CandyCollection {

  public int solve(int[] Type1, int[] Number1, int[] Type2, int[] Number2) {

    int N = Type1.length;

    int[][] number = new int[N][N];
    for (int i = 0; i < N; i++) {
      number[Type1[i]][i] = Number1[i];
      number[Type2[i]][i] = Number2[i];
    }

    int sum = 0;
    boolean[] checked = new boolean[N];
    for (int start = 0; start < N; start++) {
      if (!checked[start]) {

        ArrayList<Integer> loop = new ArrayList<Integer>();

        int f = start;
        int s = -1;

        do {

          checked[f] = true;

          int ss = s;
          s = 0;
          while (number[f][s] == 0 || s == ss)
            s++;

          loop.add(number[f][s]);

          int ff = f;
          f = 0;
          while (number[f][s] == 0 || f == ff)
            f++;

          loop.add(number[f][s]);

        } while (f != start);

        sum += minimum(loop);
      }
    }

    return sum;
  }

  int minimum(ArrayList<Integer> loop) {

    int n = loop.size() / 2;
    loop.add(loop.get(0));
    loop.add(loop.get(1));
    loop.add(loop.get(2));
    loop.add(loop.get(3));

    int[] flavor = new int[n + 2];
    for (int i = 1; i <= n + 1; i++)
      flavor[i] = Math.min(loop.get(2 * i - 2), loop.get(2 * i + 1)) + 1;

    int[] shape = new int[n + 2];
    for (int i = 1; i <= n + 1; i++)
      shape[i] = Math.max(loop.get(2 * i), loop.get(2 * i + 1)) + 1;

    int[][] minimum = new int[3][n + 2];

    minimum[1][0] = 0;
    minimum[1][1] = flavor[1];
    for (int i = 2; i <= n; i++)
      minimum[1][i] = Math.min(minimum[1][i - 2] + shape[i - 1], minimum[1][i - 1] + flavor[i]);

    minimum[2][1] = 0;
    minimum[2][2] = flavor[2];
    for (int i = 3; i <= n + 1; i++)
      minimum[2][i] = Math.min(minimum[2][i - 2] + shape[i - 1], minimum[2][i - 1] + flavor[i]);

    return Math.min(minimum[1][n], minimum[2][n + 1]);
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      CandyCollectionHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        CandyCollectionHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class CandyCollectionHarness {
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
                int[] Type1               = {0,0};
                int[] Number1             = {1,1};
                int[] Type2               = {1,1};
                int[] Number2             = {1,1};
                int expected__            = 2;

                return verifyCase(casenum__, expected__, new CandyCollection().solve(Type1, Number1, Type2, Number2));
      }
      case 1: {
                int[] Type1               = {0,0};
                int[] Number1             = {2,5};
                int[] Type2               = {1,1};
                int[] Number2             = {2,5};
                int expected__            = 3;

                return verifyCase(casenum__, expected__, new CandyCollection().solve(Type1, Number1, Type2, Number2));
      }
      case 2: {
                int[] Type1               = {0,0,2,3};
                int[] Number1             = {1,1,2,2};
                int[] Type2               = {1,1,3,2};
                int[] Number2             = {1,1,2,2};
                int expected__            = 5;

                return verifyCase(casenum__, expected__, new CandyCollection().solve(Type1, Number1, Type2, Number2));
      }
      case 3: {
                int[] Type1               = {0,1,2,3};
                int[] Number1             = {5,5,10,13};
                int[] Type2               = {1,2,3,0};
                int[] Number2             = {8,8,10,15};
                int expected__            = 20;

                return verifyCase(casenum__, expected__, new CandyCollection().solve(Type1, Number1, Type2, Number2));
      }
      case 4: {
                int[] Type1               = {12,9,0,16,9,18,12,3,6,0,8,2,10,6,5,2,14,10,5,13};
                int[] Number1             = {895,704,812,323,334,674,665,142,712,254,869,548,645,663,758,38,860,724,742,530};
                int[] Type2               = {1,4,7,11,15,8,18,13,17,17,19,14,7,11,4,1,15,19,3,16};
                int[] Number2             = {779,317,36,191,843,289,107,41,943,265,649,447,806,891,730,371,351,7,102,394};
                int expected__            = 5101;

                return verifyCase(casenum__, expected__, new CandyCollection().solve(Type1, Number1, Type2, Number2));
      }

      // custom cases

      /*      case 5: {
              int[] Type1               = ;
              int[] Number1             = ;
              int[] Type2               = ;
              int[] Number2             = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new CandyCollection().solve(Type1, Number1, Type2, Number2));
              }*/
      /*      case 6: {
              int[] Type1               = ;
              int[] Number1             = ;
              int[] Type2               = ;
              int[] Number2             = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new CandyCollection().solve(Type1, Number1, Type2, Number2));
              }*/
      /*      case 7: {
              int[] Type1               = ;
              int[] Number1             = ;
              int[] Type2               = ;
              int[] Number2             = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new CandyCollection().solve(Type1, Number1, Type2, Number2));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
