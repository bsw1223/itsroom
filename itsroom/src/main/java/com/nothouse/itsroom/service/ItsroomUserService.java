package com.nothouse.itsroom.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.nothouse.itsroom.entity.ItsroomUser;
import com.nothouse.itsroom.entity.ItsroomUserPK;

public class ItsroomUserService {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ItsroomUser");
    
    //유저생성
    public void createItsroomUser(String email, String connectPath) {
	    EntityManager em1     = emf.createEntityManager(); //엔티티매니저
	    EntityTransaction tx1 = em1.getTransaction();      //트랜젝션
    	tx1.begin();
    	
    	ItsroomUser itsroomUser = new ItsroomUser();
    	itsroomUser.seteMail(email);
    	itsroomUser.setConnectionPath(connectPath); //접속방법(카카오,네이버)
    	
    	em1.persist(itsroomUser);
    	tx1.commit();
    	
    	em1.close();
	}
   
    //유저셀렉트
    public void selectItsroomUser(ItsroomUserPK itsroomUserPK) {
    	EntityManager em2     = emf.createEntityManager(); //엔티티매니저
    	EntityTransaction tx2 = em2.getTransaction();      //트랜젝션
    	tx2.begin();
    	
    	ItsroomUser itsroomUser = em2.find(ItsroomUser.class, itsroomUserPK); //PK를 파라미터로 셀렉트
    	
    	em2.persist(itsroomUser);
    	tx2.commit();
    	
    	em2.close();
    }
    
    
    
    
}
