package com.example.demo.controller;

import com.example.demo.model.entity.flashcard.Flashcard;
import com.example.demo.model.entity.flashcard.FlashcardAttempt;
import com.example.demo.model.io.dto.PerformanceStats;
import com.example.demo.model.io.dto.SpacedRepetitionModeData;
import com.example.demo.model.io.dto.StudyProgressStats;
import com.example.demo.service.intface.ISpacedRepetitionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spaced-repetition")
@CrossOrigin("*")
@RequiredArgsConstructor
@SecurityRequirement(name = "api")
public class SpacedRepetitionController {
    private final ISpacedRepetitionService spacedRepetitionService;

    @GetMapping("/mode-data")
    public ResponseEntity<SpacedRepetitionModeData> getSpacedRepetitionModeData(
            @RequestParam Long userId,
            @RequestParam Long flashcardSetId) {
        SpacedRepetitionModeData modeData = spacedRepetitionService.getModeData(userId, flashcardSetId);
        return ResponseEntity.ok(modeData);
    }

    @PostMapping("/set-new-flashcards-per-day")
    public ResponseEntity<Void> setNewFlashcardsPerDay(
            @RequestParam Long userId,
            @RequestParam Long flashcardSetId,
            @RequestParam Integer newFlashcardsPerDay) {
        spacedRepetitionService.setNewFlashcardsPerDay(userId, flashcardSetId, newFlashcardsPerDay);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/start-session")
    public ResponseEntity<List<Flashcard>> startStudySession(
            @RequestParam Long userId,
            @RequestParam Long flashcardSetId) {
        List<Flashcard> flashcards = spacedRepetitionService.startStudySession(userId, flashcardSetId);
        return ResponseEntity.ok(flashcards);
    }

    @PostMapping("/submit-review")
    public ResponseEntity<StudyProgressStats> submitReview(
            @RequestParam Long userId,
            @RequestParam Long flashcardId,
            @RequestParam Long flashcardSetId,
            @RequestParam int quality) {
        StudyProgressStats stats = spacedRepetitionService.submitReview(userId, flashcardId, flashcardSetId, quality);
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/study-history")
    public ResponseEntity<List<FlashcardAttempt>> getStudyHistory(
            @RequestParam Long userId,
            @RequestParam Long flashcardSetId) {
        List<FlashcardAttempt> attempts = spacedRepetitionService.getStudyHistory(userId, flashcardSetId);
        return ResponseEntity.ok(attempts);
    }

    @GetMapping("/performance-stats")
    public ResponseEntity<PerformanceStats> getPerformanceStats(
            @RequestParam Long userId,
            @RequestParam Long flashcardSetId) {
        PerformanceStats stats = spacedRepetitionService.getPerformanceStats(userId, flashcardSetId);
        return ResponseEntity.ok(stats);
    }
}