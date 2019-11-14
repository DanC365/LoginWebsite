package com.sparta.djc.services;

import com.sparta.djc.components.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class userAccessor {

    public boolean addUserToDatabase(User user){
        EntityManager entityManager = getEntityManager();
        if(getUserDetails(user.getUserName(),entityManager)!=null){
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return true;
        }else{
            return false;
        }


    }

    private EntityManager getEntityManager(){
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("SakilaPersistenceUnit");
        return managerFactory.createEntityManager();
    }


    public User getUserDetails(String userName){
        EntityManager entityManager = getEntityManager();
        return getUserDetails(userName,entityManager);
    }

    private User getUserDetails(String userName, EntityManager entityManager){
        Query query = entityManager.createNamedQuery("getAccountByUsername");
        query.setParameter("username",userName);
        return (User) query.getSingleResult();
    }

}
