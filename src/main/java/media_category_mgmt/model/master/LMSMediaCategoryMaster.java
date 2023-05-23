package media_category_mgmt.model.master;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * The persistent class for the LMS_MEDIA_CATEGORY_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_MEDIA_CATEGORY_MASTER")
public class LMSMediaCategoryMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_MEDIA_CATEGORY_SEQUENCE")
	@SequenceGenerator(name = "LMS_MEDIA_CATEGORY_SEQUENCE", sequenceName = "LMS_MEDIA_CATEGORY_SEQUENCE", allocationSize = 1)
	@Column(name = "MEDIA_CATEGORY_SEQ_NO")
	private BigDecimal mediaCategorySeqNo;

	@Column(name = "MEDIA_CATEGORY")
	private String mediaCategory;

	@Column(name = "PROGRAM_SEQ_NO")
	private Long programSeqNo;

	public LMSMediaCategoryMaster() {
	}

	public BigDecimal getMediaCategorySeqNo() {
		return mediaCategorySeqNo;
	}

	public void setMediaCategorySeqNo(BigDecimal mediaCategorySeqNo) {
		this.mediaCategorySeqNo = mediaCategorySeqNo;
	}

	public String getMediaCategory() {
		return mediaCategory;
	}

	public void setMediaCategory(String mediaCategory) {
		this.mediaCategory = mediaCategory;
	}

	public Long getProgramSeqNo() {
		return programSeqNo;
	}

	public void setProgramSeqNo(Long programSeqNo) {
		this.programSeqNo = programSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mediaCategory == null) ? 0 : mediaCategory.hashCode());
		result = prime * result + ((mediaCategorySeqNo == null) ? 0 : mediaCategorySeqNo.hashCode());
		result = prime * result + ((programSeqNo == null) ? 0 : programSeqNo.hashCode());
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
		LMSMediaCategoryMaster other = (LMSMediaCategoryMaster) obj;
		if (mediaCategory == null) {
			if (other.mediaCategory != null)
				return false;
		} else if (!mediaCategory.equals(other.mediaCategory))
			return false;
		if (mediaCategorySeqNo == null) {
			if (other.mediaCategorySeqNo != null)
				return false;
		} else if (!mediaCategorySeqNo.equals(other.mediaCategorySeqNo))
			return false;
		if (programSeqNo == null) {
			if (other.programSeqNo != null)
				return false;
		} else if (!programSeqNo.equals(other.programSeqNo))
			return false;
		return true;
	}

	public LMSMediaCategoryMaster(BigDecimal mediaCategorySeqNo, String mediaCategory, Long programSeqNo) {
		super();
		this.mediaCategorySeqNo = mediaCategorySeqNo;
		this.mediaCategory = mediaCategory;
		this.programSeqNo = programSeqNo;
	}

}