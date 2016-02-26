public class WordDistance {
    Map<String,List<Integer>> map=new HashMap<>();
    public WordDistance(String[] words) {
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i])){
                List<Integer> list=new ArrayList<>();
                map.put(words[i],list);
            } 
            map.get(words[i]).add(i);
        }
    }
    public int shortest(String word1, String word2) {
        return getdif(map.get(word1),map.get(word2));
    }
    public int getdif(List<Integer> list1, List<Integer> list2){
        int min=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        while(i<list1.size()&&j<list2.size()){
            min=Math.min(Math.abs(list1.get(i)-list2.get(j)),min);
            if(list1.get(i)<list2.get(j)) i++;
            else j++;
        }
        return min;
    }
}
