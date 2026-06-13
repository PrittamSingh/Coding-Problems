public class june13_26 {
    public static String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < words.length ; i++){
            String word = words[i];
            int weight = 0;
            for(char ch : word.toCharArray()){
                weight += weights[ch - 'a'];
            }
            int idx = 26 - (weight % 26);
            char c = (char)('a' + idx - 1);
            res.append(c);
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String[] words = {"abcd", "def", "xyz"};
        int[] weights = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        System.out.println(mapWordWeights(words, weights));
    }
}
