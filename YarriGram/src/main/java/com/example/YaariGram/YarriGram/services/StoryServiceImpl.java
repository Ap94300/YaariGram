package com.example.YaariGram.YarriGram.services;

import com.example.YaariGram.YarriGram.entities.Story;
import com.example.YaariGram.YarriGram.entities.User;
import com.example.YaariGram.YarriGram.exceptions.UserException;
import com.example.YaariGram.YarriGram.repository.StoryRepository;
import com.example.YaariGram.YarriGram.repository.UserRepository;
import com.example.YaariGram.YarriGram.services.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;
    private final UserRepository userRepository;

    @Override
    public Story createStory(Long userId, Story story) throws UserException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("User not found with id: " + userId));

        story.setUser(user);
        story.setTimestamp(LocalDateTime.now());
        return storyRepository.save(story);
    }

    @Override
    public List<Story> getAllStories() {
        return storyRepository.findAll();
    }

    @Override
    public List<Story> getStoriesByUserId(Long userId) throws UserException {
        if (!userRepository.existsById(userId)) {
            throw new UserException("User not found with id: " + userId);
        }
        return storyRepository.findByUserId(userId);
    }
}
