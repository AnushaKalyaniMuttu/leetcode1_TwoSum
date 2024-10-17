import java.util.HashMap;

public class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        // Create a hash map to store number and its index
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Check if the complement exists in the map
            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i };
            }
            // Store the number and its index in the map
            numToIndex.put(nums[i], i);
        }
        
        // If no solution is found, return an empty array or throw an exception
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

//TC o(n)  SC  o(n)
