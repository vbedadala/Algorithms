package strings;

import java.util.HashMap;
import java.util.Map;

public class FibonacciSeries {
	
	private static Map<Long,Long> fibMap = new HashMap<Long, Long>();
	
	public static void main ( String args[]) {
		for( int i =0 ;i < 1000 ; i ++){
			System.out.println((long)fib(i) + "..." + i );
		}
	}
	
	public static Long fib(long n){
		if(n<2){
			return n;
		}
		
		else if(fibMap.get(n)!=null){
			return fibMap.get(n);
		}
		else{
		long fibValue = fib(n-1) + fib(n-2);
		fibMap.put(n, fibValue);
		return fibValue;
		}
			
		
	}

}
