package content_mgmt.content_type_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;

import content_mgmt.content_type_mgmt.model.dto.LMSContentTypeMasterDTO;

public interface I_LMSContentTypeMasterService
{
    abstract public LMSContentTypeMasterDTO newLMSContentTypeMaster(LMSContentTypeMasterDTO contentTypeMasterDTO);
    abstract public ArrayList<LMSContentTypeMasterDTO> getAllLMSContentTypeMasters();    
    abstract public LMSContentTypeMasterDTO getLMSContentTypeMasterById(BigDecimal contentTypeSeqNo);  
    abstract public ArrayList<LMSContentTypeMasterDTO> getSelectLMSContentTypes(ArrayList<BigDecimal> ids);
    abstract public void updLMSContentTypeMaster(LMSContentTypeMasterDTO LMSContentTypeMasterDTO);
    abstract public void delLMSContentTypeMaster(BigDecimal contentTypeSeqNo);
    abstract public void delAllLMSContentTypeMasters();    
    abstract public void delSelectLMSContentTypes(ArrayList<BigDecimal> ids);
}