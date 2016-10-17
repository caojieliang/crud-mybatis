package com.landian.crud.mybatis.dao;

import com.landian.crud.core.dao.ProxyDao;
import com.landian.crud.core.dao.SQLPageUtils;
import com.landian.crud.mybatis.mapper.MybatisDao;
import com.landian.sql.jpa.context.IdContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProxyDaoMybatis implements ProxyDao {

    @Autowired
    private MybatisDao mybatisDao;

    @Override
    public int doInsert(String sql) {
        return mybatisDao.doInsert(sql);
    }

    public int doInsertWidthId(String sql) {
        return mybatisDao.doInsert(sql);
    }

    @Override
    public Object doInsertAndReturnId(String sql) {
        IdContainer idContainer = new IdContainer();
        mybatisDao.doInsertAndReturnId(sql,idContainer);
        return idContainer.getId();
    }

    @Override
    public int doUpdate(String sql) {
        return mybatisDao.doUpdate(sql);
    }

    @Override
    public List<Map<String, Object>> doFind(String sql) {
        List<Map<String, Object>> mapList = mybatisDao.doFind(sql);
        return mapList;
    }

    @Override
    public List<Map<String, Object>> doFindPage(String sql, int start, int pageSize) {
        String sqlTarget = SQLPageUtils.appendLimit(sql, start, pageSize);
        return doFind(sqlTarget);
    }

    @Override
    public int doDelete(String sql) {
        return mybatisDao.doDelete(sql);
    }

    @Override
    public List<Long> queryAsLongValue(String sql) {
        return mybatisDao.queryAsLongValue(sql);
    }

    @Override
    public List<Integer> queryAsIntValue(String sql) {
        return mybatisDao.queryAsIntValue(sql);
    }
}
