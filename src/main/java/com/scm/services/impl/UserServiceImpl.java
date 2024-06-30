package com.scm.services.impl;

import com.scm.entities.User;
import com.scm.helper.ResourceNotFoundException;
import com.scm.repositiries.UserRepo;
import com.scm.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepo userRepo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user)
    {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserbyId(String id)
    {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateuser(User user)
    {
        User user2 = userRepo.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.getEnabled());
        user2.setEmailVerified(user.getEmailVerified());
        user2.setPhoneVerified(user.getPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());

        User savedUser = userRepo.save(user2);
        return Optional.ofNullable(savedUser);


    }

    @Override
    public void deleteuser(String id)
    {
        User user2 = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepo.delete(user2);

    }

    @Override
    public boolean isUserExist(String id)
    {
        User user2 = userRepo.findById(id).orElse(null);
        return user2!=null ?true :false;


    }

    @Override
    public boolean isUserExitByEmail(String email)
    {
        User user2 = userRepo.findByEmail(email).orElse(null);
        return user2!=null ?true :false;    }

    @Override
    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }
}
