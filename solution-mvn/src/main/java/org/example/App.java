package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.example.ListNode;

class Solution{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode current = dummyHead;
        while (current.next != null){
            if (current.next.val == val){
                current.next = current.next.next; // skip
            }
            else{
                current = current.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        for(int i =0; i < s.length(); i++){
            if (s2t.containsKey(s.charAt(i)) && s2t.get(s.charAt(i)) != t.charAt(i))
                return false;
            if (t2s.containsKey(t.charAt(i)) && t2s.get(t.charAt(i)) != s.charAt(i))
                return false;
            s2t.put(s.charAt(i), t.charAt(i));
            t2s.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
    
}

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
