package com.erkan.someJava.noteapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import java.util.Date;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@MappedSuperclass // base class , db tablosu olmaması için.
@Entity
@NoArgsConstructor
@Getter
public class BaseNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String title;

    @Setter
    private String content;

    private Date createdAt;

    public BaseNote(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
    }
}
