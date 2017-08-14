package com.nexwon.admin.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nexwon.admin.VO.LadderVO;
import com.nexwon.admin.VO.ParamVO;


@Repository
public class LadderDAO {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSession sqlSession;
	
	public String getCurrentDateTime() {
        return sqlSession.selectOne("ladder.getCurrentDateTime");
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<LadderVO> getLadderList(ParamVO paramVO) {		
    		return (ArrayList) sqlSession.selectList("ladder.ladderList", paramVO);
    }
	

}
