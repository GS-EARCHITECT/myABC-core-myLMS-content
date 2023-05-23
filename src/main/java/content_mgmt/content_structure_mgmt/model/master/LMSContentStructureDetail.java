package content_mgmt.content_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_CONTENT_STRUCTURE_DETAILS database table.
 * 
 */
@Entity
@Table(name = "LMS_CONTENT_STRUCTURE_DETAILS")
public class LMSContentStructureDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSContentStructureDetailPK id;

	@Column(name = "CONTENT_SUMMARY")
	private String contentSummary;

	public LMSContentStructureDetail() {
	}

	public LMSContentStructureDetailPK getId() {
		return this.id;
	}

	public void setId(LMSContentStructureDetailPK id) {
		this.id = id;
	}

	public String getContentSummary() {
		return this.contentSummary;
	}

	public void setContentSummary(String contentSummary) {
		this.contentSummary = contentSummary;
	}

	public LMSContentStructureDetail(LMSContentStructureDetailPK id, String contentSummary) {
		super();
		this.id = id;
		this.contentSummary = contentSummary;
	}

}