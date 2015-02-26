public class PowersOfTwo {

  public long count(long[] powers) {
    int[] occurs = new int[60];
    for (int i = 0, N = powers.length; i < N; i++)
      for (int j = 0; j <= 50; j++)
        if (powers[i] == 1L << j)
          occurs[j]++;
    for (int i = 0, N = occurs.length; i < N; i++) {
      if (occurs[i] > 0) {
        int q = (occurs[i] - 1) / 2;
        occurs[i + 1] += q;
        occurs[i] -= 2 * q;
      }
    }
    long count = 1;
    for (int i = 0, N = occurs.length; i < N; i++) {
      long subCount = 1,
           power = 1;
      while (occurs[i] > 0) {
        subCount += occurs[i] * power;
        power *= 2;
        i++;
      }
      count *= subCount;
    }
    return count;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      PowersOfTwoHarness.run_test(-1);
    }
    else {
      for (int i = 0; i < args.length; i++)
        PowersOfTwoHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class PowersOfTwoHarness {
  public static void run_test(int casenum) {
    if (casenum != -1) {
      if (runTestCase(casenum) == -1)
        System.err.println("Illegal input! Test case "+ casenum +" does not exist.");
      return;
    }

    int correct = 0,
        total = 0;
    for (int i = 0; true; i++) {
      int x = runTestCase(i);
      if (x == -1) {
        if (i >= 100) break;
        continue;
      }
      correct += x;
      total++;
    }

    if (total == 0)
      System.err.println("No test cases run.");
    else if (correct < total)
      System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
    else
      System.err.println("All " + total + " tests passed!");
  }

  static boolean compareOutput(long expected, long result) {
    return expected == result;
  }

  static String formatResult(long res) {
    return String.format("%d", res);
  }

  static int verifyCase(int casenum, long expected, long received) {
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
                long[] powers             = {1, 2};
                long expected__           = 4;

                return verifyCase(casenum__, expected__, new PowersOfTwo().count(powers));
      }
      case 1: {
                long[] powers             = {1, 1, 1, 1};
                long expected__           = 5;

                return verifyCase(casenum__, expected__, new PowersOfTwo().count(powers));
      }
      case 2: {
                long[] powers             = {1, 2, 2, 2, 4, 4, 16};
                long expected__           = 32;

                return verifyCase(casenum__, expected__, new PowersOfTwo().count(powers));
      }
      case 3: {
                long[] powers             = {1, 32, 1, 16, 32};
                long expected__           = 18;

                return verifyCase(casenum__, expected__, new PowersOfTwo().count(powers));
      }
      case 4: {
                long[] powers             = {1048576, 1073741824, 549755813888L, 70368744177664L, 4398046511104L, 262144, 1048576, 2097152, 8796093022208L, 1048576, 1048576, 35184372088832L, 2097152, 256, 256, 256, 262144, 1048576, 1048576, 70368744177664L, 262144, 1048576};
                long expected__           = 18432;

                return verifyCase(casenum__, expected__, new PowersOfTwo().count(powers));
      }

      // custom cases

      /*      case 5: {
              long[] powers             = {};
              long expected__           = ;

              return verifyCase(casenum__, expected__, new PowersOfTwo().count(powers));
              }*/
      /*      case 6: {
              long[] powers             = {};
              long expected__           = ;

              return verifyCase(casenum__, expected__, new PowersOfTwo().count(powers));
              }*/
      /*      case 7: {
              long[] powers             = {};
              long expected__           = ;

              return verifyCase(casenum__, expected__, new PowersOfTwo().count(powers));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
