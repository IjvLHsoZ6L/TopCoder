import java.util.LinkedList;

public class MyVeryLongCake {

  public int cut(int n) {

    LinkedList<Integer> primeFactors = new LinkedList<Integer>();
    for (int p = 2, N = n; N > 1; p++) {
      if (p * p > N) {
        primeFactors.addLast(N);
        break;
      }
      if (N % p == 0) {
        primeFactors.addLast(p);
        do N /= p; while(N % p == 0);
      }
    }

    int uncut = n;
    for (int p : primeFactors)
      uncut = uncut / p * (p - 1);

    return n - uncut;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      MyVeryLongCakeHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        MyVeryLongCakeHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class MyVeryLongCakeHarness {
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
                int n                     = 6;
                int expected__            = 4;

                return verifyCase(casenum__, expected__, new MyVeryLongCake().cut(n));
      }
      case 1: {
                int n                     = 3;
                int expected__            = 1;

                return verifyCase(casenum__, expected__, new MyVeryLongCake().cut(n));
      }
      case 2: {
                int n                     = 15;
                int expected__            = 7;

                return verifyCase(casenum__, expected__, new MyVeryLongCake().cut(n));
      }
      case 3: {
                int n                     = 1000000000;
                int expected__            = 600000000;

                return verifyCase(casenum__, expected__, new MyVeryLongCake().cut(n));
      }
      case 4: {
                int n                     = 577007436;
                int expected__            = 384671628;

                return verifyCase(casenum__, expected__, new MyVeryLongCake().cut(n));
      }

      // custom cases

      /*      case 5: {
              int n                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new MyVeryLongCake().cut(n));
              }*/
      /*      case 6: {
              int n                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new MyVeryLongCake().cut(n));
              }*/
      /*      case 7: {
              int n                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new MyVeryLongCake().cut(n));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
