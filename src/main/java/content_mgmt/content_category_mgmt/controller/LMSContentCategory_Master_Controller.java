package content_mgmt.content_category_mgmt.controller;

import java.math.BigDecimal;
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

import content_mgmt.content_category_mgmt.model.dto.LMSContentCategoryMasterDTO;
import content_mgmt.content_category_mgmt.services.I_LMSContentCategoryMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/ContentCategoryManagement")
public class LMSContentCategory_Master_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSContentCategoryMaster_Controller.class);

	@Autowired
	private I_LMSContentCategoryMasterService contentCategoryMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSContentCategoryMasterDTO> newContentCategory(@RequestBody LMSContentCategoryMasterDTO ContentCategoryDTO) {
		LMSContentCategoryMasterDTO ContentCategoryDTO2 = contentCategoryMasterServ.newLMSContentCategoryMaster(ContentCategoryDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(ContentCategoryDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectContentCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSContentCategoryMasterDTO>> getSelectLMSContentCategories(@RequestBody ArrayList<BigDecimal> ids)
	{
		ArrayList<LMSContentCategoryMasterDTO> ContentCategoryDTOs = contentCategoryMasterServ.getSelectLMSContentCategories(ids);
		return new ResponseEntity<>(ContentCategoryDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectContentCategoriesForTypes", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSContentCategoryMasterDTO>> getSelectLMSContentCategoriesForTypes(@RequestBody ArrayList<BigDecimal> ids)
	{
		ArrayList<LMSContentCategoryMasterDTO> ContentCategoryDTOs = contentCategoryMasterServ.getSelectLMSContentCategoriesForTypes(ids);
		return new ResponseEntity<>(ContentCategoryDTOs, HttpStatus.OK);
	}
		
	@GetMapping(value = "/getAllContentCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSContentCategoryMasterDTO>> getAllLMSContentCategoryMasters() {
		ArrayList<LMSContentCategoryMasterDTO> ContentCategoryDTOs = contentCategoryMasterServ.getAllLMSContentCategoryMasters();
		return new ResponseEntity<>(ContentCategoryDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSContentCategoryMasterDTO> getLMSContentCategoryMasterById(
			@RequestBody LMSContentCategoryMasterDTO lmsContentCategoryMasterDTO) 
	{
		LMSContentCategoryMasterDTO ContentCategoryAccNoDTOs = contentCategoryMasterServ
				.getLMSContentCategoryMasterById(lmsContentCategoryMasterDTO);
		return new ResponseEntity<>(ContentCategoryAccNoDTOs, HttpStatus.OK);
	}

	@PutMapping("/updContentCategory")
	public void updateContentCategory(@RequestBody LMSContentCategoryMasterDTO ContentCategoryDTO) {
		contentCategoryMasterServ.updLMSContentCategoryMaster(ContentCategoryDTO);
		return;
	}

	@DeleteMapping("/delContentCategory")
	public void deleteContentCategory(@RequestBody LMSContentCategoryMasterDTO lmsContentCategoryMasterDTO)
	{
		contentCategoryMasterServ.delLMSContentCategoryMaster(lmsContentCategoryMasterDTO);
	}

	@DeleteMapping("/delSelectContentCategory")
	public void deleteSelectContentCategory(@RequestBody ArrayList<BigDecimal> ContentCategorySeqNoList) {
		contentCategoryMasterServ.getSelectLMSContentCategories(ContentCategorySeqNoList);
		return;
	}

	@DeleteMapping("/delAllContentCategory")
	public void deleteAllContentCategories() {
		contentCategoryMasterServ.delAllLMSContentCategoryMasters();
		;
		return;
	}
}