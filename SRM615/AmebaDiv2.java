public class AmebaDiv2 {

  public int simulate(int[] X, int A) {

    for (int i = 0, n = X.length; i < n; i++)
      if (X[i] == A)
        A *= 2;

    return A;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      AmebaDiv2Harness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        AmebaDiv2Harness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class AmebaDiv2Harness {
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
                int[] X                   = {2,1,3,1,2};
                int A                     = 1;
                int expected__            = 4;

                return verifyCase(casenum__, expected__, new AmebaDiv2().simulate(X, A));
      }
      case 1: {
                int[] X                   = {1,4,9,16,25,36,49};
                int A                     = 10;
                int expected__            = 10;

                return verifyCase(casenum__, expected__, new AmebaDiv2().simulate(X, A));
      }
      case 2: {
                int[] X                   = {1,2,4,8,16,32,64,128,256,1024,2048};
                int A                     = 1;
                int expected__            = 512;

                return verifyCase(casenum__, expected__, new AmebaDiv2().simulate(X, A));
      }
      case 3: {
                int[] X                   = {817,832,817,832,126,817,63,63,126,817,832,287,823,817,574};
                int A                     = 63;
                int expected__            = 252;

                return verifyCase(casenum__, expected__, new AmebaDiv2().simulate(X, A));
      }

      // custom cases

      /*      case 4: {
              int[] X                   = ;
              int A                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new AmebaDiv2().simulate(X, A));
              }*/
      /*      case 5: {
              int[] X                   = ;
              int A                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new AmebaDiv2().simulate(X, A));
              }*/
      /*      case 6: {
              int[] X                   = ;
              int A                     = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new AmebaDiv2().simulate(X, A));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
