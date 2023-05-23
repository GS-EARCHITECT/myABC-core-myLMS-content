package content_mgmt.content_category_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSContentCategoryMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4409502239590128950L;

	private BigDecimal contentCategorySeqNo;
	private BigDecimal contentTypeSeqNo;
	private String contentCategory;

	public String getContentCategory() {
		return contentCategory;
	}

	public void setContentCategory(String contentCategory) {
		this.contentCategory = contentCategory;
	}

	public BigDecimal getContentCategorySeqNo() {
		return contentCategorySeqNo;
	}

	public void setContentCategorySeqNo(BigDecimal contentCategorySeqNo) {
		this.contentCategorySeqNo = contentCategorySeqNo;
	}

	public BigDecimal getContentTypeSeqNo() {
		return contentTypeSeqNo;
	}

	public void setContentTypeSeqNo(BigDecimal contenttypeSeqNo) {
		this.contentTypeSeqNo = contenttypeSeqNo;
	}

	public LMSContentCategoryMasterDTO() {
		super();
	}

	public LMSContentCategoryMasterDTO(BigDecimal contentCategorySeqNo, BigDecimal contentTypeSeqNo,
			String contentCategory) {
		super();
		this.contentCategorySeqNo = contentCategorySeqNo;
		this.contentTypeSeqNo = contentTypeSeqNo;
		this.contentCategory = contentCategory;
	}

}