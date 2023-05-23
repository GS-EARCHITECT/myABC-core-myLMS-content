package content_mgmt.content_master_mgmt.model.master;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the LMS_CONTENT_TYPE_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_CONTENT_MASTER")
public class LMSContentMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1344358535323535615L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_CONTENT_SEQUENCE")
	@SequenceGenerator(name = "LMS_CONTENT_SEQUENCE", sequenceName = "LMS_CONTENT_SEQUENCE", allocationSize = 1)
	@Column(name = "CONTENT_SEQ_NO")
	private long contentSeqNo;

	@Column(name = "CONTENT_CATEGORY_SEQ_NO")
	private BigDecimal contentCategorySeqNo;

	@Column(name = "CONTENT_SUMMARY")
	private String contentSummary;

	public long getContentSeqNo() {
		return contentSeqNo;
	}

	public void setContentSeqNo(long contentSeqNo) {
		this.contentSeqNo = contentSeqNo;
	}

	public BigDecimal getContentCategorySeqNo() {
		return contentCategorySeqNo;
	}

	public void setContentCategorySeqNo(BigDecimal contentCategorySeqNo) {
		this.contentCategorySeqNo = contentCategorySeqNo;
	}

	public String getContentSummary() {
		return contentSummary;
	}

	public void setContentSummary(String contentSummary) {
		this.contentSummary = contentSummary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contentCategorySeqNo == null) ? 0 : contentCategorySeqNo.hashCode());
		result = prime * result + (int) (contentSeqNo ^ (contentSeqNo >>> 32));
		result = prime * result + ((contentSummary == null) ? 0 : contentSummary.hashCode());
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
		LMSContentMaster other = (LMSContentMaster) obj;
		if (contentCategorySeqNo == null) {
			if (other.contentCategorySeqNo != null)
				return false;
		} else if (!contentCategorySeqNo.equals(other.contentCategorySeqNo))
			return false;
		if (contentSeqNo != other.contentSeqNo)
			return false;
		if (contentSummary == null) {
			if (other.contentSummary != null)
				return false;
		} else if (!contentSummary.equals(other.contentSummary))
			return false;
		return true;
	}

	public LMSContentMaster(long contentSeqNo, BigDecimal contentCategorySeqNo, String contentSummary) {
		super();
		this.contentSeqNo = contentSeqNo;
		this.contentCategorySeqNo = contentCategorySeqNo;
		this.contentSummary = contentSummary;
	}

	public LMSContentMaster() {
		super();
	}

}