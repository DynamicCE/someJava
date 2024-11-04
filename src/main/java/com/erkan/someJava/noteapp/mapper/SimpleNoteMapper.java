package com.erkan.someJava.noteapp.mapper;

import com.erkan.someJava.noteapp.model.dto.SimpleNoteRequestDto;
import com.erkan.someJava.noteapp.model.dto.SimpleNoteResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.erkan.someJava.noteapp.model.SimpleNote;

@Mapper(componentModel = "spring")
public interface SimpleNoteMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    SimpleNote toEntity(SimpleNoteRequestDto simpleNoteRequestDto);

    SimpleNoteResponseDto toResponseDto(SimpleNote simpleNote);
}
