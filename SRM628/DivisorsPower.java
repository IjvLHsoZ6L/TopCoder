import java.util.*;

public class DivisorsPower {

  public long findArgument(long n) {

    ArrayList<Integer> as = new ArrayList<Integer>();
    long N = n;
    for (int a = 2; power(2, a) <= N; a++) {
      long r = (long) Math.pow(N, 1D / a);
      while (power(r, a) < N)
        r++;
      while (power(r, a) > N)
        r--;
      if (power(r, a) == N) {
        N = r;
        as.add(a);
        a--;
      }
    }

    int b = 1;
    for (int a : as)
      b *= a;

    if (b == 1)
      return -1;

    ArrayList<Integer> ms = new ArrayList<Integer>();
    for (long M = N, p = 2; M > 1; p++) {
      if (p * p > M) {
        ms.add(1);
        break;
      }
      int m = 0;
      while (M % p == 0) {
        M /= p;
        m++;
      }
      if (m > 0) {
        ms.add(m);
      }
    }

    for (int c = 1; c < b; c++) {
      if (b % c == 0) {
        int d = 1;
        for (int m : ms)
          d *= c * m + 1;
        if (d == b / c)
          return power(N, c);
      }
    }

    return -1;
  }

  long power(long base, int index) {
    long power = 1;
    for (int i = 0; i < index; i++)
      power *= base;
    return power;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      DivisorsPowerHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        DivisorsPowerHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class DivisorsPowerHarness {
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

  static boolean compareOutput(long expected, long result) { return expected == result; }
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
                long n                    = 4;
                long expected__           = 2;

                return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
      }
      case 1: {
                long n                    = 10;
                long expected__           = -1;

                return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
      }
      case 2: {
                long n                    = 64;
                long expected__           = 4;

                return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
      }
      case 3: {
                long n                    = 10000;
                long expected__           = 10;

                return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
      }
      case 4: {
                long n                    = 2498388559757689L;
                long expected__           = 49983883;

                return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
      }

      // custom cases

      case 5: {
                long n                    = 999999999999999989L;
                long expected__           = -1;

                return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
      }
      case 6: {
                long n                    = 1771561;
                long expected__           = 121;

                return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
      }
      /*      case 7: {
              long n                    = ;
              long expected__           = ;

              return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
