package subject_questions_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import subject_questions_mgmt.model.dto.LMSSubjectQuestionMasterExactDTO;
import subject_questions_mgmt.model.dto.LMSSubjectQuestionsMasterDTO;
import subject_questions_mgmt.services.I_LMSSubjectQuestionsMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/subjectQuestionsMasterQuestionsManagement")
public class LMSSubjectQuestionsMasterController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSSubjectQuestionsMaster_Controller.class);

	@Autowired
	private I_LMSSubjectQuestionsMasterService subjectQuestionsMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSSubjectQuestionsMasterDTO> newsubjectQuestionsMaster(
			@RequestBody LMSSubjectQuestionsMasterDTO subjectQuestionsMasterDTO) {
		LMSSubjectQuestionsMasterDTO subjectQuestionsMasterDTO2 = subjectQuestionsMasterServ
				.newQuestion(subjectQuestionsMasterDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(subjectQuestionsMasterDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getExactQuestionAnswerDetails/{questionSeqNo}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSSubjectQuestionMasterExactDTO> getExactQuestionAnswerDetails(
			@PathVariable Long questionSeqNo) {
		LMSSubjectQuestionMasterExactDTO subjectQuestionsMasterExactDTO = subjectQuestionsMasterServ
				.getQuestionAnswerDetails(questionSeqNo);
		return new ResponseEntity<>(subjectQuestionsMasterExactDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllQuestions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectQuestionsMasterDTO>> getAllQuestions() {
		ArrayList<LMSSubjectQuestionsMasterDTO> subjectQuestionsMasterDTOs = subjectQuestionsMasterServ
				.getAllQuestions();
		return new ResponseEntity<>(subjectQuestionsMasterDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{questionSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSSubjectQuestionsMasterDTO> getQuestionById(@PathVariable Long questionSeqNo) {
		LMSSubjectQuestionsMasterDTO subjectQuestionsMasterAccNoDTOs = subjectQuestionsMasterServ
				.getQuestionById(questionSeqNo);
		return new ResponseEntity<>(subjectQuestionsMasterAccNoDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectQuestionsForSubjects", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectQuestionsMasterDTO>> getSelectQuestionsForSubjects(
			@RequestBody ArrayList<Long> subjectSeqNos) {
		ArrayList<LMSSubjectQuestionsMasterDTO> subjectQuestionsMasterDTOs = subjectQuestionsMasterServ
				.getSelectQuestionsForSubjects(subjectSeqNos);
		return new ResponseEntity<>(subjectQuestionsMasterDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSubjectiveInList", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<Long>> getSubjectiveInList(@RequestBody ArrayList<Long> qSeqNos) {
		ArrayList<Long> filteredqSeqNos = subjectQuestionsMasterServ.getSubjectiveInList(qSeqNos);
		return new ResponseEntity<>(filteredqSeqNos, HttpStatus.OK);
	}

	@GetMapping(value = "/getObjectiveInList", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<Long>> getObjectiveInList(@RequestBody ArrayList<Long> qSeqNos) {
		ArrayList<Long> filteredqSeqNos = subjectQuestionsMasterServ.getObjectiveInList(qSeqNos);
		return new ResponseEntity<>(filteredqSeqNos, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectQuestionsForSubjectsByComplexities", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectQuestionsMasterDTO>> getSelectQuestionsForSubjectsByComplexities(
			@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> cids) {
		ArrayList<LMSSubjectQuestionsMasterDTO> subjectQuestionsMasterDTOs = subjectQuestionsMasterServ
				.getSelectQuestionsForSubjectsByComplexities(ids, cids);
		return new ResponseEntity<>(subjectQuestionsMasterDTOs, HttpStatus.OK);
	}

	@PutMapping("/updsubjectQuestionsMaster")
	public void updatesubjectQuestionsMaster(@RequestBody LMSSubjectQuestionsMasterDTO subjectQuestionsMasterDTO) {
		subjectQuestionsMasterServ.updQuestion(subjectQuestionsMasterDTO);
		return;
	}

	@DeleteMapping("/delQuestion/{questionSeqNo}")
	public void deletesubjectQuestionsMaster(@PathVariable Long questionSeqNo) {
		subjectQuestionsMasterServ.delQuestion(questionSeqNo);
	}

	@DeleteMapping("/delSelectQuestionsForSubjects")
	public void deleteSelectsubjectQuestionsMasters(@RequestBody ArrayList<Long> subjectSeqNoList) {
		subjectQuestionsMasterServ.delSelectQuestionsForSubjects(subjectSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectQuestionsForSubjectsByComplexities")
	public void deleteSelectSubjectsByCategries(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> cids) {
		subjectQuestionsMasterServ.delSelectQuestionsForSubjectsByComplexities(ids, cids);
		return;
	}

	@DeleteMapping("/delAllQuestions")
	public void delAllQuestions() {
		subjectQuestionsMasterServ.delAllQuestions();

		return;
	}
}