package com.jocata.controller;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jocata.dao.CountryRepository;
import com.jocata.entity.Country;
import com.jocata.entity.Employee;
import com.jocata.utils.HibernateUtils;
import com.jocata.vo.Country_vo;
import com.jocata.vo.EmpCountryVo;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryRepository dao;
	
	
	public CountryController() {
		super();
	}
	public CountryController(CountryRepository dao) {
		super();
		this.dao = dao;
	}
	@PostMapping("/add")
	public Employee addCountry(@RequestBody EmpCountryVo employee) {
		Country count=new Country();
		Country_vo country_vo =employee.getCountry_vo();
		
		count.setCountryLang(country_vo.getCountryLang());
		count.setCountryName(country_vo.getCountryName());
		count.setCountryPopulation(country_vo.getCountryPopulation());
		dao.saveCountry(count);
		
		Employee emp=new Employee();
		emp.setEname(employee.getEname());
		emp.setEstatus(employee.getEstatus());
		emp.setCountry(count);
		
		return dao.saveEmployee(emp);
		
	}
	@DeleteMapping("/del/{EMP_NAME}")
	public void delCountryAndEmployee(@PathVariable(value ="EMP_NAME") String name) {
		Transaction transaction=null;
		Session session=HibernateUtils.getSessionFactory().openSession();
		//Country country=session.get(Country.class,countid);
		
		try {
			transaction=session.beginTransaction();
			Query query=session.createNativeQuery( "delete from MAPP_EMP where EMP_NAME =:name" );
			query.setString("name",name);
			query.executeUpdate();
			transaction.commit();
		}
		catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();	
			}
			e.printStackTrace();
		  }
		
//		if(country!=null) {
//			Employee employee=session.load(Employee.class, countid );
//			if(employee!=null) {
//				employee.setCountry(null);
//				session.delete(country);
//				session.createNativeQuery("DELETE FROM MAPP_EMP WHERE EMP_ID=countid");
//			}
//			//session.delete(employee);
//		}
//		
//		if(country!=null) {
//			session.delete(country);
//		}
		System.out.println("deleted");
		
	}	
	@DeleteMapping("/delete/{id}")
	public void deleteCountry(@PathVariable(value="id") int id) {
		Session session=HibernateUtils.getSessionFactory().openSession();
		Transaction transaction=null;
		//Country country=session.get(Country.class,id);
		//System.out.println(country);
		//session.delete(country);
		//entityManager.createNativeQuery("DELETE FROM MAPP_EMP WHERE EMP_ID=countid");
		dao.removeCountryById(id);
		//System.out.println("Suscess delete"+country);
	}
	@PostMapping("/show/emp")
	public List<Employee> getAllStudents() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=null;
        List<Employee> employees1=null;
		try {
			transaction=session.beginTransaction();
			employees1 = session.createQuery("FROM MAPP_EMP", Employee.class).getResultList();
			transaction.commit();
		}
		catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();	
			}
			e.printStackTrace();
		  }
         return employees1;
    }
	
}


