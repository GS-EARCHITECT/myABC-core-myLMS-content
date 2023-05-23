package media_author_mgmt.services;

import java.util.ArrayList;
import media_author_mgmt.model.dto.LMSMediaAuthorDetailDTO;

public interface I_LMSMediaAuthorDetailService
{
    abstract public LMSMediaAuthorDetailDTO newLMSMediaAuthorDetail(LMSMediaAuthorDetailDTO mediaAuthorDetailDTO);
    abstract public ArrayList<LMSMediaAuthorDetailDTO> getAllLMSMediaAuthorDetails();    
    abstract public LMSMediaAuthorDetailDTO getLMSMediaAuthorDetailById(LMSMediaAuthorDetailDTO mediaAuthorDTO);
    abstract public ArrayList<LMSMediaAuthorDetailDTO> getSelectLMSMedia(ArrayList<Long> ids);
    abstract public ArrayList<LMSMediaAuthorDetailDTO> getSelectLMSMediaByAuthors(ArrayList<Long> ids);        
    abstract public void updLMSMediaAuthorDetail(LMSMediaAuthorDetailDTO LMSMediaAuthorDetailDTO);
    abstract public void delLMSMediaAuthorDetail(LMSMediaAuthorDetailDTO mediaAuthorDTO);
    abstract public void delAllLMSMediaAuthorDetails();    
    abstract public void delSelectLMSMediaByAuthors(ArrayList<Long> ids);	
    abstract public void delSelectLMSMedia(ArrayList<Long> ids);
}



