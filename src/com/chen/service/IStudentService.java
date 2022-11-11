package com.chen.service;

import com.chen.domain.Student;

import java.util.List;

public interface IStudentService {

    Student selectById(Long id);

    List<Student> queryAll();

    int save(Student student);

    int update(Student student);

    int deleteById(Long id);
}
