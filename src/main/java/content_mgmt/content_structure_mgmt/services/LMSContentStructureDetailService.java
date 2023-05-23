package content_mgmt.content_structure_mgmt.services;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import content_mgmt.content_structure_mgmt.model.dto.LMSContentStructureDetailDTO;
import content_mgmt.content_structure_mgmt.model.master.LMSContentStructureDetail;
import content_mgmt.content_structure_mgmt.model.master.LMSContentStructureDetailPK;
import content_mgmt.content_structure_mgmt.model.repo.LMSContentStructureDetailRepo;

@Service("contentStructureDetailServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSContentStructureDetailService implements I_LMSContentStructureDetailService {

	@Autowired
	private LMSContentStructureDetailRepo contentStructureDetailRepo;

	public LMSContentStructureDetailDTO newLMSContentStructureDetail(LMSContentStructureDetailDTO lmsContentStructureDetailDTO) {
		LMSContentStructureDetailPK lmsContentStructureDetailPK = new LMSContentStructureDetailPK();
		lmsContentStructureDetailPK.setContentSeqNo(lmsContentStructureDetailDTO.getContentSeqNo());
		lmsContentStructureDetailPK.setParContentSeqNo(lmsContentStructureDetailDTO.getParContentSeqNo());
		LMSContentStructureDetailDTO lmsContentStructureDetailDTO2 = null;
		LMSContentStructureDetail lmsContentStructureDetail = null;

		if (!contentStructureDetailRepo.existsById(lmsContentStructureDetailPK)) {
			lmsContentStructureDetail = setLMSContentStructureDetail(lmsContentStructureDetailDTO);
			lmsContentStructureDetail.setId(lmsContentStructureDetailPK);
			lmsContentStructureDetailDTO2 = getLMSContentStructureDetailDTO(contentStructureDetailRepo.save(lmsContentStructureDetail));
		}
		return lmsContentStructureDetailDTO2;
	}

	public ArrayList<LMSContentStructureDetailDTO> getAllLMSContentStructureDetails() {
		ArrayList<LMSContentStructureDetail> contentCategoryList = (ArrayList<LMSContentStructureDetail>) contentStructureDetailRepo
				.findAll();
		ArrayList<LMSContentStructureDetailDTO> lMasterss = new ArrayList<LMSContentStructureDetailDTO>();
		lMasterss = contentCategoryList != null ? this.getLMSContentStructureDetailDTOs(contentCategoryList) : null;
		return lMasterss;
	}

	public ArrayList<LMSContentStructureDetailDTO> getSelectLMSContentStructureDetail(ArrayList<Long> ids) {
		ArrayList<LMSContentStructureDetail> lMasters = contentStructureDetailRepo.getSelectLMSContentDetails(ids);
		ArrayList<LMSContentStructureDetailDTO> LMSContentStructureDetailDTOs = new ArrayList<LMSContentStructureDetailDTO>();
		LMSContentStructureDetailDTO LMSContentStructureDetailDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSContentStructureDetailDTO = this.getLMSContentStructureDetailDTO(lMasters.get(i));
				LMSContentStructureDetailDTOs.add(LMSContentStructureDetailDTO);
			}
		}
		return LMSContentStructureDetailDTOs;
	}

	public ArrayList<LMSContentStructureDetailDTO> getSelectLMSContentStructureDetailbyParents(ArrayList<Long> ids) 
	{
		ArrayList<LMSContentStructureDetail> lMasters = contentStructureDetailRepo.getSelectLMSContentDetailsByParents(ids);
		ArrayList<LMSContentStructureDetailDTO> LMSContentStructureDetailDTOs = new ArrayList<LMSContentStructureDetailDTO>();
		LMSContentStructureDetailDTO LMSContentStructureDetailDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSContentStructureDetailDTO = this.getLMSContentStructureDetailDTO(lMasters.get(i));
				LMSContentStructureDetailDTOs.add(LMSContentStructureDetailDTO);
			}
		}
		return LMSContentStructureDetailDTOs;
	}

	
	public LMSContentStructureDetailDTO getLMSContentStructureDetailById(LMSContentStructureDetailDTO contentStructureDetailDTO) {
		LMSContentStructureDetailPK lmsContentStructureDetailPK = new LMSContentStructureDetailPK();
		lmsContentStructureDetailPK.setContentSeqNo(contentStructureDetailDTO.getContentSeqNo());
		lmsContentStructureDetailPK.setParContentSeqNo(contentStructureDetailDTO.getParContentSeqNo());
		LMSContentStructureDetailDTO lmsContentStructureDetailDTO2 = null;
		LMSContentStructureDetail lmsContentStructureDetail = null;
		Optional<LMSContentStructureDetail> LMSContentStructureDetail = contentStructureDetailRepo
				.findById(lmsContentStructureDetailPK);
		LMSContentStructureDetailDTO lmsContentStructureDetailDTO = null;

		if (LMSContentStructureDetail.isPresent()) {
			lmsContentStructureDetailDTO = LMSContentStructureDetail != null
					? this.getLMSContentStructureDetailDTO(LMSContentStructureDetail.get())
					: null;
		}
		return lmsContentStructureDetailDTO;
	}

	public void updLMSContentStructureDetail(LMSContentStructureDetailDTO lmsContentStructureDetailDTO) {
		LMSContentStructureDetailPK lmsContentStructureDetailPK = new LMSContentStructureDetailPK();
		lmsContentStructureDetailPK.setContentSeqNo(lmsContentStructureDetailDTO.getContentSeqNo());
		lmsContentStructureDetailPK.setParContentSeqNo(lmsContentStructureDetailDTO.getParContentSeqNo());
		LMSContentStructureDetail lmsContentStructureDetail = null;

		if (contentStructureDetailRepo.existsById(lmsContentStructureDetailPK)) {
			lmsContentStructureDetail = this.setLMSContentStructureDetail(lmsContentStructureDetailDTO);
			contentStructureDetailRepo.save(lmsContentStructureDetail);
		}
		return;
	}

	public void delLMSContentStructureDetail(LMSContentStructureDetailDTO lmsContentStructureDetailDTO) {
		LMSContentStructureDetailPK lmsContentStructureDetailPK = new LMSContentStructureDetailPK();
		lmsContentStructureDetailPK.setContentSeqNo(lmsContentStructureDetailDTO.getContentSeqNo());
		lmsContentStructureDetailPK.setParContentSeqNo(lmsContentStructureDetailDTO.getParContentSeqNo());
		LMSContentStructureDetail lmsContentStructureDetail = null;

		if (contentStructureDetailRepo.existsById(lmsContentStructureDetailPK)) {
			contentStructureDetailRepo.deleteById(lmsContentStructureDetailPK);
		}
		return;
	}

	public void delSelectLMSContentStructureDetail(ArrayList<Long> ids) {
		contentStructureDetailRepo.delSelectLMSContentDetails(ids);
		return;
	}

	public void delSelectLMSContentStructureDetailByParents(ArrayList<Long> ids) 
	{
		contentStructureDetailRepo.delSelectLMSContentDetailsByParents(ids);
		return;
	}

	
	public void delAllLMSContentStructureDetails() {
		contentStructureDetailRepo.deleteAll();
	}

	private ArrayList<LMSContentStructureDetailDTO> getLMSContentStructureDetailDTOs(
			ArrayList<LMSContentStructureDetail> lMasters) {
		LMSContentStructureDetailDTO lDTO = null;
		ArrayList<LMSContentStructureDetailDTO> lMasterDTOs = new ArrayList<LMSContentStructureDetailDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSContentStructureDetailDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSContentStructureDetailDTO getLMSContentStructureDetailDTO(LMSContentStructureDetail lmsContentStructureDetail) {
		LMSContentStructureDetailDTO lDTO = new LMSContentStructureDetailDTO();
		lDTO.setContentSeqNo(lmsContentStructureDetail.getId().getContentSeqNo());
		lDTO.setParContentSeqNo(lmsContentStructureDetail.getId().getParContentSeqNo());
		lDTO.setContentSummary(lmsContentStructureDetail.getContentSummary());		
		return lDTO;
	}

	private LMSContentStructureDetail setLMSContentStructureDetail(LMSContentStructureDetailDTO lDTO) {
		LMSContentStructureDetailPK lmsContentStructureDetailPK = new LMSContentStructureDetailPK();
		LMSContentStructureDetail lmsContentStructureDetail = new LMSContentStructureDetail();
		lmsContentStructureDetailPK.setContentSeqNo(lDTO.getContentSeqNo());
		lmsContentStructureDetailPK.setParContentSeqNo(lDTO.getParContentSeqNo());
		lmsContentStructureDetail.setContentSummary(lDTO.getContentSummary());
		lmsContentStructureDetail.setId(lmsContentStructureDetailPK);
		return lmsContentStructureDetail;
	}
}