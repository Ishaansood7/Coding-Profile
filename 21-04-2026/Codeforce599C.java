import java.util.*;

public class Codeforce599C {
    public static int maxChunkstoSort(int[] nums) {

        int n = nums.length;

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        suffixMin[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        int chunks = 1;

        for(int i = 0; i < n - 1; i++) {
            if(prefixMax[i] <= suffixMin[i + 1]) {
                chunks++;
            }
        }

        return chunks;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = maxChunkstoSort(arr);

        System.out.println(ans);
    }
}