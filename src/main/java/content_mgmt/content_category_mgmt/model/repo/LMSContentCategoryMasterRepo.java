package content_mgmt.content_category_mgmt.model.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import content_mgmt.content_category_mgmt.model.master.LMSContentCategoryMaster;
import content_mgmt.content_category_mgmt.model.master.LMSContentCategoryMasterPK;

@Repository("contentCategoryMasterRepo")
public interface LMSContentCategoryMasterRepo extends CrudRepository<LMSContentCategoryMaster, LMSContentCategoryMasterPK> 
{
	@Query(value = "SELECT * FROM LMS_CONTENT_CATEGORY_MASTER a WHERE a.content_category_seq_no in :ids order by content_type_seq_no", nativeQuery = true)
	ArrayList<LMSContentCategoryMaster> getSelectLMSContentCategories(@Param("ids") ArrayList<BigDecimal> ids);

	@Query(value = "SELECT * FROM LMS_CONTENT_CATEGORY_MASTER a WHERE a.content_type_seq_no in :ids order by content_type_seq_no", nativeQuery = true)
	ArrayList<LMSContentCategoryMaster> getSelectLMSContentCategoriesForTypes(@Param("ids") ArrayList<BigDecimal> ids);
	
	@Query(value = "DELETE FROM LMS_CONTENT_CATEGORY_MASTER WHERE a.content_category_seq_no in :ids", nativeQuery = true)
	void delSelectLMSContentCategories(@Param("ids") ArrayList<BigDecimal> ids);

}
