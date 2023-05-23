package subject_category_mgmt.model.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import subject_category_mgmt.model.master.LMSSubjectCategoryMaster;

@Repository("subjectCategoryMasterRepo")
public interface LMSSubjectCategoryMasterRepo extends CrudRepository<LMSSubjectCategoryMaster, BigDecimal> 
{
	@Query(value = "SELECT * FROM LMS_SUBJECT_CATEGORY_MASTER a WHERE a.subject_type_seq_no in :ids order by subject_category_seq_no", nativeQuery = true)
	ArrayList<LMSSubjectCategoryMaster> getSelectLMSSubjectTypes(@Param("ids") ArrayList<BigDecimal> ids);

	@Query(value = "SELECT * FROM LMS_SUBJECT_CATEGORY_MASTER a WHERE a.subject_category_seq_no in :ids order by subject_category_seq_no", nativeQuery = true)
	ArrayList<LMSSubjectCategoryMaster> getSelectLMSSubjectCategories(@Param("ids") ArrayList<BigDecimal> ids);
	
	@Query(value = "SELECT * FROM LMS_SUBJECT_CATEGORY_MASTER a WHERE a.PAR_CATEGORY_SEQ_NO in :ids order by subject_category_seq_no", nativeQuery = true)
	ArrayList<LMSSubjectCategoryMaster> getSelectSubjectCategoriesByParents(@Param("ids") ArrayList<BigDecimal> ids);

	@Query(value = "DELETE FROM LMS_SUBJECT_CATEGORY_MASTER WHERE a.subject_category_seq_no in :ids", nativeQuery = true)
	void delSelectLMSSubjectCategories(@Param("ids") ArrayList<BigDecimal> ids);

}
