package media_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import media_mgmt.model.dto.LMSMediaMasterDTO;

public interface I_LMSMediaMasterService
{
    abstract public LMSMediaMasterDTO newLMSMediaMaster(LMSMediaMasterDTO mediaMasterDTO);
    abstract public ArrayList<LMSMediaMasterDTO> getAllLMSMediaMasters();    
    abstract public LMSMediaMasterDTO getLMSMediaMasterById(Long mediaSeqNo);
    abstract public ArrayList<LMSMediaMasterDTO> getSelectLMSMedia(ArrayList<Long> ids);
    abstract public ArrayList<LMSMediaMasterDTO> getSelectLMSMediaByCategories(ArrayList<BigDecimal> ids);    
    abstract public void updLMSMediaMaster(LMSMediaMasterDTO LMSMediaMasterDTO);
    abstract public void delLMSMedia(Long mediaSeqNo);
    abstract public void delAllLMSMediaMasters();
    abstract public void delSelectLMSMedia(ArrayList<Long> ids);
    abstract public void delSelectLMSMediaByCategories(ArrayList<BigDecimal> ids);
}



