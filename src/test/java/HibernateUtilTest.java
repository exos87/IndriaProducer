import indria.entity.User;
import indria.utils.HibernateUtil;
import org.hibernate.*;
import org.junit.jupiter.api.*;

public class HibernateUtilTest {

    private static SessionFactory sessionFactory;
    private Session session;

    @BeforeAll
    public static void setup() {
        sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println("SessionFactory created");
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed");
    }

    @Test
    public void testAddUser() {
        System.out.println("Running testAddUser...");

        session.beginTransaction();

        User user = new User(1, "a1", "TestMeno");
        Integer id = (Integer) session.save(user);

        session.getTransaction().commit();

        Assertions.assertTrue(id > 0);
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testGet() {
    }

    @Test
    public void testList() {
    }

    @Test
    public void testDelete() {
    }

    @BeforeEach
    public void openSession() {
        session = sessionFactory.openSession();
        System.out.println("Session created");
    }

    @AfterEach
    public void closeSession() {
        if (session != null) session.close();
        System.out.println("Session closed\n");
    }
}