package com.example.YaariGram.YarriGram.controller;

import com.example.YaariGram.YarriGram.entities.Story;
import com.example.YaariGram.YarriGram.exceptions.UserException;
import com.example.YaariGram.YarriGram.services.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/stories")
@RequiredArgsConstructor
public class StoryController {

    private final StoryService storyService;

    // POST: Create a new story for a given user
    @PostMapping("/{userId}")
    public ResponseEntity<Story> createStory(@PathVariable Long userId, @RequestBody Story story) throws UserException {
        Story createdStory = storyService.createStory(userId, story);
        return ResponseEntity
                .created(URI.create("/api/stories/" + createdStory.getId()))
                .body(createdStory);
    }

    // GET: Fetch all stories
    @GetMapping("/all")
    public ResponseEntity<List<Story>> getAllStories() {
        return ResponseEntity.ok(storyService.getAllStories());
    }

    // GET: Fetch all stories by a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Story>> getStoriesByUser(@PathVariable Long userId) throws UserException {
        return ResponseEntity.ok(storyService.getStoriesByUserId(userId));
    }
}
