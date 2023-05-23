package subject_questions_mgmt.model.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class LMSSubjectQuestionMasterExactDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5453497468761571577L;
	private Long qSeqNo;
	private String question;
	private ArrayList<String> blankTxts;
	private ArrayList<Integer> choiceTxtNos;
	private String paragraphTxt;

	public Long getqSeqNo() {
		return qSeqNo;
	}

	public void setqSeqNo(Long qSeqNo) {
		this.qSeqNo = qSeqNo;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ArrayList<String> getBlankTxts() {
		return blankTxts;
	}

	public void setBlankTxts(ArrayList<String> blankTxts) {
		this.blankTxts = blankTxts;
	}

	public ArrayList<Integer> getChoiceTxtNos() {
		return choiceTxtNos;
	}

	public void setChoiceTxtNos(ArrayList<Integer> choiceTxtNos) {
		this.choiceTxtNos = choiceTxtNos;
	}

	public String getParagraphTxt() {
		return paragraphTxt;
	}

	public void setParagraphTxt(String paragraphTxt) {
		this.paragraphTxt = paragraphTxt;
	}

	public LMSSubjectQuestionMasterExactDTO(Long qSeqNo, String question, ArrayList<String> blankTxts,
			ArrayList<Integer> choiceTxtNos, String paragraphTxt) {
		super();
		this.qSeqNo = qSeqNo;
		this.question = question;
		this.blankTxts = blankTxts;
		this.choiceTxtNos = choiceTxtNos;
		this.paragraphTxt = paragraphTxt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blankTxts == null) ? 0 : blankTxts.hashCode());
		result = prime * result + ((choiceTxtNos == null) ? 0 : choiceTxtNos.hashCode());
		result = prime * result + ((paragraphTxt == null) ? 0 : paragraphTxt.hashCode());
		result = prime * result + ((qSeqNo == null) ? 0 : qSeqNo.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
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
		LMSSubjectQuestionMasterExactDTO other = (LMSSubjectQuestionMasterExactDTO) obj;
		if (blankTxts == null) {
			if (other.blankTxts != null)
				return false;
		} else if (!blankTxts.equals(other.blankTxts))
			return false;
		if (choiceTxtNos == null) {
			if (other.choiceTxtNos != null)
				return false;
		} else if (!choiceTxtNos.equals(other.choiceTxtNos))
			return false;
		if (paragraphTxt == null) {
			if (other.paragraphTxt != null)
				return false;
		} else if (!paragraphTxt.equals(other.paragraphTxt))
			return false;
		if (qSeqNo == null) {
			if (other.qSeqNo != null)
				return false;
		} else if (!qSeqNo.equals(other.qSeqNo))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

	public LMSSubjectQuestionMasterExactDTO() {
		super();
	}

}