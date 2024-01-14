package hibernate.client;

import org.hibernate.SessionFactory;

import hibernate.configDB.HibernateConfig;

import java.util.LinkedList;
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
		// fetchAllEmployee(session);
		// fetchAllAddress(session);
		System.out.print("Suceess...");
		session.close();

	}

	// @SuppressWarnings("deprecation")
	// private static void fetchAllEmployee(Session session) {
	// System.out.println("...............EMPLOYEE Fetching..........");
	// List<Employee> resultList = session.createQuery("From Employee",
	// Employee.class).getResultList();
	// for (Employee employee : resultList) {
	// System.out.println(employee);
	// }
	// // System.out.println(resultList.get(1).employee);
	// System.out.println("...............EMP end...........");
	// }

	// private static void fetchAllAddress(Session session) {
	// System.out.println("...............Address Fetching..........");
	// List<Address> resultList = session.createQuery("From Address",
	// Address.class).getResultList();
	// for (Address address : resultList) {
	// System.out.println(address + " " + address.getEmployee());
	// }
	// // System.out.println(resultList.get(1).employee);
	// System.out.println("...............Address end...........");
	// }

	private static void save(Session session) {
		Transaction transaction = session.beginTransaction();
		Employee e = new Employee();
		e.setFirstName("Thanos");
		e.setLastName("Marvel");
		Address address1 = new Address("NH21", "Sitapur");
		Address address2 = new Address("NH22", "LKO");
		Address address3 = new Address("NH23", "GZB");
		address1.setEmployee(e);
		address2.setEmployee(e);
		address3.setEmployee(e);
		List<Address> ll = new LinkedList<>();
		ll.add(address1);
		ll.add(address2);
		ll.add(address3);
		e.setAddresses(ll);
		session.persist(e);
		// session.persist(ll);
		transaction.commit();
	}

}
