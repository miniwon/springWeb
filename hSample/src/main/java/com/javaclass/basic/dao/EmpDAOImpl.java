package com.javaclass.basic.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.basic.domain.EmpVO;

@Repository
public class EmpDAOImpl implements EmpDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSess;
	
	@Override
	public List<EmpVO> empSelect(){
		// 하나만 가져올 때는 selectone / 여러 개 가져올 때는 selectList
		// 입력매개변수: Mapper이름.select태그의id값
		return sqlSess.selectList("EmpDao.empSelect");
	}

	@Override
	public List<HashMap> empDept() {
		return sqlSess.selectList("EmpDao.empDept");
	}
}
