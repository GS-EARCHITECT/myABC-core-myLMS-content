package content_mgmt.content_type_mgmt.controller;

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

import content_mgmt.content_type_mgmt.model.dto.LMSContentTypeMasterDTO;
import content_mgmt.content_type_mgmt.services.I_LMSContentTypeMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/contentTypeManagement")
public class LMSContentType_Master_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSContentTypeMaster_Controller.class);

	@Autowired
	private I_LMSContentTypeMasterService contentTypeMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSContentTypeMasterDTO> newcontentType(@RequestBody LMSContentTypeMasterDTO contentTypeDTO) {
		LMSContentTypeMasterDTO contentTypeDTO2 = contentTypeMasterServ.newLMSContentTypeMaster(contentTypeDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(contentTypeDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllContentTypes", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSContentTypeMasterDTO>> getAllLMSContentTypeMasters() {
		ArrayList<LMSContentTypeMasterDTO> contentTypeDTOs = contentTypeMasterServ.getAllLMSContentTypeMasters();
		return new ResponseEntity<>(contentTypeDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectContentTypes", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSContentTypeMasterDTO>> getSelectLMSContentTypesMasters(
			@RequestBody ArrayList<BigDecimal> contentTypeSeqNos) {
		ArrayList<LMSContentTypeMasterDTO> contentTypeDTOs = contentTypeMasterServ
				.getSelectLMSContentTypes(contentTypeSeqNos);
		return new ResponseEntity<>(contentTypeDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{contentTypeSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSContentTypeMasterDTO> getLMSContentTypeMasterById(
			@PathVariable BigDecimal contentTypeSeqNo) {
		LMSContentTypeMasterDTO contentTypeAccNoDTOs = contentTypeMasterServ
				.getLMSContentTypeMasterById(contentTypeSeqNo);
		return new ResponseEntity<>(contentTypeAccNoDTOs, HttpStatus.OK);
	}

	@PutMapping("/updcontentType")
	public void updatecontentType(@RequestBody LMSContentTypeMasterDTO contentTypeDTO) {
		contentTypeMasterServ.updLMSContentTypeMaster(contentTypeDTO);
		return;
	}

	@DeleteMapping("/delcontentType/{contentTypeSeqNo}")
	public void deletecontentType(@PathVariable BigDecimal contentTypeSeqNo) {
		contentTypeMasterServ.delLMSContentTypeMaster(contentTypeSeqNo);
	}

	@DeleteMapping("/delSelectcontentType")
	public void deleteSelectcontentType(@RequestBody ArrayList<BigDecimal> contentTypeSeqNoList) {
		contentTypeMasterServ.getSelectLMSContentTypes(contentTypeSeqNoList);
		return;
	}

	@DeleteMapping("/delAllcontentType")
	public void deleteAllContentTypes() {
		contentTypeMasterServ.delAllLMSContentTypeMasters();
		;
		return;
	}
}