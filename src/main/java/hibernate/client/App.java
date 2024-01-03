package hibernate.client;

import org.hibernate.SessionFactory;

import hibernate.configDB.HibernateConfig;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernate.entity.Employee;
import org.hibernate.query.Query;

public class App {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Employee e = new Employee();
		// e.setId(2);
		e.setName("Monkey King");
		e.setGender("Male");
		e.setSalary(200000);

		HibernateConfig cfg = new HibernateConfig();

		SessionFactory sf = cfg.getSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		// session.save(e);

		// Query ineterface HQL

		/*
		 * //Example of HQL to get all the records
		 * 
		 * Query query1 = session.createQuery("from Employee");
		 * List list = query1.list();
		 * System.out.println(list);
		 * 
		 */

		/*
		 * // Fetching Specific source to specific destination data from the table
		 * // HQL to get records with pagination
		 * Query query1 = session.createQuery("from Employee");
		 * query1.setFirstResult(2); // set the position at row specific row and result
		 * prints from row 3
		 * query1.setMaxResults(3); // Returns Three Records After record 2
		 * List list = query1.list();
		 * System.out.println(list);
		 */

		//// HQL update query Using Named Parameters
		// Query q = session.createQuery("update Employee set name=:n where id=:i");
		// q.setParameter("n", "Udit kumar");
		// q.setParameter("i", 1);
		// System.out.println("status: " + q.executeUpdate());

		tx.commit();

		System.out.print("Suceess...");
		session.close();

	}

}
