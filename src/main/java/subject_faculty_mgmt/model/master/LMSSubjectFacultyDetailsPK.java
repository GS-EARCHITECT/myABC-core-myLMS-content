package subject_faculty_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_SUBJECT_FACULTY_DETAILS database table.
 * 
 */
@Embeddable
public class LMSSubjectFacultyDetailsPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SUBJECT_SEQ_NO")
	private long subjectSeqNo;

	@Column(name="FACULTY_SEQ_NO")
	private long facultySeqNo;

	public LMSSubjectFacultyDetailsPK() {
	}
	public long getSubjectSeqNo() {
		return this.subjectSeqNo;
	}
	public void setSubjectSeqNo(long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}
	public long getFacultySeqNo() {
		return this.facultySeqNo;
	}
	public void setFacultySeqNo(long facultySeqNo) {
		this.facultySeqNo = facultySeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSSubjectFacultyDetailsPK)) {
			return false;
		}
		LMSSubjectFacultyDetailsPK castOther = (LMSSubjectFacultyDetailsPK)other;
		return 
			(this.subjectSeqNo == castOther.subjectSeqNo)
			&& (this.facultySeqNo == castOther.facultySeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.subjectSeqNo ^ (this.subjectSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.facultySeqNo ^ (this.facultySeqNo >>> 32)));
		
		return hash;
	}
	public LMSSubjectFacultyDetailsPK(long subjectSeqNo, long facultySeqNo) {
		super();
		this.subjectSeqNo = subjectSeqNo;
		this.facultySeqNo = facultySeqNo;
	}
	
}