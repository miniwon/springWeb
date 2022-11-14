package com.javaclass.basic.service;

import java.util.HashMap;
import java.util.List;

import com.javaclass.basic.domain.EmpVO;

public interface EmpService {
	
	List<EmpVO> empSelect();
	List<HashMap> empDept();

}
