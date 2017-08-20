package Test1;

/**
 *
 * @author angelia
 */
class MissingInteger {
    public int solution(int[] A) {
        int n = A.length;
        int [] buffer = new int[n];
        int min = Integer.MAX_VALUE;

        // Find min within the array for the positive integers
        for (int i = 0; i < n; i++) {
            if (min > A[i] && A[i] > 0) min = A[i];
        }

        // No positive integer? Return 1
        if (min == Integer.MAX_VALUE) return 1;

        // Fill additional buffer with positive integers restricting to valus from 1 to A.length
        for (int i = 0; i < n; i++) {
            if (A[i] > n) continue;
            if (A[i] < 1) continue;
            buffer[A[i] - 1] = A[i];
        }

        // Return result
        if (buffer[0] != 1) return 1;
        for (int i = 0; i < n; i++) {
            if (buffer[i] == 0) return i + 1;
        }
        return n + 1;
    }
    public static void main (String[] args) {
        MissingInteger sol = new MissingInteger();
        int [] arr = {-2, -1, 2, 4, 6, 3, 8};
        System.out.println(sol.solution(arr));
    }
}
