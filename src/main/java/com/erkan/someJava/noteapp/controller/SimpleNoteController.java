package com.erkan.someJava.noteapp.controller;

import com.erkan.someJava.noteapp.model.dto.SimpleNoteRequestDto;
import com.erkan.someJava.noteapp.model.dto.SimpleNoteResponseDto;
import com.erkan.someJava.noteapp.service.ISimpleNoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notes")
public class SimpleNoteController {
    private final ISimpleNoteService simpleNoteService;

    public SimpleNoteController(ISimpleNoteService simpleNoteService) {
        this.simpleNoteService = simpleNoteService;
    }

    @GetMapping
    public ResponseEntity<List<SimpleNoteResponseDto>> getAllNotes() {
        return ResponseEntity.ok(simpleNoteService.getAllNotes());
    }

    @PostMapping
    public ResponseEntity<Void> addNote(@RequestBody SimpleNoteRequestDto requestDto) {
        simpleNoteService.addNote(requestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<SimpleNoteResponseDto>> searchNotes(@RequestParam String keyword) {
        return ResponseEntity.ok(simpleNoteService.searchNotes(keyword));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        simpleNoteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimpleNoteResponseDto> updateNote(
            @PathVariable Long id,
            @RequestBody SimpleNoteRequestDto requestDto) {
        return ResponseEntity.ok(simpleNoteService.updateNote(id, requestDto));
    }

    @GetMapping("/titles")
    public ResponseEntity<List<String>> getAllTitles() {
        return ResponseEntity.ok(simpleNoteService.getAllTitles());
    }

    @GetMapping("/group-by-title-first-letter")
    public ResponseEntity<Map<String, List<SimpleNoteResponseDto>>> groupNotesByTitleFirstLetter() {
        return ResponseEntity.ok(simpleNoteService.groupNotesByTitleFirstLetter());
    }
}
