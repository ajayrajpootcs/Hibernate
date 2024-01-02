package hibernate.client;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import hibernate.entity.Employee;

public class App {
	// @SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Employee e = new Employee();
		// e.setId(2);
		e.setName("Black Widow");
		e.setGender("Male");
		e.setSalary(200000);

		// Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		// SessionFactory sf = cfg.buildSessionFactory();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = meta.buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(e);
		// session.update(e)
		// session.delete(e.getName(), e);;;
		tx.commit();

		// e = session.get(Employee.class, 4);
		// System.out.println(e);

		System.out.print("Suceess...");
		session.close();

	}

}
