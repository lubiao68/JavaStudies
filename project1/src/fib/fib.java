package fib;
 
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

 
public class fib {
               public static void main(String[] args) {
                              Scanner in = new Scanner (System.in);
                              System.out.println("Please enter tye fib index:");
                              int index = in.nextInt();
                              System.out.println(fib_bottomUp(index));
                              // System.out.println(fib_memo(index));
                              // System.out.println(fib_regular(index));                           
               }
               public static long fib_regular (int index) {
                              if (index == 0 || index == 1) {
                                 return 1;
                              }
                              return fib_regular(index-1) + fib_regular(index-2);
               }
               public static long fib_bottomUp(int index) {
 	   			   List<Long> bottomup = new ArrayList<>(index);
 	   			   if (index == 0 || index == 1) {
 	   				   return index;
 	   			   }
 	   			   bottomup.add(0,(long)0);
 	   			   bottomup.add(1,(long)1);
 	   			   for (int i=2;i<=index;i++) {
 	   				   bottomup.add(i, bottomup.get(i-1) + bottomup.get(i-2));
 	   			   }	   			   
            	   return bottomup.get(index);
               }
               public static long fib_memo (int index) {
            	   			  Map<Integer, Long> memo = new HashMap<>();
                              return fib_memo(index, memo);
               }
               public static long fib_memo (int index, Map<Integer, Long> memo) {
            	   	  		  Long result = 0L;
                              if ((result = memo.get(index)) != null) {
                                  return result;
                              }
                              if (index == 0 || index == 1) {
                            	 result = (long) index; 
                                 memo.put(index, result);
                                 return result;                                                
                              }                      
                              if (memo.get(index-1) != null && memo.get(index-2) != null) {
                                     memo.put(index, memo.get(index-1) + memo.get(index-2));
                              }
                              else if (memo.get(index-1) == null && memo.get(index-2) != null) {
                                     memo.put(index, fib_memo(index - 1, memo) + memo.get(index-2));
                              }
                              else if (memo.get(index-1) != null && memo.get(index-2) == null) {
                                    memo.put(index, memo.get(index-1) + fib_memo(index - 1, memo));
                              }
                              else {
                                    memo.put(index, fib_memo(index-1, memo) + fib_memo(index-2, memo));                                
                              }
        return memo.get(index);                            
    }

}

