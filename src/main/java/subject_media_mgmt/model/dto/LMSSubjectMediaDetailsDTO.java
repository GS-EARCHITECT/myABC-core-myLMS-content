package subject_media_mgmt.model.dto;

import java.io.Serializable;

public class LMSSubjectMediaDetailsDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2703300812120399840L;
	private long subjectSeqNo;
	private long resourceSeqNo;
	private Long locationSeqNo;
	public long getSubjectSeqNo() {
		return subjectSeqNo;
	}
	public void setSubjectSeqNo(long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}
	public long getResourceSeqNo() {
		return resourceSeqNo;
	}
	public void setResourceSeqNo(long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}
	public Long getLocationSeqNo() {
		return locationSeqNo;
	}
	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}
	public LMSSubjectMediaDetailsDTO(long subjectSeqNo, long resourceSeqNo, Long locationSeqNo) {
		super();
		this.subjectSeqNo = subjectSeqNo;
		this.resourceSeqNo = resourceSeqNo;
		this.locationSeqNo = locationSeqNo;
	}
	public LMSSubjectMediaDetailsDTO() {
		super();
	}
	
}