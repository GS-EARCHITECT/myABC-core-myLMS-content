package content_mgmt.content_type_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import content_mgmt.content_type_mgmt.model.dto.LMSContentTypeMasterDTO;
import content_mgmt.content_type_mgmt.model.master.LMSContentTypeMaster;
import content_mgmt.content_type_mgmt.model.repo.LMSContentTypeMasterRepo;

@Service("contentTypeMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSContentTypeMasterService implements I_LMSContentTypeMasterService {

	@Autowired
	private LMSContentTypeMasterRepo contentTypeMasterRepo;

	public LMSContentTypeMasterDTO newLMSContentTypeMaster(LMSContentTypeMasterDTO lMasters) {
		LMSContentTypeMaster LMSContentTypeMaster = contentTypeMasterRepo.save(this.setLMSContentTypeMaster(lMasters));
		lMasters = getLMSContentTypeMasterDTO(LMSContentTypeMaster);
		return lMasters;
	}

	public ArrayList<LMSContentTypeMasterDTO> getAllLMSContentTypeMasters() {
		ArrayList<LMSContentTypeMaster> contentTypeList = (ArrayList<LMSContentTypeMaster>) contentTypeMasterRepo.findAll();
		ArrayList<LMSContentTypeMasterDTO> lMasterss = new ArrayList<LMSContentTypeMasterDTO>();
		lMasterss = contentTypeList != null ? this.getLMSContentTypeMasterDTOs(contentTypeList) : null;
		return lMasterss;
	}

	public ArrayList<LMSContentTypeMasterDTO> getSelectLMSContentTypes(ArrayList<BigDecimal> ids) {
		ArrayList<LMSContentTypeMaster> lMasters = contentTypeMasterRepo.getSelectLMSContentTypes(ids);
		ArrayList<LMSContentTypeMasterDTO> LMSContentTypeMasterDTOs = new ArrayList<LMSContentTypeMasterDTO>();
		LMSContentTypeMasterDTO LMSContentTypeMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSContentTypeMasterDTO = this.getLMSContentTypeMasterDTO(lMasters.get(i));
				LMSContentTypeMasterDTOs.add(LMSContentTypeMasterDTO);
			}
		}
		return LMSContentTypeMasterDTOs;
	}

	public LMSContentTypeMasterDTO getLMSContentTypeMasterById(BigDecimal contentTypeSeqNo) {
		Optional<LMSContentTypeMaster> LMSContentTypeMaster = contentTypeMasterRepo.findById(contentTypeSeqNo);
		LMSContentTypeMasterDTO lMasters = null;
		if (LMSContentTypeMaster.isPresent()) {
			lMasters = LMSContentTypeMaster != null ? this.getLMSContentTypeMasterDTO(LMSContentTypeMaster.get())
					: null;
		}
		return lMasters;
	}

	public void updLMSContentTypeMaster(LMSContentTypeMasterDTO lMaster) {
		LMSContentTypeMaster contentTypeMaster = this.setLMSContentTypeMaster(lMaster);
		if (contentTypeMasterRepo.existsById(lMaster.getContentTypeSeqNo())) {
			contentTypeMaster.setContentTypeSeqNo(lMaster.getContentTypeSeqNo());
			contentTypeMasterRepo.save(contentTypeMaster);
		}
		return;
	}

	public void delLMSContentTypeMaster(BigDecimal contentTypeSeqNo) {
		if (contentTypeMasterRepo.existsById(contentTypeSeqNo)) {
			contentTypeMasterRepo.deleteById(contentTypeSeqNo);
		}
		return;
	}

	public void delSelectLMSContentTypes(ArrayList<BigDecimal> ids) {
		contentTypeMasterRepo.delSelectLMSContentTypes(ids);
		return;
	}

	public void delAllLMSContentTypeMasters() {
		contentTypeMasterRepo.deleteAll();
	}

	private ArrayList<LMSContentTypeMasterDTO> getLMSContentTypeMasterDTOs(ArrayList<LMSContentTypeMaster> lMasters) {
		LMSContentTypeMasterDTO lDTO = null;
		ArrayList<LMSContentTypeMasterDTO> lMasterDTOs = new ArrayList<LMSContentTypeMasterDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSContentTypeMasterDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSContentTypeMasterDTO getLMSContentTypeMasterDTO(LMSContentTypeMaster lMaster) {
		LMSContentTypeMasterDTO lDTO = new LMSContentTypeMasterDTO();
		lDTO.setContentTypeSeqNo(lMaster.getContentTypeSeqNo());
		lDTO.setContentType(lMaster.getContentType());
		return lDTO;
	}

	private LMSContentTypeMaster setLMSContentTypeMaster(LMSContentTypeMasterDTO lDTO) {
		LMSContentTypeMaster lMaster = new LMSContentTypeMaster();
		lMaster.setContentType(lDTO.getContentType());
		return lMaster;
	}
}