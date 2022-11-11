package com.chen.dao;

import com.chen.domain.Grade;

import java.util.List;

public interface IGradeDao {

    List<Grade> selectAll();

    int saveClass(Grade grade);
}
