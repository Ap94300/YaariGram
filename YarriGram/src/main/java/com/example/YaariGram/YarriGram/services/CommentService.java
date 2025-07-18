package com.example.YaariGram.YarriGram.services;

import com.example.YaariGram.YarriGram.entities.Comment;
import com.example.YaariGram.YarriGram.exceptions.CommentException;
import com.example.YaariGram.YarriGram.exceptions.PostException;
import com.example.YaariGram.YarriGram.exceptions.UserException;

public interface CommentService {

    public Comment createComment(Comment comment,Long userId,Long postId) throws UserException, PostException;

    public Comment findCommentById(Long commentId) throws CommentException;

    public Comment likeComment(Long commentId,Long userId) throws UserException,CommentException;

    public Comment unlikeComment(Long commentId,Long userId) throws UserException,CommentException;
}

