package com.erkan.someJava.noteapp.service;

import com.erkan.someJava.noteapp.model.SimpleNote;

import java.util.List;
import java.util.Map;

public interface ISimpleNoteService {

    void addNote(SimpleNote note);

    List<SimpleNote> searchNotes(String keyword);

    List<String> getAllTitles();

    Map<String, List<SimpleNote>> groupNotesByTitleFirstLetter();

    void deleteNote(Long id);

    List<SimpleNote> getAllNotes();
}
