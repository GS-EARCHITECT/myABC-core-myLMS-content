package content_mgmt.content_category_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_CONTENT_CATEGORY_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_CONTENT_CATEGORY_MASTER")
public class LMSContentCategoryMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSContentCategoryMasterPK id;

	@Column(name = "CONTENT_CATEGORY")
	private String contentCategory;

	public LMSContentCategoryMaster() {
	}

	public LMSContentCategoryMasterPK getId() {
		return this.id;
	}

	public void setId(LMSContentCategoryMasterPK id) {
		this.id = id;
	}

	public String getContentCategory() {
		return this.contentCategory;
	}

	public void setContentCategory(String contentCategory) {
		this.contentCategory = contentCategory;
	}

	public LMSContentCategoryMaster(LMSContentCategoryMasterPK id, String contentCategory) {
		super();
		this.id = id;
		this.contentCategory = contentCategory;

	}
}