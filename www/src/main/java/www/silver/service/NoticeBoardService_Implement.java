package www.silver.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import www.silver.dao.IF_NoticeBoardDAO;
import www.silver.util.FileDataUtil;
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
		
		// 첨부파일이 있다면 첨부파일을 kboard_attach에 저장해라
		String[] fname = userVO.getFileName();
		if(fname.length <= 1) {
			// kboard_attach 테이블에 저장하는 코드
			for(int i = 0; i < fname.length; i++) {
				noticeBoardDAO.insertNotice(fname[i]);
			}
		}
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

	@Override
	public UserVO getNotice(int noticeNumber) throws Exception {
		userVO.insertNotice(userVO);
		String[] fname = userVO.getFilename();
		for(int i = 0; i < fname.length; i++) {
			if(fname[i] != null) {
				noticeBoardDAO.insertAttach(fname[i]);
		}
		return null;
	}

	@Override
	public List<String> detailNotice(int noticeNumber) throws Exception {
		noticeBoardDAO.detailNotice(noticeNumber);
		return null;
	}
	
}
