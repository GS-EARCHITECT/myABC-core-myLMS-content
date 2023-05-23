package subject_content_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import subject_content_mgmt.model.dto.LMSSubjectContentDetailsDTO;
import subject_content_mgmt.services.I_LMSSubjectContentDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/subjectContentManagement")
public class LMSSubjectContent_Detail_Controller {

//	private static final Logger logger = LoggerFactory.getLogger(LMSSubjectContentDetails_Controller.class);

	@Autowired
	private I_LMSSubjectContentDetailsService subjectContentDetailsServ;
	
	@PostMapping("/new")
	public ResponseEntity<LMSSubjectContentDetailsDTO> newsubjectContent(@RequestBody LMSSubjectContentDetailsDTO subjectContentDTO) {
		LMSSubjectContentDetailsDTO subjectContentDTO2 = subjectContentDetailsServ.newLMSSubjectContentDetails(subjectContentDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(subjectContentDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllsubjectContent", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectContentDetailsDTO>> getAllLMSSubjectContentDetailss() {
		ArrayList<LMSSubjectContentDetailsDTO> subjectContentDTOs = subjectContentDetailsServ.getAllLMSSubjectContentDetailss();
		return new ResponseEntity<>(subjectContentDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectSubjectContent", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectContentDetailsDTO>> getSelectLMSSubjectContentDetailss(@RequestBody ArrayList<Long> subjectContentSeqNos) {
		ArrayList<LMSSubjectContentDetailsDTO> subjectContentDTOs = subjectContentDetailsServ.getSelectLMSSubjects(subjectContentSeqNos);		
		return new ResponseEntity<>(subjectContentDTOs, HttpStatus.OK);
	}	
	
	@PutMapping("/updsubjectContent")
	public void updatesubjectContent(@RequestBody LMSSubjectContentDetailsDTO subjectContentDTO) 
	{
			subjectContentDetailsServ.updLMSSubjectContentDetails(subjectContentDTO);	
		return;
	}

	@DeleteMapping("/delsubjectContent")
	public void deletesubjectContent(@RequestBody LMSSubjectContentDetailsDTO lMaster) {
		subjectContentDetailsServ.delLMSSubjectContentDetails(lMaster);
	}

	@DeleteMapping("/delSelectsubjectContent")
	public void deleteSelectsubjectContent(@RequestBody ArrayList<Long> subjectContentSeqNoList) {
		subjectContentDetailsServ.delSelectLMSSubjects(subjectContentSeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllsubjectContent")
	public void deleteAllsubjectContent() {
		subjectContentDetailsServ.delAllLMSSubjectContentDetailss();;
		return;
	}
	}