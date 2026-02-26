public class feb26_26 {
    public static int numSteps(String s) {
        int noOfSteps = 0;
        int carry = 0;
        for(int i = s.length() - 1 ; i > 0 ; i--){
            int a = (s.charAt(i) - '0') + carry;
            if(a == 1){ //Odd
                noOfSteps += 2;
                carry = 1;
            }
            else{ //Even
                noOfSteps += 1;
            }
        }
        if(carry == 1){
            noOfSteps += 1;
        }
        return noOfSteps;
    }
    public static void main(String[] args) {
        String s = "1101";
        String s1 = "10";
        System.out.println(numSteps(s) + " " + numSteps(s1));
    }
}
