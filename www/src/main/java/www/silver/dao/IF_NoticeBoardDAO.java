package www.silver.dao;

import www.silver.vo.UserVO;

public interface IF_NoticeBoardDAO {
	public void insertBoard(UserVO userVO) throws Exception;
	// DB 작업 목적
	// Mybatis mapper랑 매핑해서 DB 작업 수행
}
