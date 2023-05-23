package subject_media_mgmt.controller;

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
import subject_media_mgmt.model.dto.LMSSubjectMediaDetailsDTO;
import subject_media_mgmt.services.I_LMSSubjectMediaDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/subjectMediaDetailsManagement")
public class LMSSubjectMediaDetails_Master_Controller {

//	private static final Logger logger = LoggerFactory.getLogger(LMSSubjectMediaDetails_Controller.class);

	@Autowired
	private I_LMSSubjectMediaDetailsService subjectMediaDetailsServ;
	
	@PostMapping("/new")
	public ResponseEntity<LMSSubjectMediaDetailsDTO> newsubjectMediaDetails(@RequestBody LMSSubjectMediaDetailsDTO subjectMediaDetailsDTO) {
		LMSSubjectMediaDetailsDTO subjectMediaDetailsDTO2 = subjectMediaDetailsServ.newLMSSubjectMediaDetails(subjectMediaDetailsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(subjectMediaDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllsubjectCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectMediaDetailsDTO>> getAllLMSSubjectMediaDetailss() {
		ArrayList<LMSSubjectMediaDetailsDTO> subjectMediaDetailsDTOs = subjectMediaDetailsServ.getAllLMSSubjectMediaDetailss();
		return new ResponseEntity<>(subjectMediaDetailsDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectSubjectCategories", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectMediaDetailsDTO>> getSelectLMSMediaBySubjects(@RequestBody ArrayList<Long> subjectDetailsSeqNos) {
		ArrayList<LMSSubjectMediaDetailsDTO> subjectMediaDetailsDTOs = subjectMediaDetailsServ.getSelectLMSMediaBySubjects(subjectDetailsSeqNos);		
		return new ResponseEntity<>(subjectMediaDetailsDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectSubjectTypes", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectMediaDetailsDTO>> getSelectLMSSubjectsByMedia(@RequestBody ArrayList<Long> subjectMediaSeqNos) {
		ArrayList<LMSSubjectMediaDetailsDTO> subjectMediaDetailsDTOs = subjectMediaDetailsServ.getSelectLMSSubjectsByMedia(subjectMediaSeqNos);		
		return new ResponseEntity<>(subjectMediaDetailsDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updsubjectMediaDetails")
	public void updatesubjectMediaDetails(@RequestBody LMSSubjectMediaDetailsDTO subjectMediaDetailsDTO) 
	{
			subjectMediaDetailsServ.updLMSSubjectMediaDetails(subjectMediaDetailsDTO);	
		return;
	}

	@DeleteMapping("/delsubjectMediaDetails/")
	public void deletesubjectMediaDetails(@RequestBody LMSSubjectMediaDetailsDTO lMaster) {
		subjectMediaDetailsServ.delLMSSubjectMediaDetails(lMaster);
	}

	@DeleteMapping("/delSelectsubjectMediaDetails")
	public void deleteSelectsubjectMediaDetails(@RequestBody ArrayList<Long> subjectMediaDetailsSeqNoList) {
		subjectMediaDetailsServ.delSelectLMSSubjects(subjectMediaDetailsSeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllsubjectMediaDetails")
	public void deleteAllsubjectCategories() {
		subjectMediaDetailsServ.delAllLMSSubjectMediaDetailss();;
		return;
	}
	}