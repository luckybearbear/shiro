package com.zj.service;


import com.zj.entity.authority.SysPermission;
import com.zj.entity.authority.SysUser;

import java.util.List;

/**
 * created on 2016年9月6日 
 *
 * 认证授权服务接口
 *
 * @author  megagao
 * @version  0.0.1
 */
public interface SysService {
	SysUser getSysUserByName(String username)throws Exception;

	List<SysPermission> findMenuListByUserId(String userId) throws Exception;

	List<SysPermission> findPermissionListByUserId(String userId) throws Exception;
}
