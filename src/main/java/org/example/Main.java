package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var nums = new int[]{2, 2, 1};
        System.out.println(new Main().singleNumber(nums)); // 1

        nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(new Main().singleNumber(nums)); // 4

        nums = new int[]{1};
        System.out.println(new Main().singleNumber(nums)); // 1

    }

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