package com.landian.crud.mybatis.provider;

import com.landian.crud.core.provider.ProviderConstant;
import com.landian.crud.core.sql.UpdateSQLBuilder;
import com.landian.sql.builder.SqlBuilder;
import com.landian.sql.jpa.context.BeanContext;
import org.apache.log4j.Logger;

import java.util.Map;

public class ProxyUpdateProvider extends SqlBuilder {
	
	private static final Logger logger = Logger.getLogger(ProxyUpdateProvider.class);

	public static final String updateNotNull = "updateNotNull";

	public String updateNotNull(Map<String, Object> parameters){
		try {
			Object bean = parameters.get(ProviderConstant.bean);
			BeanContext beanContext = (BeanContext) parameters.get(ProviderConstant.beanContext);
			return UpdateSQLBuilder.updateNotNull(bean,beanContext);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
