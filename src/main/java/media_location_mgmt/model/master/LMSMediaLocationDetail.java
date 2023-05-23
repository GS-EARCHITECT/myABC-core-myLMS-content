package media_location_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_MEDIA_LOCATION_DETAILS database table.
 * 
 */
@Entity
@Table(name = "LMS_MEDIA_LOCATION_DETAILS")
public class LMSMediaLocationDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSMediaLocationDetailPK id;

	public LMSMediaLocationDetail() {
	}

	public LMSMediaLocationDetailPK getId() {
		return this.id;
	}

	public void setId(LMSMediaLocationDetailPK id) {
		this.id = id;
	}

	public LMSMediaLocationDetail(LMSMediaLocationDetailPK id) {
		super();
		this.id = id;
	}
}