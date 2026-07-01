public class Program_07_method_overloading_challenge {
    public static void main(String[] args) {
        System.out.println(getDurationString(3945));
        System.out.println(getDurationString(125 , 30));
    }
    public static String getDurationString(int seconds){
        if(seconds < 0) return "Invald Value";
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;

        return getDurationString(minutes , remainingSeconds);
    }
    public static String getDurationString(int minutes , int seconds){
        if(minutes < 0 || seconds < 0 || seconds > 59 ){
            return "Invalid Value";
        } 
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        return hours + " h " + remainingMinutes + " m " + seconds + " s ";
    }
}

