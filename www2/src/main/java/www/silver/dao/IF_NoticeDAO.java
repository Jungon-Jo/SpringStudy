package www.silver.dao;

import java.util.List;

import www.silver.vo.NoticeVO;

public interface IF_NoticeDAO {
	public List<NoticeVO> selectAll() throws Exception;
}
