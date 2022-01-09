package conexion;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class conexionHiber {
	private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex) {
			System.err.println("Fallo en la creacion de session Factory"+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

}
