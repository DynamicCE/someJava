package com.erkan.someJava.noteapp.model.dto;

import java.util.Date;

public class SimpleNoteResponseDto {
    private Long id;
    private String title;
    private String content;
    private Date createdAt;

    public SimpleNoteResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
