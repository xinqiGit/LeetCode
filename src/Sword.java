
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
}
