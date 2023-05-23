package content_mgmt.content_media_mgmt.model.dto;

import java.io.Serializable;

public class LMSContentMediaDetailDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6022493557336535444L;
	private long contentSeqNo;
	private long mediaSeqNo;
	private Float fromLocationNo;
	private Float toLocationNo;

	public long getContentSeqNo() {
		return contentSeqNo;
	}

	public void setContentSeqNo(long contentSeqNo) {
		this.contentSeqNo = contentSeqNo;
	}

	public long getMediaSeqNo() {
		return mediaSeqNo;
	}

	public void setMediaSeqNo(long mediaSeqNo) {
		this.mediaSeqNo = mediaSeqNo;
	}

	public Float getFromLocationNo() {
		return fromLocationNo;
	}

	public void setFromLocationNo(Float fromLocationNo) {
		this.fromLocationNo = fromLocationNo;
	}

	public Float getToLocationNo() {
		return toLocationNo;
	}

	public void setToLocationNo(Float toLocationNo) {
		this.toLocationNo = toLocationNo;
	}

	public LMSContentMediaDetailDTO(long contentSeqNo, long mediaSeqNo, Float fromLocationNo, Float toLocationNo) {
		super();
		this.contentSeqNo = contentSeqNo;
		this.mediaSeqNo = mediaSeqNo;
		this.fromLocationNo = fromLocationNo;
		this.toLocationNo = toLocationNo;
	}

	public LMSContentMediaDetailDTO() {
		super();
	}

}