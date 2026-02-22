public class feb22_26 {
    public static int binaryGap(int n) {
        int lastPos = -1;
        int maxDist = 0;
        int currPos = 0;
        while(n > 0){
            if((n & 1) == 1){
                if(lastPos != -1){
                    maxDist = Math.max(maxDist, currPos - lastPos);
                }
                lastPos = currPos;
            }
            currPos++;
            n = n >> 1;
        }
        return maxDist;
    }
    public static void main(String[] args) {
        int n = 22;
        int n2 = 8;
        int n3 = 5;
        System.out.println(binaryGap(n) + " " + binaryGap(n2) + " " + binaryGap(n3));
    }
}
