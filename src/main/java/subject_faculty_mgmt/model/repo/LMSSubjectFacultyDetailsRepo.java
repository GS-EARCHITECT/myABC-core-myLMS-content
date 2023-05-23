package subject_faculty_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import subject_faculty_mgmt.model.master.LMSSubjectFacultyDetails;
import subject_faculty_mgmt.model.master.LMSSubjectFacultyDetailsPK;

@Repository("subjectFacultyDetailsRepo")
public interface LMSSubjectFacultyDetailsRepo extends CrudRepository<LMSSubjectFacultyDetails, LMSSubjectFacultyDetailsPK> 
{
	@Query(value = "SELECT * FROM LMS_SUBJECT_FACULTY_DETAILS a WHERE a.SUBJECT_SEQ_NO in :ids order by subject_seq_no", nativeQuery = true)
	ArrayList<LMSSubjectFacultyDetails> getSelectSubjects(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM LMS_SUBJECT_FACULTY_DETAILS a WHERE a.faculty_SEQ_NO in :ids order by subject_seq_no", nativeQuery = true)
	ArrayList<LMSSubjectFacultyDetails> getSelectSubjectsByFaculties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_SUBJECT_FACULTY_DETAILS WHERE a.faculty_seq_no in :ids", nativeQuery = true)
	void delSelectLMSSubjectByFaculties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_SUBJECT_FACULTY_DETAILS WHERE a.subject_seq_no in :ids", nativeQuery = true)
	void delSelectLMSSubjects(@Param("ids") ArrayList<Long> ids);

}
