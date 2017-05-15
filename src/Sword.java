
public class Sword {
	
	/*problem9:斐波那契数列
	 * f(n)=	0,n=0;
	 * 			1,n=1;
	 * 	f(n-1)+f(n-2),n>1
	 */
	public long	fibonacci(int n){
		long result = 0;
		long preOne = 1;
		long preZero = 0;
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		for(int i=2;i<=n;i++){
			result = preOne+preZero;
			//注意prezero和preone顺序
			preZero=preOne;
			preOne=result;
		}
		return result;
	}
	
	/**offer7,用两个栈实现一个队列
	 * 
	 */
	
	/*
	 *剑指offer中 5，从尾到头打印链表，用栈或递归
	 public void printListReverse(ListNode headNode){
	 	Stack<ListNode> stack = new Stack<ListNode>();
	 	while(headNode!=null){
	 		stack.push(headNode);
	 		headNode=headNode.next;
	 	}
	 	while(!stack.isEmpty()){	//栈非空，从头打印数据
	 		System.out.println(stack.pop().data);
	 	}
	 }
	 //递归
	 public void printListReverse(ListNode headNode){
	 	if(headNode!=null){
	 		if(headNode.next!=null){
	 			printListReverse(headNode.next);
	 		}
	 	}
	 	System.out.println(headNode.data);
	 }
	 */
}
