import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class LC001 {

    /**
     * 时间复杂度 O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        for (int i = 0; i < nums.length; i++) {
            //j不用从头开始，之前的i遍历时已经算过了
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 时间复杂度O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            //j不用从头开始，之前的i遍历时已经算过了
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    @Test
    public void test() {
        assert Arrays.equals(new int[]{0, 1}, twoSum(new int[]{2, 7, 11, 15}, 9));
        assert Arrays.equals(new int[]{2, 3}, twoSum(new int[]{11, 15, 2, 7}, 9));
        assert Arrays.equals(new int[]{1, 2}, twoSum(new int[]{3, 2, 4}, 6));
        assert Arrays.equals(new int[]{0, 1}, twoSum(new int[]{3, 3}, 6));

        assert Arrays.equals(new int[]{0, 1}, twoSum2(new int[]{2, 7, 11, 15}, 9));
        assert Arrays.equals(new int[]{2, 3}, twoSum2(new int[]{11, 15, 2, 7}, 9));
        assert Arrays.equals(new int[]{1, 2}, twoSum2(new int[]{3, 2, 4}, 6));
        assert Arrays.equals(new int[]{0, 1}, twoSum2(new int[]{3, 3}, 6));
    }
}
