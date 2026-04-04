public class april04_26 {
    public static String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder originalText = new StringBuilder();
        for(int col = 0 ; col < cols ; col++){
            for(int j = col ; j < n ; j += cols + 1){
                originalText.append(encodedText.charAt(j));
            }
        }
        int i = originalText.length() - 1;
        while(i >= 0){
            if(originalText.charAt(i) != ' '){
                break;
            }
            else{
                originalText.deleteCharAt(i);
                i--;
            }
        }
        return originalText.toString();
    }
    public static void main(String[] args) {
        String encodedText = "ch   ie   pr";
        int rows = 3;
        System.out.println(decodeCiphertext(encodedText, rows));
    }
}
