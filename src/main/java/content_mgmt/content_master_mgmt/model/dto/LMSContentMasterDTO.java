package content_mgmt.content_master_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSContentMasterDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1021497763102614587L;
	private long contentSeqNo;
	private BigDecimal contentCategorySeqNo;
	private String contentSummary;

	public long getContentSeqNo() {
		return contentSeqNo;
	}

	public void setContentSeqNo(long contentSeqNo) {
		this.contentSeqNo = contentSeqNo;
	}

	public BigDecimal getContentCategorySeqNo() {
		return contentCategorySeqNo;
	}

	public void setContentCategorySeqNo(BigDecimal contentCategorySeqNo) {
		this.contentCategorySeqNo = contentCategorySeqNo;
	}

	public String getContentSummary() {
		return contentSummary;
	}

	public void setContentSummary(String contentSummary) {
		this.contentSummary = contentSummary;
	}

	public LMSContentMasterDTO(long contentSeqNo, BigDecimal contentCategorySeqNo, String contentSummary) {
		super();
		this.contentSeqNo = contentSeqNo;
		this.contentCategorySeqNo = contentCategorySeqNo;
		this.contentSummary = contentSummary;
	}

	public LMSContentMasterDTO() {
		super();
	}

}