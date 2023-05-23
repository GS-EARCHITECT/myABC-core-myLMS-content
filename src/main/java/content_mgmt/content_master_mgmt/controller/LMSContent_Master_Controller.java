package content_mgmt.content_master_mgmt.controller;

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

import content_mgmt.content_master_mgmt.model.dto.LMSContentMasterDTO;
import content_mgmt.content_master_mgmt.services.I_LMSContentMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/contentManagement")
public class LMSContent_Master_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSContentMaster_Controller.class);

	@Autowired
	private I_LMSContentMasterService contentMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSContentMasterDTO> newcontent(@RequestBody LMSContentMasterDTO contentDTO) {
		LMSContentMasterDTO contentDTO2 = contentMasterServ.newLMSContentMaster(contentDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(contentDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllContents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSContentMasterDTO>> getAllLMSContentMasters() {
		ArrayList<LMSContentMasterDTO> contentDTOs = contentMasterServ.getAllLMSContentMasters();
		return new ResponseEntity<>(contentDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectContent", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSContentMasterDTO>> getSelectLMSContentsMasters(
			@RequestBody ArrayList<Long> contentSeqNos) {
		ArrayList<LMSContentMasterDTO> contentDTOs = contentMasterServ.getSelectLMSContent(contentSeqNos);
		return new ResponseEntity<>(contentDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectContentByCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSContentMasterDTO>> getSelectContentByCategories(
			@RequestBody ArrayList<BigDecimal> contentCCategorySeqNos) {
		ArrayList<LMSContentMasterDTO> contentDTOs = contentMasterServ.getSelectLMSContentByCategories(contentCCategorySeqNos);
		return new ResponseEntity<>(contentDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{contentSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSContentMasterDTO> getLMSContentMasterById(
			@PathVariable Long contentSeqNo) {
		LMSContentMasterDTO contentAccNoDTOs = contentMasterServ
				.getLMSContentMasterById(contentSeqNo);
		return new ResponseEntity<>(contentAccNoDTOs, HttpStatus.OK);
	}

	@PutMapping("/updcontent")
	public void updatecontent(@RequestBody LMSContentMasterDTO contentDTO) {
		contentMasterServ.updLMSContentMaster(contentDTO);
		return;
	}

	@DeleteMapping("/delcontent/{contentSeqNo}")
	public void deletecontent(@PathVariable Long contentSeqNo) {
		contentMasterServ.delLMSContentMaster(contentSeqNo);
	}

	@DeleteMapping("/delSelectcontent")
	public void deleteSelectcontent(@RequestBody ArrayList<Long> contentSeqNoList) {
		contentMasterServ.delSelectLMSContent(contentSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectContentByCategories")
	public void deleteSelectcontentByCategories(@RequestBody ArrayList<BigDecimal> contentCategorySeqNoList) {
		contentMasterServ.delSelectLMSContentByCategories(contentCategorySeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllcontent")
	public void deleteAllContents() {
		contentMasterServ.delAllLMSContentMasters();
		;
		return;
	}
}