package content_mgmt.content_structure_mgmt.model.dto;

import java.io.Serializable;

public class LMSContentStructureDetailDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9116505605066071331L;
	private long parContentSeqNo;
	private long contentSeqNo;
	private String contentSummary;

	public long getParContentSeqNo() {
		return parContentSeqNo;
	}

	public void setParContentSeqNo(long parContentSeqNo) {
		this.parContentSeqNo = parContentSeqNo;
	}

	public long getContentSeqNo() {
		return contentSeqNo;
	}

	public void setContentSeqNo(long contentSeqNo) {
		this.contentSeqNo = contentSeqNo;
	}

	public String getContentSummary() {
		return contentSummary;
	}

	public void setContentSummary(String contentSummary) {
		this.contentSummary = contentSummary;
	}

	public LMSContentStructureDetailDTO(long parContentSeqNo, long contentSeqNo, String contentSummary) {
		super();
		this.parContentSeqNo = parContentSeqNo;
		this.contentSeqNo = contentSeqNo;
		this.contentSummary = contentSummary;
	}

	public LMSContentStructureDetailDTO() {
		super();
	}

}