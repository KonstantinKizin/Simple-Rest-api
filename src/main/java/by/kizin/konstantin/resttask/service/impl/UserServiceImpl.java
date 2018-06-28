package by.kizin.konstantin.resttask.service.impl;

import by.kizin.konstantin.resttask.entity.User;
import by.kizin.konstantin.resttask.entity.UserStatus;
import by.kizin.konstantin.resttask.repository.UserRepository;
import by.kizin.konstantin.resttask.service.UpdateUserStatusResult;
import by.kizin.konstantin.resttask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User addUser(User user)  {
        return repository.addUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long userId)  {

        User user = repository.getUser(userId);
        if(user != null){
            user.setStatus(UserStatus.Online);
        }else {
            throw new EntityNotFoundException("Entity with {id = "+userId+"} not exists.");
        }
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UpdateUserStatusResult changeUserStatus(Long userId, UserStatus newStatus)  {
        User user = repository.getUser(userId);
        if(user == null){
            throw new EntityNotFoundException("Entity with {id = "+userId+"} not exists.");
        }
        UserStatus oldStatus = user.getStatus()== null ? UserStatus.Offline : user.getStatus();
        user.setStatus(newStatus);
        repository.addUser(user);
        return new UpdateUserStatusResult(user.getId(),oldStatus,user.getStatus());

    }
}
