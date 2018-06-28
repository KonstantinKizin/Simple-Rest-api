package by.kizin.konstantin.resttask.repository;

import by.kizin.konstantin.resttask.entity.User;
import by.kizin.konstantin.resttask.repository.exception.RepositoryException;



public interface UserRepository {

    User addUser(User user) throws RepositoryException;

    User getUser(Long userId) throws RepositoryException;






}
