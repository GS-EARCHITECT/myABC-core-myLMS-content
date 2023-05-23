package subject_category_mgmt.services;

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
import subject_category_mgmt.model.dto.LMSSubjectCategoryMasterDTO;
import subject_category_mgmt.model.master.LMSSubjectCategoryMaster;
import subject_category_mgmt.model.repo.LMSSubjectCategoryMasterRepo;

@Service("subjectCategoryMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSSubjectCategoryMasterService implements I_LMSSubjectCategoryMasterService {

	@Autowired
	private LMSSubjectCategoryMasterRepo subjectCategoryMasterRepo;

	public LMSSubjectCategoryMasterDTO newLMSSubjectCategoryMaster(LMSSubjectCategoryMasterDTO lMasters) {
		LMSSubjectCategoryMaster LMSSubjectCategoryMaster = subjectCategoryMasterRepo.save(this.setLMSSubjectCategoryMaster(lMasters));
		lMasters = getLMSSubjectCategoryMasterDTO(LMSSubjectCategoryMaster);
		return lMasters;
	}

	public ArrayList<LMSSubjectCategoryMasterDTO> getAllLMSSubjectCategoryMasters() {
		ArrayList<LMSSubjectCategoryMaster> subjectList = (ArrayList<LMSSubjectCategoryMaster>) subjectCategoryMasterRepo.findAll();
		ArrayList<LMSSubjectCategoryMasterDTO> lMasterss = new ArrayList<LMSSubjectCategoryMasterDTO>();
		lMasterss = subjectList != null ? this.getLMSSubjectCategoryMasterDTOs(subjectList) : null;
		return lMasterss;
	}

	public ArrayList<LMSSubjectCategoryMasterDTO> getSelectLMSSubjectCategories(ArrayList<BigDecimal> ids) {
		ArrayList<LMSSubjectCategoryMaster> lMasters = subjectCategoryMasterRepo.getSelectLMSSubjectCategories(ids);
		ArrayList<LMSSubjectCategoryMasterDTO> LMSSubjectCategoryMasterDTOs = new ArrayList<LMSSubjectCategoryMasterDTO>();
		LMSSubjectCategoryMasterDTO LMSSubjectCategoryMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSSubjectCategoryMasterDTO = this.getLMSSubjectCategoryMasterDTO(lMasters.get(i));
				LMSSubjectCategoryMasterDTOs.add(LMSSubjectCategoryMasterDTO);
			}
		}
		return LMSSubjectCategoryMasterDTOs;
	}

	public ArrayList<LMSSubjectCategoryMasterDTO> getSelectLMSSubjectTypes(ArrayList<BigDecimal> ids) {
		ArrayList<LMSSubjectCategoryMaster> lMasters = subjectCategoryMasterRepo.getSelectLMSSubjectTypes(ids);
		ArrayList<LMSSubjectCategoryMasterDTO> LMSSubjectCategoryMasterDTOs = new ArrayList<LMSSubjectCategoryMasterDTO>();
		LMSSubjectCategoryMasterDTO LMSSubjectCategoryMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSSubjectCategoryMasterDTO = this.getLMSSubjectCategoryMasterDTO(lMasters.get(i));
				LMSSubjectCategoryMasterDTOs.add(LMSSubjectCategoryMasterDTO);
			}
		}
		return LMSSubjectCategoryMasterDTOs;
	}

	public ArrayList<LMSSubjectCategoryMasterDTO> getSelectLMSSubjectCategoriesByParents(ArrayList<BigDecimal> ids)
	{
		ArrayList<LMSSubjectCategoryMaster> lMasters = subjectCategoryMasterRepo.getSelectSubjectCategoriesByParents(ids);
		ArrayList<LMSSubjectCategoryMasterDTO> LMSSubjectCategoryMasterDTOs = new ArrayList<LMSSubjectCategoryMasterDTO>();
		LMSSubjectCategoryMasterDTO LMSSubjectCategoryMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSSubjectCategoryMasterDTO = this.getLMSSubjectCategoryMasterDTO(lMasters.get(i));
				LMSSubjectCategoryMasterDTOs.add(LMSSubjectCategoryMasterDTO);
			}
		}
		return LMSSubjectCategoryMasterDTOs;
	}

	
	
	public LMSSubjectCategoryMasterDTO getLMSSubjectCategoryMasterById(BigDecimal subjectSeqNo) {
		Optional<LMSSubjectCategoryMaster> LMSSubjectCategoryMaster = subjectCategoryMasterRepo.findById(subjectSeqNo);
		LMSSubjectCategoryMasterDTO lMasters = null;
		if (LMSSubjectCategoryMaster.isPresent()) {
			lMasters = LMSSubjectCategoryMaster != null ? this.getLMSSubjectCategoryMasterDTO(LMSSubjectCategoryMaster.get())
					: null;
		}
		return lMasters;
	}

	public void updLMSSubjectCategoryMaster(LMSSubjectCategoryMasterDTO lMaster) {
		LMSSubjectCategoryMaster subjectCategoryMaster = this.setLMSSubjectCategoryMaster(lMaster);
		if (subjectCategoryMasterRepo.existsById(lMaster.getSubjectCategorySeqNo())) {
			subjectCategoryMaster.setSubjectCategorySeqNo(lMaster.getSubjectCategorySeqNo());
			subjectCategoryMasterRepo.save(subjectCategoryMaster);
		}
		return;
	}

	public void delLMSSubjectCategoryMaster(BigDecimal subjectSeqNo) {
		if (subjectCategoryMasterRepo.existsById(subjectSeqNo)) {
			subjectCategoryMasterRepo.deleteById(subjectSeqNo);
		}
		return;
	}

	public void delAllLMSSubjectCategoryMasters() {
		subjectCategoryMasterRepo.deleteAll();
	}

	public void delSelectLMSSubjectCategories(ArrayList<BigDecimal> subjectSeqNos) {
		if (subjectSeqNos != null) {
			subjectCategoryMasterRepo.delSelectLMSSubjectCategories(subjectSeqNos);
		}
	}

	private ArrayList<LMSSubjectCategoryMasterDTO> getLMSSubjectCategoryMasterDTOs(ArrayList<LMSSubjectCategoryMaster> lMasters) {
		LMSSubjectCategoryMasterDTO lDTO = null;
		ArrayList<LMSSubjectCategoryMasterDTO> lMasterDTOs = new ArrayList<LMSSubjectCategoryMasterDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSSubjectCategoryMasterDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSSubjectCategoryMasterDTO getLMSSubjectCategoryMasterDTO(LMSSubjectCategoryMaster lMaster) {
		LMSSubjectCategoryMasterDTO lDTO = new LMSSubjectCategoryMasterDTO();
		lDTO.setSubjectCategorySeqNo(lMaster.getSubjectCategorySeqNo());
		lDTO.setSubjectCategory(lMaster.getSubjectCategory());
		lDTO.setSubjectTypeSeqNo(lMaster.getSubjectTypeSeqNo());
		lDTO.setParCategorySeqNo(lMaster.getParCategorySeqNo());
		lDTO.setInternalRefNo(lMaster.getInternalRefNo());
		return lDTO;
	}

	private LMSSubjectCategoryMaster setLMSSubjectCategoryMaster(LMSSubjectCategoryMasterDTO lDTO) {
		LMSSubjectCategoryMaster lMaster = new LMSSubjectCategoryMaster();
		lMaster.setSubjectCategory(lDTO.getSubjectCategory());
		lMaster.setParCategorySeqNo(lDTO.getParCategorySeqNo());
		lMaster.setSubjectTypeSeqNo(lDTO.getSubjectTypeSeqNo());
		lMaster.setInternalRefNo(lDTO.getInternalRefNo());
		return lMaster;
	}
}