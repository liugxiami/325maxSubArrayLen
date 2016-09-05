package com.ccsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    //Given an array nums and a target value k,find the maximum length of a subarray that
    //sums to k,If there isn,t one, return 0 instead.

    //降维，再申明一数组，该数组的i位是原始数组的i及前面所有值的和
    public static int maxSubArrayLen(int[] nums,int k){
        int[] newArr=new int[nums.length];
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            newArr[i]+=nums[i];
        }
        Map<Integer,Integer> lookup=new HashMap<>();
        lookup.put(0,-1);
        int maxSubLen=0;
        for (int i = 0; i < nums.length; i++) {
            int diff=newArr[i]-k;
            if(lookup.containsKey(diff)){
                maxSubLen=Math.max(maxSubLen,i-lookup.get(diff));
            }
            if(!lookup.containsKey(newArr[i])){
                lookup.put(newArr[i],i);
            }
        }
        return maxSubLen;
    }
}
