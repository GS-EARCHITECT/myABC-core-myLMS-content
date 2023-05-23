package content_mgmt.content_media_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import content_mgmt.content_media_mgmt.model.master.LMSContentMediaDetail;
import content_mgmt.content_media_mgmt.model.master.LMSContentMediaDetailPK;

@Repository("contentMediaDetailRepo")
public interface LMSContentMediaDetailRepo extends CrudRepository<LMSContentMediaDetail, LMSContentMediaDetailPK> 
{
	@Query(value = "SELECT * FROM LMS_CONTENT_MEDIA_DETAILS a WHERE a.content_seq_no in :ids order by content_type_seq_no", nativeQuery = true)
	ArrayList<LMSContentMediaDetail> getSelectLMSContentDetails(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_CONTENT_MEDIA_DETAILS WHERE a.content_seq_no in :ids", nativeQuery = true)
	void delSelectLMSContentDetails(@Param("ids") ArrayList<Long> ids);
}
