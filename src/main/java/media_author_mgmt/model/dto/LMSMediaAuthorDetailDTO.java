package media_author_mgmt.model.dto;

import java.io.Serializable;

public class LMSMediaAuthorDetailDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2952858234075702605L;
	private long mediaSeqNo;
	private long personSeqNo;
	private Long specificationSeqNo;

	public long getMediaSeqNo() {
		return mediaSeqNo;
	}

	public void setMediaSeqNo(long mediaSeqNo) {
		this.mediaSeqNo = mediaSeqNo;
	}

	public long getPersonSeqNo() {
		return personSeqNo;
	}

	public void setPersonSeqNo(long personSeqNo) {
		this.personSeqNo = personSeqNo;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public LMSMediaAuthorDetailDTO(long mediaSeqNo, long personSeqNo, Long specificationSeqNo) {
		super();
		this.mediaSeqNo = mediaSeqNo;
		this.personSeqNo = personSeqNo;
		this.specificationSeqNo = specificationSeqNo;
	}

	public LMSMediaAuthorDetailDTO() {
		super();
	}

}