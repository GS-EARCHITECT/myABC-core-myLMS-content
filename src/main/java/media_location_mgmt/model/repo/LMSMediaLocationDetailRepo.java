package media_location_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import media_location_mgmt.model.master.LMSMediaLocationDetail;
import media_location_mgmt.model.master.LMSMediaLocationDetailPK;

@Repository("mediaLocationDetailRepo")
public interface LMSMediaLocationDetailRepo extends CrudRepository<LMSMediaLocationDetail, LMSMediaLocationDetailPK> 
{
	@Query(value = "SELECT * FROM LMS_MEDIA_LOCATION_DETAILS a WHERE a.location_seq_no in :ids order by media_seq_no", nativeQuery = true)
	ArrayList<LMSMediaLocationDetail> getSelectLMSMediaByLocations(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM LMS_MEDIA_LOCATION_DETAILS a WHERE a.media_seq_no in :ids order by media_seq_no", nativeQuery = true)
	ArrayList<LMSMediaLocationDetail> getSelectLMSMedia(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_MEDIA_LOCATION_DETAILS WHERE a.location_seq_no in :ids", nativeQuery = true)
	void delSelectLMSMediaByLocations(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_MEDIA_LOCATION_DETAILS a WHERE a.media_seq_no in :ids", nativeQuery = true)
	void delSelectLMSMedia(@Param("ids") ArrayList<Long> ids);
}
