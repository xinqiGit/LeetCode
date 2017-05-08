import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Array {

	public static void main(String[] args) {
		int a[]={1,3,5,6,119};
		int b[]=plusOne(a);
		for (int i : b) {
			System.out.print(i+",");
		}
	}
	
	/**
	 * һ���Ǹ���������ʾΪһ�����飬 ������ÿһ��Ԫ�ش����������һ��λ��
	 * ������±�ԽС�������λ��Խ�ߡ�
	 * ���ڶԸ���������һ���㣬�뷵�ؽ�����顣
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
	 * ������Ʊ2������һ�β���γ��۹�Ʊ���������ٴι���֮ǰ�ȳ��۸ù�Ʊ���ҵ���������
	 * prices[1,3,5,6,4],�������Ӧ�����Ҿֲ����Ž⣬�����Լ�ΪֻҪ�����Ӿ�����Ʊ
	 * �����(3-1)+(5-3)+(6-5)=5
	 * (5-1)+(6-5)=5,˳������,ÿ����֮��Ĳ�ĺ͵������ֵ-��Сֵ
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
	
	/**217 �����ظ�
	 * �����������飬���������Ƿ�����κ��ظ��
	 * ��������е��κ�ֵ���ٳ������Σ�����Ӧ����true�����ÿ��Ԫ�ض���ͬ���򷵻�false��
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
	
	/*1������һ�������һ��Ŀ���������ҳ�������������ֵ��ӵ���Ŀ�������������ǵ��±�
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

	/*121 ���Ʊ��������ÿһλ����ÿһ��ļ۸���������
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
