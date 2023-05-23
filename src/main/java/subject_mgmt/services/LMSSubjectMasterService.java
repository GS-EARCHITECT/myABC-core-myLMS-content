package subject_mgmt.services;

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
import subject_mgmt.model.dto.LMSSubjectMasterDTO;
import subject_mgmt.model.master.LMSSubjectMaster;
import subject_mgmt.model.repo.LMSSubjectMasterRepo;

@Service("subjectMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSSubjectMasterService implements I_LMSSubjectMasterService {

	@Autowired
	private LMSSubjectMasterRepo subjectMasterRepo;

	public LMSSubjectMasterDTO newLMSSubjectMaster(LMSSubjectMasterDTO lMasters) {
		LMSSubjectMaster LMSSubjectMaster = subjectMasterRepo.save(this.setLMSSubjectMaster(lMasters));
		lMasters = getLMSSubjectMasterDTO(LMSSubjectMaster);
		return lMasters;
	}

	public ArrayList<LMSSubjectMasterDTO> getAllLMSSubjectMasters() {
		ArrayList<LMSSubjectMaster> subjectList = (ArrayList<LMSSubjectMaster>) subjectMasterRepo.findAll();
		ArrayList<LMSSubjectMasterDTO> lMasterss = new ArrayList<LMSSubjectMasterDTO>();
		lMasterss = subjectList != null ? this.getLMSSubjectMasterDTOs(subjectList) : null;
		return lMasterss;
	}

	public ArrayList<LMSSubjectMasterDTO> getSelectLMSSubjectCategories(ArrayList<BigDecimal> ids) {
		ArrayList<LMSSubjectMaster> lMasters = subjectMasterRepo.getSelectLMSSubjectCategories(ids);
		ArrayList<LMSSubjectMasterDTO> LMSSubjectMasterDTOs = new ArrayList<LMSSubjectMasterDTO>();
		LMSSubjectMasterDTO LMSSubjectMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSSubjectMasterDTO = this.getLMSSubjectMasterDTO(lMasters.get(i));
				LMSSubjectMasterDTOs.add(LMSSubjectMasterDTO);
			}
		}
		return LMSSubjectMasterDTOs;
	}

	public ArrayList<LMSSubjectMasterDTO> getSelectLMSSubjects(ArrayList<Long> ids) {
		ArrayList<LMSSubjectMaster> lMasters = subjectMasterRepo.getSelectLMSSubjects(ids);
		ArrayList<LMSSubjectMasterDTO> LMSSubjectMasterDTOs = new ArrayList<LMSSubjectMasterDTO>();
		LMSSubjectMasterDTO LMSSubjectMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSSubjectMasterDTO = this.getLMSSubjectMasterDTO(lMasters.get(i));
				LMSSubjectMasterDTOs.add(LMSSubjectMasterDTO);
			}
		}
		return LMSSubjectMasterDTOs;
	}

		
	public LMSSubjectMasterDTO getLMSSubjectMasterById(Long subjectSeqNo) {
		Optional<LMSSubjectMaster> LMSSubjectMaster = subjectMasterRepo.findById(subjectSeqNo);
		LMSSubjectMasterDTO lMasters = null;
		if (LMSSubjectMaster.isPresent()) {
			lMasters = LMSSubjectMaster != null ? this.getLMSSubjectMasterDTO(LMSSubjectMaster.get())
					: null;
		}
		return lMasters;
	}

	public void updLMSSubjectMaster(LMSSubjectMasterDTO lMaster) {
		LMSSubjectMaster subjectMaster = this.setLMSSubjectMaster(lMaster);
		if (subjectMasterRepo.existsById(lMaster.getSubjectSeqNo())) {
			subjectMaster.setSubjectSeqNo(lMaster.getSubjectSeqNo());
			subjectMasterRepo.save(subjectMaster);
		}
		return;
	}

	public void delLMSSubjectMaster(Long subjectSeqNo) {
		if (subjectMasterRepo.existsById(subjectSeqNo)) {
			subjectMasterRepo.deleteById(subjectSeqNo);
		}
		return;
	}

	public void delAllLMSSubjectMasters() {
		subjectMasterRepo.deleteAll();
	}

	public void delSelectLMSSubjectCategories(ArrayList<BigDecimal> subjectSeqNos) {
		if (subjectSeqNos != null) {
			subjectMasterRepo.delSelectLMSSubjectCategories(subjectSeqNos);
		}
	}

	public void delSelectLMSSubjects(ArrayList<Long> subjectSeqNos) {
		if (subjectSeqNos != null) {
			subjectMasterRepo.delSelectLMSSubjects(subjectSeqNos);
		}
	}
	
	private ArrayList<LMSSubjectMasterDTO> getLMSSubjectMasterDTOs(ArrayList<LMSSubjectMaster> lMasters) {
		LMSSubjectMasterDTO lDTO = null;
		ArrayList<LMSSubjectMasterDTO> lMasterDTOs = new ArrayList<LMSSubjectMasterDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSSubjectMasterDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSSubjectMasterDTO getLMSSubjectMasterDTO(LMSSubjectMaster lMaster) {
		LMSSubjectMasterDTO lDTO = new LMSSubjectMasterDTO();
		lDTO.setSubjectSeqNo(lMaster.getSubjectSeqNo());
		lDTO.setSubject(lMaster.getSubject());
		lDTO.setIntRefNo(lMaster.getIntRefNo());
		lDTO.setSubjectCategorySeqNo(lMaster.getSubjectCategorySeqNo());
		return lDTO;
	}

	private LMSSubjectMaster setLMSSubjectMaster(LMSSubjectMasterDTO lDTO) {
		LMSSubjectMaster lMaster = new LMSSubjectMaster();		
		lMaster.setSubject(lDTO.getSubject());
		lMaster.setIntRefNo(lDTO.getIntRefNo());
		lMaster.setSubjectCategorySeqNo(lDTO.getSubjectCategorySeqNo());
		return lMaster;
	}
}