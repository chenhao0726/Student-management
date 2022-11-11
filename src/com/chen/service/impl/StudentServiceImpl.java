package com.chen.service.impl;

import com.chen.dao.IStudentDao;
import com.chen.dao.impl.StudentDaoImpl;
import com.chen.domain.Student;
import com.chen.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private IStudentDao dao = new StudentDaoImpl();

    @Override
    public Student selectById(Long id) {
        return dao.selectById(id);
    }

    @Override
    public List<Student> queryAll() {
        return dao.queryAll();
    }

    @Override
    public int save(Student student) {
        return dao.save(student);
    }

    @Override
    public int update(Student student) {
        return dao.update(student);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }
}
