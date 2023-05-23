package subject_mgmt.model.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import subject_category_mgmt.model.master.LMSSubjectCategoryMaster;
import subject_mgmt.model.master.LMSSubjectMaster;

@Repository("subjectMasterRepo")
public interface LMSSubjectMasterRepo extends CrudRepository<LMSSubjectMaster, Long> 
{
	
	@Query(value = "SELECT * FROM LMS_SUBJECT_MASTER a WHERE a.subject_category_seq_no in :ids order by subject_seq_no", nativeQuery = true)
	ArrayList<LMSSubjectMaster> getSelectLMSSubjectCategories(@Param("ids") ArrayList<BigDecimal> ids);

	@Query(value = "SELECT * FROM LMS_SUBJECT_MASTER a WHERE a.subject_seq_no in :ids order by subject_seq_no", nativeQuery = true)
	ArrayList<LMSSubjectMaster> getSelectLMSSubjects(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_SUBJECT_MASTER WHERE a.subject_seq_no in :ids", nativeQuery = true)
	void delSelectLMSSubjects(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM LMS_SUBJECT_MASTER WHERE a.subject_category_seq_no in :ids", nativeQuery = true)
	void delSelectLMSSubjectCategories(@Param("ids") ArrayList<BigDecimal> ids);	
}
