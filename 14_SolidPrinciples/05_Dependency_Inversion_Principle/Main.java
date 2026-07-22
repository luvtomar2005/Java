public class Main {

    public static void main(String[] args) {

        NotificationService service =
                new EmailService();

        NotificationManager manager =
                new NotificationManager(service);

        manager.notifyUser();

    }

}