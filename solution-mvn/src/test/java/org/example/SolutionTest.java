package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void twoSum() {
        Solution sol = new Solution();
        int [] nums = {2, 7, 11, 15};
        int target = 9;
        assertArrayEquals(sol.twoSum(nums, target), new int[] {0, 1});
    }


    @Test
    void isIsomorphic() {
        Solution sol = new Solution();
        String s = "foo";
        String t = "bar";
        assertEquals(sol.isIsomorphic(s, t), false);
    }
}