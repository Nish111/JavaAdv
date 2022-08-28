package com.control;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.to.Player;
import com.to.Team;


public class HibernateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(com.to.Player.class);
			configuration.addAnnotatedClass(com.to.Team.class); // added Team class 6.2
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
					applySettings(configuration.getProperties());
			
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
		    Session session = factory.openSession();
		    Transaction transaction = session.beginTransaction();
		    
		    // 6.2 starts here
		    Team t1 = new Team("Westalis");
			/* for OnetoOne
			 * Player p1 = new Player("Loid Forger", t1, 30); Player p2 = new
			 * Player("Fiona Frost", t1, 28); Player p3 = new Player("Sylvia Sherwood", t1,
			 * 32); session.save(t1); session.save(p1); session.save(p2); session.save(p3);
			 */
		    
		    Team t2 = new Team("Oceania");
		    
		    Player p = new Player();
		    p.setAge(30);
		    p.setPlayerName("Loid Forger");
		    p.getTeamList().add(t1);
		    p.getTeamList().add(t2);
		    session.save(t1);
		    session.save(t2);
		    session.save(p);
		    
		    
		    
			/*
			 * These are already created and we are using update in cfg now
			 * we will be using same data from table to in furhter demo
			 * 6.1 started 
			 * Player p1 = new Player(1, "Anya", "Ostania", 6); Player p2 = new Player(2,
			 * "Loid", "Westalis", 30); session.save(p1); session.save(p2); Player p =
			 * (Player) session.get(Player.class, 10); System.out.println("The Details : " +
			 * p);
			 * 
			 * 
			 * Player p3 = new Player("Yor", "Ostania", 26); Player p4 = new Player("Bond",
			 * "Ostania", 10);
			 * session.save(p3);
		     * session.save(p4);
			 */
		    
			/*  
			 * System.out.println("----Player Details => All Players---");
			 * Query query= session.createQuery("from Player"); // query from org.hibernate
			 * List<Player> playerList = query.list(); // List from util.List
			 * System.out.println("Player Details "); for(Player p: playerList) {
			 * System.out.println(p); }
			 */
		    
			/*
			 * System.out.println("---Player Details => as per particular Player Name---");
			 * Query query1 = session.createQuery("from Player where playerName=:name");
			 * query1.setString("name", "Loid Forger"); List<Player> playerList1 =
			 * query1.list(); System.out.println("Player Details "); for(Player p:
			 * playerList1) { System.out.println(p); }
			 */
		    
			/*
			 * System.out.println("---Player Details => as per particular Team Name---");
			 * Query query2 = session.createQuery("from Player where teamName=:name");
			 * query2.setString("name", "Westalis"); List<Player> playerList2 =
			 * query2.list(); System.out.println("Player Details "); for(Player p:
			 * playerList2) { System.out.println(p); }
			 */
		    
			/*
			 * System.out.
			 * println("---Player Details => as per Player Age order by Player Name---");
			 * Query query3 =
			 * session.createQuery("from Player where age=:age order by playerName desc");
			 * query3.setInteger("age", 6); List<Player> playerList3 = query3.list();
			 * System.out.println("Player Details "); for(Player p: playerList3) {
			 * System.out.println(p); }
			 */
		    
			/*
			 * This is for 6.1
			 * System.out.println("---Player Details => as per Player Age between given values order by Player Name---"
			 * ); Query query4 = session.
			 * createQuery("from Player where age between :age1 and :age2 order by playerName desc"
			 * ); query4.setInteger("age1", 6); query4.setInteger("age2", 30); List<Player>
			 * playerList4 = query4.list(); System.out.println("Player Details ");
			 * for(Player p: playerList4) { System.out.println(p); }
			 */
		    
		    
		    transaction.commit();
		    session.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	    //session.close();
	   
				
	}

}
