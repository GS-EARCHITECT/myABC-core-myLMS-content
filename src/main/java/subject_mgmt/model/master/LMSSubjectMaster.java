package subject_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the LMS_SUBJECT_MASTER database table.
 * 
 */
@Entity
@Table(name="LMS_SUBJECT_MASTER")
public class LMSSubjectMaster implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2016964630611957388L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LMS_SUBJECT_SEQ_NO")
	@SequenceGenerator(name="LMS_SUBJECT_SEQ_NO", sequenceName="LMS_SUBJECT_SEQ_NO", allocationSize = 1)
	@Column(name="SUBJECT_SEQ_NO")
	private Long subjectSeqNo;

	@Column(name="SUBJECT_CATEGORY_SEQ_NO")
	private BigDecimal subjectCategorySeqNo;
	
	@Column(name="INTERNAL_REF_NO")
	private String intRefNo;

	@Column(name="SUBJECT")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intRefNo == null) ? 0 : intRefNo.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((subjectCategorySeqNo == null) ? 0 : subjectCategorySeqNo.hashCode());
		result = prime * result + ((subjectSeqNo == null) ? 0 : subjectSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LMSSubjectMaster other = (LMSSubjectMaster) obj;
		if (intRefNo == null) {
			if (other.intRefNo != null)
				return false;
		} else if (!intRefNo.equals(other.intRefNo))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (subjectCategorySeqNo == null) {
			if (other.subjectCategorySeqNo != null)
				return false;
		} else if (!subjectCategorySeqNo.equals(other.subjectCategorySeqNo))
			return false;
		if (subjectSeqNo == null) {
			if (other.subjectSeqNo != null)
				return false;
		} else if (!subjectSeqNo.equals(other.subjectSeqNo))
			return false;
		return true;
	}

	public LMSSubjectMaster(Long subjectSeqNo, BigDecimal subjectCategorySeqNo, String intRefNo,
			String subject) {
		super();
		this.subjectSeqNo = subjectSeqNo;
		this.subjectCategorySeqNo = subjectCategorySeqNo;
		this.intRefNo = intRefNo;
		this.subject = subject;
	}

	public LMSSubjectMaster() {
		super();
	}

	}