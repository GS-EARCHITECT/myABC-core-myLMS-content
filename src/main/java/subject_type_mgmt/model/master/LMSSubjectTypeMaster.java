package subject_type_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="LMS_SUBJECT_TYPE_MASTER")
public class LMSSubjectTypeMaster implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6709874977126036617L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LMS_SUBJECT_TYPE_SEQ")
	@SequenceGenerator(name="LMS_SUBJECT_TYPE_SEQ", sequenceName="LMS_SUBJECT_TYPE_SEQ", allocationSize = 1)	
	@Column(name="SUBJECT_TYPE_SEQ_NO")
	private BigDecimal subjectTypeSeqNo;

	@Column(name="INTERNAL_REF_NO")
	private String internalRefNo;

	@Column(name="PAR_TYPE_SEQ_NO")
	private BigDecimal parTypeSeqNo;

	@Column(name="SUBJECT_TYPE")
	private String subjectType;

	public LMSSubjectTypeMaster() {
	}

	public BigDecimal getSubjectTypeSeqNo() {
		return this.subjectTypeSeqNo;
	}

	public void setSubjectTypeSeqNo(BigDecimal subjectTypeSeqNo) {
		this.subjectTypeSeqNo = subjectTypeSeqNo;
	}

	public String getInternalRefNo() {
		return this.internalRefNo;
	}

	public void setInternalRefNo(String internalRefNo) {
		this.internalRefNo = internalRefNo;
	}

	public BigDecimal getParTypeSeqNo() {
		return this.parTypeSeqNo;
	}

	public void setParTypeSeqNo(BigDecimal parTypeSeqNo) {
		this.parTypeSeqNo = parTypeSeqNo;
	}

	public String getSubjectType() {
		return this.subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((internalRefNo == null) ? 0 : internalRefNo.hashCode());
		result = prime * result + ((parTypeSeqNo == null) ? 0 : parTypeSeqNo.hashCode());
		result = prime * result + ((subjectType == null) ? 0 : subjectType.hashCode());
		result = prime * result + ((subjectTypeSeqNo == null) ? 0 : subjectTypeSeqNo.hashCode());
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
		LMSSubjectTypeMaster other = (LMSSubjectTypeMaster) obj;
		if (internalRefNo == null) {
			if (other.internalRefNo != null)
				return false;
		} else if (!internalRefNo.equals(other.internalRefNo))
			return false;
		if (parTypeSeqNo == null) {
			if (other.parTypeSeqNo != null)
				return false;
		} else if (!parTypeSeqNo.equals(other.parTypeSeqNo))
			return false;
		if (subjectType == null) {
			if (other.subjectType != null)
				return false;
		} else if (!subjectType.equals(other.subjectType))
			return false;
		if (subjectTypeSeqNo == null) {
			if (other.subjectTypeSeqNo != null)
				return false;
		} else if (!subjectTypeSeqNo.equals(other.subjectTypeSeqNo))
			return false;
		return true;
	}

	public LMSSubjectTypeMaster(BigDecimal subjectTypeSeqNo, String internalRefNo, BigDecimal parTypeSeqNo,
			String subjectType) {
		super();
		this.subjectTypeSeqNo = subjectTypeSeqNo;
		this.internalRefNo = internalRefNo;
		this.parTypeSeqNo = parTypeSeqNo;
		this.subjectType = subjectType;
	}

}