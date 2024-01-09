package hibernate.client;

import org.hibernate.SessionFactory;
import hibernate.configDB.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernate.entity.Address;
import hibernate.entity.Employee;

public class App {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		save(session);
		fetchAllEmployee(session);
		System.out.print("Suceess...");
		session.close();

	}

	@SuppressWarnings("deprecation")
	private static void fetchAllEmployee(Session session) {
		System.out.println("...............Address Fetching..........");
		List<Employee> resultList = session.createQuery("From Employee", Employee.class).getResultList();
		resultList.forEach(add -> {
			System.out.println(add);
		});
		// System.out.println(resultList.get(1).employee);
		System.out.println("...............Address end...........");
	}

	private static void save(Session session) {
		Transaction transaction = session.beginTransaction();
		Employee e = new Employee();
		e.setFirstName("Lucy");
		e.setLastName("Ragnarok");
		Address address = new Address("Asgaurd", "Asgaurd");
		e.setAddress(address);

		// session.persist(address);
		session.persist(e);
		transaction.commit();
	}

}
