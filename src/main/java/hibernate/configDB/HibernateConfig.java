package hibernate.configDB;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {

	public SessionFactory getSessionFactory() {

		Properties ps = new Properties();
		ps.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		ps.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatedb");
		ps.put(Environment.USER, "root");
		ps.put("hibernate.connection.password", "root");
		ps.put("hibernate.hbm2ddl.auto", "update");
		ps.put(Environment.SHOW_SQL, "true");
		ps.put(Environment.FORMAT_SQL, "true");

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(ps).build();

		// MetadataSources metasources = new
		// MetadataSources(ssr).addAnnotatedClass(hibernate.entity.Employee.class);
		// MetaData meta = metasources.buildMetadata();
		// Direct Call
		Metadata meta = new MetadataSources(ssr).addAnnotatedClass(hibernate.entity.Employee.class).buildMetadata();

		SessionFactory sf = meta.buildSessionFactory();

		return sf;

	}

}
