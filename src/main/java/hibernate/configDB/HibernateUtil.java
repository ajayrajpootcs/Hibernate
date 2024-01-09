package hibernate.configDB;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    static StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    static Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

    static SessionFactory build = null;

    public static SessionFactory getSessionFactory() {
        if (build == null) {
            build = metadata.getSessionFactoryBuilder().build();
        }
        return build;
    }

}
