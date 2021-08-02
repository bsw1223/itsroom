package com.nothouse.itsroom.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nothouse.itsroom.entity.ItsroomUser;
import com.nothouse.itsroom.entity.ItsroomUserPK;
import com.nothouse.itsroom.entity.Room;
import com.nothouse.itsroom.entity.RoomPK;
import com.nothouse.itsroom.repository.ItsroomUserRepository;
import com.nothouse.itsroom.repository.RoomRepository;

@Service
public class ItsroomUserService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("itsroomUnit"); //��ƼƼ�Ŵ��� ���丮

	@Autowired
	ItsroomUserRepository itsroomUserRepository;
	
	//param : ItsroomUserPK, ItsroomUser ���̺� INSERT
    public void createItsroomUser(ItsroomUserPK itsroomUserPK) {
		//ROOM���̺� INSERT
		EntityManager em         = emf.createEntityManager(); //��ƼƼ�Ŵ���
		EntityTransaction tx     = em.getTransaction();       //Ʈ������
		try {
			tx.begin();                                           //Ʈ������ ����
			ItsroomUser itsroomUser     = new ItsroomUser();     //room entity      
			itsroomUser.setIsroomUserPK(itsroomUserPK);         //PK SET
		    em.persist(itsroomUserPK);
		    tx.commit();  //Ʈ������ �ݱ�
		}catch (Exception e) {
            System.out.println("createItsroomUser error :::  "+e.getMessage().toString());
		}
		em.close();   //��ƼƼ�Ŵ��� �ݱ�
    }

    //param : ItsroomUserPK, ItsroomUser���̺� select
    public ItsroomUser selectItsroomUser(ItsroomUserPK itsroomUserPK) {
		EntityManager em         = emf.createEntityManager(); //��ƼƼ�Ŵ���
		EntityTransaction tx     = em.getTransaction();       //Ʈ������
		ItsroomUser itsroomUser  = new ItsroomUser();  
		try {
        	tx.begin();     
        	itsroomUser = itsroomUserRepository.selItsroomUserByPK(itsroomUserPK);
        	tx.commit();  //Ʈ������ �ݱ�
        }catch (Exception e) {
        	System.out.println("selectItsroomUser error :::  "+e.getMessage().toString());
		}
		em.close();   //��ƼƼ�Ŵ��� �ݱ�
		
        return itsroomUser;
    }
    
    //param : eMail, ItsroomUser���̺� select list
    public List<ItsroomUser> selByeMail(String eMail) {
    	EntityManager em         = emf.createEntityManager(); //��ƼƼ�Ŵ���
    	EntityTransaction tx     = em.getTransaction();       //Ʈ������
    	List<ItsroomUser> itsroomUserList      = null;
    	try {
    	    tx.begin();   //Ʈ������ ����  
    	    itsroomUserList = itsroomUserRepository.selByEmail(eMail);
    	    tx.commit();  //Ʈ������ �ݱ�
    	}catch (Exception e) {
			System.out.println("selectRoomList error :::  "+e.getMessage().toString());
		}
    	
    	em.close();   //��ƼƼ�Ŵ��� �ݱ�
    	
    	return itsroomUserList;
    }
    
    //param : connectionPath, ItsroomUser���̺� select list
    public List<ItsroomUser> selByJibun(String connectionPath) {
    	EntityManager em         = emf.createEntityManager(); //��ƼƼ�Ŵ���
    	EntityTransaction tx     = em.getTransaction();       //Ʈ������
    	List<ItsroomUser> itsroomUserList      = null;
    	try {
    		tx.begin();   //Ʈ������ ����  
    		itsroomUserList = itsroomUserRepository.selByConnection(connectionPath);
    		tx.commit();  //Ʈ������ �ݱ�
    	}catch (Exception e) {
    		System.out.println("selectRoomList error :::  "+e.getMessage().toString());
    	}
    	
    	em.close();   //��ƼƼ�Ŵ��� �ݱ�
    	
    	return itsroomUserList;
    }
    
}
