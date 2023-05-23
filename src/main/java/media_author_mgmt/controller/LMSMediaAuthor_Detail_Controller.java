package media_author_mgmt.controller;

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
import media_author_mgmt.model.dto.LMSMediaAuthorDetailDTO;
import media_author_mgmt.services.I_LMSMediaAuthorDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/mediaAuthorManagement")
public class LMSMediaAuthor_Detail_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSMediaAuthorDetail_Controller.class);

	@Autowired
	private I_LMSMediaAuthorDetailService mediaAuthorDetailServ;

	@PostMapping("/new")
	public ResponseEntity<LMSMediaAuthorDetailDTO> newMediaAuthor(@RequestBody LMSMediaAuthorDetailDTO MediaAuthorDTO) {
		LMSMediaAuthorDetailDTO MediaAuthorDTO2 = mediaAuthorDetailServ.newLMSMediaAuthorDetail(MediaAuthorDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(MediaAuthorDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectMediaByAuthors", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSMediaAuthorDetailDTO>> getSelectLMSMediaAuthors(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<LMSMediaAuthorDetailDTO> MediaAuthorDTOs = mediaAuthorDetailServ.getSelectLMSMediaByAuthors(ids);
		return new ResponseEntity<>(MediaAuthorDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllMediaAuthors", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSMediaAuthorDetailDTO>> getAllLMSMediaAuthorDetails() {
		ArrayList<LMSMediaAuthorDetailDTO> MediaAuthorDTOs = mediaAuthorDetailServ.getAllLMSMediaAuthorDetails();
		return new ResponseEntity<>(MediaAuthorDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectMedia", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSMediaAuthorDetailDTO>> getSelectLMSMediaDetails(
			@RequestBody ArrayList<Long> mediaSeqNos) {
		ArrayList<LMSMediaAuthorDetailDTO> MediaAuthorDTOs = mediaAuthorDetailServ
				.getSelectLMSMedia(mediaSeqNos);
		return new ResponseEntity<>(MediaAuthorDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getById", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSMediaAuthorDetailDTO> getLMSMediaAuthorDetailById(@RequestBody LMSMediaAuthorDetailDTO mediaAuthorDTO) {
		LMSMediaAuthorDetailDTO MediaAuthorAccNoDTOs = mediaAuthorDetailServ.getLMSMediaAuthorDetailById(mediaAuthorDTO);
		return new ResponseEntity<>(MediaAuthorAccNoDTOs, HttpStatus.OK);
	}

	@PutMapping("/updMediaAuthor")
	public void updateMediaAuthor(@RequestBody LMSMediaAuthorDetailDTO MediaAuthorDTO) {
		mediaAuthorDetailServ.updLMSMediaAuthorDetail(MediaAuthorDTO);
		return;
	}

	@DeleteMapping("/delMediaAuthor")
	public void deleteMediaAuthor(@RequestBody LMSMediaAuthorDetailDTO MediaAuthorDTO) 
	{
		mediaAuthorDetailServ.delLMSMediaAuthorDetail(MediaAuthorDTO);
	}

	@DeleteMapping("/delSelectMediaAuthors")
	public void deleteSelectMediaAuthors(@RequestBody ArrayList<Long> mediaAuthorSeqNoList) {
		mediaAuthorDetailServ.getSelectLMSMediaByAuthors(mediaAuthorSeqNoList);
		return;
	}

	@DeleteMapping("/delAllMediaAuthor")
	public void deleteAllMediaAuthors() {
		mediaAuthorDetailServ.delAllLMSMediaAuthorDetails();		
		return;
	}
}