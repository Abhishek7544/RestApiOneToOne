package com.jocata.dao;


import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.jocata.entity.Country;
import com.jocata.entity.Employee;
import com.jocata.utils.HibernateUtils;

@Repository
public class CountryRepository {
	
		public Country saveCountry(Country country) {
			
			Transaction  transaction= null;
			try(Session session = com.jocata.utils.HibernateUtils.getSessionFactory().openSession()){
				
				transaction = session.beginTransaction();
				session.save(country);
				transaction.commit();
			}catch (Exception e) {
				// TODO: handle exception
				if(transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
			return country;
		}
		public Employee saveEmployee(Employee employee) {
			
			Transaction  transaction= null;
			try(Session session = com.jocata.utils.HibernateUtils.getSessionFactory().openSession()){
				
				transaction = session.beginTransaction();
				session.save(employee);
				transaction.commit();
			}catch (Exception e) {
				// TODO: handle exception
				if(transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
			return employee;
		}
		public void deleteCountry(int id) {
			Transaction  transaction= null;
			try(Session session = com.jocata.utils.HibernateUtils.getSessionFactory().openSession()){
				transaction =session.beginTransaction();
				Country country=session.get(Country.class, id);
				if(country!=null) {
					session.delete(country);
				}
				
				transaction.commit();
			}catch (Exception e) {
				// TODO: handle exception
				if(transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
		}
		public void deleteEmployee(int id) {
			Transaction transaction=null;
			try(Session session=HibernateUtils.getSessionFactory().openSession();){
				transaction=session.beginTransaction();
				Employee employee=session.get(Employee.class,id);
				if(employee!=null) {
					session.delete(employee);
				}
				transaction.commit();
				
			}
			catch (HibernateException he) {
				if(transaction!=null) {
					transaction.rollback();
				}
				he.printStackTrace();
			}
		}
		public void removeCountryById(int id) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	
	            transaction = session.beginTransaction();
	            Country country=session.get(Country.class,id);
	            if (country != null) {
	                session.delete(country);
	                System.out.println("country 1 is deleted");
	            }

	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
//		public void showAllEmp() {
//			Transaction transaction=null;
//			try(Session session=HibernateUtils.getSessionFactory().openSession();) {
//				transaction=session.beginTransaction();
//				Query query=session.createNativeQuery("SELECT * FROM MAPP_EMP");
//				query.executeUpdate();
//				transaction.commit();
//				
//			}catch (Exception e) {
//	            if (transaction != null) {
//	                transaction.rollback();
//	            }
//	            e.printStackTrace();
//	        }
//			
//		}
		   
		    
}
