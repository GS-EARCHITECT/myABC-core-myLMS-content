package subject_faculty_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_SUBJECT_FACULTY_DETAILS database table.
 * 
 */
@Entity
@Table(name="LMS_SUBJECT_FACULTY_DETAILS")
public class LMSSubjectFacultyDetails implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSSubjectFacultyDetailsPK id;

	public LMSSubjectFacultyDetails() {
	}

	public LMSSubjectFacultyDetailsPK getId() {
		return this.id;
	}

	public void setId(LMSSubjectFacultyDetailsPK id) {
		this.id = id;
	}

	public LMSSubjectFacultyDetails(LMSSubjectFacultyDetailsPK id) {
		super();
		this.id = id;
	}
		
}