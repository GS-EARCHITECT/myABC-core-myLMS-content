package media_category_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;

import media_category_mgmt.model.dto.LMSMediaCategoryMasterDTO;

public interface I_LMSMediaCategoryMasterService
{
    abstract public LMSMediaCategoryMasterDTO newLMSMediaCategoryMaster(LMSMediaCategoryMasterDTO mediaCategoryMasterDTO);
    abstract public ArrayList<LMSMediaCategoryMasterDTO> getAllLMSMediaCategoryMasters();    
    abstract public LMSMediaCategoryMasterDTO getLMSMediaCategoryMasterById(BigDecimal mediaCategorySeqNo);
    abstract public ArrayList<LMSMediaCategoryMasterDTO> getSelectLMSMediaCategories(ArrayList<BigDecimal> ids);    
    abstract public void updLMSMediaCategoryMaster(LMSMediaCategoryMasterDTO LMSMediaCategoryMasterDTO);
    abstract public void delLMSMediaCategoryMaster(BigDecimal mediaCategorySeqNo);
    abstract public void delAllLMSMediaCategoryMasters();    
    abstract public void delSelectLMSMediaCategories(ArrayList<BigDecimal> ids);
}



