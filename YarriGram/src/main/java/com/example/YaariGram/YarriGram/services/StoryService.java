package com.example.YaariGram.YarriGram.services;

import com.example.YaariGram.YarriGram.entities.Story;
import com.example.YaariGram.YarriGram.exceptions.UserException;

import java.util.List;

public interface StoryService {

    Story createStory(Long userId, Story story) throws UserException;

    List<Story> getAllStories();

    List<Story> getStoriesByUserId(Long userId) throws UserException;
}
