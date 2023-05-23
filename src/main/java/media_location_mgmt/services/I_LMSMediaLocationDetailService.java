package media_location_mgmt.services;

import java.util.ArrayList;

import media_location_mgmt.model.dto.LMSMediaLocationDetailDTO;

public interface I_LMSMediaLocationDetailService
{
    abstract public LMSMediaLocationDetailDTO newLMSMediaLocationDetail(LMSMediaLocationDetailDTO mediaLocationDetailDTO);
    abstract public ArrayList<LMSMediaLocationDetailDTO> getAllLMSMediaLocationDetails();    
    abstract public LMSMediaLocationDetailDTO getLMSMediaLocationDetailById(LMSMediaLocationDetailDTO mediaLocationDTO);
    abstract public ArrayList<LMSMediaLocationDetailDTO> getSelectLMSMedia(ArrayList<Long> ids);
    abstract public ArrayList<LMSMediaLocationDetailDTO> getSelectLMSMediaByLocations(ArrayList<Long> ids);        
    abstract public void updLMSMediaLocationDetail(LMSMediaLocationDetailDTO LMSMediaLocationDetailDTO);
    abstract public void delLMSMediaLocationDetail(LMSMediaLocationDetailDTO mediaLocationDTO);
    abstract public void delAllLMSMediaLocationDetails();    
    abstract public void delSelectLMSMediaByLocations(ArrayList<Long> ids);	
    abstract public void delSelectLMSMedia(ArrayList<Long> ids);
}



