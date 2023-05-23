package subject_category_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSSubjectCategoryMasterDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8227174876793429668L;
	private BigDecimal subjectCategorySeqNo;
	private BigDecimal subjectTypeSeqNo;
	private String internalRefNo;
	private BigDecimal parCategorySeqNo;
	private String subjectCategory;

	public BigDecimal getSubjectCategorySeqNo() {
		return subjectCategorySeqNo;
	}

	public void setSubjectCategorySeqNo(BigDecimal subjectCategorySeqNo) {
		this.subjectCategorySeqNo = subjectCategorySeqNo;
	}

	public BigDecimal getSubjectTypeSeqNo() {
		return subjectTypeSeqNo;
	}

	public void setSubjectTypeSeqNo(BigDecimal subjectTypeSeqNo) {
		this.subjectTypeSeqNo = subjectTypeSeqNo;
	}

	public String getInternalRefNo() {
		return internalRefNo;
	}

	public void setInternalRefNo(String internalRefNo) {
		this.internalRefNo = internalRefNo;
	}

	public BigDecimal getParCategorySeqNo() {
		return parCategorySeqNo;
	}

	public void setParCategorySeqNo(BigDecimal parCategorySeqNo) {
		this.parCategorySeqNo = parCategorySeqNo;
	}

	public String getSubjectCategory() {
		return subjectCategory;
	}

	public void setSubjectCategory(String subjectCategory) {
		this.subjectCategory = subjectCategory;
	}

	public LMSSubjectCategoryMasterDTO(BigDecimal subjectCategorySeqNo, BigDecimal subjectTypeSeqNo,
			String internalRefNo, BigDecimal parCategorySeqNo, String subjectCategory) {
		super();
		this.subjectCategorySeqNo = subjectCategorySeqNo;
		this.subjectTypeSeqNo = subjectTypeSeqNo;
		this.internalRefNo = internalRefNo;
		this.parCategorySeqNo = parCategorySeqNo;
		this.subjectCategory = subjectCategory;
	}

	public LMSSubjectCategoryMasterDTO() {
		super();
	}

}