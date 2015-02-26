import java.util.*;

public class PalindromePermutations {

  public double palindromeProbability(String word) {

    int n = word.length();

    double[] factorial = new double[n + 1];
    factorial[0] = 1D;
    for (int i = 1; i <= n; i++)
      factorial[i] = factorial[i - 1] * i;

    int[] count = new int[26];
    for (int i = 0; i < n; i++)
      count[word.charAt(i) - 'a']++;

    int odds = 0;
    double probability = factorial[n / 2] / factorial[n];
    for (int c = 0; c < 26; c++) {
      if (count[c] % 2 == 1)
        odds++;
      probability *= factorial[count[c]];
      probability /= factorial[count[c] / 2];
    }

    if (odds <= 1)
      return probability;
    else
      return 0;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      PalindromePermutationsHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        PalindromePermutationsHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class PalindromePermutationsHarness {
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

  static final double MAX_DOUBLE_ERROR = 1E-9;
  static boolean compareOutput(double expected, double result){ if(Double.isNaN(expected)){ return Double.isNaN(result); }else if(Double.isInfinite(expected)){ if(expected > 0){ return result > 0 && Double.isInfinite(result); }else{ return result < 0 && Double.isInfinite(result); } }else if(Double.isNaN(result) || Double.isInfinite(result)){ return false; }else if(Math.abs(result - expected) < MAX_DOUBLE_ERROR){ return true; }else{ double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); return result > min && result < max; } }
  static double relativeError(double expected, double result) { if (Double.isNaN(expected) || Double.isInfinite(expected) || Double.isNaN(result) || Double.isInfinite(result) || expected == 0) return 0; return Math.abs(result-expected) / Math.abs(expected); }

  static String formatResult(double res) {
    return String.format("%.10g", res);
  }

  static int verifyCase(int casenum, double expected, double received) { 
    System.err.print("Example " + casenum + "... ");
    if (compareOutput(expected, received)) {
      System.err.print("PASSED");
      double rerr = relativeError(expected, received);
      if (rerr > 0) System.err.printf(" (relative error %g)", rerr);
      System.err.println();
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
                String word               = "haha";
                double expected__         = 0.3333333333333333;

                return verifyCase(casenum__, expected__, new PalindromePermutations().palindromeProbability(word));
      }
      case 1: {
                String word               = "xxxxy";
                double expected__         = 0.2;

                return verifyCase(casenum__, expected__, new PalindromePermutations().palindromeProbability(word));
      }
      case 2: {
                String word               = "xxxx";
                double expected__         = 1.0;

                return verifyCase(casenum__, expected__, new PalindromePermutations().palindromeProbability(word));
      }
      case 3: {
                String word               = "abcde";
                double expected__         = 0.0;

                return verifyCase(casenum__, expected__, new PalindromePermutations().palindromeProbability(word));
      }
      case 4: {
                String word               = "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhff";
                double expected__         = 0.025641025641025637;

                return verifyCase(casenum__, expected__, new PalindromePermutations().palindromeProbability(word));
      }

      // custom cases

      case 5: {
              String word               = "ababababababababababababababababababababababababab";
              double expected__         = 0.0;

              return verifyCase(casenum__, expected__, new PalindromePermutations().palindromeProbability(word));
              }
      /*      case 6: {
              String word               = ;
              double expected__         = ;

              return verifyCase(casenum__, expected__, new PalindromePermutations().palindromeProbability(word));
              }*/
      /*      case 7: {
              String word               = ;
              double expected__         = ;

              return verifyCase(casenum__, expected__, new PalindromePermutations().palindromeProbability(word));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
