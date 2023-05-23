package subject_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSSubjectMasterDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5881335416900009732L;
	private Long subjectSeqNo;
	private BigDecimal subjectCategorySeqNo;
	private String intRefNo;
	private String subject;

	public Long getSubjectSeqNo() {
		return subjectSeqNo;
	}

	public void setSubjectSeqNo(Long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}

	public BigDecimal getSubjectCategorySeqNo() {
		return subjectCategorySeqNo;
	}

	public void setSubjectCategorySeqNo(BigDecimal subjectCategorySeqNo) {
		this.subjectCategorySeqNo = subjectCategorySeqNo;
	}

	public String getIntRefNo() {
		return intRefNo;
	}

	public void setIntRefNo(String intRefNo) {
		this.intRefNo = intRefNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


	public LMSSubjectMasterDTO(Long subjectSeqNo, BigDecimal subjectCategorySeqNo, String intRefNo,
			String subject) {
		super();
		this.subjectSeqNo = subjectSeqNo;
		this.subjectCategorySeqNo = subjectCategorySeqNo;
		this.intRefNo = intRefNo;
		this.subject = subject;
	}

	public LMSSubjectMasterDTO() {
		super();
	}

	}