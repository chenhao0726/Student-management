package com.chen.dao.impl;

import com.chen.dao.IGradeDao;
import com.chen.domain.Grade;
import com.chen.util.JdbcUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GradeDaoImpl implements IGradeDao {
    private static final String MYSQL = "com.chen.mapper.GradeMapper.";
    private static final int RE = -1;

    @Override
    public List<Grade> selectAll() {
        SqlSession session = JdbcUtil.getSession();
        List<Grade> grades = session.selectList(GradeDaoImpl.MYSQL + "selectAll");
        session.close();
        return grades;
    }

    @Override
    public int saveClass(Grade grade) {
        SqlSession session = JdbcUtil.getSession();
        try {
            int insert = session.insert(GradeDaoImpl.MYSQL + "saveClass", grade);
            session.commit();
            return insert;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return RE;
    }
}
