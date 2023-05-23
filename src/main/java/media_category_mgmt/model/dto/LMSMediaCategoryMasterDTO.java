package media_category_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSMediaCategoryMasterDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1685396743397032277L;
	private BigDecimal mediaCategorySeqNo;
	private String mediaCategory;
	private Long programSeqNo;

	public BigDecimal getMediaCategorySeqNo() {
		return mediaCategorySeqNo;
	}

	public void setMediaCategorySeqNo(BigDecimal mediaCategorySeqNo) {
		this.mediaCategorySeqNo = mediaCategorySeqNo;
	}

	public String getMediaCategory() {
		return mediaCategory;
	}

	public void setMediaCategory(String mediaCategory) {
		this.mediaCategory = mediaCategory;
	}

	public Long getProgramSeqNo() {
		return programSeqNo;
	}

	public void setProgramSeqNo(Long programSeqNo) {
		this.programSeqNo = programSeqNo;
	}

	public LMSMediaCategoryMasterDTO(BigDecimal mediaCategorySeqNo, String mediaCategory, Long programSeqNo) {
		super();
		this.mediaCategorySeqNo = mediaCategorySeqNo;
		this.mediaCategory = mediaCategory;
		this.programSeqNo = programSeqNo;
	}

	public LMSMediaCategoryMasterDTO() {
		super();
	}

}