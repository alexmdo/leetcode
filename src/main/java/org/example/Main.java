package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        char[] input = {'h', 'e', 'l', 'l', 'o'};
        new Main().reverseString(input);
        System.out.println(Arrays.toString(input)); // ["o","l","l","e","h"]

        input = new char[]{'H','a','n','n','a','h'};
        new Main().reverseString(input);
        System.out.println(Arrays.toString(input)); // ["h","a","n","n","a","H"]
    }

    public void reverseString(char[] s) {
        int j = s.length - 1;
        for (int i = 0; i < s.length; i++) {
            if (i >= j) {
                break;
            }

            char aux = s[i];
            s[i] = s[j];
            s[j] = aux;

            j--;
        }
    }

    /*
        System.out.println(Arrays.toString(new Main().twoSum(new int[]{2, 7, 11, 15}, 9)));  // [0,1]
        System.out.println(Arrays.toString(new Main().twoSum(new int[]{3, 2, 4}, 6)));  // [1,2]
        System.out.println(Arrays.toString(new Main().twoSum(new int[]{3, 3}, 6)));  // [0,1]
     */
    public int[] twoSum(int[] nums, int target) {
        var resp = new int[2];
        for (var i = 0; i < nums.length; i++) {
            var outerValue = nums[i];
            for (var j = 0; j < nums.length; j++) {
                var innerValue = nums[j];
                if (i == j) {
                    continue;
                }

                if (outerValue + innerValue == target) {
                    resp[0] = i;
                    resp[1] = j;
                }
            }
        }

        return resp;
    }

    /*
        System.out.println(Arrays.toString(new Main().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));  // [2, 2]
        System.out.println(Arrays.toString(new Main().intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))); // [4, 9]
        System.out.println(Arrays.toString(new Main().intersect(new int[]{3, 1, 2}, new int[]{1, 1}))); // [1]
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        var map = new HashMap<Integer, Integer>();
        for (Integer num : nums1) {
            var hashValue = map.get(num);
            map.put(num, hashValue != null ? hashValue + 1 : 1);
        }

        var aux = new ArrayList<Integer>();
        for (Integer num : nums2) {
            var hashValue = map.get(num);
            if (hashValue != null && hashValue > 0) {
                aux.add(num);
                map.put(num, hashValue - 1);
            }
        }

        var resp = new int[aux.size()];
        for (int i = 0; i < aux.size(); i++) {
            resp[i] = aux.get(i);
        }

        return resp;
    }

    /*
        var nums = new int[]{2, 2, 1};
        System.out.println(new Main().singleNumber(nums)); // 1

        nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(new Main().singleNumber(nums)); // 4

        nums = new int[]{1};
        System.out.println(new Main().singleNumber(nums)); // 1
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                i++;
                continue;
            }

            return nums[i];
        }

        return nums[nums.length - 1];
    }

    /*
        var nums = new int[]{1, 2, 3, 1};
        System.out.println(new Main().containsDuplicate(nums)); // true

        nums = new int[]{1, 2, 3, 4};
        System.out.println(new Main().containsDuplicate(nums)); // false

        nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(new Main().containsDuplicate(nums)); // true
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    /*
        Causes Time Limit Exceed

    @Deprecated
    public boolean containsDuplicate(int[] nums) {
        var foundHit = 0;
        for (int i = 0; i < nums.length; i++) {
            var outerValue = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }

                var innerValue = nums[j];
                if (outerValue == innerValue) {
                    foundHit++;
                }
            }
        }

        return foundHit > 1;
    }*/


    /*
        var nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        var k = 3;
        new Main().rotate(nums, k);
        System.out.println(Arrays.toString(nums)); // [5,6,7,1,2,3,4]

        nums = new int[]{-1, -100, 3, 99};
        k = 2;
        new Main().rotate(nums, k);
        System.out.println(Arrays.toString(nums)); // [3,99,-1,-100]
     */
    public void rotate(int[] nums, int k) {
        while (k > 0) {
            var swapElem = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                var aux = nums[i - 1];
                nums[i - 1] = swapElem;
                nums[i] = aux;
            }
            k--;
        }
    }

    /*
        var prices = new int[]{7,1,5,3,6,4};
        System.out.println(new Main().maxProfit(prices)); // 7

        prices = new int[]{1,2,3,4,5};
        System.out.println(new Main().maxProfit(prices)); // 4

        prices = new int[]{7,6,4,3,1};
        System.out.println(new Main().maxProfit(prices)); // 0
     */
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }

        return totalProfit;
    }

    /*
        var nums = new int[]{1, 1, 2};

        System.out.println(new Main().removeDuplicates(nums)); // 2
        System.out.println(Arrays.toString(nums)); // [1, 2, _]

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        System.out.println(new Main().removeDuplicates(nums)); // 5
        System.out.println(Arrays.toString(nums)); // [0,1,2,3,4,_,_,_,_,_]
     */
    public int removeDuplicates(int[] nums) {
        int slowPointer = 0;
        for (int fastPointer = 0; fastPointer < nums.length; fastPointer++) {
            if (nums[fastPointer] != nums[slowPointer]) {
                slowPointer++;
                nums[slowPointer] = nums[fastPointer];
            }
        }

        return slowPointer + 1;
    }

}