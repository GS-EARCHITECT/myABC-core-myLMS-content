package content_mgmt.content_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_CONTENT_STRUCTURE_DETAILS database table.
 * 
 */
@Embeddable
public class LMSContentStructureDetailPK implements Serializable 
{
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "PAR_CONTENT_SEQ_NO")
	private long parContentSeqNo;

	@Column(name = "CONTENT_SEQ_NO")
	private long contentSeqNo;

	public LMSContentStructureDetailPK() {
	}

	public long getParContentSeqNo() {
		return this.parContentSeqNo;
	}

	public void setParContentSeqNo(long parContentSeqNo) {
		this.parContentSeqNo = parContentSeqNo;
	}

	public long getContentSeqNo() {
		return this.contentSeqNo;
	}

	public void setContentSeqNo(long contentSeqNo) {
		this.contentSeqNo = contentSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSContentStructureDetailPK)) {
			return false;
		}
		LMSContentStructureDetailPK castOther = (LMSContentStructureDetailPK) other;
		return (this.parContentSeqNo == castOther.parContentSeqNo) && (this.contentSeqNo == castOther.contentSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.parContentSeqNo ^ (this.parContentSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.contentSeqNo ^ (this.contentSeqNo >>> 32)));

		return hash;
	}

	public LMSContentStructureDetailPK(long parContentSeqNo, long contentSeqNo) {
		super();
		this.parContentSeqNo = parContentSeqNo;
		this.contentSeqNo = contentSeqNo;
	}

}