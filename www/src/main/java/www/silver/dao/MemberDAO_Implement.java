package www.silver.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import www.silver.vo.MemberVO;

@Repository
public class MemberDAO_Implement implements IF_MemberDAO {

	// sqlSession이 필요(선언) - mybatis에서 제공하는 객체
	// 주소가 옳바르게 주입되려면, root-context.xml 설정이 잘 되어 있어야 한다.
	@Inject
	SqlSession sqlSession;
	private static String mapperQuery="www.silver.dao.IF_MemberDAO";
	
	@Override
	public void insertOne(MemberVO memberVO) throws Exception {
		// sqlSessionTemplate 의 객체의 메서드를 call 하면 된다.
		// sqlSession.insert("mapper와 mapping 정보", "parameter 값");
		System.out.println(memberVO.toString());
		sqlSession.insert(mapperQuery+".insertOne",memberVO);
		// www.silver.dao.IF_memeberDAO.insertOne << 매핑의 정보
	}

}
