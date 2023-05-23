package subject_faculty_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import subject_faculty_mgmt.model.dto.LMSSubjectFacultyDetailsDTO;
import subject_faculty_mgmt.model.master.LMSSubjectFacultyDetails;
import subject_faculty_mgmt.model.master.LMSSubjectFacultyDetailsPK;
import subject_faculty_mgmt.model.repo.LMSSubjectFacultyDetailsRepo;

@Service("subjectFacultyDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSSubjectFacultyDetailsService implements I_LMSSubjectFacultyDetailsService {

	@Autowired
	private LMSSubjectFacultyDetailsRepo subjectFacultyDetailsRepo;

	public LMSSubjectFacultyDetailsDTO newLMSSubjectFacultyDetails(LMSSubjectFacultyDetailsDTO lMasters) {
		LMSSubjectFacultyDetailsPK lmsSubjectFacultyDetailsPK = new LMSSubjectFacultyDetailsPK();
		lmsSubjectFacultyDetailsPK.setSubjectSeqNo(lMasters.getSubjectSeqNo());
		lmsSubjectFacultyDetailsPK.setFacultySeqNo(lMasters.getFacultySeqNo());
		LMSSubjectFacultyDetails lmsSubjectFacultyDetails = null;

		if (!subjectFacultyDetailsRepo.existsById(lmsSubjectFacultyDetailsPK)) {
			lmsSubjectFacultyDetails = this.setLMSSubjectFacultyDetails(lMasters);
			lmsSubjectFacultyDetails.setId(lmsSubjectFacultyDetailsPK);
			lMasters = getLMSSubjectFacultyDetailsDTO(subjectFacultyDetailsRepo.save(lmsSubjectFacultyDetails));
		}
		return lMasters;
	}

	public ArrayList<LMSSubjectFacultyDetailsDTO> getAllLMSSubjectFacultyDetailss() {
		ArrayList<LMSSubjectFacultyDetails> subjectList = (ArrayList<LMSSubjectFacultyDetails>) subjectFacultyDetailsRepo
				.findAll();
		ArrayList<LMSSubjectFacultyDetailsDTO> lMasterss = new ArrayList<LMSSubjectFacultyDetailsDTO>();
		lMasterss = subjectList != null ? this.getLMSSubjectFacultyDetailsDTOs(subjectList) : null;
		return lMasterss;
	}

	public ArrayList<LMSSubjectFacultyDetailsDTO> getSelectLMSSubjects(ArrayList<Long> ids) {
		ArrayList<LMSSubjectFacultyDetails> lMasters = subjectFacultyDetailsRepo.getSelectSubjects(ids);
		ArrayList<LMSSubjectFacultyDetailsDTO> LMSSubjectFacultyDetailsDTOs = null;

		if (lMasters != null) {
			LMSSubjectFacultyDetailsDTOs = this.getLMSSubjectFacultyDetailsDTOs(lMasters);
		}

		return LMSSubjectFacultyDetailsDTOs;
	}

	public ArrayList<LMSSubjectFacultyDetailsDTO> getSelectSubjectsByFaculties(ArrayList<Long> ids) {
		ArrayList<LMSSubjectFacultyDetails> lMasters = subjectFacultyDetailsRepo.getSelectSubjectsByFaculties(ids);
		ArrayList<LMSSubjectFacultyDetailsDTO> LMSSubjectFacultyDetailsDTOs = null;

		if (lMasters != null) {
			LMSSubjectFacultyDetailsDTOs = this.getLMSSubjectFacultyDetailsDTOs(lMasters);
		}

		return LMSSubjectFacultyDetailsDTOs;
	}

	public void updLMSSubjectFacultyDetails(LMSSubjectFacultyDetailsDTO lMaster) {
		LMSSubjectFacultyDetailsPK lmsSubjectFacultyDetailsPK = new LMSSubjectFacultyDetailsPK();
		lmsSubjectFacultyDetailsPK.setSubjectSeqNo(lMaster.getSubjectSeqNo());
		lmsSubjectFacultyDetailsPK.setFacultySeqNo(lMaster.getFacultySeqNo());
		LMSSubjectFacultyDetails lMSSubjectFacultyDetails = null;

		if (subjectFacultyDetailsRepo.existsById(lmsSubjectFacultyDetailsPK)) {
			lMSSubjectFacultyDetails = setLMSSubjectFacultyDetails(lMaster);
			lMSSubjectFacultyDetails.setId(lmsSubjectFacultyDetailsPK);
			subjectFacultyDetailsRepo.save(lMSSubjectFacultyDetails);
		}
		return;
	}

	public void delSelectLMSSubjectByFaculties(ArrayList<Long> ids) {
		subjectFacultyDetailsRepo.delSelectLMSSubjectByFaculties(ids);
		return;
	}

	public void delSelectLMSSubjects(ArrayList<Long> DocumentSeqNos) {
		subjectFacultyDetailsRepo.delSelectLMSSubjects(DocumentSeqNos);
		;
		return;
	}

	public void delAllLMSSubjectFacultyDetailss() {
		subjectFacultyDetailsRepo.deleteAll();
	}

	private ArrayList<LMSSubjectFacultyDetailsDTO> getLMSSubjectFacultyDetailsDTOs(
			ArrayList<LMSSubjectFacultyDetails> lMasters) {
		LMSSubjectFacultyDetailsDTO lDTO = null;
		ArrayList<LMSSubjectFacultyDetailsDTO> lMasterDTOs = new ArrayList<LMSSubjectFacultyDetailsDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSSubjectFacultyDetailsDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSSubjectFacultyDetailsDTO getLMSSubjectFacultyDetailsDTO(LMSSubjectFacultyDetails lMaster) {
		LMSSubjectFacultyDetailsDTO lDTO = new LMSSubjectFacultyDetailsDTO();
		lDTO.setSubjectSeqNo(lMaster.getId().getSubjectSeqNo());
		lDTO.setFacultySeqNo(lMaster.getId().getFacultySeqNo());
		return lDTO;
	}

	private LMSSubjectFacultyDetails setLMSSubjectFacultyDetails(LMSSubjectFacultyDetailsDTO lDTO) {
		LMSSubjectFacultyDetails lMaster = new LMSSubjectFacultyDetails();
		LMSSubjectFacultyDetailsPK lmsSubjectFacultyDetailsPK = new LMSSubjectFacultyDetailsPK();
		lmsSubjectFacultyDetailsPK.setSubjectSeqNo(lDTO.getSubjectSeqNo());
		lmsSubjectFacultyDetailsPK.setFacultySeqNo(lDTO.getFacultySeqNo());
		lMaster.setId(lmsSubjectFacultyDetailsPK);
		return lMaster;
	}
}