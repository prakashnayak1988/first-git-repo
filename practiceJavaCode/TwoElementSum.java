package practiceJavaCode;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TwoElementSum {

    public static int []twoSum(int []nums, int target){
        HashMap<Integer, Integer>numMap=new LinkedHashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            System.out.println("Index-->"+i+" , Complement is --> "+complement);
            if(numMap.containsKey(complement)){

                return new int[] {numMap.get(complement), i};
            }
            numMap.put(nums[i],i);
            System.out.println("  Map is -->  "+numMap);
        }

throw new IllegalArgumentException("No number found which can find complement in present Array");
    }
    public static void main(String args[]){

        int num[]={4,6,8,5,2,3};
        int target=17;
        int[] result = new TwoElementSum().twoSum(num,target);
        System.out.println("The Sum found and indices are --->"+result[0]+","+result[1]);
    }
}
