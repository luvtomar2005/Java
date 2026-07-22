public class Main {

    public static void main(String[] args) {

        User user = new User("Luv","luv@gmail.com");

        UserRegistrationService registration = new UserRegistrationService();

        registration.register(user);

    }

}