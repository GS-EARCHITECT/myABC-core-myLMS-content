package content_mgmt.content_media_mgmt.controller;

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

import content_mgmt.content_media_mgmt.model.dto.LMSContentMediaDetailDTO;
import content_mgmt.content_media_mgmt.services.I_LMSContentMediaDetailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/contentMediaDetailManagement")
public class LMSContentMediaDetail_Master_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSContentMediaDetail_Controller.class);

	@Autowired
	private I_LMSContentMediaDetailService contentMediaDetailServ;

	@PostMapping("/new")
	public ResponseEntity<LMSContentMediaDetailDTO> newContentMediaDetail(@RequestBody LMSContentMediaDetailDTO ContentMediaDetailDTO) 
	{
		LMSContentMediaDetailDTO ContentMediaDetailDTO2 = contentMediaDetailServ.newLMSContentMediaDetail(ContentMediaDetailDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(ContentMediaDetailDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectContentMediaDetail", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSContentMediaDetailDTO>> getSelectLMSContentMediaDetail(@RequestBody ArrayList<Long> ids)
	{
		ArrayList<LMSContentMediaDetailDTO> ContentMediaDetailDTOs = contentMediaDetailServ.getSelectLMSContentMediaDetail(ids);
		return new ResponseEntity<>(ContentMediaDetailDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllContentMediaDetail", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSContentMediaDetailDTO>> getAllLMSContentMediaDetails() {
		ArrayList<LMSContentMediaDetailDTO> ContentMediaDetailDTOs = contentMediaDetailServ.getAllLMSContentMediaDetails();
		return new ResponseEntity<>(ContentMediaDetailDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSContentMediaDetailDTO> getLMSContentMediaDetailById(
			@RequestBody LMSContentMediaDetailDTO lmsContentMediaDetailDTO) 
	{
		LMSContentMediaDetailDTO ContentMediaDetailAccNoDTOs = contentMediaDetailServ
				.getLMSContentMediaDetailById(lmsContentMediaDetailDTO);
		return new ResponseEntity<>(ContentMediaDetailAccNoDTOs, HttpStatus.OK);
	}

	@PutMapping("/updContentMediaDetail")
	public void updateContentMediaDetail(@RequestBody LMSContentMediaDetailDTO ContentMediaDetailDTO) {
		contentMediaDetailServ.updLMSContentMediaDetail(ContentMediaDetailDTO);
		return;
	}

	@DeleteMapping("/delContentMediaDetail")
	public void deleteContentMediaDetail(@RequestBody LMSContentMediaDetailDTO lmsContentMediaDetailDTO)
	{
		contentMediaDetailServ.delLMSContentMediaDetail(lmsContentMediaDetailDTO);
	}

	@DeleteMapping("/delSelectContentMediaDetail")
	public void deleteSelectContentMediaDetail(@RequestBody ArrayList<Long> ContentMediaDetailSeqNoList) {
		contentMediaDetailServ.getSelectLMSContentMediaDetail(ContentMediaDetailSeqNoList);
		return;
	}

	@DeleteMapping("/delAllContentMediaDetail")
	public void deleteAllContentMediaDetail() {
		contentMediaDetailServ.delAllLMSContentMediaDetails();
		;
		return;
	}
}