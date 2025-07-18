package com.example.YaariGram.YarriGram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.YaariGram.YarriGram.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
