package com.algo.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PalindromicNumber {
    public static void main(String[] args) {

        String number = "313551";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < number.length(); i++) {
            map.put(number.charAt(i), map.getOrDefault(number.charAt(i), 0) + 1);
        }
        int oddCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCount++;
            }
        }
        if (oddCount > 1) {
            System.err.println("Odd Count cannot be greater than one");
            return;
        }
        char[] nums = number.toCharArray();
        Arrays.sort(nums);
        System.out.println(nums);
        char[] ans = new char[nums.length];
        for (int i = nums.length - 1, j = 0, k = nums.length - 1; i >= 0 && j < nums.length && k >= 0; ) {
            int count = map.get(nums[i]);
            if (count > 1) {
                ans[j] = nums[i];
                ans[k] = nums[i];
                map.put(nums[i], count - 2);
                i = i - 2;
                j++;
                k--;
            } else if (count == 1) {
                ans[(nums.length / 2)] = nums[i];
                i--;
            }
        }
        System.out.println(new String(ans));
    }
}
