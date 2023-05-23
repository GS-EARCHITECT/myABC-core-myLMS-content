package media_location_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_MEDIA_AUTHOR_DETAILS database table.
 * 
 */
@Embeddable
public class LMSMediaLocationDetailPK implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7617571118506868088L;

	@Column(name = "MEDIA_SEQ_NO")
	private long mediaSeqNo;

	@Column(name = "LOCATION_SEQ_NO")
	private long locationSeqNo;

	public LMSMediaLocationDetailPK() {
	}

	public long getMediaSeqNo() {
		return this.mediaSeqNo;
	}

	public void setMediaSeqNo(long mediaSeqNo) {
		this.mediaSeqNo = mediaSeqNo;
	}

	public long getLocationSeqNo() {
		return this.locationSeqNo;
	}

	public void setLocationSeqNo(long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSMediaLocationDetailPK)) {
			return false;
		}
		LMSMediaLocationDetailPK castOther = (LMSMediaLocationDetailPK) other;
		return (this.mediaSeqNo == castOther.mediaSeqNo) && (this.locationSeqNo == castOther.locationSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.mediaSeqNo ^ (this.mediaSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.locationSeqNo ^ (this.locationSeqNo >>> 32)));

		return hash;
	}

	public LMSMediaLocationDetailPK(long mediaSeqNo, long locationSeqNo) {
		super();
		this.mediaSeqNo = mediaSeqNo;
		this.locationSeqNo = locationSeqNo;
	}

}