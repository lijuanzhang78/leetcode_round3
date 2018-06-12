package Google;

public class _527_WordAbbreviation {
	public List<String> wordsAbbreviation(List<String> dict) {
        if (dict == null || dict.size() == 0) return new ArrayList<String>();
        String[] res = new String[dict.size()];
        int[] prefix = new int[dict.size()];
        for(int i = 0; i < dict.size(); i++) {
            String abbr = generateAbbr(dict.get(i),1);
            prefix[i] = 1;
            res[i] = abbr;
        }
        
        for(int i = 0; i < res.length; i++) {
            while(true) {
                Set<Integer> duplicate = new HashSet<>();
                for(int j = i+1; j < res.length; j++) {
                    if (res[i].equals(res[j])) {
                        duplicate.add(j);
                    }
                }
                if (duplicate.size() == 0) break;
                duplicate.add(i);
                for(int index : duplicate) {
                    prefix[index]++;
                    res[index] = generateAbbr(dict.get(index),prefix[index]);
                }
            }
        }
        return Arrays.asList(res);
    }
    
    String generateAbbr(String word, int k) {
        if (word.length()-k <= 2) return word;
        StringBuilder sb = new StringBuilder();
        sb.append(word.substring(0,k));
        sb.append(word.length()-k-1);
        sb.append(word.charAt(word.length()-1));
        return sb.toString();
    }

}
