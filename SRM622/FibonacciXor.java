import java.util.ArrayList;

public class FibonacciXor {


  public int find(long A, long B) {
    final int modulo = 1000000007;
    ArrayList<Long> list = new ArrayList<Long>();
    long a = 0,
         b = 1,
         c = a + b;
    list.add(a);
    list.add(b);
    while (c <= B + 1) {
      list.add(c);
      a = b;
      b = c;
      c = a + b;
    }
    int l = list.size();
    long[] fibonacci = new long[l];
    for (int i = 0; i < l; i++)
      fibonacci[i] = list.get(i);
    int[] inversion = new int[l];
    int[] coeff = new int[l];
    long N = A;
    for (int i = l - 1; i >= 2; i--) {
      coeff[i] = (int) (N / fibonacci[i]);
      N %= fibonacci[i];
    }
    for (int i = 2; i < l; i++) {
      if (coeff[i] == 1)
        for (int j = 2; j < i; j++)
          inversion[i] += (int) (coeff[j] * fibonacci[j] % 2);
      for (int j = i + 1; j < l; j++)
        inversion[i] += (int) (coeff[j] * fibonacci[i - 1] * fibonacci[j - i] % 2);
    }
    N = B + 1;
    for (int i = l - 1; i >= 2; i--) {
      coeff[i] = (int) (N / fibonacci[i]);
      N %= fibonacci[i];
    }
    for (int i = 2; i < l; i++) {
      if (coeff[i] == 1)
        for (int j = 2; j < i; j++)
          inversion[i] += (int) (coeff[j] * fibonacci[j] % 2);
      for (int j = i + 1; j < l; j++)
        inversion[i] += (int) (coeff[j] * fibonacci[i - 1] * fibonacci[j - i] % 2);
    }
    int sum = 0;
    for (int i = 2, power = 1; i < l; i++, power = power * 2 % modulo)
      if (inversion[i] % 2 == 1)
        sum = (sum + power) % modulo;
    return sum;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      FibonacciXorHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        FibonacciXorHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class FibonacciXorHarness {
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
                long A                    = 1;
                long B                    = 2;
                int expected__            = 3;

                return verifyCase(casenum__, expected__, new FibonacciXor().find(A, B));
      }
      case 1: {
                long A                    = 3;
                long B                    = 10;
                int expected__            = 25;

                return verifyCase(casenum__, expected__, new FibonacciXor().find(A, B));
      }
      case 2: {
                long A                    = 1;
                long B                    = 1000000000000000L;
                int expected__            = 780431495;

                return verifyCase(casenum__, expected__, new FibonacciXor().find(A, B));
      }

      // custom cases

      /*      case 3: {
              long A                    = ;
              long B                    = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new FibonacciXor().find(A, B));
              }*/
      /*      case 4: {
              long A                    = ;
              long B                    = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new FibonacciXor().find(A, B));
              }*/
      /*      case 5: {
              long A                    = ;
              long B                    = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new FibonacciXor().find(A, B));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
