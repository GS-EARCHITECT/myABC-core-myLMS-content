package subject_faculty_mgmt.controller;

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

import subject_faculty_mgmt.model.dto.LMSSubjectFacultyDetailsDTO;
import subject_faculty_mgmt.services.I_LMSSubjectFacultyDetailsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/subjectFacultyManagement")
public class LMSSubjectFaculty_Detail_Controller {

//	private static final Logger logger = LoggerFactory.getLogger(LMSSubjectFacultyDetails_Controller.class);

	@Autowired
	private I_LMSSubjectFacultyDetailsService subjectFacultyDetailsServ;
	
	@PostMapping("/new")
	public ResponseEntity<LMSSubjectFacultyDetailsDTO> newsubjectFaculty(@RequestBody LMSSubjectFacultyDetailsDTO subjectFacultyDTO) {
		LMSSubjectFacultyDetailsDTO subjectFacultyDTO2 = subjectFacultyDetailsServ.newLMSSubjectFacultyDetails(subjectFacultyDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(subjectFacultyDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllsubjectFaculty", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectFacultyDetailsDTO>> getAllLMSSubjectFacultyDetailss() {
		ArrayList<LMSSubjectFacultyDetailsDTO> subjectFacultyDTOs = subjectFacultyDetailsServ.getAllLMSSubjectFacultyDetailss();
		return new ResponseEntity<>(subjectFacultyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectSubjectFaculty", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectFacultyDetailsDTO>> getSelectLMSSubjectFacultyDetailss(@RequestBody ArrayList<Long> subjectFacultySeqNos) {
		ArrayList<LMSSubjectFacultyDetailsDTO> subjectFacultyDTOs = subjectFacultyDetailsServ.getSelectLMSSubjects(subjectFacultySeqNos);		
		return new ResponseEntity<>(subjectFacultyDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectSubjectsByFaculties", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectFacultyDetailsDTO>> getSelectLMSSubjectsByFaculties(@RequestBody ArrayList<Long> subjectFacultySeqNos) {
		ArrayList<LMSSubjectFacultyDetailsDTO> subjectFacultyDTOs = subjectFacultyDetailsServ.getSelectSubjectsByFaculties(subjectFacultySeqNos);		
		return new ResponseEntity<>(subjectFacultyDTOs, HttpStatus.OK);
	}	
	
	@PutMapping("/updsubjectFaculty")
	public void updatesubjectFaculty(@RequestBody LMSSubjectFacultyDetailsDTO subjectFacultyDTO) 
	{
			subjectFacultyDetailsServ.updLMSSubjectFacultyDetails(subjectFacultyDTO);	
		return;
	}

	
	@DeleteMapping("/delSelectsubjectFaculty")
	public void deleteSelectsubjectFaculty(@RequestBody ArrayList<Long> subjectFacultySeqNoList) {
		subjectFacultyDetailsServ.delSelectLMSSubjects(subjectFacultySeqNoList);
		return;
	}
	
	@DeleteMapping("/delSelectsubjectsByFaculties")
	public void deleteSelectsubjectByFaculty(@RequestBody ArrayList<Long> subjectFacultySeqNoList) {
		subjectFacultyDetailsServ.delSelectLMSSubjectByFaculties(subjectFacultySeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllsubjectFaculty")
	public void deleteAllsubjectFaculty() {
		subjectFacultyDetailsServ.delAllLMSSubjectFacultyDetailss();;
		return;
	}
	}