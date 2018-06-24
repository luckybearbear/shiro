package com.zj.service.impl;

import com.zj.dao.mapper.authority.SysPermissionMapper;
import com.zj.dao.mapper.authority.SysPermissionMapperCustom;
import com.zj.dao.mapper.authority.SysUserMapper;
import com.zj.entity.authority.SysPermission;
import com.zj.entity.authority.SysPermissionExample;
import com.zj.entity.authority.SysUser;
import com.zj.entity.authority.SysUserExample;
import com.zj.service.SysService;
import com.zj.util.CollectionsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created on 2016年9月6日 
 *
 * 认证和授权的服务接口
 *
 * @author  megagao
 * @version  0.0.1
 */
@Service
public class SysServiceImpl implements SysService {
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysPermissionMapperCustom sysPermissionMapperCustom;
	
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	
	@Override
	public List<SysPermission> findMenuListByUserId(String userId) throws Exception {
		return sysPermissionMapperCustom.findMenuListByUserId(userId);
	}

	@Override
	public List<SysPermission> findPermissionListByUserId(String userId) throws Exception {
		
		String permission = this.sysPermissionMapperCustom.findPermissionByUserId(userId);
		if(permission != null){
			String[] permissionIds = permission.split(",");
			List<Long> ids = CollectionsFactory.newArrayList();
			for(int i=0;i<permissionIds.length;i++){
				ids.add(Long.valueOf(permissionIds[i]));
			}
			SysPermissionExample example = new SysPermissionExample();
			SysPermissionExample.Criteria criteria = example.createCriteria();
			criteria.andIdIn(ids);
			return sysPermissionMapper.selectByExample(example);
		}
		return null;
	}

	@Override
	public SysUser getSysUserByName(String username) throws Exception {
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		
		List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
		
		if(list!=null && list.size()==1){
			return list.get(0);
		}	
		return null;
	}
}
