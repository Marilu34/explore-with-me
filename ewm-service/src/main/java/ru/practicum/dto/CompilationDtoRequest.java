package ru.practicum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompilationDtoRequest {
    private Integer id;
    private List<Integer> events;
    private Boolean pinned;
    private String title;
}
