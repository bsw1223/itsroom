package com.nothouse.itsroom.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.nothouse.itsroom.entity.ItsroomUser;
import com.nothouse.itsroom.entity.ItsroomUserPK;

public class ItsroomUserService {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ItsroomUser");
    
    //��������
    public void createItsroomUser(String email, String connectPath) {
	    EntityManager em1     = emf.createEntityManager(); //��ƼƼ�Ŵ���
	    EntityTransaction tx1 = em1.getTransaction();      //Ʈ������
    	tx1.begin();
    	
    	ItsroomUser itsroomUser = new ItsroomUser();
    	itsroomUser.seteMail(email);
    	itsroomUser.setConnectionPath(connectPath); //���ӹ��(īī��,���̹�)
    	
    	em1.persist(itsroomUser);
    	tx1.commit();
    	
    	em1.close();
	}
   
    //��������Ʈ
    public void selectItsroomUser(ItsroomUserPK itsroomUserPK) {
    	EntityManager em2     = emf.createEntityManager(); //��ƼƼ�Ŵ���
    	EntityTransaction tx2 = em2.getTransaction();      //Ʈ������
    	tx2.begin();
    	
    	ItsroomUser itsroomUser = em2.find(ItsroomUser.class, itsroomUserPK); //PK�� �Ķ���ͷ� ����Ʈ
    	
    	em2.persist(itsroomUser);
    	tx2.commit();
    	
    	em2.close();
    }
    
    
    
    
}
