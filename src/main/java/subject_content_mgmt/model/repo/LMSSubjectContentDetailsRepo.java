package subject_content_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import subject_content_mgmt.model.master.LMSSubjectContentDetails;
import subject_content_mgmt.model.master.LMSSubjectContentDetailsPK;

@Repository("subjectContentDetailsRepo")
public interface LMSSubjectContentDetailsRepo extends CrudRepository<LMSSubjectContentDetails, LMSSubjectContentDetailsPK> 
{
	@Query(value = "SELECT * FROM LMS_SUBJECT_CONTENT_MASTER a WHERE a.SUBJECT_SEQ_NO in :ids order by subject_seq_no", nativeQuery = true)
	ArrayList<LMSSubjectContentDetails> getSelectSubjects(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM LMS_SUBJECT_CONTENT_MASTER WHERE a.subject_seq_no in :ids", nativeQuery = true)
	void delSelectLMSSubjectContent(@Param("ids") ArrayList<Long> ids);

}
