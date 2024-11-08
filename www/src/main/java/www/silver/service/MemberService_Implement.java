package www.silver.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import www.silver.dao.IF_MemberDAO;
import www.silver.vo.MemberVO;

@Service // 해당 클래스를 객체로 생성하라는 의미
public class MemberService_Implement implements IF_MemberService {
	
	@Inject // 인터페이스로 객체를 선언하게 되면, 구현받은 모든 class를 모두 사용할 수 있다.
	IF_MemberDAO memberDAO;
	
	@Override
	public void join(MemberVO memberVO) throws Exception {
		
		System.out.println("join 서비스");
		// dao에게 작업 지시해야 한다.
		// 실제 데이터를 저장하도록 지시한다.
		memberDAO.insertOne(memberVO);
	}
}
