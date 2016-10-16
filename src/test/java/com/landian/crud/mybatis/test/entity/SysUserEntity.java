package com.landian.crud.mybatis.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysUserEntity {

    /**
     * ID
     */
    private Integer id;
    /**
     * loginName
     */
    private String loginName;
    /**
     * userName
     */
    private String userName;


}
