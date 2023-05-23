package subject_content_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LMS_SUBJECT_CONTENT_DETAILS database table.
 * 
 */
@Entity
@Table(name="LMS_SUBJECT_CONTENT_DETAILS")
public class LMSSubjectContentDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSSubjectContentDetailsPK id;

	public LMSSubjectContentDetails() {
	}

	public LMSSubjectContentDetailsPK getId() {
		return this.id;
	}

	public void setId(LMSSubjectContentDetailsPK id) {
		this.id = id;
	}

}