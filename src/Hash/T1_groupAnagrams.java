package Hash;

import java.util.*;

public class T1_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[]c=strs[i].toCharArray();
            Arrays.sort(c);
            String key=new String(c);

            if(!map.containsKey(key)){
                List<String> list=new ArrayList<>();
                list.add(strs[i]);
                map.put(key,list);
            }else{
                map.get(key).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }


}
