import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Array {

	public static void main(String[] args) {
		int a[]={1,3,5,6,117};
		int b[]=plusOne(a);
		for (int i : b) {
			System.out.print(i+",");
		}
	}
	
	/**
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
	
	/**
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
	
	/**217 包含重复
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
	
	/*1，输入一个数组和一个目标整数，找出数组中哪两个值相加等于目标整数，求他们的下标
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

	/*121 买股票，数组中每一位等于每一天的价格，求获利最大
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
