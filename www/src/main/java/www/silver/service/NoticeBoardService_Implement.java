package www.silver.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import www.silver.dao.IF_NoticeBoardDAO;
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
		noticeBoardDAO.insertBoard(userVO);
		// dao > mapper > DB insert
	}
	
}
