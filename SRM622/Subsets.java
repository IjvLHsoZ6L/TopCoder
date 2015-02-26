public class Subsets {

  int N;
  int ones;
  int[] numbers;
  int count;

  public int findSubset(int[] numbers) {
    this.N = numbers.length;
    for (int i = N; i > 0; i--) {
      for (int j = 0; j + 1 < i; j++) {
        if (numbers[j] > numbers[j + 1]) {
          int temp = numbers[j];
          numbers[j] = numbers[j + 1];
          numbers[j + 1] = temp;
        }
      }
    }
    this.numbers = numbers;
    this.ones = 0;
    while (ones < N && numbers[ones] == 1)
      ones++;
    this.count = Math.max(0, ones - 1);
    count(ones, 0, 1);
    return count;
  }

  void count(int idx, int sum, int prod) {
    if (idx < N) {
      int n = numbers[idx];
      if (sum + n + ones > prod * n) {
        count += sum + n + ones - prod * n;
        count(idx + 1, sum + n, prod * n);
        while (idx < N && numbers[idx] == n)
          idx++;
        count(idx, sum, prod);
      }
    }
    return;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      SubsetsHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        SubsetsHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class SubsetsHarness {
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
                int[] numbers             = {1,1,1};
                int expected__            = 2;

                return verifyCase(casenum__, expected__, new Subsets().findSubset(numbers));
      }
      case 1: {
                int[] numbers             = {1,1,1,1,2,2,2,2};
                int expected__            = 13;

                return verifyCase(casenum__, expected__, new Subsets().findSubset(numbers));
      }
      case 2: {
                int[] numbers             = {1,2,3,4};
                int expected__            = 3;

                return verifyCase(casenum__, expected__, new Subsets().findSubset(numbers));
      }
      case 3: {
                int[] numbers             = {1,1,1,1,1,1,1,1,1,1,1,1,1,10,20,30,40,50};
                int expected__            = 77;

                return verifyCase(casenum__, expected__, new Subsets().findSubset(numbers));
      }
      case 4: {
                int[] numbers             = {1,1,1,1,1,1,1,1,1,1,1,2,3,4,2,2,2};
                int expected__            = 100;

                return verifyCase(casenum__, expected__, new Subsets().findSubset(numbers));
      }
      case 5: {
                int[] numbers             = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,2,2,2,3,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
                int expected__            = 8050;

                return verifyCase(casenum__, expected__, new Subsets().findSubset(numbers));
      }
      case 6: {
                int[] numbers             = {5,3};
                int expected__            = 0;

                return verifyCase(casenum__, expected__, new Subsets().findSubset(numbers));
      }

      // custom cases

      /*      case 7: {
              int[] numbers             = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new Subsets().findSubset(numbers));
              }*/
      /*      case 8: {
              int[] numbers             = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new Subsets().findSubset(numbers));
              }*/
      /*      case 9: {
              int[] numbers             = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new Subsets().findSubset(numbers));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
