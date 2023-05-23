package content_mgmt.content_media_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_CONTENT_MEDIA_DETAILS database table.
 * 
 */
@Embeddable
public class LMSContentMediaDetailPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2857419093757996089L;

	@Column(name = "CONTENT_SEQ_NO")
	private long contentSeqNo;

	@Column(name = "MEDIA_SEQ_NO")
	private long mediaSeqNo;

	public LMSContentMediaDetailPK() {
	}

	public long getContentSeqNo() {
		return this.contentSeqNo;
	}

	public void setContentSeqNo(long contentSeqNo) {
		this.contentSeqNo = contentSeqNo;
	}

	public long getMediaSeqNo() {
		return this.mediaSeqNo;
	}

	public void setMediaSeqNo(long mediaSeqNo) {
		this.mediaSeqNo = mediaSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSContentMediaDetailPK)) {
			return false;
		}
		LMSContentMediaDetailPK castOther = (LMSContentMediaDetailPK) other;
		return (this.contentSeqNo == castOther.contentSeqNo) && (this.mediaSeqNo == castOther.mediaSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.contentSeqNo ^ (this.contentSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.mediaSeqNo ^ (this.mediaSeqNo >>> 32)));

		return hash;
	}

	public LMSContentMediaDetailPK(long contentSeqNo, long mediaSeqNo) {
		super();
		this.contentSeqNo = contentSeqNo;
		this.mediaSeqNo = mediaSeqNo;
	}
}
