package www.silver.hom;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import www.silver.service.IF_NoticeBoardService;
import www.silver.vo.UserVO;

@Controller
public class NoticeBoardController {
	
	@Inject
	IF_NoticeBoardService noticeBoardService;
	
	@GetMapping(value="noticeWindow")
	public String noticeWindow(ArrayList<UserVO> userData, Model model) throws Exception {
		// Controller > service > dao > mapper 
		// 전체 게시글을 가져오는 작업이 필요
		model.addAttribute("userData",userData);
		return "noticeBoard/homeNotice";
	}
	@GetMapping(value="addNoticeWindow")
	public String addNoticeWindow() throws Exception {
		return "noticeBoard/homeAddNotice";
	}
	
	
	@PostMapping(value="addNotice")
	public String addNotice(@ModelAttribute UserVO userVO) throws Exception {
		noticeBoardService.addNotice(userVO);
		System.out.println(userVO.toString());
		return "noticeBoard/homeNotice";
	}
}
