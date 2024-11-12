package www.silver.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import www.silver.dao.NoticeDAO_Impl;
import www.silver.vo.NoticeVO;

@Service
public class NoticeService_Impl implements IF_NoticeService{

	@Inject
	NoticeDAO_Impl noticeDAO;
	
	@Override
	public List<NoticeVO> viewNotice() throws Exception {
		List<NoticeVO> noticeList = noticeDAO.selectAll();
		System.out.println(noticeList.size()+"건 발생");
		return noticeList;
	}

}
