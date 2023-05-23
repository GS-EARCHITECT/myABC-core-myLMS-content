package media_mgmt.model.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import media_mgmt.model.master.LMSMediaMaster;

@Repository("mediaMasterRepo")
public interface LMSMediaMasterRepo extends CrudRepository<LMSMediaMaster, Long> 
{
	@Query(value = "SELECT * FROM LMS_MEDIA_MASTER a WHERE a.media_seq_no in :ids order by media_seq_no", nativeQuery = true)
	ArrayList<LMSMediaMaster> getSelectLMSMedia(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM LMS_MEDIA_MASTER a WHERE a.media_category_seq_no in :ids order by media_seq_no", nativeQuery = true)
	ArrayList<LMSMediaMaster> getSelectLMSMediabyCategories(@Param("ids") ArrayList<BigDecimal> ids);

	@Query(value = "DELETE FROM LMS_MEDIA_MASTER WHERE a.media_seq_no in :ids", nativeQuery = true)
	void delSelectLMSMedia(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_MEDIA_MASTER WHERE a.media_category_seq_no in :ids", nativeQuery = true)
	void delSelectLMSMediaByCategories(@Param("ids") ArrayList<BigDecimal> ids);
}
