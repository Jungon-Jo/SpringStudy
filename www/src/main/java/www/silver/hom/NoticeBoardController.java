package www.silver.hom;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import www.silver.service.IF_NoticeBoardService;
import www.silver.util.FileDataUtil;
import www.silver.vo.PageVO;
import www.silver.vo.UserVO;

@Controller
public class NoticeBoardController {
	
	@Inject
	IF_NoticeBoardService noticeBoardService;
	
	@Inject
	FileDataUtil fileDataUtil;
	
	@GetMapping(value="noticeWindow")
	public String noticeWindow(Model model, @ModelAttribute PageVO pageVO) throws Exception {
		if(pageVO.getPage()==null) {
			pageVO.setPage(1);
		}
		pageVO.setTotalCount(noticeBoardService.totalCountNotice());
		
		System.out.println(pageVO.getStartNo() + "시작 글 번호");
		System.out.println(pageVO.getEndNo() + "마지막 글 번호");
		System.out.println(pageVO.getStartPage() + "그룹 시작 페이지 번호");
		System.out.println(pageVO.getEndPage() + "그룹 마지막 페이지 번호");
		
		
		
		// Controller > service > dao > mapper 
		// 전체 게시글을 가져오는 작업이 필요
		
		// 서비스 Layer에 전체글 서비스를 요청하고 결과를 리턴
		List<UserVO> noticeList = noticeBoardService.showAllNotice(pageVO);
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
	public String addNotice(@ModelAttribute UserVO userVO, MultipartFile[] file) throws Exception {
		noticeBoardService.addNotice(userVO);
//		System.out.println(file.length);
//		for(int i = 0; i < file.length; i++) {
//			System.out.println(file[i].getOriginalFilename());
//		}
//		System.out.println(file.length);
//		System.out.println(userVO.toString());
		String[] newFileName = fileDataUtil.fileUpload(file);
		userVO.setFileName(newFileName);
		System.out.println(newFileName);
		return "redirect:noticeWindow";
	}
	
	@GetMapping(value="editNotice")
	public String editNotice(@RequestParam int noticeNumber, Model model) throws Exception {
		UserVO userVO = noticeBoardService.editNotice(noticeNumber);
		model.addAttribute("userVO",userVO);
		// sysout은 서버입장에서 부하가 걸리는 작업이므로, 실제로는 잘 사용하지 않는다.
		// 사용 후, 주석처리하거나 삭제하도록 한다.
		// test를 위해서는 junit test라는 도구를 사용한다.
		// 또, 기록을 남기기 위해서는 로그라는 기능을 사용한다.
		// 로그는 홈 컨트롤러에 가면 볼 수 있다.
//		System.out.println(userVO.getUsername());
		return "noticeBoard/homeEditNotice";
	}
	
	@PostMapping(value="editNotice")
	public String updateEditNotice(@ModelAttribute UserVO userVO, @RequestParam("noticeNumber") int noticeNumber) throws Exception {
		userVO.setSequence(noticeNumber);
		noticeBoardService.editNotice(userVO);
		return "redirect:noticeWindow";
	}
	
	@GetMapping(value="detailNotice")
	public String detailNotice(@RequestParam("noticeNumber") int noticeNumber, Model model) throws Exception {
		noticeBoardService.detailNotice(noticeNumber);
		
		return null;
	}
}
