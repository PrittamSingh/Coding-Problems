public class june18_26 {
    public static double angleClock(int hour, int minutes) {
        double hourAngle = (hour == 12) ? (minutes * 0.5) : 30 * hour + (minutes * 0.5);
        double minuteAngle = 6 * minutes;
        double angle;
        if(hourAngle > minuteAngle){
            angle = hourAngle - minuteAngle;
        }
        else{
            angle = minuteAngle - hourAngle;
        }
        return angle <= 180 ? angle : (360 - angle);
    }
    public static void main(String[] args) {
        int hour = 12;
        int minutes = 30;
        int hour2 = 3, minutes2 = 30;
        int hour3 = 3, minutes3 = 15;
        System.out.println(angleClock(hour, minutes) + " " + angleClock(hour2, minutes2) + " " + angleClock(hour3, minutes3));
    }
}
