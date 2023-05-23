package media_author_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import media_author_mgmt.model.master.LMSMediaAuthorDetail;
import media_author_mgmt.model.master.LMSMediaAuthorDetailPK;

@Repository("mediaAuthorDetailRepo")
public interface LMSMediaAuthorDetailRepo extends CrudRepository<LMSMediaAuthorDetail, LMSMediaAuthorDetailPK> 
{
	@Query(value = "SELECT * FROM LMS_MEDIA_AUTHOR_MASTER a WHERE a.person_seq_no in :ids order by media_type_seq_no", nativeQuery = true)
	ArrayList<LMSMediaAuthorDetail> getSelectLMSMediaByAuthors(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM LMS_MEDIA_AUTHOR_MASTER a WHERE a.media_seq_no in :ids order by media_type_seq_no", nativeQuery = true)
	ArrayList<LMSMediaAuthorDetail> getSelectLMSMedia(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_MEDIA_AUTHOR_MASTER WHERE a.person_seq_no in :ids", nativeQuery = true)
	void delSelectLMSMediaByAuthors(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_MEDIA_AUTHOR_MASTER a WHERE a.media_seq_no in :ids", nativeQuery = true)
	void delSelectLMSMedia(@Param("ids") ArrayList<Long> ids);
}
