package media_location_mgmt.model.dto;

import java.io.Serializable;

public class LMSMediaLocationDetailDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6601771146314185918L;
	private long mediaSeqNo;
	private long locationSeqNo;

	public long getMediaSeqNo() {
		return mediaSeqNo;
	}

	public void setMediaSeqNo(long mediaSeqNo) {
		this.mediaSeqNo = mediaSeqNo;
	}

	public long getLocationSeqNo() {
		return locationSeqNo;
	}

	public void setLocationSeqNo(long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}

	public LMSMediaLocationDetailDTO(long mediaSeqNo, long locationSeqNo) {
		super();
		this.mediaSeqNo = mediaSeqNo;
		this.locationSeqNo = locationSeqNo;
	}

	public LMSMediaLocationDetailDTO() {
		super();
	}

}