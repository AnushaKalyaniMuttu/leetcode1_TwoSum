import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Create an array of pairs to store original indices
        int[][] indexedNums = new int[nums.length][2];
        
        for (int i = 0; i < nums.length; i++) {
            indexedNums[i][0] = nums[i];  // store the number
            indexedNums[i][1] = i;         // store the original index
        }
        
        // Sort the array based on the numbers
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize two pointers
        int left = 0;
        int right = nums.length - 1;

        // Use two pointers to find the two numbers
        while (left < right) {
            int sum = indexedNums[left][0] + indexedNums[right][0];
            if (sum == target) {
                return new int[] { indexedNums[left][1], indexedNums[right][1] };
            } else if (sum < target) {
                left++; // Move left pointer to the right
            } else {
                right--; // Move right pointer to the left
            }
        }

        // If no solution is found, throw an exception
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = ts.twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}



   /** Time Complexity 𝑂(𝑛log 𝑛)
    O(nlogn) due to the sorting step.

        Space Complexity:
        𝑂(𝑛)
        O(n) for storing the original indices
        **/
