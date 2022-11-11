package com.chen.service;

import com.chen.domain.Grade;

import java.util.List;

public interface IGradeService {

    List<Grade> selectAll();

    int saveClass(Grade grade);
}
