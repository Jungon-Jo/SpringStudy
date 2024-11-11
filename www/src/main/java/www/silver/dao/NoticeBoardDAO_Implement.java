package www.silver.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import www.silver.vo.UserVO;

@Repository
public class NoticeBoardDAO_Implement implements IF_NoticeBoardDAO{

	final private String mapperQuery="www.silver.dao.IF_NoticeBoardDAO";
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public void insertBoard(UserVO userVO) throws Exception {
		// SqlSession을 통해서 mapper와 매핑하기 위해 정보를 넘겨준다.
		System.out.println(userVO.toString()); 
		sqlSession.insert(mapperQuery+".insertBoard",userVO);
	}

}
