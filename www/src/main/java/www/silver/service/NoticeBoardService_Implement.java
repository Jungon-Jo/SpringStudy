package www.silver.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import www.silver.dao.IF_NoticeBoardDAO;
import www.silver.vo.PageVO;
import www.silver.vo.UserVO;

@Service
public class NoticeBoardService_Implement implements IF_NoticeBoardService {

	@Inject
	IF_NoticeBoardDAO noticeBoardDAO;
	
	@Override
	public void addNotice(UserVO userVO) throws Exception {
		if(userVO.getMemberonly() != null) {
			userVO.setMemberonly("공개");
		} else {
			userVO.setMemberonly("비공개");
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		noticeBoardDAO.insertNotice(userVO);
		// dao > mapper > DB insert
	}

	@Override
	public List<UserVO> showAllNotice(PageVO pageVO) throws Exception {
		List<UserVO> noticeList = noticeBoardDAO.selectAll(pageVO);
		// jstl로 해결하는게 더 효율적이다.
//		for(UserVO userVO : noticeList) {
//			String date = userVO.getIndate();
//			userVO.setIndate(date.substring(0,10));
//		}
		
		// 처리하다가 DB 작업 필요
		return noticeList;
	}

	@Override
	public void deleteNotice(int noticeNumber) throws Exception {
		
		noticeBoardDAO.deleteNotice(noticeNumber);
	}

	@Override
	public UserVO editNotice(int noticeNumber) throws Exception {
		
		return noticeBoardDAO.selectOne(noticeNumber);
	}

	@Override
	public void editNotice(UserVO userVO) throws Exception {
//		System.out.println(userVO.toString());
		if(userVO.getMemberonly() != null) {
			userVO.setMemberonly("공개");
		} else {
			userVO.setMemberonly("비공개");
		}
//		System.out.println(userVO.toString());
		noticeBoardDAO.updateNotice(userVO);
	}

	@Override
	public int totalCountNotice() throws Exception {
		
		return 0;
	}
	
}
