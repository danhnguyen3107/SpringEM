package com.code.project.projectv1.repository;

import com.code.project.projectv1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
public class UserRepImpl implements UserRep{
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(User user){
        entityManager.persist(user);
    }

    @Override
    public User findByUsername(String userName) {
        int num = checkUserName(userName);
        if (checkUserName(userName) == 0) return null;
        TypedQuery<User> a = entityManager.createQuery("SELECT t FROM User t JOIN FETCH t.role WHERE t.username = :username", User.class)
                .setParameter("username", userName);
        System.out.println("Show user: " + num);
//        if (a.getResultList().size() == 0) return null;

        return a.getSingleResult();
    }
    @Override
    public int checkUserName(String userName) {

        TypedQuery<User> a = entityManager.createQuery("SELECT t FROM User t WHERE t.username = :username", User.class)
                .setParameter("username", userName);

//        System.out.println("Show user: " + a.getResultList().size());

        return a.getResultList().size();
    }

    @Override
    public Long userCount(String userName) {
        Long count = (Long)entityManager.createQuery("select count(t) from User t where t.username = :username").setParameter("username", userName).getSingleResult();
        System.out.println("Number: " + count);

        return count;

    }
}
