package leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午6:14
 */
public class Leetcode_26_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int ans=1,cur=nums[0];
        for(int i:nums){
            if(cur!=i){
                ++ans;
                cur = i;
                nums[ans-1]=i;
            }
        }
        return ans;

    }

}

