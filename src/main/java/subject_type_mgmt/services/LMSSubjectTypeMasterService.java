package subject_type_mgmt.services;

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

import subject_type_mgmt.model.dto.LMSSubjectTypeMasterDTO;
import subject_type_mgmt.model.master.LMSSubjectTypeMaster;
import subject_type_mgmt.model.repo.LMSSubjectTypeMasterRepo;

@Service("subjectTypeMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSSubjectTypeMasterService implements I_LMSSubjectTypeMasterService {

	@Autowired
	private LMSSubjectTypeMasterRepo subjectTypeMasterRepo;

	public LMSSubjectTypeMasterDTO newLMSSubjectTypeMaster(LMSSubjectTypeMasterDTO lMasters) {
		LMSSubjectTypeMaster LMSSubjectTypeMaster = subjectTypeMasterRepo.save(this.setLMSSubjectTypeMaster(lMasters));
		lMasters = getLMSSubjectTypeMasterDTO(LMSSubjectTypeMaster);
		return lMasters;
	}

	public ArrayList<LMSSubjectTypeMasterDTO> getAllLMSSubjectTypeMasters() {
		ArrayList<LMSSubjectTypeMaster> subjectList = (ArrayList<LMSSubjectTypeMaster>) subjectTypeMasterRepo.findAll();
		ArrayList<LMSSubjectTypeMasterDTO> lMasterss = new ArrayList<LMSSubjectTypeMasterDTO>();
		lMasterss = subjectList != null ? this.getLMSSubjectTypeMasterDTOs(subjectList) : null;
		return lMasterss;
	}

	public ArrayList<LMSSubjectTypeMasterDTO> getSelectLMSSubjectTypes(ArrayList<BigDecimal> ids) {
		ArrayList<LMSSubjectTypeMaster> lMasters = subjectTypeMasterRepo.getSelectLMSSubjectTypes(ids);
		ArrayList<LMSSubjectTypeMasterDTO> LMSSubjectTypeMasterDTOs = new ArrayList<LMSSubjectTypeMasterDTO>();
		LMSSubjectTypeMasterDTO LMSSubjectTypeMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSSubjectTypeMasterDTO = this.getLMSSubjectTypeMasterDTO(lMasters.get(i));
				LMSSubjectTypeMasterDTOs.add(LMSSubjectTypeMasterDTO);
			}
		}
		return LMSSubjectTypeMasterDTOs;
	}

	public ArrayList<LMSSubjectTypeMasterDTO> getSelectLMSSubjectTypesByParents(ArrayList<BigDecimal> ids)
	{
		ArrayList<LMSSubjectTypeMaster> lMasters = subjectTypeMasterRepo.getSelectSubjectTypesByParents(ids);
		ArrayList<LMSSubjectTypeMasterDTO> LMSSubjectTypeMasterDTOs = new ArrayList<LMSSubjectTypeMasterDTO>();
		LMSSubjectTypeMasterDTO LMSSubjectTypeMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSSubjectTypeMasterDTO = this.getLMSSubjectTypeMasterDTO(lMasters.get(i));
				LMSSubjectTypeMasterDTOs.add(LMSSubjectTypeMasterDTO);
			}
		}
		return LMSSubjectTypeMasterDTOs;
	}

	
	
	public LMSSubjectTypeMasterDTO getLMSSubjectTypeMasterById(BigDecimal subjectSeqNo) {
		Optional<LMSSubjectTypeMaster> LMSSubjectTypeMaster = subjectTypeMasterRepo.findById(subjectSeqNo);
		LMSSubjectTypeMasterDTO lMasters = null;
		if (LMSSubjectTypeMaster.isPresent()) {
			lMasters = LMSSubjectTypeMaster != null ? this.getLMSSubjectTypeMasterDTO(LMSSubjectTypeMaster.get())
					: null;
		}
		return lMasters;
	}

	public void updLMSSubjectTypeMaster(LMSSubjectTypeMasterDTO lMaster) {
		LMSSubjectTypeMaster subjectTypeMaster = this.setLMSSubjectTypeMaster(lMaster);
		if (subjectTypeMasterRepo.existsById(lMaster.getSubjectTypeSeqNo())) {
			subjectTypeMaster.setSubjectTypeSeqNo(lMaster.getSubjectTypeSeqNo());
			subjectTypeMasterRepo.save(subjectTypeMaster);
		}
		return;
	}

	public void delLMSSubjectTypeMaster(BigDecimal subjectSeqNo) {
		if (subjectTypeMasterRepo.existsById(subjectSeqNo)) {
			subjectTypeMasterRepo.deleteById(subjectSeqNo);
		}
		return;
	}

	public void delAllLMSSubjectTypeMasters() {
		subjectTypeMasterRepo.deleteAll();
	}

	public void delSelectLMSSubjectTypes(ArrayList<BigDecimal> subjectSeqNos) {
		if (subjectSeqNos != null) {
			subjectTypeMasterRepo.delSelectLMSSubjectTypes(subjectSeqNos);
		}
	}

	private ArrayList<LMSSubjectTypeMasterDTO> getLMSSubjectTypeMasterDTOs(ArrayList<LMSSubjectTypeMaster> lMasters) {
		LMSSubjectTypeMasterDTO lDTO = null;
		ArrayList<LMSSubjectTypeMasterDTO> lMasterDTOs = new ArrayList<LMSSubjectTypeMasterDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSSubjectTypeMasterDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSSubjectTypeMasterDTO getLMSSubjectTypeMasterDTO(LMSSubjectTypeMaster lMaster) {
		LMSSubjectTypeMasterDTO lDTO = new LMSSubjectTypeMasterDTO();
		lDTO.setSubjectTypeSeqNo(lMaster.getSubjectTypeSeqNo());
		lDTO.setSubjectType(lMaster.getSubjectType());
		lDTO.setParTypeSeqNo(lMaster.getParTypeSeqNo());
		lDTO.setInternalRefNo(lMaster.getInternalRefNo());
		return lDTO;
	}

	private LMSSubjectTypeMaster setLMSSubjectTypeMaster(LMSSubjectTypeMasterDTO lDTO) {
		LMSSubjectTypeMaster lMaster = new LMSSubjectTypeMaster();
		lMaster.setSubjectType(lDTO.getSubjectType());
		lMaster.setParTypeSeqNo(lDTO.getParTypeSeqNo());
		lMaster.setInternalRefNo(lDTO.getInternalRefNo());
		return lMaster;
	}
}