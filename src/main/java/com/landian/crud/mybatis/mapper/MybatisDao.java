package com.landian.crud.mybatis.mapper;

import com.landian.crud.core.provider.ProviderConstant;
import com.landian.crud.mybatis.provider.CommonProvider;
import com.landian.crud.mybatis.provider.ProxyInsertProvider;
import com.landian.crud.mybatis.provider.ProxyUpdateProvider;
import com.landian.sql.jpa.context.BeanContext;
import com.landian.sql.jpa.context.IdContainer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 代理版的单表通用增删改查v2.0 逐渐完善中
 * @author jie
 */
@Repository
public interface MybatisDao {

	@SelectProvider(type = CommonProvider.class, method = CommonProvider.doSQL)
	@ResultType(HashMap.class)
	List<HashMap<String, Object>> doFind(@Param(ProviderConstant.sql) String sql);


	@Options(useGeneratedKeys = true, keyProperty = ProviderConstant.idOGNL)
	@InsertProvider(type = ProxyInsertProvider.class, method = "insert")
	Integer insert2(@Param(ProviderConstant.bean) Object bean,
                       @Param(ProviderConstant.beanContext) BeanContext beanContext,
                       @Param(ProviderConstant.idContainer) IdContainer idContainer);

	@Options(useGeneratedKeys = true, keyProperty = ProviderConstant.idOGNL)
	@InsertProvider(type = CommonProvider.class, method = CommonProvider.doSQL)
	void doInsertAndReturnId(@Param(ProviderConstant.sql) String sql, @Param(ProviderConstant.idContainer) IdContainer idContainer);

	@InsertProvider(type = ProxyInsertProvider.class, method = ProxyInsertProvider.insertWithId)
	Integer insertWithId(@Param(ProviderConstant.bean) Object bean,
                            @Param(ProviderConstant.beanContext) BeanContext beanContext);

	@InsertProvider(type = CommonProvider.class, method = CommonProvider.doSQL)
	int doInsert(@Param(ProviderConstant.sql) String sql);

	@UpdateProvider(type = CommonProvider.class, method = CommonProvider.doSQL)
	int doUpdate(@Param(ProviderConstant.sql) String sql);

	@DeleteProvider(type = CommonProvider.class, method = CommonProvider.doSQL)
	int doDelete(@Param(ProviderConstant.sql) String sql);

	//感觉后期将这个方法对接到doUpdate好一点，面向对像，看时间了
	@UpdateProvider(type = ProxyUpdateProvider.class, method = ProxyUpdateProvider.updateNotNull)
	void updateNotNull2(@Param(ProviderConstant.bean) Object bean,
                        @Param(ProviderConstant.beanContext) BeanContext beanContext);

	@SelectProvider(type=CommonProvider.class, method=CommonProvider.doSQL)
	List<Long> queryAsLongValue(@Param(ProviderConstant.sql) String sql);

	@SelectProvider(type=CommonProvider.class, method=CommonProvider.doSQL)
	List<Integer> queryAsIntValue(@Param(ProviderConstant.sql) String sql);
}
