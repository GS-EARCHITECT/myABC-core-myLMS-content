package subject_media_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import subject_media_mgmt.model.dto.LMSSubjectMediaDetailsDTO;
import subject_media_mgmt.model.master.LMSSubjectMediaDetails;
import subject_media_mgmt.model.master.LMSSubjectMediaDetailsPK;
import subject_media_mgmt.model.repo.LMSSubjectMediaDetailsRepo;

@Service("subjectMediaDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSSubjectMediaDetailsService implements I_LMSSubjectMediaDetailsService {

	@Autowired
	private LMSSubjectMediaDetailsRepo subjectMediaDetailsRepo;

	public LMSSubjectMediaDetailsDTO newLMSSubjectMediaDetails(LMSSubjectMediaDetailsDTO lMasters) 
	{
		LMSSubjectMediaDetailsPK lmsSubjectMediaDetailsPK = new LMSSubjectMediaDetailsPK();
		lmsSubjectMediaDetailsPK.setSubjectSeqNo(lMasters.getSubjectSeqNo());
		lmsSubjectMediaDetailsPK.setResourceSeqNo(lMasters.getResourceSeqNo());
		LMSSubjectMediaDetails lmsSubjectMediaDetails = null;
		LMSSubjectMediaDetailsDTO lmsSubjectMediaDetailsDTO=null;
		
		if(!subjectMediaDetailsRepo.existsById(lmsSubjectMediaDetailsPK))
		{	
		lmsSubjectMediaDetails = setLMSSubjectMediaDetails(lMasters);
		lmsSubjectMediaDetails.setId(lmsSubjectMediaDetailsPK);
		lmsSubjectMediaDetailsDTO = getLMSSubjectMediaDetailsDTO(subjectMediaDetailsRepo.save(lmsSubjectMediaDetails));		
		}
		return lmsSubjectMediaDetailsDTO;
	}

	public ArrayList<LMSSubjectMediaDetailsDTO> getAllLMSSubjectMediaDetailss() {
		ArrayList<LMSSubjectMediaDetails> subjectList = (ArrayList<LMSSubjectMediaDetails>) subjectMediaDetailsRepo.findAll();
		ArrayList<LMSSubjectMediaDetailsDTO> lMasterss = new ArrayList<LMSSubjectMediaDetailsDTO>();
		lMasterss = subjectList != null ? this.getLMSSubjectMediaDetailsDTOs(subjectList) : null;
		return lMasterss;
	}

	public ArrayList<LMSSubjectMediaDetailsDTO> getSelectLMSMediaBySubjects(ArrayList<Long> ids)
	{
		ArrayList<LMSSubjectMediaDetails> lMasters = subjectMediaDetailsRepo.getSelectLMSMediaBySubjects(ids);
		ArrayList<LMSSubjectMediaDetailsDTO> LMSSubjectMediaDetailsDTOs = new ArrayList<LMSSubjectMediaDetailsDTO>();
		
		if (lMasters != null) 
		{
		LMSSubjectMediaDetailsDTOs = getLMSSubjectMediaDetailsDTOs(lMasters);			
		}
		return LMSSubjectMediaDetailsDTOs;
	}
	
	public ArrayList<LMSSubjectMediaDetailsDTO> getSelectLMSSubjectsByMedia(ArrayList<Long> ids)
	{
		ArrayList<LMSSubjectMediaDetails> lMasters = subjectMediaDetailsRepo.getSelectLMSSubjectsByMedia(ids);
		ArrayList<LMSSubjectMediaDetailsDTO> LMSSubjectMediaDetailsDTOs = new ArrayList<LMSSubjectMediaDetailsDTO>();

		if (lMasters != null) 
		{
		LMSSubjectMediaDetailsDTOs = getLMSSubjectMediaDetailsDTOs(lMasters);			
		}
		return LMSSubjectMediaDetailsDTOs;
	}

	public void updLMSSubjectMediaDetails(LMSSubjectMediaDetailsDTO lMaster) 
	{
		LMSSubjectMediaDetailsPK lmsSubjectMediaDetailsPK = new LMSSubjectMediaDetailsPK();
		lmsSubjectMediaDetailsPK.setSubjectSeqNo(lMaster.getSubjectSeqNo());
		lmsSubjectMediaDetailsPK.setResourceSeqNo(lMaster.getResourceSeqNo());
		LMSSubjectMediaDetails lmsSubjectMediaDetails = null;
		LMSSubjectMediaDetailsDTO lmsSubjectMediaDetailsDTO=null;
		
		if (subjectMediaDetailsRepo.existsById(lmsSubjectMediaDetailsPK)) 
		{
			lmsSubjectMediaDetails = setLMSSubjectMediaDetails(lMaster);
			lmsSubjectMediaDetails.setId(lmsSubjectMediaDetailsPK);			
			subjectMediaDetailsRepo.save(lmsSubjectMediaDetails);
		}
		return;
	}

	public void delLMSSubjectMediaDetails(LMSSubjectMediaDetailsDTO lMaster) 
	{
		LMSSubjectMediaDetailsPK lmsSubjectMediaDetailsPK = new LMSSubjectMediaDetailsPK();
		lmsSubjectMediaDetailsPK.setSubjectSeqNo(lMaster.getSubjectSeqNo());
		lmsSubjectMediaDetailsPK.setResourceSeqNo(lMaster.getResourceSeqNo());
		LMSSubjectMediaDetails lmsSubjectMediaDetails = null;
		LMSSubjectMediaDetailsDTO lmsSubjectMediaDetailsDTO=null;
			
		if (subjectMediaDetailsRepo.existsById(lmsSubjectMediaDetailsPK))
		{
			subjectMediaDetailsRepo.deleteById(lmsSubjectMediaDetailsPK);
		}
		return;
	}

	public void delSelectLMSSubjects(ArrayList<Long> DocumentSeqNos)
	{
		subjectMediaDetailsRepo.delSelectLMSSubjects(DocumentSeqNos);
		return;
	}

	
	public void delAllLMSSubjectMediaDetailss() {
		subjectMediaDetailsRepo.deleteAll();
	}

	
	private ArrayList<LMSSubjectMediaDetailsDTO> getLMSSubjectMediaDetailsDTOs(ArrayList<LMSSubjectMediaDetails> lMasters) {
		LMSSubjectMediaDetailsDTO lDTO = null;
		ArrayList<LMSSubjectMediaDetailsDTO> lMasterDTOs = new ArrayList<LMSSubjectMediaDetailsDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSSubjectMediaDetailsDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSSubjectMediaDetailsDTO getLMSSubjectMediaDetailsDTO(LMSSubjectMediaDetails lMaster) {
		LMSSubjectMediaDetailsDTO lDTO = new LMSSubjectMediaDetailsDTO();
		lDTO.setSubjectSeqNo(lMaster.getId().getSubjectSeqNo());
		lDTO.setLocationSeqNo(lMaster.getLocationSeqNo());
		lDTO.setResourceSeqNo(lMaster.getId().getResourceSeqNo());
		return lDTO;
	}

	private LMSSubjectMediaDetails setLMSSubjectMediaDetails(LMSSubjectMediaDetailsDTO lDTO) 
	{
		LMSSubjectMediaDetails lMaster = new LMSSubjectMediaDetails();
		lMaster.setLocationSeqNo(lDTO.getLocationSeqNo());
		return lMaster;
	}
}