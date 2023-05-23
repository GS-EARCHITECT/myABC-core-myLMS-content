package subject_content_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import subject_content_mgmt.model.dto.LMSSubjectContentDetailsDTO;
import subject_content_mgmt.model.master.LMSSubjectContentDetails;
import subject_content_mgmt.model.master.LMSSubjectContentDetailsPK;
import subject_content_mgmt.model.repo.LMSSubjectContentDetailsRepo;

@Service("subjectContentDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSSubjectContentDetailsService implements I_LMSSubjectContentDetailsService {

	@Autowired
	private LMSSubjectContentDetailsRepo subjectContentDetailsRepo;

	public LMSSubjectContentDetailsDTO newLMSSubjectContentDetails(LMSSubjectContentDetailsDTO lMasters) 
	{
		LMSSubjectContentDetailsPK lmsSubjectContentDetailsPK = new LMSSubjectContentDetailsPK();
		lmsSubjectContentDetailsPK.setSubjectSeqNo(lMasters.getSubjectSeqNo());
		lmsSubjectContentDetailsPK.setInSubjectSeqNo(lMasters.getInSubjectSeqNo());
		LMSSubjectContentDetails lmsSubjectContentDetails = null;
		
		if(!subjectContentDetailsRepo.existsById(lmsSubjectContentDetailsPK))
		{		
		lmsSubjectContentDetails = this.setLMSSubjectContentDetails(lMasters);		
		lmsSubjectContentDetails.setId(lmsSubjectContentDetailsPK);
		lMasters = getLMSSubjectContentDetailsDTO(subjectContentDetailsRepo.save(lmsSubjectContentDetails));
		}
		return lMasters;
	}

	public ArrayList<LMSSubjectContentDetailsDTO> getAllLMSSubjectContentDetailss() {
		ArrayList<LMSSubjectContentDetails> subjectList = (ArrayList<LMSSubjectContentDetails>) subjectContentDetailsRepo.findAll();
		ArrayList<LMSSubjectContentDetailsDTO> lMasterss = new ArrayList<LMSSubjectContentDetailsDTO>();
		lMasterss = subjectList != null ? this.getLMSSubjectContentDetailsDTOs(subjectList) : null;
		return lMasterss;
	}

	public ArrayList<LMSSubjectContentDetailsDTO> getSelectLMSSubjects(ArrayList<Long> ids) {
		ArrayList<LMSSubjectContentDetails> lMasters = subjectContentDetailsRepo.getSelectSubjects(ids);
		ArrayList<LMSSubjectContentDetailsDTO> LMSSubjectContentDetailsDTOs = new ArrayList<LMSSubjectContentDetailsDTO>();
		LMSSubjectContentDetailsDTO LMSSubjectContentDetailsDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSSubjectContentDetailsDTO = this.getLMSSubjectContentDetailsDTO(lMasters.get(i));
				LMSSubjectContentDetailsDTOs.add(LMSSubjectContentDetailsDTO);
			}
		}
		return LMSSubjectContentDetailsDTOs;
	}

	public void updLMSSubjectContentDetails(LMSSubjectContentDetailsDTO lMaster) 
	{
		LMSSubjectContentDetailsPK lmsSubjectContentDetailsPK = new LMSSubjectContentDetailsPK();
		lmsSubjectContentDetailsPK.setSubjectSeqNo(lMaster.getSubjectSeqNo());
		lmsSubjectContentDetailsPK.setInSubjectSeqNo(lMaster.getInSubjectSeqNo());
		LMSSubjectContentDetails lMSSubjectContentDetails = null;
		
		if (subjectContentDetailsRepo.existsById(lmsSubjectContentDetailsPK)) 
		{
			lMSSubjectContentDetails=setLMSSubjectContentDetails(lMaster);
			lMSSubjectContentDetails.setId(lmsSubjectContentDetailsPK);			
			subjectContentDetailsRepo.save(lMSSubjectContentDetails);
		}
		return;
	}

	public void delLMSSubjectContentDetails(LMSSubjectContentDetailsDTO lMaster) 
	{
		LMSSubjectContentDetailsPK lmsSubjectContentDetailsPK = new LMSSubjectContentDetailsPK();
		lmsSubjectContentDetailsPK.setSubjectSeqNo(lMaster.getSubjectSeqNo());
		lmsSubjectContentDetailsPK.setInSubjectSeqNo(lMaster.getInSubjectSeqNo());
			
		if (subjectContentDetailsRepo.existsById(lmsSubjectContentDetailsPK))
		{
			subjectContentDetailsRepo.deleteById(lmsSubjectContentDetailsPK);
		}
		return;
	}

	public void delSelectLMSSubjects(ArrayList<Long> DocumentSeqNos)
	{
		subjectContentDetailsRepo.delSelectLMSSubjectContent(DocumentSeqNos);
		return;
	}

	
	public void delAllLMSSubjectContentDetailss() {
		subjectContentDetailsRepo.deleteAll();
	}

	
	private ArrayList<LMSSubjectContentDetailsDTO> getLMSSubjectContentDetailsDTOs(ArrayList<LMSSubjectContentDetails> lMasters) {
		LMSSubjectContentDetailsDTO lDTO = null;
		ArrayList<LMSSubjectContentDetailsDTO> lMasterDTOs = new ArrayList<LMSSubjectContentDetailsDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSSubjectContentDetailsDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSSubjectContentDetailsDTO getLMSSubjectContentDetailsDTO(LMSSubjectContentDetails lMaster) {
		LMSSubjectContentDetailsDTO lDTO = new LMSSubjectContentDetailsDTO();
		lDTO.setSubjectSeqNo(lMaster.getId().getSubjectSeqNo());
		lDTO.setInSubjectSeqNo(lMaster.getId().getInSubjectSeqNo());
		return lDTO;
	}

	private LMSSubjectContentDetails setLMSSubjectContentDetails(LMSSubjectContentDetailsDTO lDTO) 
	{
		LMSSubjectContentDetails lMaster = new LMSSubjectContentDetails();		
		return lMaster;
	}
}