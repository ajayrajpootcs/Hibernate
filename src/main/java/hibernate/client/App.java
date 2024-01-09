package hibernate.client;

import org.hibernate.SessionFactory;

import hibernate.configDB.HibernateConfig;
import hibernate.configDB.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernate.entity.Address;
import hibernate.entity.Employee;

public class App {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// SessionFactory sf = HibernateUtil.getSessionFactory();
		SessionFactory sf = new HibernateConfig().getSessionFactory();
		Session session = sf.openSession();
		save(session);
		fetchAllEmployee(session);
		fetchAllAddress(session);
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
		System.out.println("...............EMP end...........");
	}

	private static void fetchAllAddress(Session session) {
		System.out.println("...............Address Fetching..........");
		List<Address> resultList = session.createQuery("From Address", Address.class).getResultList();
		for (Address address : resultList) {
			System.out.println(address + "   " + address.getEmployee());
		}
		// System.out.println(resultList.get(1).employee);
		System.out.println("...............Address end...........");
	}

	private static void save(Session session) {
		Transaction transaction = session.beginTransaction();
		Employee e = new Employee();
		e.setFirstName("Vision");
		e.setLastName("Marvel");
		Address address = new Address("Unkown", "Unkown");
		e.setAddress(address);
		address.setEmployee(e);

		session.persist(address);
		session.persist(e);
		transaction.commit();
	}

}
