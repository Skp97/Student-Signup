package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Student;

public class StudentDAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveStudents(Student student) {

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}
	public List<Student> getAllStudents(){
		
		Query query=entityManager.createQuery("select s from Student s");
		List<Student> list=query.getResultList();
		return list;
	}
	public void deleteStudent(int id) {
		
		Student student=entityManager.find(Student.class, id);
		
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
	}
}