package www.silver.service;

import java.util.List;

import www.silver.vo.PageVO;
import www.silver.vo.UserVO;

public interface IF_NoticeBoardService {
	public void addNotice(UserVO userVO) throws Exception;
	public List<UserVO> showAllNotice(PageVO pageVO) throws Exception;
	// 의미 : 클라이언트의 글작성 요청을 처리하기 위한 서비스 정의
	// 서비스 정의 : 클라이언트가 요청한 전체목록보기 서비스를 정의
	public void deleteNotice(int noticeNumber) throws Exception;
	public UserVO editNotice(int noticeNumber) throws Exception;
	public void editNotice(UserVO userVO) throws Exception;
	public int totalCountNotice() throws Exception;
}
