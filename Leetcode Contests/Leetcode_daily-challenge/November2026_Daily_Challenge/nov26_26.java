public class nov26_26 {
    public static boolean canAliceWin(int n) {
        boolean alice = true;
        boolean bob = false;
        int count = 10;
        while(n > 0){
            if(n < count){
                return alice == true ? false : true;
            }
            n -= count;
            alice = !alice;
            bob = !bob;
            count--;
        }
        return alice == true ? false : true;
    }
    public static void main(String[] args) {
        int n = 12;
        System.out.println(canAliceWin(n));
    }
}
