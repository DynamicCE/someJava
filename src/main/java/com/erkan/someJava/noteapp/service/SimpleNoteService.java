package com.erkan.someJava.noteapp.service;

import java.util.List;
import java.util.Map;

import com.erkan.someJava.noteapp.model.SimpleNote;
import com.erkan.someJava.noteapp.repository.SimpleNoteRepository;

import java.util.stream.Collectors;

import com.erkan.someJava.noteapp.core.exception.InvalidNoteException;
import com.erkan.someJava.noteapp.core.exception.UnexpectedException;

public class SimpleNoteService implements ISimpleNoteService {

    private SimpleNoteRepository simpleNoteRepository;

    public SimpleNoteService(SimpleNoteRepository simpleNoteRepository) {
        this.simpleNoteRepository = simpleNoteRepository;
    }

    @Override
    public void addNote(SimpleNote note) {
        if (note.getTitle() == null || note.getContent() == null) {
            throw new InvalidNoteException();
        }
        simpleNoteRepository.save(note);
    }

    @Override
    public List<SimpleNote> searchNotes(String keyword) {
        return simpleNoteRepository.findAll()
                .stream()
                .filter(simpleNote -> simpleNote.getTitle().contains(keyword))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllTitles() {
        try {
            return simpleNoteRepository.findAll()
                    .stream()
                    .map(SimpleNote::getTitle)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new UnexpectedException();
        }
    }

    @Override
    public Map<String, List<SimpleNote>> groupNotesByTitleFirstLetter() {
        try {
            return simpleNoteRepository.findAll()
                    .stream()
                    .collect(Collectors.groupingBy(simpleNote -> simpleNote.getTitle()
                            .substring(0, 1)
                            .toUpperCase()));
        } catch (Exception e) {
            throw new UnexpectedException();
        }
    }

    @Override
    public void deleteNote(Long id) {
        try {
            simpleNoteRepository.deleteById(id);
        } catch (Exception e) {
            throw new UnexpectedException();
        }
    }

    @Override
    public List<SimpleNote> getAllNotes() {
        try {
            return simpleNoteRepository.findAll();
        } catch (Exception e) {
            throw new UnexpectedException();
        }
    }
}
