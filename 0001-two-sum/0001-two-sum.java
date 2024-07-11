class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<nums.length;j++){
                if(i==j){
                    continue;
                }
                if(target == nums[i] + nums[j]){
                    output[0] = i;
                    output[1] = j;
                    return output;
                }
            }
        }
        return null;
    }
}