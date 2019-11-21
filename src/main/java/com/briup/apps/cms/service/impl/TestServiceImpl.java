package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Test;
import com.briup.apps.cms.bean.TestExample;
import com.briup.apps.cms.dao.TestMapper;
import com.briup.apps.cms.service.ITestService;
@Service
public class TestServiceImpl implements ITestService {
	@Resource
	private TestMapper testMapper;

	@Override
	public List<Test> findAll() {
		// TODO Auto-generated method stub
		TestExample example = new TestExample();
		
		return testMapper.selectByExample(example);
	}

	@Override
	public void saveOrUpdate(Test test) {
		// TODO Auto-generated method stub
		if(test.getId() != null) {
			testMapper.updateByPrimaryKey(test);
			
		}else {
			testMapper.insert(test);
		}
	}

}
