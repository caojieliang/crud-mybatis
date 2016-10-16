package com.landian.crud.mybatis.test.service;

import com.landian.crud.core.service.AbstractQueryService;
import com.landian.crud.mybatis.test.entity.SysUserEntity;
import com.landian.crud.mybatis.test.mapperContext.SysUserEntityContext;
import com.landian.sql.jpa.context.BeanContext;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class SysUserEntityQueryService extends AbstractQueryService<SysUserEntity> {

    @Override
    public BeanContext<SysUserEntity> getBeanContext() {
        return SysUserEntityContext.getBeanContext();
    }

}
