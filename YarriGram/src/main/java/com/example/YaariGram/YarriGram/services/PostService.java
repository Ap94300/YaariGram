package com.example.YaariGram.YarriGram.services;

import com.example.YaariGram.YarriGram.entities.Post;
import com.example.YaariGram.YarriGram.entities.User;
import com.example.YaariGram.YarriGram.exceptions.PostException;
import com.example.YaariGram.YarriGram.exceptions.UserException;

import java.util.List;

public interface PostService {

    public Post createPost(Post post,Long userId) throws UserException;

    public String deletePost(Long postId,Long userId) throws UserException, PostException;

    public List<Post> findPostByUserId(Long userId) throws UserException;

    public Post findPostById(Long postId) throws PostException;

    public List<Post> findAllPostByUserIds(List<Long> userIds) throws PostException,UserException;

    public String savePost(Long postId, Long userId) throws UserException,PostException;

    public String unSavePost(Long postId, Long userId) throws UserException,PostException;

    public Post likePost(Long postId, Long userId) throws UserException,PostException;

    public Post unLikePost(Long postId, Long userId) throws UserException,PostException;

}
