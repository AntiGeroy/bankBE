package cz.upce.bank.eb.service;

import cz.upce.bank.eb.controller.AccessProhibitedException;
import cz.upce.bank.eb.dao.UserDao;
import cz.upce.bank.eb.entity.NewPasswordRequest;
import cz.upce.bank.eb.entity.NewUserRequest;
import cz.upce.bank.eb.entity.User;
import cz.upce.bank.eb.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void changePassword(NewPasswordRequest request){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null || (user.getRole() == UserRole.USER && user.getUserId() != request.getId())){
            throw new AccessProhibitedException("Access denied");
        }

        userDao.changePassword(request);
    }

    public User getUserByLogin(String login){
        return userDao.getUserByLogin(login);
    }

    public User getUserDetailsByLogin(String username){
        User user = getUserByLogin(username);

        if (user == null){
            throw new UsernameNotFoundException(format("User: %s, not found", username));
        }

        return user;
    }

    public void resetPassword(User user){
        if (user.getRole() != UserRole.USER){
            throw new ServiceException("It's forbidden to reset passwords for admins");
        }

        userDao.resetPassword(user);
    }

    public void blockUser(User user){
        if (user.getRole() != UserRole.USER){
            throw new ServiceException("It's forbidden to block admins");
        }

        userDao.blockUser(user);
    }

    public void unblockUser(User user){
        if (user.getRole() != UserRole.USER){
            throw new ServiceException("It's forbidden to unblock admins");
        }

        userDao.unblockUser(user);
    }

    public User getUserDetailsById(Integer id){
        User user = userDao.getUserById(id);

        if (user == null){
            throw new UsernameNotFoundException(format("User with id: %s, not found", id));
        }

        return user;
    }

    public void createAdminUser(NewUserRequest request){
        userDao.createAdmin(request);
    }

}
