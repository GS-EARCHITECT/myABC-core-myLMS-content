package media_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSMediaMasterDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4101248704978656343L;
	private long mediaSeqNo;
	private BigDecimal mediaCategorySeqNo;
	private String mediaName;
	private String mediaSummary;
	private Long specificationSeqNo;

	public long getMediaSeqNo() {
		return mediaSeqNo;
	}

	public void setMediaSeqNo(long mediaSeqNo) {
		this.mediaSeqNo = mediaSeqNo;
	}

	public BigDecimal getMediaCategorySeqNo() {
		return mediaCategorySeqNo;
	}

	public void setMediaCategorySeqNo(BigDecimal mediaCategorySeqNo) {
		this.mediaCategorySeqNo = mediaCategorySeqNo;
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getMediaSummary() {
		return mediaSummary;
	}

	public void setMediaSummary(String mediaSummary) {
		this.mediaSummary = mediaSummary;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public LMSMediaMasterDTO(long mediaSeqNo, BigDecimal mediaCategorySeqNo, String mediaName, String mediaSummary,
			Long specificationSeqNo) {
		super();
		this.mediaSeqNo = mediaSeqNo;
		this.mediaCategorySeqNo = mediaCategorySeqNo;
		this.mediaName = mediaName;
		this.mediaSummary = mediaSummary;
		this.specificationSeqNo = specificationSeqNo;
	}

	public LMSMediaMasterDTO() {
		super();
	}

}