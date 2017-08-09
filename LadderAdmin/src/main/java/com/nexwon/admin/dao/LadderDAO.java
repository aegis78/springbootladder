package com.nexwon.admin.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LadderDAO {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSession sqlSession;
	
	public String getCurrentDateTime() {
        return sqlSession.selectOne("ladder.getCurrentDateTime");
    }
	

}
