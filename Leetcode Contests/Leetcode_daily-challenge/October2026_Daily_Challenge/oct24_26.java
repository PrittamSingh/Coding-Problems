public class oct24_26 {
    static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceArrivalMonth = Integer.parseInt(arriveAlice.substring(0, 2));
        int aliceArrivalDate = Integer.parseInt(arriveAlice.substring(3, 5));
        int aliceArrivalDateCount = 0;
        for(int i = 1 ; i < aliceArrivalMonth ; i++){
            aliceArrivalDateCount += days[i - 1];
        }
        aliceArrivalDateCount += aliceArrivalDate;
        int aliceLeaveMonth = Integer.parseInt(leaveAlice.substring(0, 2));
        int aliceLeaveDate = Integer.parseInt(leaveAlice.substring(3, 5));
        int aliceLeaveDateCount = 0;
        for(int i = 1 ; i < aliceLeaveMonth ; i++){
            aliceLeaveDateCount += days[i - 1];
        }
        aliceLeaveDateCount += aliceLeaveDate;
        int bobArrivalMonth = Integer.parseInt(arriveBob.substring(0, 2));
        int bobArrivalDate = Integer.parseInt(arriveBob.substring(3, 5));
        int bobArrivalDateCount = 0;
        for(int i = 1 ; i < bobArrivalMonth ; i++){
            bobArrivalDateCount += days[i - 1];
        }
        bobArrivalDateCount += bobArrivalDate;
        int bobLeaveMonth = Integer.parseInt(leaveBob.substring(0, 2));
        int bobLeaveDate = Integer.parseInt(leaveBob.substring(3, 5));
        int bobLeaveDateCount = 0;
        for(int i = 1 ; i < bobLeaveMonth ; i++){
            bobLeaveDateCount += days[i - 1];
        }
        bobLeaveDateCount += bobLeaveDate;
        int res = 0;
        for(int i = 1 ; i <= 365 ; i++){
            if(i >= aliceArrivalDateCount && i <= aliceLeaveDateCount && i >= bobArrivalDateCount && i <= bobLeaveDateCount){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19";
        System.out.println(countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }
}
