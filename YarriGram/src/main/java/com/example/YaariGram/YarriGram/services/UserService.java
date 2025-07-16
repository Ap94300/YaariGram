package com.example.YaariGram.YarriGram.services;


import com.example.YaariGram.YarriGram.entities.User;

import com.example.YaariGram.YarriGram.exceptions.UserException;

import java.util.List;

public interface UserService {

    public User findUserById(Long id) throws UserException;

    public User findUserByUsername(String username) throws UserException;

    public User findUserByToken(String token) throws UserException;

    public String followUser(Long reqUserId, Long followUserId) throws UserException;

    public String unFollowUser(Long reqUserId, Long followUserId) throws UserException;

    public List<User> findUserByIds(List<Long> userIds) throws UserException;

    public List<User> searchUser(String query)throws UserException;

    public User updateUser(User updatedUser, User existingUser) throws UserException;
}

