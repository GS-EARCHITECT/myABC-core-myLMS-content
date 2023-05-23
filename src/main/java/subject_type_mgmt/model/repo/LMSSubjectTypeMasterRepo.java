package subject_type_mgmt.model.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import subject_type_mgmt.model.master.LMSSubjectTypeMaster;

@Repository("subjectTypeMasterRepo")
public interface LMSSubjectTypeMasterRepo extends CrudRepository<LMSSubjectTypeMaster, BigDecimal> 
{
	@Query(value = "SELECT * FROM LMS_SUBJECT_TYPE_MASTER a WHERE a.subject_type_seq_no in :ids order by subject_type_seq_no", nativeQuery = true)
	ArrayList<LMSSubjectTypeMaster> getSelectLMSSubjectTypes(@Param("ids") ArrayList<BigDecimal> ids);

	@Query(value = "SELECT * FROM LMS_SUBJECT_TYPE_MASTER a WHERE a.PAR_TYPE_SEQ_NO in :ids order by subject_type_seq_no", nativeQuery = true)
	ArrayList<LMSSubjectTypeMaster> getSelectSubjectTypesByParents(@Param("ids") ArrayList<BigDecimal> ids);

	@Query(value = "DELETE FROM LMS_SUBJECT_TYPE_MASTER WHERE a.subject_type_seq_no in :ids", nativeQuery = true)
	void delSelectLMSSubjectTypes(@Param("ids") ArrayList<BigDecimal> ids);

}
