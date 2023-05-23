package subject_media_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import subject_media_mgmt.model.master.LMSSubjectMediaDetails;
import subject_media_mgmt.model.master.LMSSubjectMediaDetailsPK;

@Repository("subjectMediaDetailsRepo")
public interface LMSSubjectMediaDetailsRepo extends CrudRepository<LMSSubjectMediaDetails, LMSSubjectMediaDetailsPK> 
{
	@Query(value = "SELECT * FROM LMS_SUBJECT_CATEGORY_MASTER a WHERE a.subject_seq_no in :ids order by resource_seq_no", nativeQuery = true)
	ArrayList<LMSSubjectMediaDetails> getSelectLMSMediaBySubjects(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM LMS_SUBJECT_CATEGORY_MASTER a WHERE a.resource_seq_no in :ids order by subject_seq_no", nativeQuery = true)
	ArrayList<LMSSubjectMediaDetails> getSelectLMSSubjectsByMedia(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_SUBJECT_CATEGORY_MASTER WHERE a.subject_seq_no in :ids", nativeQuery = true)
	void delSelectLMSSubjects(@Param("ids") ArrayList<Long> ids);
}
