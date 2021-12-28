// import io.ebean.DB;
// import io.ebean.Database;

public class EbeanTest {
    public static void main(String[] args) {
        EbeanTest.saveCustomer("Liam","Breathnach");
    }
    public static void saveCustomer(final String firstName, final String lastName) {
        Customer c = new Customer(firstName,lastName);
        // Database database = DB.getDefault();
        // database.save(c);

    }
}
