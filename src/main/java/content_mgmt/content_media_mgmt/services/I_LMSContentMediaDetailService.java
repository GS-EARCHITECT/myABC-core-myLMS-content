package content_mgmt.content_media_mgmt.services;

import java.util.ArrayList;

import content_mgmt.content_media_mgmt.model.dto.LMSContentMediaDetailDTO;

public interface I_LMSContentMediaDetailService
{
	abstract public LMSContentMediaDetailDTO newLMSContentMediaDetail(LMSContentMediaDetailDTO contentMediaDetailDTO);
    abstract public ArrayList<LMSContentMediaDetailDTO> getAllLMSContentMediaDetails();    
    abstract public LMSContentMediaDetailDTO getLMSContentMediaDetailById(LMSContentMediaDetailDTO contentMediaDetailDTO);
    abstract public ArrayList<LMSContentMediaDetailDTO> getSelectLMSContentMediaDetail(ArrayList<Long> ids);    
    abstract public void updLMSContentMediaDetail(LMSContentMediaDetailDTO LMSContentMediaDetailDTO);
    abstract public void delLMSContentMediaDetail(LMSContentMediaDetailDTO contentMediaDetailDTO);
    abstract public void delAllLMSContentMediaDetails();    
    abstract public void delSelectLMSContentMediaDetail(ArrayList<Long> ids);
}



