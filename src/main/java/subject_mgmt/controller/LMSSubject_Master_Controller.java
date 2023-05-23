package subject_mgmt.controller;

import java.math.BigDecimal;
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

import subject_mgmt.model.dto.LMSSubjectMasterDTO;
import subject_mgmt.services.I_LMSSubjectMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/subjectManagement")
public class LMSSubject_Master_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSSubjectMaster_Controller.class);

	@Autowired
	private I_LMSSubjectMasterService subjectMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSSubjectMasterDTO> newsubject(@RequestBody LMSSubjectMasterDTO subjectDTO) {
		LMSSubjectMasterDTO subjectDTO2 = subjectMasterServ.newLMSSubjectMaster(subjectDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(subjectDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllsubjectCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectMasterDTO>> getAllLMSSubjectMasters() {
		ArrayList<LMSSubjectMasterDTO> subjectDTOs = subjectMasterServ.getAllLMSSubjectMasters();
		return new ResponseEntity<>(subjectDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSubjectCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectMasterDTO>> getSelectLMSSubjectMasters(
			@RequestBody ArrayList<BigDecimal> subjectSeqNos) {
		ArrayList<LMSSubjectMasterDTO> subjectDTOs = subjectMasterServ.getSelectLMSSubjectCategories(subjectSeqNos);
		return new ResponseEntity<>(subjectDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBySubjectCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectMasterDTO>> getSelectLMSSubjectsByCategories(
			@RequestBody ArrayList<BigDecimal> ids) {
		ArrayList<LMSSubjectMasterDTO> subjectDTOs = subjectMasterServ.getSelectLMSSubjectCategories(ids);
		return new ResponseEntity<>(subjectDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSubjects", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectMasterDTO>> getSelectLMSSubjects(
			@RequestBody ArrayList<Long> subjectSeqNos) {
		ArrayList<LMSSubjectMasterDTO> subjectDTOs = subjectMasterServ.getSelectLMSSubjects(subjectSeqNos);				
		return new ResponseEntity<>(subjectDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{subjectSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSSubjectMasterDTO> getLMSSubjectMasterById(@PathVariable Long subjectSeqNo) {
		LMSSubjectMasterDTO subjectAccNoDTOs = subjectMasterServ.getLMSSubjectMasterById(subjectSeqNo);
		return new ResponseEntity<>(subjectAccNoDTOs, HttpStatus.OK);
	}

	@PutMapping("/updsubject")
	public void updatesubject(@RequestBody LMSSubjectMasterDTO subjectDTO) {
		subjectMasterServ.updLMSSubjectMaster(subjectDTO);
		return;
	}

	@DeleteMapping("/delsubject/{subjectSeqNo}")
	public void deletesubject(@PathVariable Long subjectSeqNo) {
		subjectMasterServ.delLMSSubjectMaster(subjectSeqNo);
	}

	@DeleteMapping("/delSelectsubjects")
	public void deleteSelectsubjects(@RequestBody ArrayList<Long> subjectSeqNoList) {
		subjectMasterServ.delSelectLMSSubjects(subjectSeqNoList);
		return;
	}
	
	@DeleteMapping("/delSelectSubjectsByCategries")
	public void deleteSelectSubjectsByCategries(@RequestBody ArrayList<BigDecimal> subjectCatSeqNoList) {
		subjectMasterServ.delSelectLMSSubjectCategories(subjectCatSeqNoList);
		return;
	}

	@DeleteMapping("/delAllsubject")
	public void deleteAllsubjectCategories() {
		subjectMasterServ.delAllLMSSubjectMasters();
		
		return;
	}
}