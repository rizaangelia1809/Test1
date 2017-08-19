package Test1;

/**
 *
 * @author angelia
 */
public class Equilibrium {   
    public int solution(int[] A) {
        long[] sums = generateSums(A);
        long lowSum = 0L;
        int res = -1;
        for (int i = 0; i < A.length; i++) {
            if (lowSum == sums[i+1]) {
                res = i;
                break;
            }
            lowSum += A[i];
        }
        return res;
    }

    // I used long to handle sums greater than 32 bits
    public long[] generateSums(int[] A) {
        // I added another index (default value is 0) to handle the last value (E.G. the sum of previous elements is 0, so the equilibrium index should be the last value because there are no other items after it. I used the newly added index to handle it.)
        long[] res = new long[A.length+1];
        for (int i = A.length-1; i >= 0; i--) {
            res[i] = i+1 == A.length ? A[i] : res[i+1]+A[i];
        }
        return res;
    }

public static void main(String[] args) {
    Extreme sol = new Extreme();
    int A[] = {-1, 3, -4, 5, 1, -6, 2, 1};
        System.out.println(sol.solution(A));
}
}
