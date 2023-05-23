package content_mgmt.content_category_mgmt.services;

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

import content_mgmt.content_category_mgmt.model.dto.LMSContentCategoryMasterDTO;
import content_mgmt.content_category_mgmt.model.master.LMSContentCategoryMaster;
import content_mgmt.content_category_mgmt.model.master.LMSContentCategoryMasterPK;
import content_mgmt.content_category_mgmt.model.repo.LMSContentCategoryMasterRepo;

@Service("contentCategoryMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSContentCategoryMasterService implements I_LMSContentCategoryMasterService {

	@Autowired
	private LMSContentCategoryMasterRepo contentCategoryMasterRepo;

	public LMSContentCategoryMasterDTO newLMSContentCategoryMaster(
			LMSContentCategoryMasterDTO lmsContentCategoryMasterDTO) {
		LMSContentCategoryMasterPK lmsContentCategoryMasterPK = new LMSContentCategoryMasterPK();
		lmsContentCategoryMasterPK.setContentCategorySeqNo(lmsContentCategoryMasterDTO.getContentCategorySeqNo());
		lmsContentCategoryMasterPK.setContentTypeSeqNo(lmsContentCategoryMasterDTO.getContentTypeSeqNo());
		LMSContentCategoryMasterDTO lmsContentCategoryMasterDTO2 = null;
		LMSContentCategoryMaster lmsContentCategoryMaster = null;

		if (!contentCategoryMasterRepo.existsById(lmsContentCategoryMasterPK)) {
			lmsContentCategoryMaster = setLMSContentCategoryMaster(lmsContentCategoryMasterDTO);
			lmsContentCategoryMaster.setId(lmsContentCategoryMasterPK);
			lmsContentCategoryMasterDTO2 = getLMSContentCategoryMasterDTO(
					contentCategoryMasterRepo.save(lmsContentCategoryMaster));
		}
		return lmsContentCategoryMasterDTO2;
	}

	public ArrayList<LMSContentCategoryMasterDTO> getAllLMSContentCategoryMasters() {
		ArrayList<LMSContentCategoryMaster> contentCategoryList = (ArrayList<LMSContentCategoryMaster>) contentCategoryMasterRepo
				.findAll();
		ArrayList<LMSContentCategoryMasterDTO> lMasterss = new ArrayList<LMSContentCategoryMasterDTO>();
		lMasterss = contentCategoryList != null ? this.getLMSContentCategoryMasterDTOs(contentCategoryList) : null;
		return lMasterss;
	}

	public ArrayList<LMSContentCategoryMasterDTO> getSelectLMSContentCategoriesForTypes(ArrayList<BigDecimal> ids) {
		ArrayList<LMSContentCategoryMaster> lMasters = contentCategoryMasterRepo
				.getSelectLMSContentCategoriesForTypes(ids);
		ArrayList<LMSContentCategoryMasterDTO> LMSContentCategoryMasterDTOs = new ArrayList<LMSContentCategoryMasterDTO>();
		LMSContentCategoryMasterDTO LMSContentCategoryMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSContentCategoryMasterDTO = this.getLMSContentCategoryMasterDTO(lMasters.get(i));
				LMSContentCategoryMasterDTOs.add(LMSContentCategoryMasterDTO);
			}
		}
		return LMSContentCategoryMasterDTOs;
	}

	public ArrayList<LMSContentCategoryMasterDTO> getSelectLMSContentCategories(ArrayList<BigDecimal> ids) {
		ArrayList<LMSContentCategoryMaster> lMasters = contentCategoryMasterRepo.getSelectLMSContentCategories(ids);
		ArrayList<LMSContentCategoryMasterDTO> LMSContentCategoryMasterDTOs = new ArrayList<LMSContentCategoryMasterDTO>();
		LMSContentCategoryMasterDTO LMSContentCategoryMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSContentCategoryMasterDTO = this.getLMSContentCategoryMasterDTO(lMasters.get(i));
				LMSContentCategoryMasterDTOs.add(LMSContentCategoryMasterDTO);
			}
		}
		return LMSContentCategoryMasterDTOs;
	}

	public LMSContentCategoryMasterDTO getLMSContentCategoryMasterById(
			LMSContentCategoryMasterDTO contentCategoryMasterDTO) {
		LMSContentCategoryMasterPK lmsContentCategoryMasterPK = new LMSContentCategoryMasterPK();
		lmsContentCategoryMasterPK.setContentCategorySeqNo(contentCategoryMasterDTO.getContentCategorySeqNo());
		lmsContentCategoryMasterPK.setContentTypeSeqNo(contentCategoryMasterDTO.getContentTypeSeqNo());
		LMSContentCategoryMasterDTO lmsContentCategoryMasterDTO2 = null;
		LMSContentCategoryMaster lmsContentCategoryMaster = null;
		Optional<LMSContentCategoryMaster> LMSContentCategoryMaster = contentCategoryMasterRepo
				.findById(lmsContentCategoryMasterPK);
		LMSContentCategoryMasterDTO lmsContentCategoryMasterDTO = null;

		if (LMSContentCategoryMaster.isPresent()) {
			lmsContentCategoryMasterDTO = LMSContentCategoryMaster != null
					? this.getLMSContentCategoryMasterDTO(LMSContentCategoryMaster.get())
					: null;
		}
		return lmsContentCategoryMasterDTO;
	}

	public void updLMSContentCategoryMaster(LMSContentCategoryMasterDTO lmsContentCategoryMasterDTO) {
		LMSContentCategoryMasterPK lmsContentCategoryMasterPK = new LMSContentCategoryMasterPK();
		lmsContentCategoryMasterPK.setContentCategorySeqNo(lmsContentCategoryMasterDTO.getContentCategorySeqNo());
		lmsContentCategoryMasterPK.setContentTypeSeqNo(lmsContentCategoryMasterDTO.getContentTypeSeqNo());
		LMSContentCategoryMaster lmsContentCategoryMaster = null;

		if (contentCategoryMasterRepo.existsById(lmsContentCategoryMasterPK)) {
			lmsContentCategoryMaster = this.setLMSContentCategoryMaster(lmsContentCategoryMasterDTO);
			contentCategoryMasterRepo.save(lmsContentCategoryMaster);
		}
		return;
	}

	public void delLMSContentCategoryMaster(LMSContentCategoryMasterDTO lmsContentCategoryMasterDTO) {
		LMSContentCategoryMasterPK lmsContentCategoryMasterPK = new LMSContentCategoryMasterPK();
		lmsContentCategoryMasterPK.setContentCategorySeqNo(lmsContentCategoryMasterDTO.getContentCategorySeqNo());
		lmsContentCategoryMasterPK.setContentTypeSeqNo(lmsContentCategoryMasterDTO.getContentTypeSeqNo());
		LMSContentCategoryMaster lmsContentCategoryMaster = null;

		if (contentCategoryMasterRepo.existsById(lmsContentCategoryMasterPK)) {
			contentCategoryMasterRepo.deleteById(lmsContentCategoryMasterPK);
		}
		return;
	}

	public void delSelectLMSContentCategories(ArrayList<BigDecimal> ids) {
		contentCategoryMasterRepo.delSelectLMSContentCategories(ids);
		return;
	}

	public void delAllLMSContentCategoryMasters() {
		contentCategoryMasterRepo.deleteAll();
	}

	private ArrayList<LMSContentCategoryMasterDTO> getLMSContentCategoryMasterDTOs(
			ArrayList<LMSContentCategoryMaster> lMasters) {
		LMSContentCategoryMasterDTO lDTO = null;
		ArrayList<LMSContentCategoryMasterDTO> lMasterDTOs = new ArrayList<LMSContentCategoryMasterDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSContentCategoryMasterDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSContentCategoryMasterDTO getLMSContentCategoryMasterDTO(
			LMSContentCategoryMaster lmsContentCategoryMaster) {
		LMSContentCategoryMasterDTO lDTO = new LMSContentCategoryMasterDTO();
		lDTO.setContentCategorySeqNo(lmsContentCategoryMaster.getId().getContentCategorySeqNo());
		lDTO.setContentTypeSeqNo(lmsContentCategoryMaster.getId().getContentTypeSeqNo());
		lDTO.setContentCategory(lmsContentCategoryMaster.getContentCategory());
		return lDTO;
	}

	private LMSContentCategoryMaster setLMSContentCategoryMaster(LMSContentCategoryMasterDTO lDTO) {
		LMSContentCategoryMasterPK lmsContentCategoryMasterPK = new LMSContentCategoryMasterPK();
		LMSContentCategoryMaster lmsContentCategoryMaster = new LMSContentCategoryMaster();
		lmsContentCategoryMasterPK.setContentCategorySeqNo(lDTO.getContentCategorySeqNo());
		lmsContentCategoryMasterPK.setContentTypeSeqNo(lDTO.getContentTypeSeqNo());
		lmsContentCategoryMaster.setContentCategory(lDTO.getContentCategory());
		return lmsContentCategoryMaster;
	}
}