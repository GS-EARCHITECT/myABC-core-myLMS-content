package media_mgmt.services;

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
import media_mgmt.model.dto.LMSMediaMasterDTO;
import media_mgmt.model.master.LMSMediaMaster;
import media_mgmt.model.repo.LMSMediaMasterRepo;

@Service("mediaMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSMediaMasterService implements I_LMSMediaMasterService {

	@Autowired
	private LMSMediaMasterRepo mediaMasterRepo;

	public LMSMediaMasterDTO newLMSMediaMaster(LMSMediaMasterDTO lMaster) 
	{
		LMSMediaMaster lmsMediaMaster = mediaMasterRepo.save(this.setLMSMediaMaster(lMaster));
		lMaster = getLMSMediaMasterDTO(lmsMediaMaster);
		return lMaster;
	}
	
	public ArrayList<LMSMediaMasterDTO> getAllLMSMediaMasters() {
		ArrayList<LMSMediaMaster> mediaList = (ArrayList<LMSMediaMaster>) mediaMasterRepo
				.findAll();
		ArrayList<LMSMediaMasterDTO> lMasterss = new ArrayList<LMSMediaMasterDTO>();
		lMasterss = mediaList != null ? this.getLMSMediaMasterDTOs(mediaList) : null;
		return lMasterss;
	}

	public ArrayList<LMSMediaMasterDTO> getSelectLMSMediaByCategories(ArrayList<BigDecimal> ids) 
	{
		ArrayList<LMSMediaMaster> lMasters = mediaMasterRepo.getSelectLMSMediabyCategories(ids);
		ArrayList<LMSMediaMasterDTO> LMSMediaMasterDTOs = new ArrayList<LMSMediaMasterDTO>();
		LMSMediaMasterDTO LMSMediaMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSMediaMasterDTO = this.getLMSMediaMasterDTO(lMasters.get(i));
				LMSMediaMasterDTOs.add(LMSMediaMasterDTO);
			}
		}
		return LMSMediaMasterDTOs;
	}

	public ArrayList<LMSMediaMasterDTO> getSelectLMSMedia(ArrayList<Long> ids) 
	{
		ArrayList<LMSMediaMaster> lMasters = mediaMasterRepo.getSelectLMSMedia(ids);
		ArrayList<LMSMediaMasterDTO> LMSMediaMasterDTOs = new ArrayList<LMSMediaMasterDTO>();
		LMSMediaMasterDTO LMSMediaMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSMediaMasterDTO = this.getLMSMediaMasterDTO(lMasters.get(i));
				LMSMediaMasterDTOs.add(LMSMediaMasterDTO);
			}
		}
		return LMSMediaMasterDTOs;
	}
	
	public LMSMediaMasterDTO getLMSMediaMasterById(Long mediaSeqNo) 
	{
		Optional<LMSMediaMaster> LMSMediaMaster = mediaMasterRepo.findById(mediaSeqNo);
		LMSMediaMasterDTO lMasters = null;
		
		if (LMSMediaMaster.isPresent()) {
			lMasters = LMSMediaMaster != null ? this.getLMSMediaMasterDTO(LMSMediaMaster.get())
					: null;
		}
		return lMasters;
	}
	
	public void updLMSMediaMaster(LMSMediaMasterDTO lmsMediaMasterDTO) 
	{
		LMSMediaMaster lmsMediaMaster = null;

		if (mediaMasterRepo.existsById(lmsMediaMasterDTO.getMediaSeqNo())) 
		{
			lmsMediaMaster = this.setLMSMediaMaster(lmsMediaMasterDTO);
			mediaMasterRepo.save(lmsMediaMaster);
		}
		return;
	}

	public void delLMSMedia(Long mediaSeqNo) 
	{
		if (mediaMasterRepo.existsById(mediaSeqNo)) 
		{
			mediaMasterRepo.deleteById(mediaSeqNo);
		}
		return;
	}

	public void delSelectLMSMedia(ArrayList<Long> ids) 
	{
		mediaMasterRepo.delSelectLMSMedia(ids);
		return;
	}
	
	public void delSelectLMSMediaByCategories(ArrayList<BigDecimal> ids)
	{
		mediaMasterRepo.delSelectLMSMediaByCategories(ids);
		return;
	}

	public void delAllLMSMediaMasters() {
		mediaMasterRepo.deleteAll();
	}

	private ArrayList<LMSMediaMasterDTO> getLMSMediaMasterDTOs(
			ArrayList<LMSMediaMaster> lMasters) {
		LMSMediaMasterDTO lDTO = null;
		ArrayList<LMSMediaMasterDTO> lMasterDTOs = new ArrayList<LMSMediaMasterDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSMediaMasterDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSMediaMasterDTO getLMSMediaMasterDTO(LMSMediaMaster lmsMediaMaster) 
	{
		LMSMediaMasterDTO lDTO = new LMSMediaMasterDTO();
		lDTO.setMediaSeqNo(lmsMediaMaster.getMediaSeqNo());
		lDTO.setMediaCategorySeqNo(lmsMediaMaster.getMediaCategorySeqNo());
		lDTO.setMediaName(lmsMediaMaster.getMediaName());
		lDTO.setMediaSummary(lmsMediaMaster.getMediaSummary());		
		lDTO.setSpecificationSeqNo(lmsMediaMaster.getSpecificationSeqNo());	
		return lDTO;
	}

	private LMSMediaMaster setLMSMediaMaster(LMSMediaMasterDTO lDTO) 
	{
		LMSMediaMaster lmsMediaMaster = new LMSMediaMaster();
		lmsMediaMaster.setMediaCategorySeqNo(lDTO.getMediaCategorySeqNo());
		lmsMediaMaster.setMediaName(lDTO.getMediaName());
		lmsMediaMaster.setMediaSummary(lDTO.getMediaSummary());		
		lmsMediaMaster.setSpecificationSeqNo(lDTO.getSpecificationSeqNo());	
		return lmsMediaMaster;
	}
}