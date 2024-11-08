package www.silver.service;

import www.silver.vo.MemberVO;

public interface IF_MemberService {
	// 서비스 할 작업을 메서드로 정의
	// 컨트롤러가 조인 작업을 요청(이때 매개변수로 객체의 주소를 전달)
	public void join(MemberVO memberVO) throws Exception;
}
