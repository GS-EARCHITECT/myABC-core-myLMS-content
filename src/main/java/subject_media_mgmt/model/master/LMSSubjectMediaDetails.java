package subject_media_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_SUBJECT_MEDIA_DETAILS database table.
 * 
 */
@Entity
@Table(name="LMS_SUBJECT_MEDIA_DETAILS")
public class LMSSubjectMediaDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSSubjectMediaDetailsPK id;

	@Column(name="LOCATION_SEQ_NO")
	private Long locationSeqNo;

	public LMSSubjectMediaDetailsPK getId() {
		return this.id;
	}

	public void setId(LMSSubjectMediaDetailsPK id) {
		this.id = id;
	}

	public Long getLocationSeqNo() {
		return this.locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((locationSeqNo == null) ? 0 : locationSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LMSSubjectMediaDetails other = (LMSSubjectMediaDetails) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (locationSeqNo == null) {
			if (other.locationSeqNo != null)
				return false;
		} else if (!locationSeqNo.equals(other.locationSeqNo))
			return false;
		return true;
	}

	public LMSSubjectMediaDetails(LMSSubjectMediaDetailsPK id, java.lang.Long locationSeqNo) {
		super();
		this.id = id;
		this.locationSeqNo = locationSeqNo;
	}

	public LMSSubjectMediaDetails() {
		super();
	}
	
	

}