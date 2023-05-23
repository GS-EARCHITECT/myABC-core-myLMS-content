package subject_category_mgmt.controller;

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
import subject_category_mgmt.model.dto.LMSSubjectCategoryMasterDTO;
import subject_category_mgmt.services.I_LMSSubjectCategoryMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/subjectCategoryManagement")
public class LMSSubjectCategory_Master_Controller {

//	private static final Logger logger = LoggerFactory.getLogger(LMSSubjectCategoryMaster_Controller.class);

	@Autowired
	private I_LMSSubjectCategoryMasterService subjectCategoryMasterServ;
	
	@PostMapping("/new")
	public ResponseEntity<LMSSubjectCategoryMasterDTO> newsubjectCategory(@RequestBody LMSSubjectCategoryMasterDTO subjectCategoryDTO) {
		LMSSubjectCategoryMasterDTO subjectCategoryDTO2 = subjectCategoryMasterServ.newLMSSubjectCategoryMaster(subjectCategoryDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(subjectCategoryDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllsubjectCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectCategoryMasterDTO>> getAllLMSSubjectCategoryMasters() {
		ArrayList<LMSSubjectCategoryMasterDTO> subjectCategoryDTOs = subjectCategoryMasterServ.getAllLMSSubjectCategoryMasters();
		return new ResponseEntity<>(subjectCategoryDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectSubjectCategories", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectCategoryMasterDTO>> getSelectLMSSubjectCategoryMasters(@RequestBody ArrayList<BigDecimal> subjectCategorySeqNos) {
		ArrayList<LMSSubjectCategoryMasterDTO> subjectCategoryDTOs = subjectCategoryMasterServ.getSelectLMSSubjectCategories(subjectCategorySeqNos);		
		return new ResponseEntity<>(subjectCategoryDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectSubjectTypes", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectCategoryMasterDTO>> getSelectLMSSubjectTypesMasters(@RequestBody ArrayList<BigDecimal> subjectCategorySeqNos) {
		ArrayList<LMSSubjectCategoryMasterDTO> subjectCategoryDTOs = subjectCategoryMasterServ.getSelectLMSSubjectTypes(subjectCategorySeqNos);		
		return new ResponseEntity<>(subjectCategoryDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectSubjectCategoriesByParents", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSubjectCategoryMasterDTO>> getSelectLMSSubjectCategoryMastersByParents(@RequestBody ArrayList<BigDecimal> subjectCategorySeqNos) {
		ArrayList<LMSSubjectCategoryMasterDTO> subjectCategoryDTOs = subjectCategoryMasterServ.getSelectLMSSubjectCategoriesByParents(subjectCategorySeqNos);		
		return new ResponseEntity<>(subjectCategoryDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getById/{subjectCategorySeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })	
	public ResponseEntity<LMSSubjectCategoryMasterDTO> getLMSSubjectCategoryMasterById(@PathVariable BigDecimal subjectCategorySeqNo) 
	{
		LMSSubjectCategoryMasterDTO subjectCategoryAccNoDTOs = subjectCategoryMasterServ.getLMSSubjectCategoryMasterById(subjectCategorySeqNo);		
		return new ResponseEntity<>(subjectCategoryAccNoDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updsubjectCategory")
	public void updatesubjectCategory(@RequestBody LMSSubjectCategoryMasterDTO subjectCategoryDTO) 
	{
			subjectCategoryMasterServ.updLMSSubjectCategoryMaster(subjectCategoryDTO);	
		return;
	}

	@DeleteMapping("/delsubjectCategory/{subjectCategorySeqNo}")
	public void deletesubjectCategory(@PathVariable BigDecimal subjectCategorySeqNo) {
		subjectCategoryMasterServ.delLMSSubjectCategoryMaster(subjectCategorySeqNo);
	}

	@DeleteMapping("/delSelectsubjectCategory")
	public void deleteSelectsubjectCategory(@RequestBody ArrayList<BigDecimal> subjectCategorySeqNoList) {
		subjectCategoryMasterServ.getSelectLMSSubjectCategories(subjectCategorySeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllsubjectCategory")
	public void deleteAllsubjectCategories() {
		subjectCategoryMasterServ.delAllLMSSubjectCategoryMasters();;
		return;
	}
	}