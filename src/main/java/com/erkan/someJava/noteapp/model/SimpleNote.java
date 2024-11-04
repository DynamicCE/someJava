package com.erkan.someJava.noteapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class SimpleNote extends BaseNote {

    public SimpleNote(String title, String content) {
        super(title, content);
    }

}
