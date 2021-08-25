package com.nothouse.itsroom.service;

import java.util.ArrayList;
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
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("itsroomUnit"); //엔티티매니저 팩토리

	@Autowired
	ItsroomUserRepository itsroomUserRepository;
	
	//param : ItsroomUserPK, ItsroomUser 테이블 INSERT
    public void createItsroomUser(ItsroomUserPK itsroomUserPK) {
		//ROOM테이블 INSERT
		EntityManager em         = emf.createEntityManager(); //엔티티매니저
		EntityTransaction tx     = em.getTransaction();       //트랜젝션
		try {
			tx.begin();                                           //트랜젝션 시작
			ItsroomUser itsroomUser     = new ItsroomUser();     //room entity      
			itsroomUser.setIsroomUserPK(itsroomUserPK);         //PK SET
		    em.persist(itsroomUserPK);
		    tx.commit();  //트랜젝션 닫기
		}catch (Exception e) {
            System.out.println("createItsroomUser error :::  "+e.getMessage().toString());
		}
		em.close();   //엔티티매니저 닫기
    }

    //param : ItsroomUserPK, ItsroomUser테이블 select
    public ItsroomUser selectItsroomUser(ItsroomUserPK itsroomUserPK) {
		EntityManager em         = emf.createEntityManager(); //엔티티매니저
		EntityTransaction tx     = em.getTransaction();       //트랜젝션
		ItsroomUser itsroomUser  = new ItsroomUser();  
		try {
        	tx.begin();     
        	itsroomUser = itsroomUserRepository.finItsroomUser(itsroomUserPK);
        	tx.commit();  //트랜젝션 닫기
        }catch (Exception e) {
        	System.out.println("selectItsroomUser error :::  "+e.getMessage().toString());
		}
		em.close();   //엔티티매니저 닫기
		
        return itsroomUser;
    }
    
    //param : eMail, ItsroomUser테이블 select list
    public List<ItsroomUser> selByeMail(String eMail) {
    	EntityManager em         = emf.createEntityManager(); //엔티티매니저
    	EntityTransaction tx     = em.getTransaction();       //트랜젝션
    	List<ItsroomUser> itsroomUserList = new ArrayList<ItsroomUser>();
    	try {
    	    tx.begin();   //트랜젝션 시작  
    	    itsroomUserList = itsroomUserRepository.findByEMail(eMail);
    	    tx.commit();  //트랜젝션 닫기
    	}catch (Exception e) {
			System.out.println("selectRoomList error :::  "+e.getMessage().toString());
		}
    	
    	em.close();   //엔티티매니저 닫기
    	
    	return itsroomUserList;
    }
    
    //param : connectionPath, ItsroomUser테이블 select list
    public List<ItsroomUser> selByJibun(String connectionPath) {
    	EntityManager em         = emf.createEntityManager(); //엔티티매니저
    	EntityTransaction tx     = em.getTransaction();       //트랜젝션
    	List<ItsroomUser> itsroomUserList      = null;
    	try {
    		tx.begin();   //트랜젝션 시작  
    		itsroomUserList = itsroomUserRepository.findByConnectionPath(connectionPath);
    		tx.commit();  //트랜젝션 닫기
    	}catch (Exception e) {
    		System.out.println("selectRoomList error :::  "+e.getMessage().toString());
    	}
    	
    	em.close();   //엔티티매니저 닫기
    	
    	return itsroomUserList;
    }
    
}
