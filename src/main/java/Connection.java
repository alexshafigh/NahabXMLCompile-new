import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.ws.rs.core.Configuration;

/**
 * Created by saazimi on 15/11/2018.
 */
public class Connection {
        SessionFactory sessionFactory ;
        Session session ;

        public Connection() {
                sessionFactory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                session = sessionFactory.openSession();
        }

        public SessionFactory getSessionFactory() {
                return sessionFactory;
        }

        public Session getSession() {
                return session;
        }

        public void CloseSession(){
                this.session.close();
        }

        public void CloseFactory(){
                CloseSession();
                this.sessionFactory.close();
//                System.exit(0);
        }
}
