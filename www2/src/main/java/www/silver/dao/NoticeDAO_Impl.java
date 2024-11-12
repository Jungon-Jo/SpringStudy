package www.silver.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import www.silver.vo.NoticeVO;

@Repository
public class NoticeDAO_Impl implements IF_NoticeDAO {

	final private String mapperQuery = "www.silver.dao.IF_NoticeDAO";
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<NoticeVO> selectAll() throws Exception {
		return sqlSession.selectList(mapperQuery+".selectAll");
	}
	
}
