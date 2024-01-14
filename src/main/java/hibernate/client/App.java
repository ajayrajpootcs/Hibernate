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

	@SuppressWarnings("deprecation")
	private static void fetchAllEmployee(Session session) {
		System.out.println("...............EMPLOYEE Fetching..........");
		// List<Employee> resultList = session.createQuery("From Employee",
		// Employee.class).getResultList();
		// for (Employee employee : resultList) {
		// System.out.println(employee);
		// }
		Employee e = session.load(Employee.class, 1);
		System.out.println(e);
		// System.out.println(resultList.get(1).employee);
		System.out.println("...............EMP end...........");
	}

	private static void fetchAllAddress(Session session) {
		System.out.println("...............Address Fetching..........");
		// List<Address> resultList = session.createQuery("From Address",
		// Address.class).getResultList();
		// for (Address address : resultList) {
		// System.out.println(address + " " + address.getEmployee());
		// }
		// Address e = session.load(Address.class, 1);
		// System.out.println(e);
		List<Address> resultList = session.createQuery("From add2",
				Address.class).getResultList();
		for (Address add : resultList) {
			System.out.println(add + "   " + add.getEmployee());

		}
		// System.out.println(resultList.get(1).employee);
		System.out.println("...............Address end...........");
	}

	private static void save(Session session) {
		Transaction transaction = session.beginTransaction();
		Employee e = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		e.setFirstName("Thanos");
		e.setLastName("Marvel");
		e2.setFirstName("Luffy");
		e2.setLastName("D. Monkey");
		e3.setFirstName("Monkey");
		e3.setLastName("King");
		Employee e4 = new Employee();
		Employee e5 = new Employee();
		Employee e6 = new Employee();
		e4.setFirstName("Thanos2");
		e4.setLastName("Marvel2");
		e5.setFirstName("Luffy2");
		e5.setLastName("D. Monkey2");
		e6.setFirstName("Monkey2");
		e6.setLastName("King2");
		Employee e7 = new Employee();
		Employee e8 = new Employee();
		Employee e9 = new Employee();
		e7.setFirstName("Thanos3");
		e7.setLastName("Marvel3");
		e8.setFirstName("Luffy3");
		e8.setLastName("D. Monkey3");
		e9.setFirstName("Monkey3");
		e9.setLastName("King3");
		List<Employee> empList = new LinkedList<>();
		empList.add(e);
		empList.add(e2);
		empList.add(e3);
		List<Employee> empList2 = new LinkedList<>();
		empList2.add(e4);
		empList2.add(e5);
		empList2.add(e6);
		List<Employee> empList3 = new LinkedList<>();
		empList3.add(e7);
		empList3.add(e8);
		empList3.add(e9);
		Address address1 = new Address("NH21", "Sitapur");
		Address address2 = new Address("NH22", "LKO");
		Address address3 = new Address("NH23", "GZB");

		// address2.setEmployee(empList);
		// address3.setEmployee(empList);
		List<Address> ll = new LinkedList<>();
		ll.add(address1);
		ll.add(address2);
		ll.add(address3);
		e.setAddresses(ll);
		e2.setAddresses(ll);
		e3.setAddresses(ll);
		address1.setEmployee(empList);
		address2.setEmployee(empList);
		address3.setEmployee(empList);
		// empList.addAll(ll);
		Address address4 = new Address("NH01", "Manipur");
		Address address5 = new Address("NH8", "Mumbai");
		Address address6 = new Address("NH3", "Goa");
		List<Address> ll2 = new LinkedList<>();
		ll2.add(address4);
		ll2.add(address5);
		ll2.add(address6);
		e4.setAddresses(ll2);
		e5.setAddresses(ll2);
		e6.setAddresses(ll2);
		address4.setEmployee(empList2);
		address5.setEmployee(empList2);
		address6.setEmployee(empList2);
		// empList.addAll()
		Address address7 = new Address("NH1", "hydrabda");
		Address address8 = new Address("NH33", "manali");
		Address address9 = new Address("NH44", "Delhi");
		List<Address> ll3 = new LinkedList<>();
		ll3.add(address7);
		ll3.add(address8);
		ll3.add(address9);
		e7.setAddresses(ll3);
		e8.setAddresses(ll3);
		e9.setAddresses(ll3);
		address7.setEmployee(empList3);
		address8.setEmployee(empList3);
		address9.setEmployee(empList3);
		// session.merge(empList2);
		// session.merge(empList3);
		// session.persist(empList2);
		// session.persist(empList3);
		// session.persist(e);
		// session.persist(e2);
		// session.persist(e3);
		List<Employee> fullEmp = new LinkedList<>();
		fullEmp.addAll(empList);
		fullEmp.addAll(empList2);
		fullEmp.addAll(empList3);
		for (Employee employee : fullEmp) {
			session.persist(employee);

		}
		// for (Employee employee : empList) {
		// session.persist(employee);

		// }
		// for (Employee employee : empList2) {
		// session.persist(employee);

		// }
		// for (Employee employee : empList3) {
		// session.persist(employee);

		// }
		transaction.commit();
		// session.persist(ll);
	}

}
