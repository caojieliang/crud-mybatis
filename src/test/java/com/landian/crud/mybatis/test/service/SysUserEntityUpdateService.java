package com.landian.crud.mybatis.test.service;

import com.landian.crud.core.service.AbstractUpdateService;
import com.landian.crud.mybatis.test.entity.SysUserEntity;
import com.landian.crud.mybatis.test.mapperContext.SysUserEntityContext;
import com.landian.sql.jpa.context.BeanContext;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class SysUserEntityUpdateService extends AbstractUpdateService<SysUserEntity> {

    @Override
    public BeanContext getBeanContext() {
        return SysUserEntityContext.beanContext;
    }

}
