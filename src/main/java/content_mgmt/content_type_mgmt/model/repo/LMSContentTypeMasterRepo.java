package content_mgmt.content_type_mgmt.model.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import content_mgmt.content_type_mgmt.model.master.LMSContentTypeMaster;

@Repository("contentTypeMasterRepo")
public interface LMSContentTypeMasterRepo extends CrudRepository<LMSContentTypeMaster, BigDecimal> 
{
	@Query(value = "SELECT * FROM LMS_CONTENT_TYPE_MASTER a WHERE a.content_type_seq_no in :ids order by content_type_seq_no", nativeQuery = true)
	ArrayList<LMSContentTypeMaster> getSelectLMSContentTypes(@Param("ids") ArrayList<BigDecimal> ids);

	@Query(value = "DELETE FROM LMS_CONTENT_TYPE_MASTER WHERE a.content_type_seq_no in :ids", nativeQuery = true)
	void delSelectLMSContentTypes(@Param("ids") ArrayList<BigDecimal> ids);

}
