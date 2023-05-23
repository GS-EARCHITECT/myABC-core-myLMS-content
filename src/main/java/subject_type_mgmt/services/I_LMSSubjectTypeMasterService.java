package subject_type_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;

import subject_type_mgmt.model.dto.LMSSubjectTypeMasterDTO;

public interface I_LMSSubjectTypeMasterService
{
    abstract public LMSSubjectTypeMasterDTO newLMSSubjectTypeMaster(LMSSubjectTypeMasterDTO resourceTypeMasterDTO);
    abstract public ArrayList<LMSSubjectTypeMasterDTO> getAllLMSSubjectTypeMasters();    
    abstract public LMSSubjectTypeMasterDTO getLMSSubjectTypeMasterById(BigDecimal resourceTypeSeqNo);    
    abstract public ArrayList<LMSSubjectTypeMasterDTO> getSelectLMSSubjectTypes(ArrayList<BigDecimal> ids);
    abstract public ArrayList<LMSSubjectTypeMasterDTO> getSelectLMSSubjectTypesByParents(ArrayList<BigDecimal> ids);
    abstract public void updLMSSubjectTypeMaster(LMSSubjectTypeMasterDTO LMSSubjectTypeMasterDTO);
    abstract public void delLMSSubjectTypeMaster(BigDecimal DocumentSeqNo);
    abstract public void delAllLMSSubjectTypeMasters();    
    abstract public void delSelectLMSSubjectTypes(ArrayList<BigDecimal> ids);
}