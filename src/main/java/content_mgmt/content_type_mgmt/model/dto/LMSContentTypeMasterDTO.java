package content_mgmt.content_type_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSContentTypeMasterDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8528636403404510088L;
	private BigDecimal contentTypeSeqNo;
	private String contentType;

	public BigDecimal getContentTypeSeqNo() {
		return contentTypeSeqNo;
	}

	public void setContentTypeSeqNo(BigDecimal contentTypeSeqNo) {
		this.contentTypeSeqNo = contentTypeSeqNo;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public LMSContentTypeMasterDTO(BigDecimal contentTypeSeqNo, String contentType) {
		super();
		this.contentTypeSeqNo = contentTypeSeqNo;
		this.contentType = contentType;
	}

	public LMSContentTypeMasterDTO() {
		super();
	}

}