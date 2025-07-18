package com.example.YaariGram.YarriGram.controller;

import com.example.YaariGram.YarriGram.entities.Comment;
import com.example.YaariGram.YarriGram.entities.User;
import com.example.YaariGram.YarriGram.exceptions.CommentException;
import com.example.YaariGram.YarriGram.exceptions.PostException;
import com.example.YaariGram.YarriGram.exceptions.UserException;
import com.example.YaariGram.YarriGram.services.CommentService;
import com.example.YaariGram.YarriGram.services.PostService;
import com.example.YaariGram.YarriGram.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;
    private final PostService postService;

    @PostMapping("/create/{postId}")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment,@PathVariable Long postId,@RequestHeader("Authorization") String token) throws UserException, PostException {
        User user = userService.findUserByToken(token);
        Comment createComment = commentService.createComment(comment,user.getId(),postId);
        return new ResponseEntity<Comment>(createComment, HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> findCommentById(@PathVariable Long commentId) throws CommentException {
        Comment comment = commentService.findCommentById(commentId);
        return new ResponseEntity<Comment>(comment,HttpStatus.OK);
    }

    @PutMapping("/like/{commentId}")
    public ResponseEntity<Comment> likeComment(@RequestHeader("Authorization") String token,@PathVariable Long commentId) throws UserException, CommentException {
        User user = userService.findUserByToken(token);
        Comment comment = commentService.likeComment(commentId, user.getId());
        return new ResponseEntity<Comment>(comment,HttpStatus.OK);
    }

    @PutMapping("/unlike/{commentId}")
    public ResponseEntity<Comment> unlikeComment(@RequestHeader("Authorization") String token,@PathVariable Long commentId) throws UserException, CommentException {
        User user = userService.findUserByToken(token);
        Comment comment = commentService.unlikeComment(commentId, user.getId());
        return new ResponseEntity<Comment>(comment,HttpStatus.OK);
    }
}
