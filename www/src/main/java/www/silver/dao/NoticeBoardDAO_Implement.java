package www.silver.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import www.silver.vo.PageVO;
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
		sqlSession.insert(mapperQuery+".insertAttach",userVO);
	}

	@Override
	public List<UserVO> selectAll(PageVO pageVO) throws Exception {
		return sqlSession.selectList(mapperQuery+".selectAll",pageVO);
	}

	@Override
	public void deleteNotice(int noticeNumber) throws Exception {
		sqlSession.insert(mapperQuery+".deleteNotice",noticeNumber);
	}

	@Override
	public UserVO selectOne(int noticeNumber) throws Exception {
		
		return sqlSession.selectOne(mapperQuery+".selectOne",noticeNumber);
	}

	@Override
	public void updateNotice(UserVO userVO) throws Exception {
//		userVO.setSequence(noticeNumber);
//		System.out.println(userVO.toString());
		sqlSession.update(mapperQuery+".updateNotice", userVO);
		
	}

	@Override
	public int totalCountNotice() throws Exception {
		return sqlSession.selectOne(mapperQuery+".allCountNotice");
	}

	@Override
	public void insertAttach(int noticeNumber) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> selectAllAttach(int noticeNumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
