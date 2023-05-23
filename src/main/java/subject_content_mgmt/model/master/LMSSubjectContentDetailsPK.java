package subject_content_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_SUBJECT_CONTENT_DETAILS database table.
 * 
 */
@Embeddable
public class LMSSubjectContentDetailsPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SUBJECT_SEQ_NO")
	private long subjectSeqNo;

	@Column(name="IN_SUBJECT_SEQ_NO")
	private long inSubjectSeqNo;

	public LMSSubjectContentDetailsPK() {
	}
	public long getSubjectSeqNo() {
		return this.subjectSeqNo;
	}
	public void setSubjectSeqNo(long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}
	public long getInSubjectSeqNo() {
		return this.inSubjectSeqNo;
	}
	public void setInSubjectSeqNo(long inSubjectSeqNo) {
		this.inSubjectSeqNo = inSubjectSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSSubjectContentDetailsPK)) {
			return false;
		}
		LMSSubjectContentDetailsPK castOther = (LMSSubjectContentDetailsPK)other;
		return 
			(this.subjectSeqNo == castOther.subjectSeqNo)
			&& (this.inSubjectSeqNo == castOther.inSubjectSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.subjectSeqNo ^ (this.subjectSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.inSubjectSeqNo ^ (this.inSubjectSeqNo >>> 32)));
		
		return hash;
	}
}