import java.util.*;
public class B {
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    int X = sc.nextInt();
	    int[] A = new int[T + 1];
	    for(int i = 0 ; i <= T ; i++){
	        A[i] = sc.nextInt();
	    }
	    int saved = A[0];
	    System.out.println(0 + " " + A[0]);
	    for(int i = 1 ; i <= T ; i++){
	        if(Math.abs(A[i] - saved) >= X){
	            System.out.println(i + " " + A[i]);
	            saved = A[i];
	        }
	    }
	    sc.close();
	}
}
