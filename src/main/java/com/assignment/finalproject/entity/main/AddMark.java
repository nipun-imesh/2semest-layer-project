package com.assignment.finalproject.entity.main;

import com.assignment.finalproject.dto.main.AddMarkDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AddMark {
    private String classId;
    private String grade;
}
