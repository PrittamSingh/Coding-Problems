public class may26_26 {
    public static int numberOfSpecialChars(String word) {
        // ONE PASS SOLUTION
        int count = 0;
        int[] freq = new int[123];
        for(char ch : word.toCharArray()){
            freq[ch]++;
            if(ch >= 'a' && ch <= 'z'){
                char capital = (char)(ch - 'a' + 'A');
                if(freq[ch] == 1 && freq[capital] > 0){
                    count++;
                }
            }
            else{
                char lower = (char)(ch - 'A' + 'a');
                if(freq[ch] == 1 && freq[lower] > 0){
                    count++;
                }
            }
        }
        return count;




        // int count = 0;
        // Set<Integer> set = new HashSet<>();
        // for(char ch : word.toCharArray()){
        //     if(ch >= 'a' && ch <= 'z'){
        //         set.add(ch - 'a');
        //     }
        // }
        // for(char ch : word.toCharArray()){
        //     if(ch >= 'A' && ch <= 'Z'){
        //         if(set.contains(ch - 'A')){
        //             count++;
        //             set.remove(ch - 'A');
        //         }
        //     }
        // }
        // return count;
    }
    public static void main(String[] args) {
        String word = "aaAbcBC";
        System.out.println(numberOfSpecialChars(word));
    }
}
