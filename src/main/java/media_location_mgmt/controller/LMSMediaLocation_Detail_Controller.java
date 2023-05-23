package media_location_mgmt.controller;

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

import media_location_mgmt.model.dto.LMSMediaLocationDetailDTO;
import media_location_mgmt.services.I_LMSMediaLocationDetailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/mediaLocationManagement")
public class LMSMediaLocation_Detail_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSMediaLocationDetail_Controller.class);

	@Autowired
	private I_LMSMediaLocationDetailService mediaLocationDetailServ;

	@PostMapping("/new")
	public ResponseEntity<LMSMediaLocationDetailDTO> newMediaLocation(@RequestBody LMSMediaLocationDetailDTO MediaLocationDTO) {
		LMSMediaLocationDetailDTO MediaLocationDTO2 = mediaLocationDetailServ.newLMSMediaLocationDetail(MediaLocationDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(MediaLocationDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectMediaByLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSMediaLocationDetailDTO>> getSelectLMSMediaLocations(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<LMSMediaLocationDetailDTO> MediaLocationDTOs = mediaLocationDetailServ.getSelectLMSMediaByLocations(ids);
		return new ResponseEntity<>(MediaLocationDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllMediaLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSMediaLocationDetailDTO>> getAllLMSMediaLocationDetails() {
		ArrayList<LMSMediaLocationDetailDTO> MediaLocationDTOs = mediaLocationDetailServ.getAllLMSMediaLocationDetails();
		return new ResponseEntity<>(MediaLocationDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectMedia", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSMediaLocationDetailDTO>> getSelectLMSMediaDetails(
			@RequestBody ArrayList<Long> mediaSeqNos) {
		ArrayList<LMSMediaLocationDetailDTO> MediaLocationDTOs = mediaLocationDetailServ
				.getSelectLMSMedia(mediaSeqNos);
		return new ResponseEntity<>(MediaLocationDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getById", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSMediaLocationDetailDTO> getLMSMediaLocationDetailById(@RequestBody LMSMediaLocationDetailDTO mediaLocationDTO) {
		LMSMediaLocationDetailDTO MediaLocationAccNoDTOs = mediaLocationDetailServ.getLMSMediaLocationDetailById(mediaLocationDTO);
		return new ResponseEntity<>(MediaLocationAccNoDTOs, HttpStatus.OK);
	}

	@PutMapping("/updMediaLocation")
	public void updateMediaLocation(@RequestBody LMSMediaLocationDetailDTO MediaLocationDTO) {
		mediaLocationDetailServ.updLMSMediaLocationDetail(MediaLocationDTO);
		return;
	}

	@DeleteMapping("/delMediaLocation")
	public void deleteMediaLocation(@RequestBody LMSMediaLocationDetailDTO MediaLocationDTO) 
	{
		mediaLocationDetailServ.delLMSMediaLocationDetail(MediaLocationDTO);
	}

	@DeleteMapping("/delSelectMediaLocations")
	public void deleteSelectMediaLocations(@RequestBody ArrayList<Long> mediaLocationSeqNoList) {
		mediaLocationDetailServ.getSelectLMSMediaByLocations(mediaLocationSeqNoList);
		return;
	}

	@DeleteMapping("/delAllMediaLocation")
	public void deleteAllMediaLocations() {
		mediaLocationDetailServ.delAllLMSMediaLocationDetails();		
		return;
	}
}