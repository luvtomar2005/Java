// public class UserRegistrationService {
public class UserRegistrationService {
    private UserValidator validator = new UserValidator();

    private UserRepository repository = new UserRepository();

    private EmailService emailService = new EmailService();

    private LoggerService logger = new LoggerService();

    private void register(User user) {
        if(!validator.validate(user)){
            System.out.println("Invalid user");

            return;
        }
        repository.save(user);
        emailService.sendEmail(user);
        logger.log("User registered successfully");
    }
}
