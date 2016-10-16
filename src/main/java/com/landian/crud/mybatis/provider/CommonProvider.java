package com.landian.crud.mybatis.provider;

import com.landian.crud.core.provider.ProviderConstant;

import java.util.Map;


public class CommonProvider{

	public static final String doSQL = "doSQL";

	public String doSQL(Map<String, Object> parameters) throws Exception{
		String sql = (String) parameters.get(ProviderConstant.sql);
		return sql;
	}
}
