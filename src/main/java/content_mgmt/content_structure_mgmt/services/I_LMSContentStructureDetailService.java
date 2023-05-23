package content_mgmt.content_structure_mgmt.services;

import java.util.ArrayList;

import content_mgmt.content_structure_mgmt.model.dto.LMSContentStructureDetailDTO;

public interface I_LMSContentStructureDetailService
{
    abstract public LMSContentStructureDetailDTO newLMSContentStructureDetail(LMSContentStructureDetailDTO contentStructureDetailDTO);
    abstract public ArrayList<LMSContentStructureDetailDTO> getAllLMSContentStructureDetails();    
    abstract public LMSContentStructureDetailDTO getLMSContentStructureDetailById(LMSContentStructureDetailDTO contentStructureDetailDTO);
    abstract public ArrayList<LMSContentStructureDetailDTO> getSelectLMSContentStructureDetail(ArrayList<Long> ids);
    abstract public ArrayList<LMSContentStructureDetailDTO> getSelectLMSContentStructureDetailbyParents(ArrayList<Long> ids);
    abstract public void updLMSContentStructureDetail(LMSContentStructureDetailDTO LMSContentStructureDetailDTO);
    abstract public void delLMSContentStructureDetail(LMSContentStructureDetailDTO contentStructureDetailDTO);
    abstract public void delAllLMSContentStructureDetails();    
    abstract public void delSelectLMSContentStructureDetail(ArrayList<Long> ids);
    abstract public void delSelectLMSContentStructureDetailByParents(ArrayList<Long> ids);
}



