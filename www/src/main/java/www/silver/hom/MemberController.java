package www.silver.hom;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import www.silver.service.IF_MemberService;
import www.silver.vo.MemberVO;

@Controller
public class MemberController {
	// 서비스 로직을 실행 할 수 있는 변수 선언
	// 선언 시 객체의 주소가 필요하지만, Spring에서는 객체의 주소를 주입(annotation)받으므로, 별도의 생성이 필요 없다.
	@Inject // 주입 받기 위해서는 아래의 객체가 컨트롤러에 있어야 한다.
	IF_MemberService memberService;
	
	@PostMapping(value = "join")
	public String join(@ModelAttribute MemberVO memberVO) throws Exception {
		memberService.join(memberVO);
		System.out.println(memberVO.toString());
		return "home";
	}
}
