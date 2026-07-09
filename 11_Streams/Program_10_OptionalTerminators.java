import java.util.Optional;

class User {

    private int id;
    private String name;
    private int age;
    private boolean active;

    public User(int id, String name, int age, boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + age + " - " + active;
    }
}

public class Program_10_OptionalTerminators  {

    public static void main(String[] args) {

        // =====================================================
        // 1. Optional.empty()
        // =====================================================
        System.out.println("===== empty() =====");

        Optional<String> empty = Optional.empty();

        System.out.println(empty);

        // =====================================================
        // 2. Optional.of()
        // =====================================================
        System.out.println("\n===== of() =====");

        Optional<String> name = Optional.of("Rahul");

        System.out.println(name);

        // =====================================================
        // 3. Optional.ofNullable()
        // =====================================================
        System.out.println("\n===== ofNullable() =====");

        String value = null;

        Optional<String> optionalName =
                Optional.ofNullable(value);

        System.out.println(optionalName);

        // =====================================================
        // 4. isPresent()
        // =====================================================
        System.out.println("\n===== isPresent() =====");

        System.out.println(name.isPresent());

        // =====================================================
        // 5. isEmpty()
        // =====================================================
        System.out.println("\n===== isEmpty() =====");

        System.out.println(empty.isEmpty());

        // =====================================================
        // 6. ifPresent()
        // =====================================================
        System.out.println("\n===== ifPresent() =====");

        name.ifPresent(System.out::println);

        // =====================================================
        // 7. ifPresentOrElse()
        // =====================================================
        System.out.println("\n===== ifPresentOrElse() =====");

        empty.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No Value Present")
        );

        // =====================================================
        // 8. get()
        // =====================================================
        System.out.println("\n===== get() =====");

        System.out.println(name.get());

        // =====================================================
        // 9. orElse()
        // =====================================================
        System.out.println("\n===== orElse() =====");

        System.out.println(
                empty.orElse("Default User")
        );

        // =====================================================
        // 10. orElseGet()
        // =====================================================
        System.out.println("\n===== orElseGet() =====");

        System.out.println(
                empty.orElseGet(() -> "Generated User")
        );

        // =====================================================
        // 11. orElseThrow()
        // =====================================================
        System.out.println("\n===== orElseThrow() =====");

        Optional<User> user =
                Optional.of(new User(101, "Rahul", 22, true));

        User actualUser =
                user.orElseThrow(
                        () -> new RuntimeException("User Not Found")
                );

        System.out.println(actualUser);

        // =====================================================
        // 12. map()
        // =====================================================
        System.out.println("\n===== map() =====");

        Optional<String> userName =
                user.map(User::getName);

        System.out.println(userName);

        // =====================================================
        // 13. filter()
        // =====================================================
        System.out.println("\n===== filter() =====");

        Optional<User> activeUser =
                user.filter(User::isActive);

        System.out.println(activeUser);

        // =====================================================
        // 14. flatMap()
        // =====================================================
        System.out.println("\n===== flatMap() =====");

        Optional<String> result =
                user.flatMap(u ->
                        Optional.of(u.getName()));

        System.out.println(result);

        // =====================================================
        // 15. Chaining (Real Backend Example)
        // =====================================================
        System.out.println("\n===== Chaining =====");

        String finalResult =
                user
                        .filter(User::isActive)
                        .map(User::getName)
                        .map(String::toUpperCase)
                        .orElse("Guest");

        System.out.println(finalResult);
    }
}