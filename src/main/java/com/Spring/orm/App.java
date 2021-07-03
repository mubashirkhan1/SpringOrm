package com.Spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Spring.orm.Dao.StudentDao2imple;
import Spring.orm.Entity.Student;

public class App
{
	public static void main(String[] args)
	{

			ApplicationContext ac = new ClassPathXmlApplicationContext("orm1config.xml");
			//Student st = (Student) ac.getBean("student1");
			StudentDao2imple std1 = ac.getBean(StudentDao2imple.class, "dao");
	
			// Student student2=new Student(122,"mubashirkhan","mumbai");
		
			// int value1= std1.save1(st);
	
			// System.out.println(value1);
			// System.out.println(student2);

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			boolean muba=true;
			while(muba) 
			{
				   System.out.println("press 1 fir save student");
			
				   System.out.println("press 2 for get  all student");
			
				   System.out.println("press 3 get all detail of single student");
			
				   System.out.println("press 4 for delete paricular student detail");
			
				   System.out.println("press 5 for update student");
			
				   System.out.println("press 6 for exit");
	          
				   try
				   
				   {
					
					   
					   int input=Integer.parseInt( br.readLine());
							switch (input)
							{
								case 1:
									
									//taking student infomation from inputstream
									 System.out.println("enter student id");
									int uid=Integer.parseInt(br.readLine());
									
									System.out.println("enter  student name");
									String uname=br.readLine();
									
									System.out.println("enter  student city");
									String ucity=br.readLine();
								  
									//creating student object for inject value
									Student st=new Student();
									st.setId(uid);
									st.setName(uname);
									st.setCity(ucity);
									
									//call save method  to save info in database
									int saveinfo=	std1.save1(st);
								
								System.out.println(saveinfo +"   Student added");
								System.out.println("-------------------------------------------");
									
								break;
				
								case 2:
										
								List<Student> alldata=	std1.getstudentalldata();
									
								//fetch all student
								for(Student value1: alldata)
									{
										System.out.println(" Id  :"+value1.getId() +"     Name "+value1.getName()+"       City  :" +value1.getCity());
									System.out.println("----------------------------------------");
									
									}
									break;
							
								case 3:
									//fetch particular student
									 System.out.println("enter student id");
										int uid1=Integer.parseInt(br.readLine());
										Student data=std1.getstudentdata(uid1);
										
										
										System.out.println(" Id  :"+data.getId() +"     Name "+data.getName()+"       City  :" +data.getCity());
										System.out.println("----------------------------------------");
									break;
				
								case 4:
									
									//deltee student
									 System.out.println("enter student id");
										int dele=Integer.parseInt(br.readLine());
										std1.deletedata(dele);
										System.out.println("Delete succesfully");
									
									break;
								
								case 5:
								
									 System.out.println("enter student id who you want upodate");
										int toid=Integer.parseInt(br.readLine());
										
										
										Student data9=std1.getstudentdata(toid);
										int id33=data9.getId();
										std1.deletedata(id33);
									//	std1.updatestudent(update);
										
								  	 System.out.println("enter new id student id");
										int nuid=Integer.parseInt(br.readLine());
										
										System.out.println("enter new student name");
										String nuname=br.readLine();
										
										System.out.println("enter new student city");
										String nucity=br.readLine();
									  
										//creating student object for inject value
										Student st1=new Student();
										st1.setId(nuid);
										st1.setName(nuname);
										st1.setCity(nucity);
										   std1.updatestudent(st1);
										//call save method  to save info in database
										//int saveinfo1=	std1.save1(st1);
								       
								       System.out.println("update succesfully");
									
									
										
									break;
									
								case 6:
									  muba=false;
									  
									  System.out.println("System  exit");
									break;
							}  
					   
				   }
				  catch (Exception e) 
				   
				   {
					  	System.out.println("invalid try another name");
					  	System.out.println(e.getMessage());
				   }
		
	  
	} 
			System.out.println("thanx fro using our application");
			
			}

	private static String readLine() {
		// TODO Auto-generated method stub
		return null;
	}

	private static int Integer(String readLine) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
