public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Iterate through all pairs of numbers
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // Check if the two numbers add up to the target
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
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


//TC: O(n2)  SC: O(n)
