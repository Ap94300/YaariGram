package com.example.YaariGram.YarriGram.controller;

import com.example.YaariGram.YarriGram.entities.Post;
import com.example.YaariGram.YarriGram.entities.User;
import com.example.YaariGram.YarriGram.exceptions.UserException;
import com.example.YaariGram.YarriGram.services.PostService;
import com.example.YaariGram.YarriGram.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;


    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post, @RequestHeader("Authorization") String token) throws UserException {
        User user = userService.findUserByToken(token);
        Post createdPost = postService.createPost(post,user.getId());
        return new ResponseEntity<Post>(createdPost, HttpStatus.OK);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<Post>> findPostByUserId(@PathVariable Long userId) throws UserException {
        List<Post> posts = postService.findPostByUserId(userId);
        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
    }
}
