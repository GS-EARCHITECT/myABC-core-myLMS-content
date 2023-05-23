package content_mgmt.content_type_mgmt.model.master;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * The persistent class for the LMS_CONTENT_TYPE_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_CONTENT_TYPE_MASTER")
public class LMSContentTypeMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_CONTENT_TYPE_SEQUENCE")
	@SequenceGenerator(name = "LMS_CONTENT_TYPE_SEQUENCE", sequenceName = "LMS_CONTENT_TYPE_SEQUENCE", allocationSize = 1)
	@Column(name = "CONTENT_TYPE_SEQ_NO")
	private BigDecimal contentTypeSeqNo;

	@Column(name = "CONTENT_TYPE")
	private String contentType;

	public LMSContentTypeMaster() {
	}

	public BigDecimal getContentTypeSeqNo() {
		return this.contentTypeSeqNo;
	}

	public void setContentTypeSeqNo(BigDecimal contentTypeSeqNo) {
		this.contentTypeSeqNo = contentTypeSeqNo;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
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
		LMSContentTypeMaster other = (LMSContentTypeMaster) obj;
		if (contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!contentType.equals(other.contentType))
			return false;
		if (contentTypeSeqNo == null) {
			if (other.contentTypeSeqNo != null)
				return false;
		} else if (!contentTypeSeqNo.equals(other.contentTypeSeqNo))
			return false;
		return true;
	}

	public LMSContentTypeMaster(BigDecimal contentTypeSeqNo, String contentType) {
		super();
		this.contentTypeSeqNo = contentTypeSeqNo;
		this.contentType = contentType;
	}

}