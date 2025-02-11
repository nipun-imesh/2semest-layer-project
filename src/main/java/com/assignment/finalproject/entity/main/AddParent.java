package com.assignment.finalproject.entity.main;

import com.assignment.finalproject.dto.main.AddParentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AddParent {

    private String parentId;
    private String parentName;
    private String parentEmail;
    private String status = "Active";


    public AddParent(String parentId, String parentName, String parentEmail) {
        this.parentId = parentId;
        this.parentName = parentName;
        this.parentEmail = parentEmail;
    }
}
