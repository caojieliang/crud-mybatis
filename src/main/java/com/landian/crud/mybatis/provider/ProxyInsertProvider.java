package com.landian.crud.mybatis.provider;

import com.landian.crud.core.provider.ProviderConstant;
import com.landian.crud.core.sql.ProxyInsertSQLBuilder;
import com.landian.sql.builder.SqlBuilder;
import com.landian.sql.jpa.context.BeanContext;
import org.apache.log4j.Logger;

import java.util.Map;


public class ProxyInsertProvider extends SqlBuilder{

	private static final Logger logger = Logger.getLogger(ProxyInsertProvider.class);

	public static final String insertWithId = "insertWithId";

	public void main(String[] args) {
		BEGIN();
		INSERT_INTO("tableA");
		VALUES("columnA", "#{" + "aa" + "}"); //好像不需要类型与能成功
		String sql = SQL();
		System.out.println(sql);
	}

	public String insert(Map<String, Object> parameters){
		try {
			Object bean = parameters.get(ProviderConstant.bean);
			BeanContext beanContext = (BeanContext) parameters.get(ProviderConstant.beanContext);
			return ProxyInsertSQLBuilder.insertSQL(bean,beanContext);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public String insertWithId(Map<String, Object> parameters){
		try {
			Object bean = parameters.get(ProviderConstant.bean);
			BeanContext beanContext = (BeanContext) parameters.get(ProviderConstant.beanContext);
			return ProxyInsertSQLBuilder.insertWithIdSQL(bean,beanContext);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
