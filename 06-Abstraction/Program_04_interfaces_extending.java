// public interface SmartDevice {
interface SmartDevice{
    void powerOn();

    void powerOff();

    default void showBrand(){
        System.out.println("Brand : Generic Smart Device");
    }
    static void companyInfo(){
        System.out.println("Smart Devices are manufactured worldwid");
    }
}
interface Camera {
    void takePhoto();

    default void cameraMode(){
        System.out.println("Camera Mode : Auto");
    }

}


interface Internet {

    void browseInternet();

    default void wifiStatus() {
        System.out.println("Connected to WiFi");
    }
}

interface SmartPhone extends SmartDevice, Camera, Internet {

    void makeCall();

}

class SamsungGalaxy implements SmartPhone {

    @Override
    public void powerOn() {
        System.out.println("Samsung Galaxy Powered ON");
    }

    @Override
    public void powerOff() {
        System.out.println("Samsung Galaxy Powered OFF");
    }

    @Override
    public void takePhoto() {
        System.out.println("Taking 200MP Photo");
    }

    @Override
    public void browseInternet() {
        System.out.println("Browsing Internet...");
    }

    @Override
    public void makeCall() {
        System.out.println("Calling...");
    }

    @Override
    public void showBrand() {
        System.out.println("Brand : Samsung");
    }
}

public class Program_04_interfaces_extending{
    public static void main(String[] args) {
        System.out.println("===== Object Reference =====");

        SamsungGalaxy phone = new SamsungGalaxy();

        phone.powerOn();
        phone.makeCall();
        phone.takePhoto();
        phone.browseInternet();
        phone.showBrand();
        phone.cameraMode();
        phone.wifiStatus();
        phone.powerOff();

        System.out.println();

        System.out.println("===== Interface Reference =====");

        SmartPhone smartPhone = new SamsungGalaxy();

        smartPhone.powerOn();
        smartPhone.makeCall();
        smartPhone.takePhoto();
        smartPhone.browseInternet();
        smartPhone.showBrand();
        smartPhone.cameraMode();
        smartPhone.wifiStatus();

        System.out.println();

        System.out.println("===== Static Interface Method =====");

        SmartDevice.companyInfo();
    }
}