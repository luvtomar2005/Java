interface Printer{
    void print();
    void scan();
}

class HPPrinter implements Printer{
    private String model;
    public HPPrinter(String model){
        this.model =  model;
    }
    @Override
    public void print(){
        System.out.println(model + " is printing documents : ");
    }
    @Override
    public void scan(){
        System.out.println(model + " is scanning documents ");
    }
    public void wifiPrinting(){
        System.out.println(model + " supports Wi-Fi printing. ");
    }

}

class CanonPrinter implements Printer {
    private String model;
    public CanonPrinter(String model){
        this.model = model;
    }
    @Override
    public void print(){
        System.out.println(model + " is printing photos. ");
    }
    @Override
    public void scan(){
        System.out.println(model + " is scanning photos . ");
    }

}
public class Program_03_interfaces {
    public static void main(String[] args) {
        System.out.println("===== HP Printer ==== ");
        HPPrinter hp = new HPPrinter("HP LaserJet P1108");
        hp.print();
        hp.scan();
        hp.wifiPrinting();

        System.out.println();


        
    System.out.println("===== Canon Printer =====");

        CanonPrinter canon = new CanonPrinter("Canon PIXMA G3010");

        canon.print();
        canon.scan();
      
    }
}

