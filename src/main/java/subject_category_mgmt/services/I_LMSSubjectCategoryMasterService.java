package subject_category_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;

import subject_category_mgmt.model.dto.LMSSubjectCategoryMasterDTO;

public interface I_LMSSubjectCategoryMasterService
{
    abstract public LMSSubjectCategoryMasterDTO newLMSSubjectCategoryMaster(LMSSubjectCategoryMasterDTO resourceCategoryMasterDTO);
    abstract public ArrayList<LMSSubjectCategoryMasterDTO> getAllLMSSubjectCategoryMasters();    
    abstract public LMSSubjectCategoryMasterDTO getLMSSubjectCategoryMasterById(BigDecimal resourceCategorySeqNo);  
    abstract public ArrayList<LMSSubjectCategoryMasterDTO> getSelectLMSSubjectTypes(ArrayList<BigDecimal> ids);
    abstract public ArrayList<LMSSubjectCategoryMasterDTO> getSelectLMSSubjectCategories(ArrayList<BigDecimal> ids);
    abstract public ArrayList<LMSSubjectCategoryMasterDTO> getSelectLMSSubjectCategoriesByParents(ArrayList<BigDecimal> ids);
    abstract public void updLMSSubjectCategoryMaster(LMSSubjectCategoryMasterDTO LMSSubjectCategoryMasterDTO);
    abstract public void delLMSSubjectCategoryMaster(BigDecimal DocumentSeqNo);
    abstract public void delAllLMSSubjectCategoryMasters();    
    abstract public void delSelectLMSSubjectCategories(ArrayList<BigDecimal> ids);
}