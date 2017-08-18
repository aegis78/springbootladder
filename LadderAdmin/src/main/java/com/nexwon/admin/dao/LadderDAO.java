package com.nexwon.admin.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nexwon.admin.vo.LadderVO;
import com.nexwon.admin.vo.ParamVO;


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
	
	
	public int getLadderListCount(ParamVO paramVO) {		
    		return sqlSession.selectOne("ladder.ladderListCount", paramVO);
    }
	
	public int insertLadder(LadderVO ladderVo) {
		return sqlSession.insert("ladder.insertExcel", ladderVo);	
	}
	
	public int deleteData(ParamVO paramVo) {
		return sqlSession.delete("ladder.deleteData", paramVo);
	}
	
	public int updateData(LadderVO ladderVo) {
		return sqlSession.update("ladder.updateData", ladderVo);
	}
}
