package com.assignment.finalproject.dto.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AddParentDTO {

    private String parentId;
    private String parentName;
    private String parentEmail;
    private String status = "Active";

    public AddParentDTO(String parentId, String parentName, String parentEmail) {
        this.parentId = parentId;
        this.parentName = parentName;
        this.parentEmail = parentEmail;
    }
}
