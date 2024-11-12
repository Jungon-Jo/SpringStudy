package www.silver.hom;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import www.silver.service.IF_NoticeService;
import www.silver.vo.NoticeVO;

@Controller
public class PracticeController {
	
	@Inject
	IF_NoticeService NoticeService_Impl;
	
	@GetMapping(value="practice")
	public String window() throws Exception {
		return "practice/practice";
	}
	
	@GetMapping(value="noticeWindow")
	public String noticeWindow(Model model) throws Exception {
		List<NoticeVO> noticeList = NoticeService_Impl.viewNotice();
		model.addAttribute("noticeList", noticeList);
		return "practice/notice";
	}
}
