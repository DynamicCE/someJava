package com.erkan.someJava.noteapp.service;

import com.erkan.someJava.noteapp.model.SimpleNote;
import com.erkan.someJava.noteapp.model.dto.SimpleNoteResponseDto;
import com.erkan.someJava.noteapp.model.dto.SimpleNoteRequestDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public interface ISimpleNoteService {

    void addNote(SimpleNoteRequestDto simpleNoteRequestDto);

    List<SimpleNoteResponseDto> searchNotes(String keyword);

    List<String> getAllTitles();

    Map<String, List<SimpleNoteResponseDto>> groupNotesByTitleFirstLetter();

    void deleteNote(Long id);

    SimpleNoteResponseDto updateNote(Long id, SimpleNoteRequestDto simpleNoteRequestDto);

    List<SimpleNoteResponseDto> getAllNotes();
}
