package subject_media_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_SUBJECT_MEDIA_DETAILS database table.
 * 
 */
@Embeddable
public class LMSSubjectMediaDetailsPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SUBJECT_SEQ_NO")
	private long subjectSeqNo;

	@Column(name="RESOURCE_SEQ_NO")
	private long resourceSeqNo;

	public LMSSubjectMediaDetailsPK() {
	}
	public long getSubjectSeqNo() {
		return this.subjectSeqNo;
	}
	public void setSubjectSeqNo(long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}
	public long getResourceSeqNo() {
		return this.resourceSeqNo;
	}
	public void setResourceSeqNo(long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSSubjectMediaDetailsPK)) {
			return false;
		}
		LMSSubjectMediaDetailsPK castOther = (LMSSubjectMediaDetailsPK)other;
		return 
			(this.subjectSeqNo == castOther.subjectSeqNo)
			&& (this.resourceSeqNo == castOther.resourceSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.subjectSeqNo ^ (this.subjectSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.resourceSeqNo ^ (this.resourceSeqNo >>> 32)));
		
		return hash;
	}
}