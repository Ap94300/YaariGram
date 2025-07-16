package com.example.YaariGram.YarriGram.repository;

import com.example.YaariGram.YarriGram.entities.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
    List<Story> findByUserId(Long userId);
}