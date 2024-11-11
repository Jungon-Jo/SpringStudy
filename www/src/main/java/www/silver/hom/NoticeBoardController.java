package www.silver.hom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeBoardController {
	@GetMapping(value="noticeWindow")
	public String noticeBoard() throws Exception {
		// Controller > service > dao > mapper 
		// 전체 게시글을 가져오는 작업이 필요
		return "noticeBoard/homeNotice";
	}
	@GetMapping(value="addNoticeWindow")
	public String addNoticeBoard() throws Exception {
		return "noticeBoard/homeAddNotice";
	}
}
