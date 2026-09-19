public class sept19_26 {
    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // int upLimitCircle = yCenter + radius;
        // int downLimitCircle = yCenter - radius;
        // int leftLimitCircle = xCenter - radius;
        // int rightLimitCircle = xCenter + radius;
        // if(y1 > upLimitCircle || y2 < downLimitCircle || x1 > rightLimitCircle || x2 < leftLimitCircle){
        //     return false;
        // }
        // int closestX;
        // if(xCenter < x1){
        //     closestX = x1;
        // }
        // else if(xCenter > x2){
        //     closestX = x2;
        // }
        // else{
        //     closestX = xCenter;
        // }
        // int closestY;
        // if(yCenter < y1){
        //     closestY = y1;
        // }
        // else if(yCenter > y2){
        //     closestY = y2;
        // }
        // else{
        //     closestY = yCenter;
        // }
        // int dist = ((closestX - xCenter) * (closestX - xCenter)) + ((closestY - yCenter) * (closestY - yCenter));
        // if(dist <= (radius * radius)){
        //     return true;
        // }
        // return false;


        int xi = Math.max(x1, Math.min(x2, xCenter));
        int yi = Math.max(y1, Math.min(y2, yCenter));
        long dx = xi - xCenter;
        long dy = yi - yCenter;
        return dx * dx + dy * dy <= (long) radius * radius;
    }
    public static void main(String[] args) {
        // int radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1;
        int radius = 1, xCenter = 1, yCenter = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1;
        System.out.println(checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2));
    }
}
