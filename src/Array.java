import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Array {

	public static void main(String[] args) {
		int a[]={1,3,5,6,119};
		int b[]=plusOne(a);
		for (int i : b) {
			System.out.print(i+",");
		}
	}

	
	
	/** 7-26 移除有序数组中的重复元素，不新建数组，在原有数组上操作
	 * 有序数组去重，从头到尾，相邻两两比较。
	 * @param nums	[1,1,2]
	 * @return	返回去重后的数组长度2，[1,2]
	 */
	public int removeDuplicates(int[] nums) {
		if(nums.length==0||nums==null){
			return 0;
		}
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
			if(nums[size]!=nums[i]){
				nums[++size]=nums[i];
			}
		}
        return size+1;
    }
	
	/*6-219解法2	数组中重复的数，用set很6
	public boolean containsNearbyDuplicate(int[] nums, int k) {
			for (int i = 0; i < nums.length; i++) {
			if(i>k) s.remove(nums[i-k-1]);	//保证set中只有k个数,这样一有重复的数下标肯定小于等于k
			if(!s.add(nums[i])) return true;
		}
		return false;
	}
	*/
	
	/**6-219
	 * 借助hashMap判断下标，与第2题类似，都是数组中下标的问题
	 * @param nums	输入一个数组和一个整数k
	 * @param k
	 * @return	如果数组中存在两个相同的数且下标距离小于k，返回true
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> s = new HashSet<>();
        if(nums.length<2||k<1)
        	return false;
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++){
        	//如果map中没有这个值，添加到map中
        	if(!m.containsKey(nums[i])){
        		m.put(nums[i], i);
        	}
        	//如果map中有这个值取出它的下标，判断i-value<k
        	else{
        		int value = m.get(nums[i]);
        		if((i-value)<=k)
        			return true;
        		m.put(nums[i], i);	//这一步可能的情况是，前两个相同的数下标大于k，存在第3个相同的数，2,3的下标<k
        	}
        }
        return false;
    }
	
	/**5-
	 * 一个非负整数被表示为一个数组， 数组中每一个元素代表该整数的一个位。
	 * 数组的下标越小，代表的位数越高。
	 * 现在对该数组做加一运算，请返回结果数组。
	 */
	public static int[] plusOne(int[] digits) {
        int carries = 1;
        for(int i = digits.length-1; i>=0 && carries > 0; i--){  // fast break when carries equals zero
            int sum = digits[i] + carries;
            digits[i] = sum % 10;
            carries = sum / 10;
        }
        if(carries == 0)
            return digits;
            
        int[] rst = new int[digits.length+1];
        rst[0] = 1;
        for(int i=1; i< rst.length; i++){
            rst[i] = digits[i-1];
        }
        return rst;
    }
	
	/**4-
	 * 买卖股票2，购买一次并多次出售股票，必须在再次购买之前先出售该股票，找到最大的利润。
	 * prices[1,3,5,6,4],这个问题应该是找局部最优解，但可以简化为只要有增加就卖股票
	 * 结果是(3-1)+(5-3)+(6-5)=5
	 * (5-1)+(6-5)=5,顺序数组,每个数之间的差的和等于最大值-最小值
	 */
	public static int maxProfit2(int[] prices){
		int profit=0;
		for(int i=0;i<prices.length-1;i++){
			int diff=prices[i+1]-prices[i];
			if(diff>0){
				profit+=diff;
			}
		}
		return profit;
	}
	
	/**3-217 包含重复
	 * 给定整数数组，查找数组是否包含任何重复项。
	 * 如果数组中的任何值至少出现两次，则函数应返回true，如果每个元素都不同，则返回false。
	 * @param nums
	 * @return
	 */
	public  boolean containsDuplicate(int[] nums) {
		 Set<Integer> set = new HashSet<>();
		 for(int i : nums)
			 if(!set.add(i))// if there is same,set.add() return false
				 return true; 
		 return false;
	 }
	
	/*2-1，输入一个数组和一个目标整数，找出数组中哪两个值相加等于目标整数，求他们的下标
	 * @param numbers : An array of Integer
	 * @param target : target = numbers[index1] + numbers[index2]
	 * @return : [index1 + 1, index2 + 1] (index1 < index2) numbers=[2, 7, 11,
	 * 15], target=9 return [1, 2]
	 */
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {
			if (map.get(numbers[i]) != null) {
				int[] result = { map.get(numbers[i]) + 1, i + 1 };
				return result;
			}
			map.put(target - numbers[i], i);
		}

		int[] result = {};
		return result;
	}

	/*1-121 买股票，数组中每一位等于每一天的价格，求获利最大
	 * Input: [7, 1, 5, 3, 6, 4] Output: 5 
	 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
	 */
	 public int maxProfit(int[] prices) {
	        if (prices == null || prices.length == 0) {
	            return 0;
	        }

	        int min = Integer.MAX_VALUE;  //just remember the smallest price
	        int profit = 0;
	        for (int i : prices) {
	            min = i < min ? i : min;
	            profit = (i - min) > profit ? i - min : profit;
	        }

	        return profit;
	    }
}
