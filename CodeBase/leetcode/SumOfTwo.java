/* problem statement: https://leetcode.com/problems/two-sum */
class SumOfTwo {
    public int[] twoSum(int[] nums, int target) throws IllegalArgumentException{
    /* Solution 1 */
            /*int ret[]= new int[2];
            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]+nums[j]==target){
                        
                        ret[0]=i;
                        ret[1]=j;
                        break;
                    }
                }
            }
            return ret;*/
        /* Solution 2 */    
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[] {i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    
    }
}