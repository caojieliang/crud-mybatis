package com.landian.crud.mybatis.test.main;

import com.landian.crud.mybatis.test.entity.SysUserEntity;
import com.landian.crud.mybatis.test.service.SysUserEntityQueryService;
import com.landian.crud.mybatis.test.service.SysUserEntityUpdateService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 */
public class CrudMybatisInActionTest extends BaseServiceTest {

    private static final Logger logger = Logger.getLogger(CrudMybatisInActionTest.class);

    @Autowired
    private SysUserEntityQueryService sysUserEntityQueryService;
    @Autowired
    private SysUserEntityUpdateService sysUserEntityUpdateService;

    @Test
    public void testIntegration(){
        logger.info(sysUserEntityQueryService);
    }

    @Test
    public void queryBeanAll(){
        List<SysUserEntity> sysUserEntities = sysUserEntityQueryService.queryBeanAll();
        logger.info(sysUserEntities);
    }

    @Test
    public void save(){
        SysUserEntity sysUserEntity = SysUserEntity.builder().userName("A").loginName("李").build();
        SysUserEntity save = sysUserEntityUpdateService.save(sysUserEntity);
        logger.info(save);
    }



}
