package com.boobalan.leetcode;

public class MajorityElement {

    public static void main(String args[]){

        int[] nums={1,1,1,6,6};
        System.out.print(majorityElement(nums));

    }
    public static int majorityElement(int[] nums) {
        int num=0;
        int count=0;

        for(int i=0; i<nums.length; i++){

            if(count==0){
                num=nums[i];
            }

            if(num==nums[i]){
                count++;
            }

            else{
                count--;
            }
            System.out.print(num);
            System.out.println(count);
        }

        return num;
    }
}
