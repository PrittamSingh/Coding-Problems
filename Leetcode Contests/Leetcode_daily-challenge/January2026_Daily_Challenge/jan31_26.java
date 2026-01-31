public class jan31_26 {
    public static char nextGreatestLetter(char[] letters, char target) {
        for(char ch : letters){
            int chNum = ch - 'a';
            int targetNum = target - 'a';
            if(chNum - targetNum > 0){
                return ch;
            }
        }
        return letters[0];
    }
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters, target));
        char[] letters1= {'c','f','j'};
        char target1 = 'c';
        System.out.println(nextGreatestLetter(letters1, target1));
    }
}
