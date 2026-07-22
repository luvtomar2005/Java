

public class UserValidator {
    public boolean validate(User user) {
        return user.getName() != null && !user.getName().isEmpty();
    }
}