package content_mgmt.content_master_mgmt.model.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import content_mgmt.content_master_mgmt.model.master.LMSContentMaster;

@Repository("contentMasterRepo")
public interface LMSContentMasterRepo extends CrudRepository<LMSContentMaster, Long> 
{
	@Query(value = "SELECT * FROM LMS_CONTENT_MASTER a WHERE a.content_seq_no in :ids order by content_seq_no", nativeQuery = true)
	ArrayList<LMSContentMaster> getSelectLMSContent(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM LMS_CONTENT_MASTER a WHERE a.content_category_seq_no in :ids order by content_seq_no", nativeQuery = true)
	ArrayList<LMSContentMaster> getSelectLMSContentByCategories(@Param("ids") ArrayList<BigDecimal> ids);
	
	@Query(value = "DELETE FROM LMS_CONTENT_MASTER WHERE a.content_seq_no in :ids", nativeQuery = true)
	void delSelectLMSContent(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM LMS_CONTENT_MASTER WHERE a.content_category_seq_no in :ids", nativeQuery = true)
	void delSelectLMSContentByCategories(@Param("ids") ArrayList<BigDecimal> ids);
	
}
