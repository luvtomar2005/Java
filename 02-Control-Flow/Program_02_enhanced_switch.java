public class Program_02_enhanced_switch {
    public static void main(String[] args) {
        System.out.println(getQuarter("JAN"));
        System.out.println(getQuarter("DEC"));
        System.out.println(getQuarter("JUL"));
    }
    public static String getQuarter(String month){
        return switch(month.toUpperCase()){
            case "JAN" ,"FEB" , "MAR" -> "1st Quarter";
            case "APR" , "MAY" , "JUN" -> "2nd Quarter";

            case "OCT" , "NOV" , "DEC" -> "3rd Quarter";

            default -> "Invalid Month";
        };
    }
}


