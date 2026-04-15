public class april15_26 {
    public static int closestTarget(String[] words, String target, int startIndex) {
        // int n = words.length;
        // int rightDist = 0;
        // int rightIdx = startIndex;
        // for(int i = 0 ; i < n ; i++){
        //     if(words[rightIdx].equals(target)){
        //         break;
        //     }
        //     else{
        //         rightIdx = (rightIdx + 1) % n;
        //     }
        //     rightDist++;
        // }
        // int leftDist = 0;
        // int leftIdx = startIndex;
        // for(int i = 0 ; i < n ; i++){
        //     if(words[leftIdx].equals(target)){
        //         break;
        //     }
        //     else{
        //         leftIdx = (leftIdx - 1 + n) % n;
        //     }
        //     leftDist++;
        // }
        // if(leftDist == n && !words[leftIdx].equals(target)){
        //     return -1;
        // }
        // return Math.min(leftDist, rightDist);





        int n = words.length;
        for(int step = 0 ; step < n ; step++){
            int right = (startIndex + step) % n;
            int left = (startIndex - step + n) % n;
            if(words[right].equals(target) || words[left].equals(target)){
                return step;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String[] words = {"hello","i","am","leetcode","hello"};
        String target = "hello";
        int startIndex = 1;
        String[] words2 = {"i","eat","leetcode"};
        String target2 = "ate";
        int startIndex2 = 0;
        System.out.println(closestTarget(words, target, startIndex) + " " + closestTarget(words2, target2, startIndex2));
    }
}
