package subject_category_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the LMS_SUBJECT_CATEGORY_MASTER database table.
 * 
 */
@Entity
@Table(name="LMS_SUBJECT_CATEGORY_MASTER")
public class LMSSubjectCategoryMaster implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2016964630611957388L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LMS_SUBJECT_CATEGORY_SEQ")
	@SequenceGenerator(name="LMS_SUBJECT_CATEGORY_SEQ", sequenceName="LMS_SUBJECT_CATEGORY_SEQ", allocationSize = 1)
	@Column(name="SUBJECT_CATEGORY_SEQ_NO")
	private BigDecimal subjectCategorySeqNo;

	@Column(name="SUBJECT_TYPE_SEQ_NO")
	private BigDecimal subjectTypeSeqNo;
	
	@Column(name="INTERNAL_REF_NO")
	private String internalRefNo;

	@Column(name="PAR_CATEGORY_SEQ_NO")
	private BigDecimal parCategorySeqNo;

	@Column(name="SUBJECT_CATEGORY")
	private String subjectCategory;

	public LMSSubjectCategoryMaster() {
	}

	public BigDecimal getSubjectCategorySeqNo() {
		return this.subjectCategorySeqNo;
	}

	public void setSubjectCategorySeqNo(BigDecimal subjectCategorySeqNo) {
		this.subjectCategorySeqNo = subjectCategorySeqNo;
	}

	public String getInternalRefNo() {
		return this.internalRefNo;
	}

	public void setInternalRefNo(String internalRefNo) {
		this.internalRefNo = internalRefNo;
	}

	public BigDecimal getParCategorySeqNo() {
		return this.parCategorySeqNo;
	}

	public void setParCategorySeqNo(BigDecimal parCategorySeqNo) {
		this.parCategorySeqNo = parCategorySeqNo;
	}

	public String getSubjectCategory() {
		return this.subjectCategory;
	}

	public void setSubjectCategory(String subjectCategory) {
		this.subjectCategory = subjectCategory;
	}

	public BigDecimal getSubjectTypeSeqNo() {
		return subjectTypeSeqNo;
	}

	public void setSubjectTypeSeqNo(BigDecimal subjectTypeSeqNo) {
		this.subjectTypeSeqNo = subjectTypeSeqNo;
	}

	public LMSSubjectCategoryMaster(BigDecimal subjectCategorySeqNo, BigDecimal subjectTypeSeqNo, String internalRefNo,
			BigDecimal parCategorySeqNo, String subjectCategory) {
		super();
		this.subjectCategorySeqNo = subjectCategorySeqNo;
		this.subjectTypeSeqNo = subjectTypeSeqNo;
		this.internalRefNo = internalRefNo;
		this.parCategorySeqNo = parCategorySeqNo;
		this.subjectCategory = subjectCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((internalRefNo == null) ? 0 : internalRefNo.hashCode());
		result = prime * result + ((parCategorySeqNo == null) ? 0 : parCategorySeqNo.hashCode());
		result = prime * result + ((subjectCategory == null) ? 0 : subjectCategory.hashCode());
		result = prime * result + ((subjectCategorySeqNo == null) ? 0 : subjectCategorySeqNo.hashCode());
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
		LMSSubjectCategoryMaster other = (LMSSubjectCategoryMaster) obj;
		if (internalRefNo == null) {
			if (other.internalRefNo != null)
				return false;
		} else if (!internalRefNo.equals(other.internalRefNo))
			return false;
		if (parCategorySeqNo == null) {
			if (other.parCategorySeqNo != null)
				return false;
		} else if (!parCategorySeqNo.equals(other.parCategorySeqNo))
			return false;
		if (subjectCategory == null) {
			if (other.subjectCategory != null)
				return false;
		} else if (!subjectCategory.equals(other.subjectCategory))
			return false;
		if (subjectCategorySeqNo == null) {
			if (other.subjectCategorySeqNo != null)
				return false;
		} else if (!subjectCategorySeqNo.equals(other.subjectCategorySeqNo))
			return false;
		if (subjectTypeSeqNo == null) {
			if (other.subjectTypeSeqNo != null)
				return false;
		} else if (!subjectTypeSeqNo.equals(other.subjectTypeSeqNo))
			return false;
		return true;
	}

	}