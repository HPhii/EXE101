package com.example.demo.repository;

import com.example.demo.model.entity.flashcard.FlashcardAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardAttemptRepository extends JpaRepository<FlashcardAttempt, Long> {
}
