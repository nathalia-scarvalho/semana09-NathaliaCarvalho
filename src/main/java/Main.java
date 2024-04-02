import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {

        Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/farmacia_hibernate", "root", "isotonos08").load();

        flyway.repair();

    }
}