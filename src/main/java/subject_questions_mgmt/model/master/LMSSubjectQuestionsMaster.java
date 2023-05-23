package subject_questions_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_SUBJECT_QUESTIONS_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_SUBJECT_QUESTIONS_MASTER")
public class LMSSubjectQuestionsMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_QUESTION_SEQ_NO")
	@SequenceGenerator(name = "LMS_QUESTION_SEQ_NO", sequenceName = "LMS_QUESTION_SEQ_NO", allocationSize = 1)
	@Column(name = "Q_SEQ_NO")
	private Long qSeqNo;

	@Column(name = "COMPLEXITY_SEQ_NO")
	private Long complexitySeqNo;

	@Column(name = "SUBJECTIVE")
	private Character subjective;

	@Column(name = "BLANK_TXT1")
	private String blankTxt1;

	@Column(name = "BLANK_TXT1_TYPE")
	private String blankTxt1Type;

	@Column(name = "BLANK_TXT2")
	private String blankTxt2;

	@Column(name = "BLANK_TXT2_TYPE")
	private String blankTxt2Type;

	@Column(name = "BLANK_TXT3")
	private String blankTxt3;

	@Column(name = "BLANK_TXT3_TYPE")
	private String blankTxt3Type;

	@Column(name = "BLANK_TXT4")
	private String blankTxt4;

	@Column(name = "BLANK_TXT4_TYPE")
	private String blankTxt4Type;

	@Column(name = "BLANK_TXT5")
	private String blankTxt5;

	@Column(name = "BLANK_TXT5_TYPE")
	private String blankTxt5Type;

	@Column(name = "BLANK_TXT6")
	private String blankTxt6;

	@Column(name = "BLANK_TXT6_TYPE")
	private String blankTxt6Type;

	@Column(name = "BLANK_TXT7")
	private String blankTxt7;

	@Column(name = "BLANK_TXT7_TYPE")
	private String blankTxt7Type;

	@Column(name = "CHOICE_FLG1")
	private String choiceFlg1;

	@Column(name = "CHOICE_FLG2")
	private String choiceFlg2;

	@Column(name = "CHOICE_FLG3")
	private String choiceFlg3;

	@Column(name = "CHOICE_FLG4")
	private String choiceFlg4;

	@Column(name = "CHOICE_FLG5")
	private String choiceFlg5;

	@Column(name = "CHOICE_FLG6")
	private String choiceFlg6;

	@Column(name = "CHOICE_FLG7")
	private String choiceFlg7;

	@Column(name = "CHOICE_TXT1")
	private String choiceTxt1;

	@Column(name = "CHOICE_TXT2")
	private String choiceTxt2;

	@Column(name = "CHOICE_TXT3")
	private String choiceTxt3;

	@Column(name = "CHOICE_TXT4")
	private String choiceTxt4;

	@Column(name = "CHOICE_TXT5")
	private String choiceTxt5;

	@Column(name = "CHOICE_TXT6")
	private String choiceTxt6;

	@Column(name = "CHOICE_TXT7")
	private String choiceTxt7;

	@Column(name = "DURATION")
	private Integer duration;

	@Column(name = "PARAGRAPH_TXT")
	private String paragraphTxt;

	@Column(name = "QUESTION")
	private String question;

	@Column(name = "QUESTION_ID")
	private String questionId;

	@Column(name = "SUBJECT_SEQ_NO")
	private Long subjectSeqNo;

	public LMSSubjectQuestionsMaster() {
	}

	public Long getComplexitySeqNo() {
		return complexitySeqNo;
	}

	public void setComplexitySeqNo(Long complexitySeqNo) {
		this.complexitySeqNo = complexitySeqNo;
	}

	public String getBlankTxt1() {
		return this.blankTxt1;
	}

	public void setBlankTxt1(String blankTxt1) {
		this.blankTxt1 = blankTxt1;
	}

	public String getBlankTxt1Type() {
		return this.blankTxt1Type;
	}

	public void setBlankTxt1Type(String blankTxt1Type) {
		this.blankTxt1Type = blankTxt1Type;
	}

	public String getBlankTxt2() {
		return this.blankTxt2;
	}

	public void setBlankTxt2(String blankTxt2) {
		this.blankTxt2 = blankTxt2;
	}

	public String getBlankTxt2Type() {
		return this.blankTxt2Type;
	}

	public void setBlankTxt2Type(String blankTxt2Type) {
		this.blankTxt2Type = blankTxt2Type;
	}

	public String getBlankTxt3() {
		return this.blankTxt3;
	}

	public void setBlankTxt3(String blankTxt3) {
		this.blankTxt3 = blankTxt3;
	}

	public String getBlankTxt3Type() {
		return this.blankTxt3Type;
	}

	public void setBlankTxt3Type(String blankTxt3Type) {
		this.blankTxt3Type = blankTxt3Type;
	}

	public String getBlankTxt4() {
		return this.blankTxt4;
	}

	public void setBlankTxt4(String blankTxt4) {
		this.blankTxt4 = blankTxt4;
	}

	public String getBlankTxt4Type() {
		return this.blankTxt4Type;
	}

	public void setBlankTxt4Type(String blankTxt4Type) {
		this.blankTxt4Type = blankTxt4Type;
	}

	public String getBlankTxt5() {
		return this.blankTxt5;
	}

	public void setBlankTxt5(String blankTxt5) {
		this.blankTxt5 = blankTxt5;
	}

	public String getBlankTxt5Type() {
		return this.blankTxt5Type;
	}

	public void setBlankTxt5Type(String blankTxt5Type) {
		this.blankTxt5Type = blankTxt5Type;
	}

	public String getBlankTxt6() {
		return this.blankTxt6;
	}

	public void setBlankTxt6(String blankTxt6) {
		this.blankTxt6 = blankTxt6;
	}

	public String getBlankTxt6Type() {
		return this.blankTxt6Type;
	}

	public void setBlankTxt6Type(String blankTxt6Type) {
		this.blankTxt6Type = blankTxt6Type;
	}

	public String getBlankTxt7() {
		return this.blankTxt7;
	}

	public void setBlankTxt7(String blankTxt7) {
		this.blankTxt7 = blankTxt7;
	}

	public String getBlankTxt7Type() {
		return this.blankTxt7Type;
	}

	public void setBlankTxt7Type(String blankTxt7Type) {
		this.blankTxt7Type = blankTxt7Type;
	}

	public String getChoiceFlg1() {
		return this.choiceFlg1;
	}

	public void setChoiceFlg1(String choiceFlg1) {
		this.choiceFlg1 = choiceFlg1;
	}

	public String getChoiceFlg2() {
		return this.choiceFlg2;
	}

	public void setChoiceFlg2(String choiceFlg2) {
		this.choiceFlg2 = choiceFlg2;
	}

	public String getChoiceFlg3() {
		return this.choiceFlg3;
	}

	public void setChoiceFlg3(String choiceFlg3) {
		this.choiceFlg3 = choiceFlg3;
	}

	public String getChoiceFlg4() {
		return this.choiceFlg4;
	}

	public void setChoiceFlg4(String choiceFlg4) {
		this.choiceFlg4 = choiceFlg4;
	}

	public String getChoiceFlg5() {
		return this.choiceFlg5;
	}

	public void setChoiceFlg5(String choiceFlg5) {
		this.choiceFlg5 = choiceFlg5;
	}

	public String getChoiceFlg6() {
		return this.choiceFlg6;
	}

	public void setChoiceFlg6(String choiceFlg6) {
		this.choiceFlg6 = choiceFlg6;
	}

	public String getChoiceFlg7() {
		return this.choiceFlg7;
	}

	public void setChoiceFlg7(String choiceFlg7) {
		this.choiceFlg7 = choiceFlg7;
	}

	public String getChoiceTxt1() {
		return this.choiceTxt1;
	}

	public void setChoiceTxt1(String choiceTxt1) {
		this.choiceTxt1 = choiceTxt1;
	}

	public String getChoiceTxt2() {
		return this.choiceTxt2;
	}

	public void setChoiceTxt2(String choiceTxt2) {
		this.choiceTxt2 = choiceTxt2;
	}

	public String getChoiceTxt3() {
		return this.choiceTxt3;
	}

	public void setChoiceTxt3(String choiceTxt3) {
		this.choiceTxt3 = choiceTxt3;
	}

	public String getChoiceTxt4() {
		return this.choiceTxt4;
	}

	public void setChoiceTxt4(String choiceTxt4) {
		this.choiceTxt4 = choiceTxt4;
	}

	public String getChoiceTxt5() {
		return this.choiceTxt5;
	}

	public void setChoiceTxt5(String choiceTxt5) {
		this.choiceTxt5 = choiceTxt5;
	}

	public String getChoiceTxt6() {
		return this.choiceTxt6;
	}

	public void setChoiceTxt6(String choiceTxt6) {
		this.choiceTxt6 = choiceTxt6;
	}

	public String getChoiceTxt7() {
		return this.choiceTxt7;
	}

	public void setChoiceTxt7(String choiceTxt7) {
		this.choiceTxt7 = choiceTxt7;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getParagraphTxt() {
		return this.paragraphTxt;
	}

	public void setParagraphTxt(String paragraphTxt) {
		this.paragraphTxt = paragraphTxt;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public Long getSubjectSeqNo() {
		return this.subjectSeqNo;
	}

	public void setSubjectSeqNo(Long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}

	public Long getqSeqNo() {
		return qSeqNo;
	}

	public void setqSeqNo(Long qSeqNo) {
		this.qSeqNo = qSeqNo;
	}

	public Character getSubjective() {
		return subjective;
	}

	public void setSubjective(Character subjective) {
		this.subjective = subjective;
	}

	public LMSSubjectQuestionsMaster(Long qSeqNo, Long complexitySeqNo, Character subjective, String blankTxt1,
			String blankTxt1Type, String blankTxt2, String blankTxt2Type, String blankTxt3, String blankTxt3Type,
			String blankTxt4, String blankTxt4Type, String blankTxt5, String blankTxt5Type, String blankTxt6,
			String blankTxt6Type, String blankTxt7, String blankTxt7Type, String choiceFlg1, String choiceFlg2,
			String choiceFlg3, String choiceFlg4, String choiceFlg5, String choiceFlg6, String choiceFlg7,
			String choiceTxt1, String choiceTxt2, String choiceTxt3, String choiceTxt4, String choiceTxt5,
			String choiceTxt6, String choiceTxt7, Integer duration, String paragraphTxt, String question,
			String questionId, Long subjectSeqNo) {
		super();
		this.qSeqNo = qSeqNo;
		this.complexitySeqNo = complexitySeqNo;
		this.subjective = subjective;
		this.blankTxt1 = blankTxt1;
		this.blankTxt1Type = blankTxt1Type;
		this.blankTxt2 = blankTxt2;
		this.blankTxt2Type = blankTxt2Type;
		this.blankTxt3 = blankTxt3;
		this.blankTxt3Type = blankTxt3Type;
		this.blankTxt4 = blankTxt4;
		this.blankTxt4Type = blankTxt4Type;
		this.blankTxt5 = blankTxt5;
		this.blankTxt5Type = blankTxt5Type;
		this.blankTxt6 = blankTxt6;
		this.blankTxt6Type = blankTxt6Type;
		this.blankTxt7 = blankTxt7;
		this.blankTxt7Type = blankTxt7Type;
		this.choiceFlg1 = choiceFlg1;
		this.choiceFlg2 = choiceFlg2;
		this.choiceFlg3 = choiceFlg3;
		this.choiceFlg4 = choiceFlg4;
		this.choiceFlg5 = choiceFlg5;
		this.choiceFlg6 = choiceFlg6;
		this.choiceFlg7 = choiceFlg7;
		this.choiceTxt1 = choiceTxt1;
		this.choiceTxt2 = choiceTxt2;
		this.choiceTxt3 = choiceTxt3;
		this.choiceTxt4 = choiceTxt4;
		this.choiceTxt5 = choiceTxt5;
		this.choiceTxt6 = choiceTxt6;
		this.choiceTxt7 = choiceTxt7;
		this.duration = duration;
		this.paragraphTxt = paragraphTxt;
		this.question = question;
		this.questionId = questionId;
		this.subjectSeqNo = subjectSeqNo;
	}

}