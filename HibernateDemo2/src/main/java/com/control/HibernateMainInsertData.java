package com.control;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.to.PlayerTill52;

public class HibernateMainInsertData {

	// to remove all the errors as we are modifying Player in 6.2 created PlayerTill52 class which can be used till 5.2
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(com.to.PlayerTill52.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());

			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			// till 5.2 in here and prep for 6.1
			// 6.1 started
			PlayerTill52 p1 = new PlayerTill52(1, "Anya Forger", "Ostania", 6);
			PlayerTill52 p2 = new PlayerTill52(2, "Loid Forger", "Westalis", 30);
			session.save(p1);
			session.save(p2);
			PlayerTill52 p = (PlayerTill52) session.get(PlayerTill52.class, 10);
			System.out.println("The Details : " + p);

			PlayerTill52 p3 = new PlayerTill52("Yor Forger", "Ostania", 26);
			PlayerTill52 p4 = new PlayerTill52("Bond Forger", "Ostania", 10);
			PlayerTill52 p5 = new PlayerTill52("Yuri Briar", "Ostania", 22);
			PlayerTill52 p6 = new PlayerTill52("Damian Desmond", "Ostania", 6);
			PlayerTill52 p7 = new PlayerTill52("Franky Franklin", "Ostania", 29);
			PlayerTill52 p8 = new PlayerTill52("Fiona Frost", "Westalis", 28);
			PlayerTill52 p9 = new PlayerTill52("Sylvia Sherwood", "Westalis", 32);
			PlayerTill52 p10 = new PlayerTill52("Henry Henderson", "Ostania", 57);
			PlayerTill52 p11 = new PlayerTill52("Becky Blackbell", "Ostania", 6);

			session.save(p3);
			session.save(p4);
			session.save(p5);
			session.save(p6);
			session.save(p7);
			session.save(p8);
			session.save(p9);
			session.save(p10);
			session.save(p11);

			// Query query = session.createQuery("from plyer");
			transaction.commit();
			session.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		// session.close();

	}

}
