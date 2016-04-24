package com.homerentmanagement.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
  
public class StoreData {  
public static void main(String[] args) throws IOException {  
      
	int id;
	String Fname,Lname;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	List<Home> homelist=new ArrayList();
	//creating configuration object  
    Configuration cfg=new Configuration();  
    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
      
    //creating session factory object  
    SessionFactory factory=cfg.buildSessionFactory();  
    System.out.println("Enter your choice \n true - continue \n false - exit");
    Boolean choice = Boolean.parseBoolean(br.readLine());
    
    while(choice)
    {	Home e1=new Home();
    	System.out.println("Enter the ID");
    	id = Integer.parseInt(br.readLine());
    	System.out.println("Enter the Fname");
    	Fname = br.readLine();
    	System.out.println("Enter the Lastname");
    	Lname = br.readLine();
    	e1.setId(id);  
        e1.setFirstName(Fname);  
        e1.setLastName(Lname); 
        homelist.add(e1);
        System.out.println("Enter your choice \n true - continue \n false - exit");
        choice = Boolean.parseBoolean(br.readLine());
    	
    }
    Session session=factory.openSession();  
    
    //creating transaction object  
    
    
    for(int i=0; i<homelist.size();i++)
    {
    	//creating session object  
        
    	Transaction t=session.beginTransaction(); 
    	session.persist(homelist.get(i));//persisting the object  
    	t.commit();//transaction is committed
    }  
     
    session.close();
      
    System.out.println("successfully saved");  
      
}
}  
  
