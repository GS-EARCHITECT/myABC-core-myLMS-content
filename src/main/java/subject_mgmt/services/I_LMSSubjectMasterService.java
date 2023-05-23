package subject_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import subject_mgmt.model.dto.LMSSubjectMasterDTO;

public interface I_LMSSubjectMasterService
{
    abstract public LMSSubjectMasterDTO newLMSSubjectMaster(LMSSubjectMasterDTO resourceCategoryMasterDTO);
    abstract public ArrayList<LMSSubjectMasterDTO> getAllLMSSubjectMasters();    
    abstract public LMSSubjectMasterDTO getLMSSubjectMasterById(Long resourceCategorySeqNo);
    abstract public ArrayList<LMSSubjectMasterDTO> getSelectLMSSubjectCategories(ArrayList<BigDecimal> ids);
    abstract public ArrayList<LMSSubjectMasterDTO> getSelectLMSSubjects(ArrayList<Long> ids);
    abstract public void updLMSSubjectMaster(LMSSubjectMasterDTO LMSSubjectMasterDTO);
    abstract public void delLMSSubjectMaster(Long DocumentSeqNo);
    abstract public void delSelectLMSSubjectCategories(ArrayList<BigDecimal> DocumentSeqNo);
    abstract public void delSelectLMSSubjects(ArrayList<Long> DocumentSeqNo);
    abstract public void delAllLMSSubjectMasters();
}