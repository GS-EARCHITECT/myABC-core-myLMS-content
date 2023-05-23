package subject_type_mgmt.controller;

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
import subject_type_mgmt.model.dto.LMSSubjectTypeMasterDTO;
import subject_type_mgmt.services.I_LMSSubjectTypeMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/subjectTypeManagement")
public class LMSSubjectType_Master_Controller {

//	private static final Logger logger = LoggerFactory.getLogger(LMSSubjectTypeMaster_Controller.class);

	@Autowired
	private I_LMSSubjectTypeMasterService subjectTypeMasterServ;
	
	@PostMapping("/new")
	public ResponseEntity<LMSSubjectTypeMasterDTO> newsubjectType(@RequestBody LMSSubjectTypeMasterDTO subjectTypeDTO) {
		LMSSubjectTypeMasterDTO subjectTypeDTO2 = subjectTypeMasterServ.newLMSSubjectTypeMaster(subjectTypeDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(subjectTypeDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllsubjectTypes", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectTypeMasterDTO>> getAllLMSSubjectTypeMasters() {
		ArrayList<LMSSubjectTypeMasterDTO> subjectTypeDTOs = subjectTypeMasterServ.getAllLMSSubjectTypeMasters();
		return new ResponseEntity<>(subjectTypeDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectSubjectType", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectTypeMasterDTO>> getSelectLMSSubjectTypeMasters(@RequestBody ArrayList<BigDecimal> subjectTypeSeqNos) {
		ArrayList<LMSSubjectTypeMasterDTO> subjectTypeDTOs = subjectTypeMasterServ.getSelectLMSSubjectTypes(subjectTypeSeqNos);		
		return new ResponseEntity<>(subjectTypeDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectSubjectTypesByParents", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectTypeMasterDTO>> getSelectLMSSubjectTypeMastersByParents(@RequestBody ArrayList<BigDecimal> subjectTypeSeqNos) {
		ArrayList<LMSSubjectTypeMasterDTO> subjectTypeDTOs = subjectTypeMasterServ.getSelectLMSSubjectTypesByParents(subjectTypeSeqNos);		
		return new ResponseEntity<>(subjectTypeDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getById/{subjectTypeSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })	
	public ResponseEntity<LMSSubjectTypeMasterDTO> getLMSSubjectTypeMasterById(@PathVariable BigDecimal subjectTypeSeqNo) 
	{
		LMSSubjectTypeMasterDTO subjectTypeAccNoDTOs = subjectTypeMasterServ.getLMSSubjectTypeMasterById(subjectTypeSeqNo);		
		return new ResponseEntity<>(subjectTypeAccNoDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updsubjectType")
	public void updatesubjectType(@RequestBody LMSSubjectTypeMasterDTO subjectTypeDTO) 
	{
			subjectTypeMasterServ.updLMSSubjectTypeMaster(subjectTypeDTO);	
		return;
	}

	@DeleteMapping("/delsubjectType/{subjectTypeSeqNo}")
	public void deletesubjectType(@PathVariable BigDecimal subjectTypeSeqNo) {
		subjectTypeMasterServ.delLMSSubjectTypeMaster(subjectTypeSeqNo);
	}

	@DeleteMapping("/delSelectsubjectType")
	public void deleteSelectsubjectType(@RequestBody ArrayList<BigDecimal> subjectTypeSeqNoList) {
		subjectTypeMasterServ.getSelectLMSSubjectTypes(subjectTypeSeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllsubjectType")
	public void deleteAllsubjectTypes() {
		subjectTypeMasterServ.delAllLMSSubjectTypeMasters();;
		return;
	}
	}