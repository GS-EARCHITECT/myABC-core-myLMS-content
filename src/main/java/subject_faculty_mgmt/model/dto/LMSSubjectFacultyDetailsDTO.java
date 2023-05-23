package subject_faculty_mgmt.model.dto;

import java.io.Serializable;

public class LMSSubjectFacultyDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8906102542073846342L;
	private long subjectSeqNo;
	private long facultySeqNo;

	public long getSubjectSeqNo() {
		return subjectSeqNo;
	}

	public void setSubjectSeqNo(long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}

	public long getFacultySeqNo() {
		return facultySeqNo;
	}

	public void setFacultySeqNo(long facultySeqNo) {
		this.facultySeqNo = facultySeqNo;
	}

	public LMSSubjectFacultyDetailsDTO(long subjectSeqNo, long facultySeqNo) {
		super();
		this.subjectSeqNo = subjectSeqNo;
		this.facultySeqNo = facultySeqNo;
	}

	public LMSSubjectFacultyDetailsDTO() {
		super();
	}

}