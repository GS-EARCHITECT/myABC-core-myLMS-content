package media_author_mgmt.services;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import media_author_mgmt.model.dto.LMSMediaAuthorDetailDTO;
import media_author_mgmt.model.master.LMSMediaAuthorDetail;
import media_author_mgmt.model.master.LMSMediaAuthorDetailPK;
import media_author_mgmt.model.repo.LMSMediaAuthorDetailRepo;

@Service("mediaAuthorDetailServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSMediaAuthorDetailService implements I_LMSMediaAuthorDetailService {

	@Autowired
	private LMSMediaAuthorDetailRepo mediaAuthorDetailRepo;

	public LMSMediaAuthorDetailDTO newLMSMediaAuthorDetail(LMSMediaAuthorDetailDTO lDetail) 
	{
		LMSMediaAuthorDetailPK lmsMediaAuthorDetailPK = new LMSMediaAuthorDetailPK();
		lmsMediaAuthorDetailPK.setPersonSeqNo(lDetail.getPersonSeqNo());
		lmsMediaAuthorDetailPK.setMediaSeqNo(lDetail.getMediaSeqNo());
		LMSMediaAuthorDetailDTO lmsMediaAuthorDetailDTO2 = null;
		LMSMediaAuthorDetail lmsMediaAuthorDetail = null;

		if (!mediaAuthorDetailRepo.existsById(lmsMediaAuthorDetailPK)) 
		{
			lmsMediaAuthorDetail = setLMSMediaAuthorDetail(lDetail);
			lmsMediaAuthorDetail.setId(lmsMediaAuthorDetailPK);
			lmsMediaAuthorDetailDTO2 = getLMSMediaAuthorDetailDTO(
			mediaAuthorDetailRepo.save(lmsMediaAuthorDetail));
		}
		return lmsMediaAuthorDetailDTO2;
	}
	
	public ArrayList<LMSMediaAuthorDetailDTO> getAllLMSMediaAuthorDetails() {
		ArrayList<LMSMediaAuthorDetail> mediaAuthorList = (ArrayList<LMSMediaAuthorDetail>) mediaAuthorDetailRepo
				.findAll();
		ArrayList<LMSMediaAuthorDetailDTO> lDetailss = new ArrayList<LMSMediaAuthorDetailDTO>();
		lDetailss = mediaAuthorList != null ? this.getLMSMediaAuthorDetailDTOs(mediaAuthorList) : null;
		return lDetailss;
	}

	public ArrayList<LMSMediaAuthorDetailDTO> getSelectLMSMediaByAuthors(ArrayList<Long> ids) 
	{
		ArrayList<LMSMediaAuthorDetail> lDetails = mediaAuthorDetailRepo.getSelectLMSMediaByAuthors(ids);
		ArrayList<LMSMediaAuthorDetailDTO> LMSMediaAuthorDetailDTOs = new ArrayList<LMSMediaAuthorDetailDTO>();
		LMSMediaAuthorDetailDTO LMSMediaAuthorDetailDTO = null;

		if (lDetails != null) {
			for (int i = 0; i < lDetails.size(); i++) {
				LMSMediaAuthorDetailDTO = this.getLMSMediaAuthorDetailDTO(lDetails.get(i));
				LMSMediaAuthorDetailDTOs.add(LMSMediaAuthorDetailDTO);
			}
		}
		return LMSMediaAuthorDetailDTOs;
	}

	public ArrayList<LMSMediaAuthorDetailDTO> getSelectLMSMedia(ArrayList<Long> ids) 
	{
		ArrayList<LMSMediaAuthorDetail> lDetails = mediaAuthorDetailRepo.getSelectLMSMedia(ids);
		ArrayList<LMSMediaAuthorDetailDTO> LMSMediaAuthorDetailDTOs = new ArrayList<LMSMediaAuthorDetailDTO>();
		LMSMediaAuthorDetailDTO LMSMediaAuthorDetailDTO = null;

		if (lDetails != null) {
			for (int i = 0; i < lDetails.size(); i++) {
				LMSMediaAuthorDetailDTO = this.getLMSMediaAuthorDetailDTO(lDetails.get(i));
				LMSMediaAuthorDetailDTOs.add(LMSMediaAuthorDetailDTO);
			}
		}
		return LMSMediaAuthorDetailDTOs;
	}

	
	
	public LMSMediaAuthorDetailDTO getLMSMediaAuthorDetailById(LMSMediaAuthorDetailDTO lmsMediaAuthorDetailDTO) 
	{
		LMSMediaAuthorDetailPK lmsMediaAuthorDetailPK = new LMSMediaAuthorDetailPK();
		lmsMediaAuthorDetailPK.setMediaSeqNo(lmsMediaAuthorDetailDTO.getMediaSeqNo());
		lmsMediaAuthorDetailPK.setPersonSeqNo(lmsMediaAuthorDetailDTO.getPersonSeqNo());
		LMSMediaAuthorDetailDTO lmsMediaAuthorDetailDTO2 = null;
		LMSMediaAuthorDetail lmsMediaAuthorDetail = null;
		Optional<LMSMediaAuthorDetail> LMSMediaAuthorDetail = mediaAuthorDetailRepo
				.findById(lmsMediaAuthorDetailPK);
		
		if (LMSMediaAuthorDetail.isPresent()) {
			lmsMediaAuthorDetailDTO = LMSMediaAuthorDetail != null
					? this.getLMSMediaAuthorDetailDTO(LMSMediaAuthorDetail.get())
					: null;
		}
		return lmsMediaAuthorDetailDTO;

	}
	
	public void updLMSMediaAuthorDetail(LMSMediaAuthorDetailDTO lmsMediaAuthorDetailDTO) 
	{
		LMSMediaAuthorDetail lmsMediaAuthorDetail = null;
		LMSMediaAuthorDetailPK lmsMediaAuthorDetailPK = new LMSMediaAuthorDetailPK();
		lmsMediaAuthorDetailPK.setMediaSeqNo(lmsMediaAuthorDetailDTO.getMediaSeqNo());
		lmsMediaAuthorDetailPK.setPersonSeqNo(lmsMediaAuthorDetailDTO.getPersonSeqNo());
		LMSMediaAuthorDetailDTO lmsMediaAuthorDetailDTO2 = null;		
		Optional<LMSMediaAuthorDetail> LMSMediaAuthorDetail = mediaAuthorDetailRepo
				.findById(lmsMediaAuthorDetailPK);
		
		if (mediaAuthorDetailRepo.existsById(lmsMediaAuthorDetailPK)) 
		{
			lmsMediaAuthorDetail = this.setLMSMediaAuthorDetail(lmsMediaAuthorDetailDTO);
			mediaAuthorDetailRepo.save(lmsMediaAuthorDetail);
		}
		return;
	}

	public void delLMSMediaAuthorDetail(LMSMediaAuthorDetailDTO lmsMediaAuthorDetailDTO) 
	{
		
		LMSMediaAuthorDetail lmsMediaAuthorDetail = null;
		LMSMediaAuthorDetailPK lmsMediaAuthorDetailPK = new LMSMediaAuthorDetailPK();
		lmsMediaAuthorDetailPK.setMediaSeqNo(lmsMediaAuthorDetailDTO.getMediaSeqNo());
		lmsMediaAuthorDetailPK.setPersonSeqNo(lmsMediaAuthorDetailDTO.getPersonSeqNo());
		LMSMediaAuthorDetailDTO lmsMediaAuthorDetailDTO2 = null;		
		Optional<LMSMediaAuthorDetail> LMSMediaAuthorDetail = mediaAuthorDetailRepo.findById(lmsMediaAuthorDetailPK);
		
		if (mediaAuthorDetailRepo.existsById(lmsMediaAuthorDetailPK)) 
		{
			mediaAuthorDetailRepo.deleteById(lmsMediaAuthorDetailPK);
		}
		return;
	}

	public void delSelectLMSMedia(ArrayList<Long> ids) 
	{
		mediaAuthorDetailRepo.delSelectLMSMedia(ids);
		return;
	}

	public void delSelectLMSMediaByAuthors(ArrayList<Long> ids) 
	{
		mediaAuthorDetailRepo.delSelectLMSMediaByAuthors(ids);
		return;
	}
	
	public void delAllLMSMediaAuthorDetails() {
		mediaAuthorDetailRepo.deleteAll();
	}

	private ArrayList<LMSMediaAuthorDetailDTO> getLMSMediaAuthorDetailDTOs(
			ArrayList<LMSMediaAuthorDetail> lDetails) {
		LMSMediaAuthorDetailDTO lDTO = null;
		ArrayList<LMSMediaAuthorDetailDTO> lDetailDTOs = new ArrayList<LMSMediaAuthorDetailDTO>();
		for (int i = 0; i < lDetails.size(); i++) {
			lDTO = getLMSMediaAuthorDetailDTO(lDetails.get(i));
			lDetailDTOs.add(lDTO);
		}
		return lDetailDTOs;
	}

	private LMSMediaAuthorDetailDTO getLMSMediaAuthorDetailDTO(LMSMediaAuthorDetail lmsMediaAuthorDetail) 
	{
		LMSMediaAuthorDetailDTO lDTO = new LMSMediaAuthorDetailDTO();
		lDTO.setPersonSeqNo(lmsMediaAuthorDetail.getId().getPersonSeqNo());
		lDTO.setMediaSeqNo(lmsMediaAuthorDetail.getId().getMediaSeqNo());
		lDTO.setSpecificationSeqNo(lmsMediaAuthorDetail.getSpecificationSeq());		
		return lDTO;
	}

	private LMSMediaAuthorDetail setLMSMediaAuthorDetail(LMSMediaAuthorDetailDTO lDTO) 
	{
		LMSMediaAuthorDetail lmsMediaAuthorDetail = new LMSMediaAuthorDetail();
		LMSMediaAuthorDetailPK lmslMediaAuthorDetailPK = new LMSMediaAuthorDetailPK();		
		lmslMediaAuthorDetailPK.setMediaSeqNo(lDTO.getMediaSeqNo());
		lmslMediaAuthorDetailPK.setPersonSeqNo(lDTO.getPersonSeqNo());
		lmsMediaAuthorDetail.setSpecificationSeq(lDTO.getSpecificationSeqNo());
		lmsMediaAuthorDetail.setId(lmslMediaAuthorDetailPK);		
		return lmsMediaAuthorDetail;
	}
}