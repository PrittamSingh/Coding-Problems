public class june29_26 {
    public static int numOfStrings(String[] patterns, String word) {
        // Set<String> set = new HashSet<>();
        // int n = word.length();
        // for(int i = 0 ; i < n ; i++){
        //     StringBuilder sb = new StringBuilder();
        //     for(int j = i ; j < n ; j++){
        //         sb.append(word.charAt(j));
        //         set.add(sb.toString());
        //     }
        // }
        // int m = patterns.length;
        // int count = 0;
        // for(int i = 0 ; i < m ; i++){
        //     if(set.contains(patterns[i])){
        //         count++;
        //     }
        // }
        // return count;



        int count = 0;
        for(int i = 0 ; i < patterns.length ; i++){
            if(word.contains(patterns[i])){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String[] patterns = {"a","abc","bc","d"};
        String word = "abc";
        System.out.println(numOfStrings(patterns, word));
    }
}
