package content_mgmt.content_media_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_CONTENT_MEDIA_DETAILS database table.
 * 
 */
@Entity
@Table(name = "LMS_CONTENT_MEDIA_DETAILS")
public class LMSContentMediaDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6157200946071315951L;

	@EmbeddedId
	private LMSContentMediaDetailPK id;

	@Column(name = "FROM_LOCATION_NO")
	private Float fromLocationNo;

	@Column(name = "TO_LOCATION_NO")
	private Float toLocationNo;

	public LMSContentMediaDetail() {
	}

	public LMSContentMediaDetailPK getId() {
		return this.id;
	}

	public void setId(LMSContentMediaDetailPK id) {
		this.id = id;
	}

	public Float getFromLocationNo() {
		return this.fromLocationNo;
	}

	public void setFromLocationNo(Float fromLocationNo) {
		this.fromLocationNo = fromLocationNo;
	}

	public Float getToLocationNo() {
		return this.toLocationNo;
	}

	public void setToLocationNo(Float toLocationNo) {
		this.toLocationNo = toLocationNo;
	}

	public LMSContentMediaDetail(LMSContentMediaDetailPK id, Float fromLocationNo, Float toLocationNo) {
		super();
		this.id = id;
		this.fromLocationNo = fromLocationNo;
		this.toLocationNo = toLocationNo;
	}

}