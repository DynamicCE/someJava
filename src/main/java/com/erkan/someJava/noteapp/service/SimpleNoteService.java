package com.erkan.someJava.noteapp.service;

import java.util.List;
import java.util.Map;

import com.erkan.someJava.noteapp.model.SimpleNote;
import com.erkan.someJava.noteapp.repository.SimpleNoteRepository;

import java.util.stream.Collectors;

import com.erkan.someJava.noteapp.core.exception.InvalidNoteException;
import com.erkan.someJava.noteapp.core.exception.UnexpectedException;
import com.erkan.someJava.noteapp.core.exception.NoteNotFoundException;

import org.springframework.stereotype.Service;
import com.erkan.someJava.noteapp.mapper.SimpleNoteMapper;
import com.erkan.someJava.noteapp.model.dto.SimpleNoteRequestDto;
import com.erkan.someJava.noteapp.model.dto.SimpleNoteResponseDto;

@Service
public class SimpleNoteService implements ISimpleNoteService {

    private SimpleNoteMapper simpleNoteMapper;
    private SimpleNoteRepository simpleNoteRepository;

    public SimpleNoteService(SimpleNoteRepository simpleNoteRepository, SimpleNoteMapper simpleNoteMapper) {
        this.simpleNoteRepository = simpleNoteRepository;
        this.simpleNoteMapper = simpleNoteMapper;
    }

    @Override
    public void addNote(SimpleNoteRequestDto note) {
        if (note.getTitle() == null || note.getContent() == null) {
            throw new InvalidNoteException();
        }
        simpleNoteRepository.save(simpleNoteMapper.toEntity(note));
    }

    @Override
    public List<SimpleNoteResponseDto> searchNotes(String keyword) {
        return simpleNoteRepository.findAll()
                .stream()
                .filter(simpleNote -> simpleNote.getTitle().contains(keyword) ||
                        simpleNote.getContent().contains(keyword))
                .map(simpleNoteMapper::toResponseDto)
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
    public Map<String, List<SimpleNoteResponseDto>> groupNotesByTitleFirstLetter() {
        try {
            return simpleNoteRepository.findAll()
                    .stream()
                    .collect(Collectors.groupingBy(note -> note.getTitle().substring(0, 1).toUpperCase(),
                            Collectors.mapping(
                                    simpleNoteMapper::toResponseDto,
                                    Collectors.toList())));
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
    public List<SimpleNoteResponseDto> getAllNotes() {
        try {
            return simpleNoteRepository.findAll()
                    .stream()
                    .map(simpleNoteMapper::toResponseDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new UnexpectedException();
        }
    }

    @Override
    public SimpleNoteResponseDto updateNote(Long id, SimpleNoteRequestDto simpleNoteRequestDto) {
        SimpleNote existingNote = simpleNoteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
        existingNote.setTitle(simpleNoteRequestDto.getTitle());
        existingNote.setContent(simpleNoteRequestDto.getContent());
        return simpleNoteMapper.toResponseDto(simpleNoteRepository.save(existingNote));
    }
}
