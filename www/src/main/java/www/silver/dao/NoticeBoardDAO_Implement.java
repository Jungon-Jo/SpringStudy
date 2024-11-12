package www.silver.dao;

import java.util.List;

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
	public void insertNotice(UserVO userVO) throws Exception {
		// SqlSession을 통해서 mapper와 매핑하기 위해 정보를 넘겨준다.
		System.out.println(userVO.toString()); 
		sqlSession.insert(mapperQuery+".insertNotice",userVO);
	}

	@Override
	public List<UserVO> selectAll() throws Exception {
		return sqlSession.selectList(mapperQuery+".selectAll");
	}

	@Override
	public void deleteNotice(int noticeNumber) throws Exception {
		sqlSession.insert(mapperQuery+".deleteNotice",noticeNumber);
	}

}
