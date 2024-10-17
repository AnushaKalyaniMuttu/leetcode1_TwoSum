import java.util.Arrays;

public class TwoSum4 {
    public int[] twoSum(int[] nums, int target) {
        // Create an array of pairs to store the original indices
        int[][] indexedNums = new int[nums.length][2];
        
        for (int i = 0; i < nums.length; i++) {
            indexedNums[i][0] = nums[i];  // store the number
            indexedNums[i][1] = i;         // store the original index
        }
        
        // Sort the array based on the numbers
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(a[0], b[0]));

        // Iterate through the sorted array
        for (int i = 0; i < indexedNums.length; i++) {
            int complement = target - indexedNums[i][0];
            // Perform binary search for the complement
            int index = binarySearch(indexedNums, complement, i + 1);
            if (index != -1) {
                return new int[] { indexedNums[i][1], indexedNums[index][1] };
            }
        }

        // If no solution is found, throw an exception
        throw new IllegalArgumentException("No two sum solution");
    }

    private int binarySearch(int[][] nums, int target, int start) {
        int left = start, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid][0] == target) {
                return mid; // Found the target
            } else if (nums[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = ts.twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}

//TC O(nlog n)   SC O(n)
