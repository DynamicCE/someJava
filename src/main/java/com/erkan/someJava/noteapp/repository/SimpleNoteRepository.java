package com.erkan.someJava.noteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.erkan.someJava.noteapp.model.SimpleNote;

import org.springframework.stereotype.Repository;

@Repository
public interface SimpleNoteRepository extends JpaRepository<SimpleNote, Long> {

}
