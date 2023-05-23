package media_category_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import media_category_mgmt.model.dto.LMSMediaCategoryMasterDTO;
import media_category_mgmt.model.master.LMSMediaCategoryMaster;
import media_category_mgmt.model.repo.LMSMediaCategoryMasterRepo;

@Service("mediaCategoryMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSMediaCategoryMasterService implements I_LMSMediaCategoryMasterService {

	@Autowired
	private LMSMediaCategoryMasterRepo mediaCategoryMasterRepo;

	public LMSMediaCategoryMasterDTO newLMSMediaCategoryMaster(LMSMediaCategoryMasterDTO lMaster) 
	{
		LMSMediaCategoryMaster lmsMediaCategoryMaster = mediaCategoryMasterRepo.save(this.setLMSMediaCategoryMaster(lMaster));
		lMaster = getLMSMediaCategoryMasterDTO(lmsMediaCategoryMaster);
		return lMaster;
	}
	
	public ArrayList<LMSMediaCategoryMasterDTO> getAllLMSMediaCategoryMasters() {
		ArrayList<LMSMediaCategoryMaster> mediaCategoryList = (ArrayList<LMSMediaCategoryMaster>) mediaCategoryMasterRepo
				.findAll();
		ArrayList<LMSMediaCategoryMasterDTO> lMasterss = new ArrayList<LMSMediaCategoryMasterDTO>();
		lMasterss = mediaCategoryList != null ? this.getLMSMediaCategoryMasterDTOs(mediaCategoryList) : null;
		return lMasterss;
	}

	public ArrayList<LMSMediaCategoryMasterDTO> getSelectLMSMediaCategories(ArrayList<BigDecimal> ids) {
		ArrayList<LMSMediaCategoryMaster> lMasters = mediaCategoryMasterRepo.getSelectLMSMediaCategories(ids);
		ArrayList<LMSMediaCategoryMasterDTO> LMSMediaCategoryMasterDTOs = new ArrayList<LMSMediaCategoryMasterDTO>();
		LMSMediaCategoryMasterDTO LMSMediaCategoryMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSMediaCategoryMasterDTO = this.getLMSMediaCategoryMasterDTO(lMasters.get(i));
				LMSMediaCategoryMasterDTOs.add(LMSMediaCategoryMasterDTO);
			}
		}
		return LMSMediaCategoryMasterDTOs;
	}

	public LMSMediaCategoryMasterDTO getLMSMediaCategoryMasterById(BigDecimal mediaCategorySeqNo) 
	{
		Optional<LMSMediaCategoryMaster> LMSMediaCategoryMaster = mediaCategoryMasterRepo.findById(mediaCategorySeqNo);
		LMSMediaCategoryMasterDTO lMasters = null;
		
		if (LMSMediaCategoryMaster.isPresent()) {
			lMasters = LMSMediaCategoryMaster != null ? this.getLMSMediaCategoryMasterDTO(LMSMediaCategoryMaster.get())
					: null;
		}
		return lMasters;
	}
	
	public void updLMSMediaCategoryMaster(LMSMediaCategoryMasterDTO lmsMediaCategoryMasterDTO) 
	{
		LMSMediaCategoryMaster lmsMediaCategoryMaster = null;

		if (mediaCategoryMasterRepo.existsById(lmsMediaCategoryMasterDTO.getMediaCategorySeqNo())) 
		{
			lmsMediaCategoryMaster = this.setLMSMediaCategoryMaster(lmsMediaCategoryMasterDTO);
			mediaCategoryMasterRepo.save(lmsMediaCategoryMaster);
		}
		return;
	}

	public void delLMSMediaCategoryMaster(BigDecimal mediaCategorySeqNo) 
	{
		if (mediaCategoryMasterRepo.existsById(mediaCategorySeqNo)) 
		{
			mediaCategoryMasterRepo.deleteById(mediaCategorySeqNo);
		}
		return;
	}

	public void delSelectLMSMediaCategories(ArrayList<BigDecimal> ids) {
		mediaCategoryMasterRepo.delSelectLMSMediaCategories(ids);
		return;
	}

	public void delAllLMSMediaCategoryMasters() {
		mediaCategoryMasterRepo.deleteAll();
	}

	private ArrayList<LMSMediaCategoryMasterDTO> getLMSMediaCategoryMasterDTOs(
			ArrayList<LMSMediaCategoryMaster> lMasters) {
		LMSMediaCategoryMasterDTO lDTO = null;
		ArrayList<LMSMediaCategoryMasterDTO> lMasterDTOs = new ArrayList<LMSMediaCategoryMasterDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSMediaCategoryMasterDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSMediaCategoryMasterDTO getLMSMediaCategoryMasterDTO(LMSMediaCategoryMaster lmsMediaCategoryMaster) 
	{
		LMSMediaCategoryMasterDTO lDTO = new LMSMediaCategoryMasterDTO();
		lDTO.setMediaCategorySeqNo(lmsMediaCategoryMaster.getMediaCategorySeqNo());
		lDTO.setMediaCategory(lmsMediaCategoryMaster.getMediaCategory());
		lDTO.setProgramSeqNo(lmsMediaCategoryMaster.getProgramSeqNo());		
		return lDTO;
	}

	private LMSMediaCategoryMaster setLMSMediaCategoryMaster(LMSMediaCategoryMasterDTO lDTO) 
	{
		LMSMediaCategoryMaster lmsMediaCategoryMaster = new LMSMediaCategoryMaster();		
		lmsMediaCategoryMaster.setMediaCategory(lDTO.getMediaCategory());
		lmsMediaCategoryMaster.setProgramSeqNo(lDTO.getProgramSeqNo());	
		return lmsMediaCategoryMaster;
	}
}