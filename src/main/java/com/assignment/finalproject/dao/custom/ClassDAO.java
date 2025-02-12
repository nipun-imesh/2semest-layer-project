package com.assignment.finalproject.dao.custom;

import com.assignment.finalproject.dao.CrudDAO;
import com.assignment.finalproject.dto.sub.ClassDTO;
import com.assignment.finalproject.entity.sub.Classes;

public interface ClassDAO extends CrudDAO<Classes> {

    ClassDTO findByclass(String selectedClassId);
}
