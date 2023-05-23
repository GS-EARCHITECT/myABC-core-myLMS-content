package content_mgmt.content_master_mgmt.services;

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

import content_mgmt.content_master_mgmt.model.dto.LMSContentMasterDTO;
import content_mgmt.content_master_mgmt.model.master.LMSContentMaster;
import content_mgmt.content_master_mgmt.model.repo.LMSContentMasterRepo;

@Service("contentMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSContentMasterService implements I_LMSContentMasterService {

	@Autowired
	private LMSContentMasterRepo contentMasterRepo;

	public LMSContentMasterDTO newLMSContentMaster(LMSContentMasterDTO lMasters) {
		LMSContentMaster LMSContentMaster = contentMasterRepo.save(this.setLMSContentMaster(lMasters));
		lMasters = getLMSContentMasterDTO(LMSContentMaster);
		return lMasters;
	}

	public ArrayList<LMSContentMasterDTO> getAllLMSContentMasters() {
		ArrayList<LMSContentMaster> contentList = (ArrayList<LMSContentMaster>) contentMasterRepo
				.findAll();
		ArrayList<LMSContentMasterDTO> lMasterss = new ArrayList<LMSContentMasterDTO>();
		lMasterss = contentList != null ? this.getLMSContentMasterDTOs(contentList) : null;
		return lMasterss;
	}

	public ArrayList<LMSContentMasterDTO> getSelectLMSContent(ArrayList<Long> ids) 
	{
		ArrayList<LMSContentMaster> lMasters = contentMasterRepo.getSelectLMSContent(ids);
		ArrayList<LMSContentMasterDTO> LMSContentMasterDTOs = new ArrayList<LMSContentMasterDTO>();
		LMSContentMasterDTO LMSContentMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSContentMasterDTO = this.getLMSContentMasterDTO(lMasters.get(i));
				LMSContentMasterDTOs.add(LMSContentMasterDTO);
			}
		}
		return LMSContentMasterDTOs;
	}


	public ArrayList<LMSContentMasterDTO> getSelectLMSContentByCategories(ArrayList<BigDecimal> ids) 
	{
		ArrayList<LMSContentMaster> lMasters = contentMasterRepo.getSelectLMSContentByCategories(ids);
		ArrayList<LMSContentMasterDTO> LMSContentMasterDTOs = new ArrayList<LMSContentMasterDTO>();
		LMSContentMasterDTO LMSContentMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSContentMasterDTO = this.getLMSContentMasterDTO(lMasters.get(i));
				LMSContentMasterDTOs.add(LMSContentMasterDTO);
			}
		}
		return LMSContentMasterDTOs;
	}

	
	public LMSContentMasterDTO getLMSContentMasterById(Long contentSeqNo) {
		Optional<LMSContentMaster> LMSContentMaster = contentMasterRepo.findById(contentSeqNo);
		LMSContentMasterDTO lMasters = null;
		if (LMSContentMaster.isPresent()) {
			lMasters = LMSContentMaster != null ? this.getLMSContentMasterDTO(LMSContentMaster.get())
					: null;
		}
		return lMasters;
	}

	public void updLMSContentMaster(LMSContentMasterDTO lMaster) {
		LMSContentMaster contentMaster = this.setLMSContentMaster(lMaster);
		if (contentMasterRepo.existsById(lMaster.getContentSeqNo())) {
			contentMaster.setContentSeqNo(lMaster.getContentSeqNo());
			contentMasterRepo.save(contentMaster);
		}
		return;
	}

	public void delLMSContentMaster(Long contentSeqNo) 
	{
		if (contentMasterRepo.existsById(contentSeqNo)) {
			contentMasterRepo.deleteById(contentSeqNo);
		}
		return;
	}

	public void delSelectLMSContent(ArrayList<Long> ids) {
		contentMasterRepo.delSelectLMSContent(ids);
		return;
	}


	public void delSelectLMSContentByCategories(ArrayList<BigDecimal> ids) 
	{
		contentMasterRepo.delSelectLMSContentByCategories(ids);
		return;
	}

	
	public void delAllLMSContentMasters() {
		contentMasterRepo.deleteAll();
	}

	private ArrayList<LMSContentMasterDTO> getLMSContentMasterDTOs(ArrayList<LMSContentMaster> lMasters) {
		LMSContentMasterDTO lDTO = null;
		ArrayList<LMSContentMasterDTO> lMasterDTOs = new ArrayList<LMSContentMasterDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSContentMasterDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSContentMasterDTO getLMSContentMasterDTO(LMSContentMaster lMaster) {
		LMSContentMasterDTO lDTO = new LMSContentMasterDTO();
		lDTO.setContentSeqNo(lMaster.getContentSeqNo());
		lDTO.setContentCategorySeqNo(lMaster.getContentCategorySeqNo());		
		lDTO.setContentSummary(lMaster.getContentSummary());
		return lDTO;
	}

	private LMSContentMaster setLMSContentMaster(LMSContentMasterDTO lDTO) {
		LMSContentMaster lMaster = new LMSContentMaster();
		lMaster.setContentSummary(lDTO.getContentSummary());
		lMaster.setContentCategorySeqNo(lDTO.getContentCategorySeqNo());
		return lMaster;
	}
}