package media_location_mgmt.services;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import media_location_mgmt.model.dto.LMSMediaLocationDetailDTO;
import media_location_mgmt.model.master.LMSMediaLocationDetail;
import media_location_mgmt.model.master.LMSMediaLocationDetailPK;
import media_location_mgmt.model.repo.LMSMediaLocationDetailRepo;

@Service("mediaLocationDetailServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSMediaLocationDetailService implements I_LMSMediaLocationDetailService {

	@Autowired
	private LMSMediaLocationDetailRepo mediaLocationDetailRepo;

	public LMSMediaLocationDetailDTO newLMSMediaLocationDetail(LMSMediaLocationDetailDTO lDetail) 
	{
		LMSMediaLocationDetailPK lmsMediaLocationDetailPK = new LMSMediaLocationDetailPK();
		lmsMediaLocationDetailPK.setLocationSeqNo(lDetail.getLocationSeqNo());
		lmsMediaLocationDetailPK.setMediaSeqNo(lDetail.getMediaSeqNo());
		LMSMediaLocationDetailDTO lmsMediaLocationDetailDTO2 = null;
		LMSMediaLocationDetail lmsMediaLocationDetail = null;

		if (!mediaLocationDetailRepo.existsById(lmsMediaLocationDetailPK)) 
		{
			lmsMediaLocationDetail = setLMSMediaLocationDetail(lDetail);
			lmsMediaLocationDetail.setId(lmsMediaLocationDetailPK);
			lmsMediaLocationDetailDTO2 = getLMSMediaLocationDetailDTO(
			mediaLocationDetailRepo.save(lmsMediaLocationDetail));
		}
		return lmsMediaLocationDetailDTO2;
	}
	
	public ArrayList<LMSMediaLocationDetailDTO> getAllLMSMediaLocationDetails() {
		ArrayList<LMSMediaLocationDetail> mediaLocationList = (ArrayList<LMSMediaLocationDetail>) mediaLocationDetailRepo
				.findAll();
		ArrayList<LMSMediaLocationDetailDTO> lDetailss = new ArrayList<LMSMediaLocationDetailDTO>();
		lDetailss = mediaLocationList != null ? this.getLMSMediaLocationDetailDTOs(mediaLocationList) : null;
		return lDetailss;
	}

	public ArrayList<LMSMediaLocationDetailDTO> getSelectLMSMediaByLocations(ArrayList<Long> ids) 
	{
		ArrayList<LMSMediaLocationDetail> lDetails = mediaLocationDetailRepo.getSelectLMSMediaByLocations(ids);
		ArrayList<LMSMediaLocationDetailDTO> LMSMediaLocationDetailDTOs = new ArrayList<LMSMediaLocationDetailDTO>();
		LMSMediaLocationDetailDTO LMSMediaLocationDetailDTO = null;

		if (lDetails != null) {
			for (int i = 0; i < lDetails.size(); i++) {
				LMSMediaLocationDetailDTO = this.getLMSMediaLocationDetailDTO(lDetails.get(i));
				LMSMediaLocationDetailDTOs.add(LMSMediaLocationDetailDTO);
			}
		}
		return LMSMediaLocationDetailDTOs;
	}

	public ArrayList<LMSMediaLocationDetailDTO> getSelectLMSMedia(ArrayList<Long> ids) 
	{
		ArrayList<LMSMediaLocationDetail> lDetails = mediaLocationDetailRepo.getSelectLMSMedia(ids);
		ArrayList<LMSMediaLocationDetailDTO> LMSMediaLocationDetailDTOs = new ArrayList<LMSMediaLocationDetailDTO>();
		LMSMediaLocationDetailDTO LMSMediaLocationDetailDTO = null;

		if (lDetails != null) {
			for (int i = 0; i < lDetails.size(); i++) {
				LMSMediaLocationDetailDTO = this.getLMSMediaLocationDetailDTO(lDetails.get(i));
				LMSMediaLocationDetailDTOs.add(LMSMediaLocationDetailDTO);
			}
		}
		return LMSMediaLocationDetailDTOs;
	}

	
	
	public LMSMediaLocationDetailDTO getLMSMediaLocationDetailById(LMSMediaLocationDetailDTO lmsMediaLocationDetailDTO) 
	{
		LMSMediaLocationDetailPK lmsMediaLocationDetailPK = new LMSMediaLocationDetailPK();
		lmsMediaLocationDetailPK.setMediaSeqNo(lmsMediaLocationDetailDTO.getMediaSeqNo());
		lmsMediaLocationDetailPK.setLocationSeqNo(lmsMediaLocationDetailDTO.getLocationSeqNo());
		LMSMediaLocationDetailDTO lmsMediaLocationDetailDTO2 = null;
		LMSMediaLocationDetail lmsMediaLocationDetail = null;
		Optional<LMSMediaLocationDetail> LMSMediaLocationDetail = mediaLocationDetailRepo
				.findById(lmsMediaLocationDetailPK);
		
		if (LMSMediaLocationDetail.isPresent()) {
			lmsMediaLocationDetailDTO = LMSMediaLocationDetail != null
					? this.getLMSMediaLocationDetailDTO(LMSMediaLocationDetail.get())
					: null;
		}
		return lmsMediaLocationDetailDTO;

	}
	
	public void updLMSMediaLocationDetail(LMSMediaLocationDetailDTO lmsMediaLocationDetailDTO) 
	{
		LMSMediaLocationDetail lmsMediaLocationDetail = null;
		LMSMediaLocationDetailPK lmsMediaLocationDetailPK = new LMSMediaLocationDetailPK();
		lmsMediaLocationDetailPK.setMediaSeqNo(lmsMediaLocationDetailDTO.getMediaSeqNo());
		lmsMediaLocationDetailPK.setLocationSeqNo(lmsMediaLocationDetailDTO.getLocationSeqNo());
		LMSMediaLocationDetailDTO lmsMediaLocationDetailDTO2 = null;		
		Optional<LMSMediaLocationDetail> LMSMediaLocationDetail = mediaLocationDetailRepo
				.findById(lmsMediaLocationDetailPK);
		
		if (mediaLocationDetailRepo.existsById(lmsMediaLocationDetailPK)) 
		{
			lmsMediaLocationDetail = this.setLMSMediaLocationDetail(lmsMediaLocationDetailDTO);
			mediaLocationDetailRepo.save(lmsMediaLocationDetail);
		}
		return;
	}

	public void delLMSMediaLocationDetail(LMSMediaLocationDetailDTO lmsMediaLocationDetailDTO) 
	{
		
		LMSMediaLocationDetail lmsMediaLocationDetail = null;
		LMSMediaLocationDetailPK lmsMediaLocationDetailPK = new LMSMediaLocationDetailPK();
		lmsMediaLocationDetailPK.setMediaSeqNo(lmsMediaLocationDetailDTO.getMediaSeqNo());
		lmsMediaLocationDetailPK.setLocationSeqNo(lmsMediaLocationDetailDTO.getLocationSeqNo());
		LMSMediaLocationDetailDTO lmsMediaLocationDetailDTO2 = null;		
		Optional<LMSMediaLocationDetail> LMSMediaLocationDetail = mediaLocationDetailRepo.findById(lmsMediaLocationDetailPK);
		
		if (mediaLocationDetailRepo.existsById(lmsMediaLocationDetailPK)) 
		{
			mediaLocationDetailRepo.deleteById(lmsMediaLocationDetailPK);
		}
		return;
	}

	public void delSelectLMSMedia(ArrayList<Long> ids) 
	{
		mediaLocationDetailRepo.delSelectLMSMedia(ids);
		return;
	}

	public void delSelectLMSMediaByLocations(ArrayList<Long> ids) 
	{
		mediaLocationDetailRepo.delSelectLMSMediaByLocations(ids);
		return;
	}
	
	public void delAllLMSMediaLocationDetails() {
		mediaLocationDetailRepo.deleteAll();
	}

	private ArrayList<LMSMediaLocationDetailDTO> getLMSMediaLocationDetailDTOs(
			ArrayList<LMSMediaLocationDetail> lDetails) {
		LMSMediaLocationDetailDTO lDTO = null;
		ArrayList<LMSMediaLocationDetailDTO> lDetailDTOs = new ArrayList<LMSMediaLocationDetailDTO>();
		for (int i = 0; i < lDetails.size(); i++) {
			lDTO = getLMSMediaLocationDetailDTO(lDetails.get(i));
			lDetailDTOs.add(lDTO);
		}
		return lDetailDTOs;
	}

	private LMSMediaLocationDetailDTO getLMSMediaLocationDetailDTO(LMSMediaLocationDetail lmsMediaLocationDetail) 
	{
		LMSMediaLocationDetailDTO lDTO = new LMSMediaLocationDetailDTO();
		lDTO.setLocationSeqNo(lmsMediaLocationDetail.getId().getLocationSeqNo());
		lDTO.setMediaSeqNo(lmsMediaLocationDetail.getId().getMediaSeqNo());				
		return lDTO;
	}

	private LMSMediaLocationDetail setLMSMediaLocationDetail(LMSMediaLocationDetailDTO lDTO) 
	{
		LMSMediaLocationDetail lmsMediaLocationDetail = new LMSMediaLocationDetail();
		LMSMediaLocationDetailPK lmslMediaLocationDetailPK = new LMSMediaLocationDetailPK();		
		lmslMediaLocationDetailPK.setMediaSeqNo(lDTO.getMediaSeqNo());
		lmslMediaLocationDetailPK.setLocationSeqNo(lDTO.getLocationSeqNo());
		lmsMediaLocationDetail.setId(lmslMediaLocationDetailPK);		
		return lmsMediaLocationDetail;
	}
}