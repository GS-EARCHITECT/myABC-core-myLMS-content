package content_mgmt.content_category_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;

import content_mgmt.content_category_mgmt.model.dto.LMSContentCategoryMasterDTO;

public interface I_LMSContentCategoryMasterService
{
    abstract public LMSContentCategoryMasterDTO newLMSContentCategoryMaster(LMSContentCategoryMasterDTO contentCategoryMasterDTO);
    abstract public ArrayList<LMSContentCategoryMasterDTO> getAllLMSContentCategoryMasters();    
    abstract public LMSContentCategoryMasterDTO getLMSContentCategoryMasterById(LMSContentCategoryMasterDTO contentCategoryMasterDTO);
    abstract public ArrayList<LMSContentCategoryMasterDTO> getSelectLMSContentCategories(ArrayList<BigDecimal> ids);
    abstract public ArrayList<LMSContentCategoryMasterDTO> getSelectLMSContentCategoriesForTypes(ArrayList<BigDecimal> ids);
    abstract public void updLMSContentCategoryMaster(LMSContentCategoryMasterDTO LMSContentCategoryMasterDTO);
    abstract public void delLMSContentCategoryMaster(LMSContentCategoryMasterDTO contentCategoryMasterDTO);
    abstract public void delAllLMSContentCategoryMasters();    
    abstract public void delSelectLMSContentCategories(ArrayList<BigDecimal> ids);
}



