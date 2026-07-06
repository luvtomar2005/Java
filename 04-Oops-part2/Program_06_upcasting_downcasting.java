import java.util.Scanner;

class Movie{
    private String title;
    public Movie(String title){
        this.title = title;
    }
    public void watchMovie(){
        String instanceOf = this.getClass().getSimpleName();
        System.out.println(title + " is  a " + instanceOf + " film ");
    }
    
    /*
     * Factory Method
     *
     * Notice the return type is Movie.
     *
     * Although this method creates Adventure, Comedy,
     * or ScienceFiction objects, it returns them as
     * a Movie reference.
     *
     * This is called IMPLICIT UPCASTING.
     */
    public static Movie getMovie(String type , String title){
        return switch(type.toUpperCase().charAt(0)){
            case 'A' -> new Adventure(title);
            case 'B' -> new Comedy(title);
            case 'C' -> new ScienceFiction(title);
            default -> new Movie(title);
        };

    }
}

class Adventure extends Movie{
    public Adventure(String title){
        super(title);
    }
    @Override
    public void watchMovie(){
        super.watchMovie();
        System.out.printf("...%n".repeat(3) , "Pleasent Scene" , "Scary Music" , 
    "Something Bad Happens");
    }
    public void watchAdventure(){
        System.out.println("Watching an Adventure ");
    }
}

// =========================================================
// Comedy
// =========================================================
class Comedy extends Movie {

    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {

        super.watchMovie();

        System.out.printf(".. %s%n".repeat(3),
                "Something funny happens",
                "Something even funnier happens",
                "Happy Ending");
    }

    // Child-specific method
    public void watchComedy() {
        System.out.println("Watching a Comedy!");
    }
}

// =========================================================
// Science Fiction
// =========================================================
class ScienceFiction extends Movie {

    public ScienceFiction(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {

        super.watchMovie();

        System.out.printf(".. %s%n".repeat(3),
                "Bad Aliens do Bad Stuff",
                "Space Guys Chase Aliens",
                "Planet Blows Up");
    }

    // Child-specific method
    public void watchScienceFiction() {
        System.out.println("Watching a Science Fiction Thriller!");
    }
}

public class Program_06_upcasting_downcasting {

    public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("Example 1 : Runtime Polymorphism");
        System.out.println("=======================================");

        while (true) {

            System.out.print(
                    "\nEnter Type (A-Adventure, C-Comedy, S-Science Fiction, Q-Quit): ");

            String type = scanner.nextLine();

            if ("Qq".contains(type)) {
                break;
            }

            System.out.print("Enter Movie Title: ");
            String title = scanner.nextLine();

            /*
             * getMovie() returns Movie.
             *
             * But internally it creates one of the child objects.
             *
             * Example:
             *
             * Movie movie = new Adventure(...)
             *
             * This is IMPLICIT UPCASTING.
             */
            Movie movie = Movie.getMovie(type, title);

            /*
             * Runtime Polymorphism
             *
             * Compiler checks:
             * Does Movie have watchMovie()?
             * YES.
             *
             * JVM checks:
             * What is the actual object?
             *
             * Adventure -> Adventure.watchMovie()
             * Comedy -> Comedy.watchMovie()
             * ScienceFiction -> ScienceFiction.watchMovie()
             */
            movie.watchMovie();
        }

        System.out.println("\n=======================================");
        System.out.println("Example 2 : Upcasting");
        System.out.println("=======================================");

        /*
         * Adventure object
         *
         * stored inside
         *
         * Movie reference.
         *
         * Child -> Parent
         *
         * This is UPCASTING.
         */
        Movie movie = Movie.getMovie("A", "Jaws");

        movie.watchMovie();

        System.out.println("\n=======================================");
        System.out.println("Example 3 : Downcasting");
        System.out.println("=======================================");

        /*
         * getMovie() returns Movie.
         *
         * We know the object is actually Adventure.
         *
         * So we explicitly cast it.
         *
         * Parent Reference
         *        ↓
         * Child Reference
         *
         * This is DOWNCASTING.
         */
        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");

        jaws.watchMovie();

        // Now we can access Adventure-specific methods.
        jaws.watchAdventure();

        System.out.println("\n=======================================");
        System.out.println("Example 4 : Upcasting to Object");
        System.out.println("=======================================");

        /*
         * Every class in Java ultimately extends Object.
         *
         * Comedy
         *    ↓
         * Movie
         *    ↓
         * Object
         *
         * Therefore this is another UPCAST.
         */
        Object comedy = Movie.getMovie("C", "Airplane");

        /*
         * Object
         *    ↓
         * Comedy
         *
         * Explicit DOWNCAST.
         */
        Comedy comedyMovie = (Comedy) comedy;

        comedyMovie.watchComedy();

        System.out.println("\n=======================================");
        System.out.println("Example 5 : var Keyword");
        System.out.println("=======================================");

        /*
         * getMovie() returns Movie.
         *
         * Therefore var becomes Movie.
         *
         * It DOES NOT become Comedy.
         */
        var airplane = Movie.getMovie("C", "Airplane");

        airplane.watchMovie();

        // airplane.watchComedy(); // Compile-time Error

        /*
         * Here the right side is directly Comedy.
         *
         * Therefore var becomes Comedy.
         */
        var plane = new Comedy("Airplane");

        plane.watchComedy();

        System.out.println("\n=======================================");
        System.out.println("Example 6 : instanceof");
        System.out.println("=======================================");

        Movie movie2 = Movie.getMovie("S", "Interstellar");

        /*
         * Before DOWNCASTING,
         * verify the runtime type.
         *
         * This prevents ClassCastException.
         */
        if (movie2 instanceof ScienceFiction) {

            ScienceFiction scienceFiction = (ScienceFiction) movie2;

            scienceFiction.watchScienceFiction();

        } else {

            System.out.println("This is not a Science Fiction movie.");
        }

        scanner.close();     
    }
}