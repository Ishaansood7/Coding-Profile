import java.util.*;

public class Codeforces466C {

    public static long countWays(int[] arr) {

        int n = arr.length;

        long[] prefix = new long[n];
        prefix[0] = arr[0];

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        long total = prefix[n - 1];

        if(total % 3 != 0) return 0;

        long part = total / 3;
        long twoPart = 2 * part;

        long countPart = 0;
        long ways = 0;

        for(int i = 0; i < n - 1; i++) {

            if(prefix[i] == twoPart) {
                ways += countPart;
            }

            if(prefix[i] == part) {
                countPart++;
            }
        }

        return ways;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long ans = countWays(arr);

        System.out.println(ans);

        sc.close();
    }
}