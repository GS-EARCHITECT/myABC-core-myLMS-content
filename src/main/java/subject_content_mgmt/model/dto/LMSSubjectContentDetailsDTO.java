package subject_content_mgmt.model.dto;

import java.io.Serializable;

public class LMSSubjectContentDetailsDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6358675945401577254L;
	private long subjectSeqNo;
	private long inSubjectSeqNo;
	
	public long getSubjectSeqNo() {
		return subjectSeqNo;
	}
	public void setSubjectSeqNo(long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}
	public long getInSubjectSeqNo() {
		return inSubjectSeqNo;
	}
	public void setInSubjectSeqNo(long inSubjectSeqNo) {
		this.inSubjectSeqNo = inSubjectSeqNo;
	}
	public LMSSubjectContentDetailsDTO(long subjectSeqNo, long inSubjectSeqNo) {
		super();
		this.subjectSeqNo = subjectSeqNo;
		this.inSubjectSeqNo = inSubjectSeqNo;
	}
	public LMSSubjectContentDetailsDTO() {
		super();
	}
		
}