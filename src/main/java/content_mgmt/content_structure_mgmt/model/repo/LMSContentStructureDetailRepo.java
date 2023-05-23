package content_mgmt.content_structure_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import content_mgmt.content_structure_mgmt.model.master.LMSContentStructureDetail;
import content_mgmt.content_structure_mgmt.model.master.LMSContentStructureDetailPK;

@Repository("contentStructureDetailRepo")
public interface LMSContentStructureDetailRepo extends CrudRepository<LMSContentStructureDetail, LMSContentStructureDetailPK> 
{
	@Query(value = "SELECT * FROM LMS_CONTENT_STRUCTURE_DETAILS a WHERE a.content_seq_no in :ids order by content_type_seq_no", nativeQuery = true)
	ArrayList<LMSContentStructureDetail> getSelectLMSContentDetails(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM LMS_CONTENT_STRUCTURE_DETAILS a WHERE a.par_content_seq_no in :ids order by content_type_seq_no", nativeQuery = true)
	ArrayList<LMSContentStructureDetail> getSelectLMSContentDetailsByParents(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_CONTENT_STRUCTURE_DETAILS WHERE a.content_seq_no in :ids", nativeQuery = true)
	void delSelectLMSContentDetails(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_CONTENT_STRUCTURE_DETAILS WHERE a.par_content_seq_no in :ids", nativeQuery = true)
	void delSelectLMSContentDetailsByParents(@Param("ids") ArrayList<Long> ids);
}
