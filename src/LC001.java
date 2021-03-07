import org.junit.Test;

import java.util.Arrays;


public class LC001 {

    @Test
    public void test(){
        assert Arrays.equals(new int[]{0,1}, twoSum(new int[]{2,7,11,15}, 9));
        assert Arrays.equals(new int[]{1,2}, twoSum(new int[]{3,2,4}, 6));
        assert Arrays.equals(new int[]{0,1}, twoSum(new int[]{3, 3}, 6));
    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return null;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] + nums[i+1] == target){
                return new int[]{i,i+1};
            }
        }
        return null;
    }
}
