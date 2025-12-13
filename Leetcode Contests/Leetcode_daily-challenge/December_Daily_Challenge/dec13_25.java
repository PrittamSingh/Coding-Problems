import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class dec13_25 {
    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String[]> validCoupons = new ArrayList<>();
        for(int i = 0 ; i < code.length ; i++){
            if(isValidCode(code[i])){
                if(businessLine[i].equals("electronics") || businessLine[i].equals("grocery") || businessLine[i].equals("pharmacy") || businessLine[i].equals("restaurant")){
                    if(isActive[i]){
                        validCoupons.add(new String[]{businessLine[i], code[i]});
                    }
                }
            }
        }
        HashMap<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);

        Collections.sort(validCoupons, (a, b) -> {
            int p1 = priority.get(a[0]);
            int p2 = priority.get(b[0]);

            if(p1 != p2){
                return p1 - p2;
            }

            return a[1].compareTo(b[1]);
        });

        List<String> result = new ArrayList<>();
        for(String[] coupon : validCoupons){
            result.add(coupon[1]);
        }
        return result;
    }
    private static boolean isValidCode(String s){
        if(s == null || s.isEmpty()) return false;
        for(char c : s.toCharArray()){
            if(!Character.isLetterOrDigit(c) && c != '_'){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String[] code = {"SAVE20","","PHARMA5","SAVE@20"}, businessLine = {"restaurant","grocery","pharmacy","restaurant"};
        boolean[] isActive = {true,true,true,true};
        List<String> ans = validateCoupons(code, businessLine, isActive);
        for(String s : ans){
            System.out.print(s + " ");
        }
        System.out.println();

        String[] code2 = {"GROCERY15","ELECTRONICS_50","DISCOUNT10"} , businessLine2 = {"grocery","electronics","invalid"};
        boolean[] isActive2 = {false,true,true};
        List<String> ans2 = validateCoupons(code2, businessLine2, isActive2);
        for(String s : ans2){
            System.out.print(s + " ");
        }
    }
}
