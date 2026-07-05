class Dimensions {

    private int width;
    private int height;
    private int depth;

    public Dimensions(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public void displayDimensions() {
        System.out.println("Dimensions: " + width + " x " + height + " x " + depth);
    }
}

class Case {

    private String model;
    private String manufacturer;
    private String powerSupply;
    private Dimensions dimensions;

    public Case(String model, String manufacturer, String powerSupply, Dimensions dimensions) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.powerSupply = powerSupply;
        this.dimensions = dimensions;
    }

    public void pressPowerButton() {
        System.out.println("Power button pressed.");
    }

    public void showCaseInfo() {
        System.out.println("Case Model : " + model);
        System.out.println("Manufacturer : " + manufacturer);
        System.out.println("Power Supply : " + powerSupply);
        dimensions.displayDimensions();
    }
}

class Resolution {

    private int width;
    private int height;

    public Resolution(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String getResolution() {
        return width + " x " + height;
    }
}

class Monitor {

    private String model;
    private String manufacturer;
    private int size;
    private Resolution nativeResolution;

    public Monitor(String model, String manufacturer, int size, Resolution nativeResolution) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
        this.nativeResolution = nativeResolution;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.println("Drawing pixel at (" + x + "," + y + ") in " + color + " color.");
    }

    public void showMonitorInfo() {
        System.out.println("Monitor Model : " + model);
        System.out.println("Manufacturer : " + manufacturer);
        System.out.println("Size : " + size + " inches");
        System.out.println("Resolution : " + nativeResolution.getResolution());
    }
}

class Motherboard {

    private String model;
    private String manufacturer;
    private int ramSlots;
    private String bios;

    public Motherboard(String model, String manufacturer, int ramSlots, String bios) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.ramSlots = ramSlots;
        this.bios = bios;
    }

    public void loadProgram(String programName) {
        System.out.println(programName + " is now loading...");
    }

    public void showMotherboardInfo() {
        System.out.println("Motherboard Model : " + model);
        System.out.println("Manufacturer : " + manufacturer);
        System.out.println("RAM Slots : " + ramSlots);
        System.out.println("BIOS : " + bios);
    }
}

class PersonalComputer {

    private Case computerCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PersonalComputer(Case computerCase, Monitor monitor, Motherboard motherboard) {
        this.computerCase = computerCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {

        System.out.println("Powering up the computer...\n");

        computerCase.pressPowerButton();

        monitor.drawPixelAt(1200, 50, "Yellow");

        motherboard.loadProgram("Windows 11");

        System.out.println("\nComputer is ready to use.");
    }

    public void showSpecifications() {

        System.out.println("===== COMPUTER SPECIFICATIONS =====");

        computerCase.showCaseInfo();

        System.out.println();

        monitor.showMonitorInfo();

        System.out.println();

        motherboard.showMotherboardInfo();
    }
}

public class Program_02_Composition {

    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions(20, 20, 5);

        Case computerCase = new Case(
                "220B",
                "Dell",
                "240W",
                dimensions);

        Resolution resolution = new Resolution(1920, 1080);

        Monitor monitor = new Monitor(
                "27inch Beast",
                "Dell",
                27,
                resolution);

        Motherboard motherboard = new Motherboard(
                "BJ-200",
                "Asus",
                4,
                "v2.44");

        PersonalComputer pc = new PersonalComputer(
                computerCase,
                monitor,
                motherboard);

        pc.showSpecifications();

        System.out.println();

        pc.powerUp();
    }
}
