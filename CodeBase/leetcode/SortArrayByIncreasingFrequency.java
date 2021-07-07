/* https://leetcode.com/problems/sort-array-by-increasing-frequency */
import java.util.*;
class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        
        return solution2(nums);        
    }
    public int[] solution1(int[] nums){
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++){
            if(frequencyMap.containsKey(nums[i])){
                frequencyMap.put(nums[i], frequencyMap.get(nums[i])+1);                
            }
            else
                frequencyMap.put(nums[i], 1);
            result.add(nums[i]);
        }
        
        Collections.sort(result, new SortedComparator(frequencyMap));
        //System.out.println(result);
        //Integer[] arr = result.toArray(new Integer[result.size()])    ;
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    public class SortedComparator implements Comparator<Integer> {
        Map<Integer, Integer> map ;
        SortedComparator(Map<Integer, Integer> map){
            this.map = map;            
        }
        
        @Override
        public int compare(Integer key1, Integer key2){
            int result = map.get(key1).compareTo(map.get(key2));
            if(result == 0)
                result = key2.compareTo(key1);
            return result;
        }
    }
    /* using tree map [faster solution]*/
    public int[] solution2(int[] nums){
        
        int[] freq = new int[201]; //-100 to 100
        for(int i=0; i<nums.length; i++){
            freq[nums[i]+100]++;
        }
        
        TreeMap<Integer, List<Integer>> tree=  new TreeMap<Integer, List<Integer>>();
        for(int i=freq.length-1; i>=0; i--){ //TreeMap to store numbers list by their frequency and in case of same frequency the list will be in descending order
            if(freq[i]>0){                
                if(!tree.containsKey(freq[i]))
                    tree.put(freq[i], new ArrayList<Integer>());
                List<Integer> temp = tree.get(freq[i]);
                temp.add(i-100);
            
            }       
        }
        int[] result = new int[nums.length];
        int index = 0;
        for(Map.Entry<Integer, List<Integer>> entry : tree.entrySet()){
            List<Integer> valueList =entry.getValue();
            if(valueList.size()>1)
                Collections.sort(valueList, (a,b) -> b.compareTo(a));
            for(int i=0; i<valueList.size(); i++)
                for(int j=0; j<entry.getKey(); j++){
                    result[index++] = valueList.get(i);
                }
        }
        return result;
    }
        
}