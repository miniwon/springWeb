package com.javaclass.basic.dao;

import java.util.HashMap;
import java.util.List;

import com.javaclass.basic.domain.EmpVO;

public interface EmpDAO {

	List<EmpVO> empSelect();
	
	List<HashMap> empDept();

}