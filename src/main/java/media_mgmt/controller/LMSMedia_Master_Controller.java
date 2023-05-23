package media_mgmt.controller;

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
import media_mgmt.model.dto.LMSMediaMasterDTO;
import media_mgmt.services.I_LMSMediaMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/mediaManagement")
public class LMSMedia_Master_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSMediaMaster_Controller.class);

	@Autowired
	private I_LMSMediaMasterService mediaMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSMediaMasterDTO> newMedia(@RequestBody LMSMediaMasterDTO MediaDTO) {
		LMSMediaMasterDTO MediaDTO2 = mediaMasterServ.newLMSMediaMaster(MediaDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(MediaDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectMedia", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSMediaMasterDTO>> getSelectLMSMedia(@RequestBody ArrayList<Long> ids)
	{
		ArrayList<LMSMediaMasterDTO> MediaDTOs = mediaMasterServ.getSelectLMSMedia(ids);
		return new ResponseEntity<>(MediaDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectMediaByCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSMediaMasterDTO>> getSelectLMSMediaByCategories(@RequestBody ArrayList<BigDecimal> ids)
	{
		ArrayList<LMSMediaMasterDTO> MediaDTOs = mediaMasterServ.getSelectLMSMediaByCategories(ids);
		return new ResponseEntity<>(MediaDTOs, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAllMedia", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSMediaMasterDTO>> getAllLMSMediaMasters() {
		ArrayList<LMSMediaMasterDTO> MediaDTOs = mediaMasterServ.getAllLMSMediaMasters();
		return new ResponseEntity<>(MediaDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectMedia", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSMediaMasterDTO>> getSelectLMSMediaMasters(
			@RequestBody ArrayList<Long> MediaSeqNos) {
		ArrayList<LMSMediaMasterDTO> MediaDTOs = mediaMasterServ
				.getSelectLMSMedia(MediaSeqNos);
		return new ResponseEntity<>(MediaDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{mediaSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSMediaMasterDTO> getLMSMediaMasterById(
			@PathVariable Long mediaSeqNo) 
	{
		LMSMediaMasterDTO MediaAccNoDTOs = mediaMasterServ
				.getLMSMediaMasterById(mediaSeqNo);
		return new ResponseEntity<>(MediaAccNoDTOs, HttpStatus.OK);
	}

	@PutMapping("/updMedia")
	public void updateMedia(@RequestBody LMSMediaMasterDTO MediaDTO) {
		mediaMasterServ.updLMSMediaMaster(MediaDTO);
		return;
	}

	@DeleteMapping("/delMedia{mediaSeqNo}")
	public void deleteMedia(@PathVariable Long mediaSeqNo)
	{
		mediaMasterServ.delLMSMedia(mediaSeqNo);
	}

	@DeleteMapping("/delSelectMedia")
	public void deleteSelectMedia(@RequestBody ArrayList<Long> mediaSeqNoList) {
		mediaMasterServ.delSelectLMSMedia(mediaSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectMediaByCategories")
	public void deleteSelectMediaByCategories(@RequestBody ArrayList<BigDecimal> mediaCatSeqNoList) {
		mediaMasterServ.delSelectLMSMediaByCategories(mediaCatSeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllMedia")
	public void deleteAllMedia() {
		mediaMasterServ.delAllLMSMediaMasters();
		;
		return;
	}
}