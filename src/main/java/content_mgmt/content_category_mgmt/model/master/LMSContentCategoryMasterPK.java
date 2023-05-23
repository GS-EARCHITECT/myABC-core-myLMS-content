package content_mgmt.content_category_mgmt.model.master;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The primary key class for the LMS_CONTENT_CATEGORY_MASTER database table.
 * 
 */
@Embeddable
public class LMSContentCategoryMasterPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "CONTENT_CATEGORY_SEQ_NO")
	private BigDecimal contentCategorySeqNo;

	@Column(name = "CONTENT_TYPE_SEQ_NO")
	private BigDecimal contentTypeSeqNo;

	public LMSContentCategoryMasterPK() {
	}

	public BigDecimal getContentCategorySeqNo() {
		return this.contentCategorySeqNo;
	}

	public void setContentCategorySeqNo(BigDecimal contentCategorySeqNo) {
		this.contentCategorySeqNo = contentCategorySeqNo;
	}

	public BigDecimal getContentTypeSeqNo() {
		return this.contentTypeSeqNo;
	}

	public void setContentTypeSeqNo(BigDecimal contentTypeSeqNo) {
		this.contentTypeSeqNo = contentTypeSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contentCategorySeqNo == null) ? 0 : contentCategorySeqNo.hashCode());
		result = prime * result + ((contentTypeSeqNo == null) ? 0 : contentTypeSeqNo.hashCode());
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
		LMSContentCategoryMasterPK other = (LMSContentCategoryMasterPK) obj;
		if (contentCategorySeqNo == null) {
			if (other.contentCategorySeqNo != null)
				return false;
		} else if (!contentCategorySeqNo.equals(other.contentCategorySeqNo))
			return false;
		if (contentTypeSeqNo == null) {
			if (other.contentTypeSeqNo != null)
				return false;
		} else if (!contentTypeSeqNo.equals(other.contentTypeSeqNo))
			return false;
		return true;
	}

}