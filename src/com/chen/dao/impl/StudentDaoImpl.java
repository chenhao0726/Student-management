package com.chen.dao.impl;

import com.chen.dao.IStudentDao;
import com.chen.domain.Student;
import com.chen.util.JdbcUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements IStudentDao {
    private static final String MYSQL = "com.chen.mapper.StudentMapper.";
    private static final int RE = -1;


    @Override
    public Student selectById(Long id) {
        SqlSession session = JdbcUtil.getSession();
        Student stu = session.selectOne(StudentDaoImpl.MYSQL + "selectById", id);
        session.close();
        return stu;
    }

    @Override
    public List<Student> queryAll() {
        SqlSession session = JdbcUtil.getSession();
        List<Student> stu = session.selectList(StudentDaoImpl.MYSQL + "queryAll");
        session.close();
        return stu;
    }

    @Override
    public int save(Student student) {
        SqlSession session = JdbcUtil.getSession();
        try {
            int insert = session.insert(StudentDaoImpl.MYSQL + "save", student);
            session.commit();
            return insert;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return RE;
    }

    @Override
    public int update(Student student) {
        SqlSession session = JdbcUtil.getSession();
        try {
            int update = session.update(StudentDaoImpl.MYSQL + "update", student);
            session.commit();
            return update;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return RE;
    }

    @Override
    public int deleteById(Long id) {
        SqlSession session = JdbcUtil.getSession();
        try {
            int delete = session.delete(StudentDaoImpl.MYSQL + "deleteById", id);
            session.commit();
            return delete;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return RE;
    }
}
