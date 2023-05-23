package media_category_mgmt.controller;

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
import media_category_mgmt.model.dto.LMSMediaCategoryMasterDTO;
import media_category_mgmt.services.I_LMSMediaCategoryMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/mediaCategoryManagement")
public class LMSMediaCategory_Master_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSMediaCategoryMaster_Controller.class);

	@Autowired
	private I_LMSMediaCategoryMasterService mediaCategoryMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSMediaCategoryMasterDTO> newMediaCategory(@RequestBody LMSMediaCategoryMasterDTO MediaCategoryDTO) {
		LMSMediaCategoryMasterDTO MediaCategoryDTO2 = mediaCategoryMasterServ.newLMSMediaCategoryMaster(MediaCategoryDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(MediaCategoryDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectMediaCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSMediaCategoryMasterDTO>> getSelectLMSMediaCategories(@RequestBody ArrayList<BigDecimal> ids)
	{
		ArrayList<LMSMediaCategoryMasterDTO> MediaCategoryDTOs = mediaCategoryMasterServ.getSelectLMSMediaCategories(ids);
		return new ResponseEntity<>(MediaCategoryDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllMediaCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSMediaCategoryMasterDTO>> getAllLMSMediaCategoryMasters() {
		ArrayList<LMSMediaCategoryMasterDTO> MediaCategoryDTOs = mediaCategoryMasterServ.getAllLMSMediaCategoryMasters();
		return new ResponseEntity<>(MediaCategoryDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectMediaCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSMediaCategoryMasterDTO>> getSelectLMSMediaCategoriesMasters(
			@RequestBody ArrayList<BigDecimal> MediaCategorySeqNos) {
		ArrayList<LMSMediaCategoryMasterDTO> MediaCategoryDTOs = mediaCategoryMasterServ
				.getSelectLMSMediaCategories(MediaCategorySeqNos);
		return new ResponseEntity<>(MediaCategoryDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{mediaCatSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSMediaCategoryMasterDTO> getLMSMediaCategoryMasterById(
			@PathVariable BigDecimal mediaCatSeqNo) 
	{
		LMSMediaCategoryMasterDTO MediaCategoryAccNoDTOs = mediaCategoryMasterServ
				.getLMSMediaCategoryMasterById(mediaCatSeqNo);
		return new ResponseEntity<>(MediaCategoryAccNoDTOs, HttpStatus.OK);
	}

	@PutMapping("/updMediaCategory")
	public void updateMediaCategory(@RequestBody LMSMediaCategoryMasterDTO MediaCategoryDTO) {
		mediaCategoryMasterServ.updLMSMediaCategoryMaster(MediaCategoryDTO);
		return;
	}

	@DeleteMapping("/delMediaCategory{mediaCatSeqNo}")
	public void deleteMediaCategory(@PathVariable BigDecimal mediaCatSeqNo)
	{
		mediaCategoryMasterServ.delLMSMediaCategoryMaster(mediaCatSeqNo);
	}

	@DeleteMapping("/delSelectMediaCategory")
	public void deleteSelectMediaCategory(@RequestBody ArrayList<BigDecimal> MediaCategorySeqNoList) {
		mediaCategoryMasterServ.getSelectLMSMediaCategories(MediaCategorySeqNoList);
		return;
	}

	@DeleteMapping("/delAllMediaCategory")
	public void deleteAllMediaCategories() {
		mediaCategoryMasterServ.delAllLMSMediaCategoryMasters();
		;
		return;
	}
}