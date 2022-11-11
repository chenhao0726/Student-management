package com.chen.service.impl;

import com.chen.dao.IGradeDao;
import com.chen.dao.impl.GradeDaoImpl;
import com.chen.domain.Grade;
import com.chen.service.IGradeService;

import java.util.List;

public class GradeServiceImpl implements IGradeService {
    private IGradeDao dao = new GradeDaoImpl();

    @Override
    public List<Grade> selectAll() {
        return dao.selectAll();
    }

    @Override
    public int saveClass(Grade grade) {
        return dao.saveClass(grade);
    }
}
