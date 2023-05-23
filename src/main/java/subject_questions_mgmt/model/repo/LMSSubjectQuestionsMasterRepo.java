package subject_questions_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import subject_questions_mgmt.model.master.LMSSubjectQuestionsMaster;

@Repository("subjectQuestionsMasterRepo")
public interface LMSSubjectQuestionsMasterRepo extends CrudRepository<LMSSubjectQuestionsMaster, Long> 
{
	@Query(value = "SELECT * FROM LMS_SUBJECT_QUESTIONS_MASTER a WHERE a.subject_seq_no in :ids order by subject_seq_no", nativeQuery = true)
	ArrayList<LMSSubjectQuestionsMaster> getSelectQuestionsForSubjects(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM LMS_SUBJECT_QUESTIONS_MASTER a WHERE ((a.subject_seq_no in :ids) and (a.complexity_seq_no in :cids)) order by subject_seq_no", nativeQuery = true)
	ArrayList<LMSSubjectQuestionsMaster> getSelectQuestionsForSubjectsByComplexities(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);
	
	@Query(value = "DELETE FROM LMS_SUBJECT_QUESTIONS_MASTER WHERE a.subject_seq_no in :ids", nativeQuery = true)
	void delSelectQuestionsForSubjects(@Param("ids") ArrayList<Long> ids);	
	
	@Query(value = "DELETE FROM LMS_SUBJECT_QUESTIONS_MASTER a WHERE ((a.subject_seq_no in :ids) and (a.complexity_seq_no in :cids))", nativeQuery = true)
	void delSelectQuestionsForSubjectsByComplexities(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);
	
	@Query(value = "select q_seq_no from LMS_SUBJECT_QUESTIONS_MASTER where upper(subjective) = 'Y' and Q_SEQ_NO in :idsLst", nativeQuery = true)
	ArrayList<Long> getSubjectiveInList(@Param("idsLst") ArrayList<Long> idsLst);
	
	@Query(value = "select q_seq_no from LMS_SUBJECT_QUESTIONS_MASTER where upper(subjective) <> 'Y' and Q_SEQ_NO in :idsLst", nativeQuery = true)
	ArrayList<Long> getObjectiveInList(@Param("idsLst") ArrayList<Long> idsLst);
}
