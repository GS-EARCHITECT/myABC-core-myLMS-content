package content_mgmt.content_media_mgmt.services;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import content_mgmt.content_media_mgmt.model.dto.LMSContentMediaDetailDTO;
import content_mgmt.content_media_mgmt.model.master.LMSContentMediaDetail;
import content_mgmt.content_media_mgmt.model.master.LMSContentMediaDetailPK;
import content_mgmt.content_media_mgmt.model.repo.LMSContentMediaDetailRepo;

@Service("contentMediaDetailServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSContentMediaDetailService implements I_LMSContentMediaDetailService {

	@Autowired
	private LMSContentMediaDetailRepo contentMediaDetailRepo;

	public LMSContentMediaDetailDTO newLMSContentMediaDetail(LMSContentMediaDetailDTO lmsContentMediaDetailDTO) {
		LMSContentMediaDetailPK lmsContentMediaDetailPK = new LMSContentMediaDetailPK();
		lmsContentMediaDetailPK.setContentSeqNo(lmsContentMediaDetailDTO.getContentSeqNo());
		lmsContentMediaDetailPK.setMediaSeqNo(lmsContentMediaDetailDTO.getMediaSeqNo());
		LMSContentMediaDetailDTO lmsContentMediaDetailDTO2 = null;
		LMSContentMediaDetail lmsContentMediaDetail = null;

		if (!contentMediaDetailRepo.existsById(lmsContentMediaDetailPK)) {
			lmsContentMediaDetail = setLMSContentMediaDetail(lmsContentMediaDetailDTO);
			lmsContentMediaDetail.setId(lmsContentMediaDetailPK);
			lmsContentMediaDetailDTO2 = getLMSContentMediaDetailDTO(contentMediaDetailRepo.save(lmsContentMediaDetail));
		}
		return lmsContentMediaDetailDTO2;
	}

	public ArrayList<LMSContentMediaDetailDTO> getAllLMSContentMediaDetails() {
		ArrayList<LMSContentMediaDetail> contentCategoryList = (ArrayList<LMSContentMediaDetail>) contentMediaDetailRepo
				.findAll();
		ArrayList<LMSContentMediaDetailDTO> lMasterss = new ArrayList<LMSContentMediaDetailDTO>();
		lMasterss = contentCategoryList != null ? this.getLMSContentMediaDetailDTOs(contentCategoryList) : null;
		return lMasterss;
	}

	public ArrayList<LMSContentMediaDetailDTO> getSelectLMSContentMediaDetail(ArrayList<Long> ids) {
		ArrayList<LMSContentMediaDetail> lMasters = contentMediaDetailRepo.getSelectLMSContentDetails(ids);
		ArrayList<LMSContentMediaDetailDTO> LMSContentMediaDetailDTOs = new ArrayList<LMSContentMediaDetailDTO>();
		LMSContentMediaDetailDTO LMSContentMediaDetailDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSContentMediaDetailDTO = this.getLMSContentMediaDetailDTO(lMasters.get(i));
				LMSContentMediaDetailDTOs.add(LMSContentMediaDetailDTO);
			}
		}
		return LMSContentMediaDetailDTOs;
	}

	public LMSContentMediaDetailDTO getLMSContentMediaDetailById(LMSContentMediaDetailDTO contentMediaDetailDTO) {
		LMSContentMediaDetailPK lmsContentMediaDetailPK = new LMSContentMediaDetailPK();
		lmsContentMediaDetailPK.setContentSeqNo(contentMediaDetailDTO.getContentSeqNo());
		lmsContentMediaDetailPK.setMediaSeqNo(contentMediaDetailDTO.getMediaSeqNo());
		Optional<LMSContentMediaDetail> LMSContentMediaDetail = contentMediaDetailRepo
				.findById(lmsContentMediaDetailPK);
		LMSContentMediaDetailDTO lmsContentMediaDetailDTO = null;

		if (LMSContentMediaDetail.isPresent()) {
			lmsContentMediaDetailDTO = LMSContentMediaDetail != null
					? this.getLMSContentMediaDetailDTO(LMSContentMediaDetail.get())
					: null;
		}
		return lmsContentMediaDetailDTO;
	}

	public void updLMSContentMediaDetail(LMSContentMediaDetailDTO lmsContentMediaDetailDTO) {
		LMSContentMediaDetailPK lmsContentMediaDetailPK = new LMSContentMediaDetailPK();
		lmsContentMediaDetailPK.setContentSeqNo(lmsContentMediaDetailDTO.getContentSeqNo());
		lmsContentMediaDetailPK.setMediaSeqNo(lmsContentMediaDetailDTO.getMediaSeqNo());
		LMSContentMediaDetail lmsContentMediaDetail = null;

		if (contentMediaDetailRepo.existsById(lmsContentMediaDetailPK)) {
			lmsContentMediaDetail = this.setLMSContentMediaDetail(lmsContentMediaDetailDTO);
			contentMediaDetailRepo.save(lmsContentMediaDetail);
		}
		return;
	}

	public void delLMSContentMediaDetail(LMSContentMediaDetailDTO lmsContentMediaDetailDTO) {
		LMSContentMediaDetailPK lmsContentMediaDetailPK = new LMSContentMediaDetailPK();
		lmsContentMediaDetailPK.setContentSeqNo(lmsContentMediaDetailDTO.getContentSeqNo());
		lmsContentMediaDetailPK.setMediaSeqNo(lmsContentMediaDetailDTO.getMediaSeqNo());

		if (contentMediaDetailRepo.existsById(lmsContentMediaDetailPK)) {
			contentMediaDetailRepo.deleteById(lmsContentMediaDetailPK);
		}
		return;
	}

	public void delSelectLMSContentMediaDetail(ArrayList<Long> ids) {
		contentMediaDetailRepo.delSelectLMSContentDetails(ids);
		return;
	}

	public void delAllLMSContentMediaDetails() {
		contentMediaDetailRepo.deleteAll();
	}

	private ArrayList<LMSContentMediaDetailDTO> getLMSContentMediaDetailDTOs(
			ArrayList<LMSContentMediaDetail> lMasters) {
		LMSContentMediaDetailDTO lDTO = null;
		ArrayList<LMSContentMediaDetailDTO> lMasterDTOs = new ArrayList<LMSContentMediaDetailDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSContentMediaDetailDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSContentMediaDetailDTO getLMSContentMediaDetailDTO(LMSContentMediaDetail lmsContentMediaDetail) {
		LMSContentMediaDetailDTO lDTO = new LMSContentMediaDetailDTO();
		lDTO.setContentSeqNo(lmsContentMediaDetail.getId().getContentSeqNo());
		lDTO.setMediaSeqNo(lmsContentMediaDetail.getId().getMediaSeqNo());
		lDTO.setFromLocationNo(lmsContentMediaDetail.getFromLocationNo());
		lDTO.setToLocationNo(lmsContentMediaDetail.getToLocationNo());
		return lDTO;
	}

	private LMSContentMediaDetail setLMSContentMediaDetail(LMSContentMediaDetailDTO lDTO) {
		LMSContentMediaDetailPK lmsContentMediaDetailPK = new LMSContentMediaDetailPK();
		LMSContentMediaDetail lmsContentMediaDetail = new LMSContentMediaDetail();
		lmsContentMediaDetailPK.setContentSeqNo(lDTO.getContentSeqNo());
		lmsContentMediaDetailPK.setMediaSeqNo(lDTO.getMediaSeqNo());
		lmsContentMediaDetail.setFromLocationNo(lDTO.getFromLocationNo());
		lmsContentMediaDetail.setToLocationNo(lDTO.getToLocationNo());
		return lmsContentMediaDetail;
	}
}