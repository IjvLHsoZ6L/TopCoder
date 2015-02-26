import java.util.*;

public class ChooseTheBestOne {

  public int countNumber(int N) {

    LinkedList<Integer> remainder = new LinkedList<Integer>();
    for (int i = 1; i <= N; i++)
      remainder.addLast(i);

    int current = 0;
    for (int t = 1; t <= N - 1; t++) {
      int modulo = remainder.size();
      current = (current + ((t * t) % modulo * t) % modulo + modulo - 1) % modulo;
      remainder.remove(current);
    }

    return remainder.getFirst();
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      ChooseTheBestOneHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        ChooseTheBestOneHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class ChooseTheBestOneHarness {
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
                int N                     = 3;
                int expected__            = 2;

                return verifyCase(casenum__, expected__, new ChooseTheBestOne().countNumber(N));
      }
      case 1: {
                int N                     = 6;
                int expected__            = 6;

                return verifyCase(casenum__, expected__, new ChooseTheBestOne().countNumber(N));
      }
      case 2: {
                int N                     = 10;
                int expected__            = 8;

                return verifyCase(casenum__, expected__, new ChooseTheBestOne().countNumber(N));
      }
      case 3: {
                int N                     = 1234;
                int expected__            = 341;

                return verifyCase(casenum__, expected__, new ChooseTheBestOne().countNumber(N));
      }

      // custom cases

      /*      case 4: {
              int N                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new ChooseTheBestOne().countNumber(N));
              }*/
      /*      case 5: {
              int N                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new ChooseTheBestOne().countNumber(N));
              }*/
      /*      case 6: {
              int N                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new ChooseTheBestOne().countNumber(N));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
