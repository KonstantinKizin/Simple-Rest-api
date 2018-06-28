package by.kizin.konstantin.resttask.repository.impl;

import by.kizin.konstantin.resttask.entity.User;
import by.kizin.konstantin.resttask.repository.UserRepository;
import by.kizin.konstantin.resttask.repository.exception.EntityAlreadyExistException;
import by.kizin.konstantin.resttask.repository.exception.RepositoryException;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;


@Repository
public class JpaUserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User addUser(User user) throws RepositoryException {
        try{
            entityManager.persist(user);
            return user;
        }catch (PersistenceException e){
           throw new EntityAlreadyExistException("user","name",user.getName());
        }
    }

    @Override
    public User getUser(Long userId) throws RepositoryException {
        try {
            User user = entityManager.find(User.class, userId);
            return user;
        }catch (PersistenceException e){
            throw new RepositoryException(e);
        }
    }


}
