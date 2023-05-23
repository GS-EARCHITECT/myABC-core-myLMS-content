package media_category_mgmt.model.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import media_category_mgmt.model.master.LMSMediaCategoryMaster;

@Repository("mediaCategoryMasterRepo")
public interface LMSMediaCategoryMasterRepo extends CrudRepository<LMSMediaCategoryMaster, BigDecimal> 
{
	@Query(value = "SELECT * FROM LMS_MEDIA_CATEGORY_MASTER a WHERE a.media_category_seq_no in :ids order by media_type_seq_no", nativeQuery = true)
	ArrayList<LMSMediaCategoryMaster> getSelectLMSMediaCategories(@Param("ids") ArrayList<BigDecimal> ids);

	@Query(value = "DELETE FROM LMS_MEDIA_CATEGORY_MASTER WHERE a.media_category_seq_no in :ids", nativeQuery = true)
	void delSelectLMSMediaCategories(@Param("ids") ArrayList<BigDecimal> ids);
}
