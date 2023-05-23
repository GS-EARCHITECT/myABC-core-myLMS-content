package subject_questions_mgmt.services;

import java.util.ArrayList;
import subject_questions_mgmt.model.dto.LMSSubjectQuestionMasterExactDTO;
import subject_questions_mgmt.model.dto.LMSSubjectQuestionsMasterDTO;

public interface I_LMSSubjectQuestionsMasterService
{
    abstract public LMSSubjectQuestionsMasterDTO newQuestion(LMSSubjectQuestionsMasterDTO questionMasterDTO);
    abstract public ArrayList<LMSSubjectQuestionsMasterDTO> getAllQuestions();
    abstract public ArrayList<Long> getSubjectiveInList(ArrayList<Long> idsLst);
    abstract public ArrayList<Long> getObjectiveInList( ArrayList<Long> idsLst);
    abstract public LMSSubjectQuestionsMasterDTO getQuestionById(Long questionSeqNo);
    abstract public ArrayList<LMSSubjectQuestionsMasterDTO> getSelectQuestionsForSubjects(ArrayList<Long> ids);
    abstract public ArrayList<LMSSubjectQuestionsMasterDTO> getSelectQuestionsForSubjectsByComplexities(ArrayList<Long> ids, ArrayList<Long> cids);
    abstract public LMSSubjectQuestionMasterExactDTO getQuestionAnswerDetails(Long qSeqNo);
    abstract public void updQuestion(LMSSubjectQuestionsMasterDTO questionMasterDTO);
    abstract public void delQuestion(Long questionSeqNo);
    abstract public void delSelectQuestionsForSubjects(ArrayList<Long> ids);
    abstract public void delAllQuestions();
    abstract public void delSelectQuestionsForSubjectsByComplexities(ArrayList<Long> ids, ArrayList<Long> cids);

}