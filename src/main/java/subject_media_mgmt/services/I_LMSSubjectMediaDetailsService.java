package subject_media_mgmt.services;

import java.util.ArrayList;
import subject_media_mgmt.model.dto.LMSSubjectMediaDetailsDTO;

public interface I_LMSSubjectMediaDetailsService
{
    abstract public LMSSubjectMediaDetailsDTO newLMSSubjectMediaDetails(LMSSubjectMediaDetailsDTO resourceMediaDetailsDTO);
    abstract public ArrayList<LMSSubjectMediaDetailsDTO> getAllLMSSubjectMediaDetailss();    
    abstract public ArrayList<LMSSubjectMediaDetailsDTO> getSelectLMSMediaBySubjects(ArrayList<Long> ids);
    abstract public ArrayList<LMSSubjectMediaDetailsDTO> getSelectLMSSubjectsByMedia(ArrayList<Long> ids);
    abstract public void updLMSSubjectMediaDetails(LMSSubjectMediaDetailsDTO LMSSubjectMediaDetailsDTO);
    abstract public void delLMSSubjectMediaDetails(LMSSubjectMediaDetailsDTO lMaster);    
    abstract public void delSelectLMSSubjects(ArrayList<Long> DocumentSeqNos);
    abstract public void delAllLMSSubjectMediaDetailss();
        
}