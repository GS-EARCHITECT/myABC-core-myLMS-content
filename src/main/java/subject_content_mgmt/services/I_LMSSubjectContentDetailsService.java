package subject_content_mgmt.services;

import java.util.ArrayList;

import subject_content_mgmt.model.dto.LMSSubjectContentDetailsDTO;

public interface I_LMSSubjectContentDetailsService
{
    abstract public LMSSubjectContentDetailsDTO newLMSSubjectContentDetails(LMSSubjectContentDetailsDTO resourceContentDetailsDTO);
    abstract public ArrayList<LMSSubjectContentDetailsDTO> getAllLMSSubjectContentDetailss();    
    abstract public ArrayList<LMSSubjectContentDetailsDTO> getSelectLMSSubjects(ArrayList<Long> ids);
    abstract public void updLMSSubjectContentDetails(LMSSubjectContentDetailsDTO LMSSubjectContentDetailsDTO);
    abstract public void delLMSSubjectContentDetails(LMSSubjectContentDetailsDTO lMaster);
    abstract public void delSelectLMSSubjects(ArrayList<Long> DocumentSeqNos);
    abstract public void delAllLMSSubjectContentDetailss();
}