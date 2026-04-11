import java.util.*;
public class A {
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    String S = sc.next();
	    int fstDiff = -1;
	    for(int i = 0 ; i < N ; i++){
	        if(S.charAt(i) == 'o'){
	            continue;
	        }
	        else{
	            fstDiff = i;
	            break;
	        }
	    }
	    if(fstDiff == -1){
	        System.out.println();
	    }
	    else{
	        StringBuilder sb = new StringBuilder();
	        for(int i = fstDiff ; i < N ; i++){
	            sb.append(S.charAt(i));
	        }
	        System.out.println(sb.toString());
	    }
	    sc.close();
	}
}
