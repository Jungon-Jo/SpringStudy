package www.silver.dao;

import java.util.List;

import www.silver.vo.PageVO;
import www.silver.vo.UserVO;

public interface IF_NoticeBoardDAO {
	public void insertNotice(UserVO userVO) throws Exception;
	// DB 작업 목적
	// Mybatis mapper랑 매핑해서 DB 작업 수행
	
	public List<UserVO> selectAll(PageVO pageVO) throws Exception;
	public void deleteNotice(int noticeNumber) throws Exception;
	public UserVO selectOne(int noticeNumber) throws Exception;
	public void updateNotice(UserVO userVO) throws Exception;
	public int totalCountNotice() throws Exception;
	public void insertAttach(int noticeNumber) throws Exception;
	public List<String> selectAllAttach(int noticeNumber) throws Exception;
}
