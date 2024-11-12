package www.silver.hom;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import www.silver.service.IF_NoticeBoardService;
import www.silver.vo.UserVO;

@Controller
public class NoticeBoardController {
	
	@Inject
	IF_NoticeBoardService noticeBoardService;
	
	@GetMapping(value="noticeWindow")
	public String noticeWindow(Model model) throws Exception {
		// Controller > service > dao > mapper 
		// 전체 게시글을 가져오는 작업이 필요
		
		// 서비스 Layer에 전체글 서비스를 요청하고 결과를 리턴
		List<UserVO> noticeList = noticeBoardService.showAllNotice();
		// 리턴받은 ArrayList변수의 값을 모델 객체로 뷰에게 전송하는 코드
		model.addAttribute("allNotice",noticeList);
		// 뷰를 지정
		
		System.out.println(noticeList.size()+"건 가져욤");
		return "noticeBoard/homeNotice";
	}
	
	@GetMapping(value="addNoticeWindow")
	public String addNoticeWindow() throws Exception {
		return "noticeBoard/homeAddNotice";
	}
	
	@GetMapping(value="deleteNotice")
	public String deleteNotice(@RequestParam("noticeNumber") int noticeNumber) throws Exception {
		noticeBoardService.deleteNotice(noticeNumber);
		return "redirect:noticeWindow";
	}
	
	@PostMapping(value="addNotice")
	public String addNotice(@ModelAttribute UserVO userVO) throws Exception {
		noticeBoardService.addNotice(userVO);
		System.out.println(userVO.toString());
		return "redirect:noticeWindow";
	}
}
