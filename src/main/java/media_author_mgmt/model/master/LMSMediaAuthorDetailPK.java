package media_author_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_MEDIA_AUTHOR_DETAILS database table.
 * 
 */
@Embeddable
public class LMSMediaAuthorDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "MEDIA_SEQ_NO")
	private long mediaSeqNo;

	@Column(name = "PERSON_SEQ_NO")
	private long personSeqNo;

	public LMSMediaAuthorDetailPK() {
	}

	public long getMediaSeqNo() {
		return this.mediaSeqNo;
	}

	public void setMediaSeqNo(long mediaSeqNo) {
		this.mediaSeqNo = mediaSeqNo;
	}

	public long getPersonSeqNo() {
		return this.personSeqNo;
	}

	public void setPersonSeqNo(long personSeqNo) {
		this.personSeqNo = personSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSMediaAuthorDetailPK)) {
			return false;
		}
		LMSMediaAuthorDetailPK castOther = (LMSMediaAuthorDetailPK) other;
		return (this.mediaSeqNo == castOther.mediaSeqNo) && (this.personSeqNo == castOther.personSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.mediaSeqNo ^ (this.mediaSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.personSeqNo ^ (this.personSeqNo >>> 32)));

		return hash;
	}

	public LMSMediaAuthorDetailPK(long mediaSeqNo, long personSeqNo) {
		super();
		this.mediaSeqNo = mediaSeqNo;
		this.personSeqNo = personSeqNo;
	}

}