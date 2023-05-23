package subject_type_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSSubjectTypeMasterDTO implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8213692769821054653L;
	private BigDecimal subjectTypeSeqNo;
	private String internalRefNo;
	private BigDecimal parTypeSeqNo;
	private String subjectType;

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

	public BigDecimal getParTypeSeqNo() {
		return parTypeSeqNo;
	}

	public void setParTypeSeqNo(BigDecimal parTypeSeqNo) {
		this.parTypeSeqNo = parTypeSeqNo;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	public LMSSubjectTypeMasterDTO(BigDecimal subjectTypeSeqNo, String internalRefNo, BigDecimal parTypeSeqNo,
			String subjectType) {
		super();
		this.subjectTypeSeqNo = subjectTypeSeqNo;
		this.internalRefNo = internalRefNo;
		this.parTypeSeqNo = parTypeSeqNo;
		this.subjectType = subjectType;
	}

	public LMSSubjectTypeMasterDTO() {
		super();
	}

}