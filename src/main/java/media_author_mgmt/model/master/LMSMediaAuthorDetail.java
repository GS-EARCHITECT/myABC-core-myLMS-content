package media_author_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_MEDIA_AUTHOR_DETAILS database table.
 * 
 */
@Entity
@Table(name = "LMS_MEDIA_AUTHOR_DETAILS")
public class LMSMediaAuthorDetail implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSMediaAuthorDetailPK id;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	public LMSMediaAuthorDetail() {
	}

	public LMSMediaAuthorDetailPK getId() {
		return this.id;
	}

	public void setId(LMSMediaAuthorDetailPK id) {
		this.id = id;
	}

	public Long getSpecificationSeq() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeq(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public LMSMediaAuthorDetail(LMSMediaAuthorDetailPK id, Long specificationSeqNo) {
		super();
		this.id = id;
		this.specificationSeqNo = specificationSeqNo;
	}

}