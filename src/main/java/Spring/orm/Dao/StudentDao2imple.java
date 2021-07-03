package Spring.orm.Dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import Spring.orm.Entity.Student;

public class StudentDao2imple

// implements StudentDao2 {
{
	private	HibernateTemplate hibernateTemplate;
		
	//setter gatter inject objectt
	public HibernateTemplate getHibernateTemplate() 
	{
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;

	}
	//save data
	@Transactional   //activate by applying tx:annotation-driven in B.xml and tx annotation-driven get by apply .xsd file in B.xml
	public int save1(Student st) {
	
		
		//hibernateTemplate.save(st);
		Integer i=(Integer)this.hibernateTemplate.save(st);
		
		return i;
	}
	
	//get single student
	public Student getstudentdata(int Studentid) 
	
	{
		return this.hibernateTemplate.get(Student.class,Studentid);
	
		
	}
	//get all data from student
	public List<Student> getstudentalldata() 
	
	{
		return this.hibernateTemplate.loadAll(Student.class);
	
		
	}
	//delete student
	@Transactional
	public void deletedata(int Studentid) {
		
	Student student=this.hibernateTemplate.get(Student.class,Studentid);
	this.hibernateTemplate.delete(student);
	}
	//update data
	@Transactional
	public void updatestudent(Student student5) {
		//Student student=this.hibernateTemplate.get(Student.class,update);
		this.hibernateTemplate.update(student5);
	}
//	private	HibernateTemplate hibernateTemplate;
//	@Transactional
//	public int insert(Student st) 
//	{
//
//        Integer i1=	(Integer) this.hibernateTemplate.save(st);
//		return 1;
//		
	
	}
