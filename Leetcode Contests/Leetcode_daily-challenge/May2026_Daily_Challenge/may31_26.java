import java.util.Arrays;

public class may31_26 {
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass = mass; 
        for(int a : asteroids){
            if(currMass < a){
                return false;
            }
            currMass += a;
            // System.out.print(currMass + " ");
        }
        return true;
    }
    public static void main(String[] args) {
        int mass = 10;
        int[] asteroids = {3, 9, 19, 5, 21};
        System.out.println(asteroidsDestroyed(mass, asteroids));
    }
}
