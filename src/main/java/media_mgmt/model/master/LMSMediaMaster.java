package media_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the LMS_MEDIA_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_MEDIA_MASTER")
@NamedQuery(name = "LMSMediaMaster.findAll", query = "SELECT l FROM LMSMediaMaster l")
public class LMSMediaMaster implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_MEDIA_SEQUENCE")
	@SequenceGenerator(name = "LMS_MEDIA_SEQUENCE", sequenceName = "LMS_MEDIA_SEQUENCE", allocationSize = 1)
	@Column(name = "MEDIA_SEQ_NO")
	private long mediaSeqNo;

	@Column(name = "MEDIA_CATEGORY_SEQ_NO")
	private BigDecimal mediaCategorySeqNo;

	@Column(name = "MEDIA_NAME")
	private String mediaName;

	@Column(name = "MEDIA_SUMMARY")
	private String mediaSummary;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	public LMSMediaMaster() {
	}

	public long getMediaSeqNo() {
		return this.mediaSeqNo;
	}

	public void setMediaSeqNo(long mediaSeqNo) {
		this.mediaSeqNo = mediaSeqNo;
	}

	public BigDecimal getMediaCategorySeqNo() {
		return this.mediaCategorySeqNo;
	}

	public void setMediaCategorySeqNo(BigDecimal mediaCategorySeqNo) {
		this.mediaCategorySeqNo = mediaCategorySeqNo;
	}

	public String getMediaName() {
		return this.mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getMediaSummary() {
		return this.mediaSummary;
	}

	public void setMediaSummary(String mediaSummary) {
		this.mediaSummary = mediaSummary;
	}

	public Long getSpecificationSeqNo() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mediaCategorySeqNo == null) ? 0 : mediaCategorySeqNo.hashCode());
		result = prime * result + ((mediaName == null) ? 0 : mediaName.hashCode());
		result = prime * result + (int) (mediaSeqNo ^ (mediaSeqNo >>> 32));
		result = prime * result + ((mediaSummary == null) ? 0 : mediaSummary.hashCode());
		result = prime * result + ((specificationSeqNo == null) ? 0 : specificationSeqNo.hashCode());
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
		LMSMediaMaster other = (LMSMediaMaster) obj;
		if (mediaCategorySeqNo == null) {
			if (other.mediaCategorySeqNo != null)
				return false;
		} else if (!mediaCategorySeqNo.equals(other.mediaCategorySeqNo))
			return false;
		if (mediaName == null) {
			if (other.mediaName != null)
				return false;
		} else if (!mediaName.equals(other.mediaName))
			return false;
		if (mediaSeqNo != other.mediaSeqNo)
			return false;
		if (mediaSummary == null) {
			if (other.mediaSummary != null)
				return false;
		} else if (!mediaSummary.equals(other.mediaSummary))
			return false;
		if (specificationSeqNo == null) {
			if (other.specificationSeqNo != null)
				return false;
		} else if (!specificationSeqNo.equals(other.specificationSeqNo))
			return false;
		return true;
	}

	public LMSMediaMaster(long mediaSeqNo, BigDecimal mediaCategorySeqNo, String mediaName, String mediaSummary,
			Long specificationSeqNo) {
		super();
		this.mediaSeqNo = mediaSeqNo;
		this.mediaCategorySeqNo = mediaCategorySeqNo;
		this.mediaName = mediaName;
		this.mediaSummary = mediaSummary;
		this.specificationSeqNo = specificationSeqNo;
	}

}