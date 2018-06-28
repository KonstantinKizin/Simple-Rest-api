package by.kizin.konstantin.resttask.service;

import by.kizin.konstantin.resttask.entity.User;
import by.kizin.konstantin.resttask.entity.UserStatus;

public interface UserService {

    User addUser(User user) ;

    User getUserById(Long userId) ;

    UpdateUserStatusResult changeUserStatus(Long userId, UserStatus newStatus);


}
