import com.aman.portfolio.dao.ContactDAO;

public class TestContactDAO {
    public static void main(String[] args) {

        ContactDAO dao = new ContactDAO();
        boolean result = dao.saveMessage(
            "Test User",
            "test@example.com",
            "This is a test message from backend"
        );

        if (result) {
            System.out.println("Message saved to database!");
        } else {
            System.out.println("Failed to save message.");
        }
    }
}
