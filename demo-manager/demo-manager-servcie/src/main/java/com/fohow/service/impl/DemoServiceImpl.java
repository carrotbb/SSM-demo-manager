package com.fohow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fohow.dao.QuartzConfigureMapper;
import com.fohow.entity.QuartzConfigure;
import com.fohow.entity.QuartzConfigureExample;
import com.fohow.entity.QuartzConfigureExample.Criteria;
import com.fohow.service.DemoService;
import com.fohow.util.BeanUtil;
import com.fohow.util.PagedResult;
import com.github.pagehelper.PageHelper;

@Service
public class DemoServiceImpl implements DemoService {
	
	@Autowired
	QuartzConfigureMapper quartzConfigureMapper;

	
	/**
	 * ��Ӕ���
	 */
	@Override
	@Transactional
	public void add(QuartzConfigure quartzConfigure) throws Exception{
		quartzConfigureMapper.insert(quartzConfigure);
	}

	
	/**
	 * �б���
	 */
	public PagedResult<QuartzConfigure> getPage(Integer pageNo, Integer pageSize,String taskName) throws Exception{
		QuartzConfigureExample example=new QuartzConfigureExample();
		example.setOrderByClause("update_time desc");
		Criteria  c=example.createCriteria();
		if(taskName!=null&&taskName!=""){
			c.andTaskNameEqualTo("taskName");
		}
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(quartzConfigureMapper.selectByExample(example));
	}

	/**
	 * ������
	 */
	@Override
	@Transactional
	public void update(QuartzConfigure quartzConfigure) throws Exception{
		quartzConfigureMapper.updateByPrimaryKey(quartzConfigure);
	}

	/**
	 * ����id�@ȡ����
	 */
	@Override
    public QuartzConfigure find(String id) throws Exception
    {
		QuartzConfigure  qc=quartzConfigureMapper.selectByPrimaryKey(id);
		return  qc;
    }

}
