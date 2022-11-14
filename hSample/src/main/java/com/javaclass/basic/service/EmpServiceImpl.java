package com.javaclass.basic.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.basic.dao.EmpDAO;
import com.javaclass.basic.domain.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDAO empDAO;
	
	@Override
	public List<EmpVO> empSelect() {
		
		return empDAO.empSelect();
	}

	@Override
	public List<HashMap> empDept() {
		return empDAO.empDept();
	}

}
