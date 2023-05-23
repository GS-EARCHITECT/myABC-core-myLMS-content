package content_mgmt.content_master_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;

import content_mgmt.content_master_mgmt.model.dto.LMSContentMasterDTO;

public interface I_LMSContentMasterService
{
    abstract public LMSContentMasterDTO newLMSContentMaster(LMSContentMasterDTO contentMasterDTO);
    abstract public ArrayList<LMSContentMasterDTO> getAllLMSContentMasters();    
    abstract public LMSContentMasterDTO getLMSContentMasterById(Long contentSeqNo);  
    abstract public ArrayList<LMSContentMasterDTO> getSelectLMSContent(ArrayList<Long> ids);
    abstract public ArrayList<LMSContentMasterDTO> getSelectLMSContentByCategories(ArrayList<BigDecimal> ids);
    abstract public void updLMSContentMaster(LMSContentMasterDTO LMSContentMasterDTO);
    abstract public void delLMSContentMaster(Long contentSeqNo);
    abstract public void delAllLMSContentMasters();    
    abstract public void delSelectLMSContent(ArrayList<Long> ids);
    abstract public void delSelectLMSContentByCategories( ArrayList<BigDecimal> ids);
    
}