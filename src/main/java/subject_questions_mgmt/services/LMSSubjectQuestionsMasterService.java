package subject_questions_mgmt.services;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import subject_questions_mgmt.model.dto.LMSSubjectQuestionMasterExactDTO;
import subject_questions_mgmt.model.dto.LMSSubjectQuestionsMasterDTO;
import subject_questions_mgmt.model.master.LMSSubjectQuestionsMaster;
import subject_questions_mgmt.model.repo.LMSSubjectQuestionsMasterRepo;

@Service("subjectQuestionsMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSSubjectQuestionsMasterService implements I_LMSSubjectQuestionsMasterService 
{

	@Autowired
	private LMSSubjectQuestionsMasterRepo subjectQuestionsMasterRepo;

	public LMSSubjectQuestionsMasterDTO newQuestion(LMSSubjectQuestionsMasterDTO lMasters) {
		LMSSubjectQuestionsMaster LMSSubjectQuestionsMaster = subjectQuestionsMasterRepo.save(this.setLMSSubjectQuestionsMaster(lMasters));
		lMasters = getLMSSubjectQuestionsMasterDTO(LMSSubjectQuestionsMaster);
		return lMasters;
	}

	public ArrayList<Long> getSubjectiveInList(ArrayList<Long> idsLst) 
	{
		ArrayList<Long> subjectList = subjectQuestionsMasterRepo.getSubjectiveInList(idsLst);
		return subjectList;
	}
	
    public ArrayList<Long> getObjectiveInList( ArrayList<Long> idsLst) 
	{
		ArrayList<Long> subjectList = subjectQuestionsMasterRepo.getObjectiveInList(idsLst);
		return subjectList;
	}
    
	
	public ArrayList<LMSSubjectQuestionsMasterDTO> getAllQuestions() {
		ArrayList<LMSSubjectQuestionsMaster> subjectList = (ArrayList<LMSSubjectQuestionsMaster>) subjectQuestionsMasterRepo.findAll();
		ArrayList<LMSSubjectQuestionsMasterDTO> lMasters = new ArrayList<LMSSubjectQuestionsMasterDTO>();
		lMasters = subjectList != null ? this.getLMSSubjectQuestionsMasterDTOs(subjectList) : null;
		return lMasters;
	}

	public LMSSubjectQuestionMasterExactDTO getQuestionAnswerDetails(Long qSeqNo) 
	{
		LMSSubjectQuestionsMasterDTO lmsSubjectQuestionsMasterDTO = this.getQuestionById(qSeqNo);
		ArrayList<String> blankTxtStrs = new ArrayList<String>();
		ArrayList<Integer> choiceTxtNos = new ArrayList<Integer>();
		String pText = null; 
		LMSSubjectQuestionMasterExactDTO lmsSubjectQuestionMasterExactDTO = new LMSSubjectQuestionMasterExactDTO(); 
		
		// Check answer choices in question  
		if(lmsSubjectQuestionsMasterDTO.getChoiceFlg1()!=null)
		{
		choiceTxtNos.add(1);	
		}
		
		if(lmsSubjectQuestionsMasterDTO.getChoiceFlg2()!=null)
		{
		choiceTxtNos.add(2);	
		}
		
		if(lmsSubjectQuestionsMasterDTO.getChoiceFlg3()!=null)
		{
		choiceTxtNos.add(3);	
		}
		
		if(lmsSubjectQuestionsMasterDTO.getChoiceFlg4()!=null)
		{
		choiceTxtNos.add(4);	
		}
		
		if(lmsSubjectQuestionsMasterDTO.getChoiceFlg5()!=null)
		{
		choiceTxtNos.add(5);	
		}
		
		if(lmsSubjectQuestionsMasterDTO.getChoiceFlg6()!=null)
		{
		choiceTxtNos.add(6);	
		}
		
		if(lmsSubjectQuestionsMasterDTO.getChoiceFlg7()!=null)
		{
		choiceTxtNos.add(7);	
		}
		
		// Check answer blanks in question
		if(lmsSubjectQuestionsMasterDTO.getBlankTxt1()!=null)
		{
		blankTxtStrs.add(lmsSubjectQuestionsMasterDTO.getBlankTxt1());	
		}
		
		if(lmsSubjectQuestionsMasterDTO.getBlankTxt2()!=null)
		{
		blankTxtStrs.add(lmsSubjectQuestionsMasterDTO.getBlankTxt2());	
		}
		
		if(lmsSubjectQuestionsMasterDTO.getBlankTxt3()!=null)
		{
		blankTxtStrs.add(lmsSubjectQuestionsMasterDTO.getBlankTxt3());	
		}
		
		if(lmsSubjectQuestionsMasterDTO.getBlankTxt4()!=null)
		{
		blankTxtStrs.add(lmsSubjectQuestionsMasterDTO.getBlankTxt4());	
		}
		
		if(lmsSubjectQuestionsMasterDTO.getBlankTxt5()!=null)
		{
		blankTxtStrs.add(lmsSubjectQuestionsMasterDTO.getBlankTxt5());	
		}
		
		if(lmsSubjectQuestionsMasterDTO.getBlankTxt6()!=null)
		{
		blankTxtStrs.add(lmsSubjectQuestionsMasterDTO.getBlankTxt6());	
		}
		
		if(lmsSubjectQuestionsMasterDTO.getBlankTxt7()!=null)
		{
		blankTxtStrs.add(lmsSubjectQuestionsMasterDTO.getBlankTxt7());	
		}
		
		// Check answer para in question
		if(lmsSubjectQuestionsMasterDTO.getParagraphTxt()!=null)
		{
		pText=lmsSubjectQuestionsMasterDTO.getParagraphTxt();	
		}
		
		lmsSubjectQuestionMasterExactDTO.setqSeqNo(lmsSubjectQuestionsMasterDTO.getqSeqNo());
		lmsSubjectQuestionMasterExactDTO.setBlankTxts(blankTxtStrs);
		lmsSubjectQuestionMasterExactDTO.setChoiceTxtNos(choiceTxtNos);
		lmsSubjectQuestionMasterExactDTO.setParagraphTxt(pText);		
		return lmsSubjectQuestionMasterExactDTO;
	}
	
	public LMSSubjectQuestionsMasterDTO getQuestionById(Long questionSeqNo) 
	{
		Optional<LMSSubjectQuestionsMaster> LMSSubjectQuestionsMaster = subjectQuestionsMasterRepo.findById(questionSeqNo);
		LMSSubjectQuestionsMasterDTO lMasters = null;
		if (LMSSubjectQuestionsMaster.isPresent()) {
			lMasters = LMSSubjectQuestionsMaster != null ? this.getLMSSubjectQuestionsMasterDTO(LMSSubjectQuestionsMaster.get())
					: null;
		}
		return lMasters;
	}

	public ArrayList<LMSSubjectQuestionsMasterDTO> getSelectQuestionsForSubjects(ArrayList<Long> ids) 
	{
		ArrayList<LMSSubjectQuestionsMaster> lMasters = subjectQuestionsMasterRepo.getSelectQuestionsForSubjects(ids);
		ArrayList<LMSSubjectQuestionsMasterDTO> LMSSubjectQuestionsMasterDTOs = new ArrayList<LMSSubjectQuestionsMasterDTO>();
		LMSSubjectQuestionsMasterDTO LMSSubjectQuestionsMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSSubjectQuestionsMasterDTO = this.getLMSSubjectQuestionsMasterDTO(lMasters.get(i));
				LMSSubjectQuestionsMasterDTOs.add(LMSSubjectQuestionsMasterDTO);
			}
		}
		return LMSSubjectQuestionsMasterDTOs;
	}

	public ArrayList<LMSSubjectQuestionsMasterDTO> getSelectQuestionsForSubjectsByComplexities(ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids) 
	{
		ArrayList<LMSSubjectQuestionsMaster> lMasters = subjectQuestionsMasterRepo.getSelectQuestionsForSubjectsByComplexities(ids, cids);
		ArrayList<LMSSubjectQuestionsMasterDTO> LMSSubjectQuestionsMasterDTOs = new ArrayList<LMSSubjectQuestionsMasterDTO>();
		LMSSubjectQuestionsMasterDTO LMSSubjectQuestionsMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSSubjectQuestionsMasterDTO = this.getLMSSubjectQuestionsMasterDTO(lMasters.get(i));
				LMSSubjectQuestionsMasterDTOs.add(LMSSubjectQuestionsMasterDTO);
			}
		}
		return LMSSubjectQuestionsMasterDTOs;
	}

		
	
	public void updQuestion(LMSSubjectQuestionsMasterDTO questionMasterDTO)
	{
		LMSSubjectQuestionsMaster subjectQuestionsMaster = this.setLMSSubjectQuestionsMaster(questionMasterDTO);
		if (subjectQuestionsMasterRepo.existsById(questionMasterDTO.getqSeqNo())) {
			subjectQuestionsMaster.setSubjectSeqNo(questionMasterDTO.getqSeqNo());
			subjectQuestionsMasterRepo.save(subjectQuestionsMaster);
		}
		return;
	}

	public void delQuestion(Long questionSeqNo)
	{
		if (subjectQuestionsMasterRepo.existsById(questionSeqNo)) {
			subjectQuestionsMasterRepo.deleteById(questionSeqNo);
		}
		return;
	}

	public void delAllQuestions() {
		subjectQuestionsMasterRepo.deleteAll();
	}

	public void delSelectQuestionsForSubjects(ArrayList<Long> ids)
	{
		if (ids != null) {
			subjectQuestionsMasterRepo.delSelectQuestionsForSubjects(ids);
		}
	}

	public void delSelectQuestionsForSubjectsByComplexities(ArrayList<Long> ids, ArrayList<Long> cids)
	{
		if (ids != null && cids != null) {
			subjectQuestionsMasterRepo.delSelectQuestionsForSubjectsByComplexities(ids, cids);
		}
	}
	
	private ArrayList<LMSSubjectQuestionsMasterDTO> getLMSSubjectQuestionsMasterDTOs(ArrayList<LMSSubjectQuestionsMaster> lMasters) {
		LMSSubjectQuestionsMasterDTO lDTO = null;
		ArrayList<LMSSubjectQuestionsMasterDTO> lMasterDTOs = new ArrayList<LMSSubjectQuestionsMasterDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSSubjectQuestionsMasterDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSSubjectQuestionsMasterDTO getLMSSubjectQuestionsMasterDTO(LMSSubjectQuestionsMaster lMaster) {
		LMSSubjectQuestionsMasterDTO lDTO = new LMSSubjectQuestionsMasterDTO();
		lDTO.setSubjectSeqNo(lMaster.getSubjectSeqNo());
		lDTO.setqSeqNo(lMaster.getqSeqNo());
		lDTO.setQuestion(lMaster.getQuestion());
		lDTO.setQuestionId(lMaster.getQuestionId());
		lDTO.setDuration(lMaster.getDuration());
		lDTO.setBlankTxt1(lMaster.getBlankTxt1());
		lDTO.setBlankTxt1Type(lMaster.getBlankTxt1Type());
		lDTO.setBlankTxt2(lMaster.getBlankTxt2());
		lDTO.setBlankTxt2Type(lMaster.getBlankTxt2Type());
		lDTO.setBlankTxt3(lMaster.getBlankTxt3());
		lDTO.setBlankTxt3Type(lMaster.getBlankTxt3Type());
		lDTO.setBlankTxt4(lMaster.getBlankTxt4());
		lDTO.setBlankTxt4Type(lMaster.getBlankTxt4Type());
		lDTO.setBlankTxt5(lMaster.getBlankTxt5());
		lDTO.setBlankTxt5Type(lMaster.getBlankTxt5Type());
		lDTO.setBlankTxt6(lMaster.getBlankTxt6());
		lDTO.setBlankTxt6Type(lMaster.getBlankTxt6Type());
		lDTO.setBlankTxt7(lMaster.getBlankTxt7());
		lDTO.setBlankTxt7Type(lMaster.getBlankTxt7Type());
		lDTO.setChoiceTxt1(lMaster.getChoiceTxt1());
		lDTO.setChoiceTxt2(lMaster.getChoiceTxt2());
		lDTO.setChoiceTxt3(lMaster.getChoiceTxt3());
		lDTO.setChoiceTxt4(lMaster.getChoiceTxt4());
		lDTO.setChoiceTxt5(lMaster.getChoiceTxt5());
		lDTO.setChoiceTxt6(lMaster.getChoiceTxt6());
		lDTO.setChoiceTxt7(lMaster.getChoiceTxt7());
		lDTO.setComplexitySeqNo(lMaster.getComplexitySeqNo());		
		lDTO.setParagraphTxt(lMaster.getParagraphTxt());
		lDTO.setSubjective(lMaster.getSubjective());
		return lDTO;
	}

	private LMSSubjectQuestionsMaster setLMSSubjectQuestionsMaster(LMSSubjectQuestionsMasterDTO lDTO) {
		LMSSubjectQuestionsMaster lMaster = new LMSSubjectQuestionsMaster();		
		lMaster.setSubjectSeqNo(lDTO.getSubjectSeqNo());		
		lMaster.setQuestion(lDTO.getQuestion());
		lMaster.setQuestionId(lDTO.getQuestionId());
		lMaster.setDuration(lDTO.getDuration());
		lMaster.setBlankTxt1(lDTO.getBlankTxt1());
		lMaster.setBlankTxt1Type(lDTO.getBlankTxt1Type());
		lMaster.setBlankTxt2(lDTO.getBlankTxt2());
		lMaster.setBlankTxt2Type(lDTO.getBlankTxt2Type());
		lMaster.setBlankTxt3(lDTO.getBlankTxt3());
		lMaster.setBlankTxt3Type(lDTO.getBlankTxt3Type());
		lMaster.setBlankTxt4(lDTO.getBlankTxt4());
		lMaster.setBlankTxt4Type(lDTO.getBlankTxt4Type());
		lMaster.setBlankTxt5(lDTO.getBlankTxt5());
		lMaster.setBlankTxt5Type(lDTO.getBlankTxt5Type());
		lMaster.setBlankTxt6(lDTO.getBlankTxt6());
		lMaster.setBlankTxt6Type(lDTO.getBlankTxt6Type());
		lMaster.setBlankTxt7(lDTO.getBlankTxt7());
		lMaster.setBlankTxt7Type(lDTO.getBlankTxt7Type());
		lMaster.setChoiceTxt1(lDTO.getChoiceTxt1());
		lMaster.setChoiceTxt2(lDTO.getChoiceTxt2());
		lMaster.setChoiceTxt3(lDTO.getChoiceTxt3());
		lMaster.setChoiceTxt4(lDTO.getChoiceTxt4());
		lMaster.setChoiceTxt5(lDTO.getChoiceTxt5());
		lMaster.setChoiceTxt6(lDTO.getChoiceTxt6());
		lMaster.setChoiceTxt7(lDTO.getChoiceTxt7());
		lMaster.setChoiceFlg1(lDTO.getChoiceFlg1());
		lMaster.setChoiceFlg2(lDTO.getChoiceFlg2());
		lMaster.setChoiceFlg3(lDTO.getChoiceFlg3());
		lMaster.setChoiceFlg4(lDTO.getChoiceFlg4());
		lMaster.setChoiceFlg5(lDTO.getChoiceFlg5());
		lMaster.setChoiceFlg6(lDTO.getChoiceFlg6());
		lMaster.setChoiceFlg7(lDTO.getChoiceFlg7());
		lMaster.setComplexitySeqNo(lDTO.getComplexitySeqNo());		
		lMaster.setParagraphTxt(lDTO.getParagraphTxt());
		lMaster.setSubjective(lDTO.getSubjective());
		return lMaster;
	}
}