package content_mgmt.content_structure_mgmt.controller;

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

import content_mgmt.content_structure_mgmt.model.dto.LMSContentStructureDetailDTO;
import content_mgmt.content_structure_mgmt.services.I_LMSContentStructureDetailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/contentStructureDetailManagement")
public class LMSContentStructureDetail_Master_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSContentStructureDetail_Controller.class);

	@Autowired
	private I_LMSContentStructureDetailService contentStructureDetailServ;

	@PostMapping("/new")
	public ResponseEntity<LMSContentStructureDetailDTO> newContentStructureDetail(@RequestBody LMSContentStructureDetailDTO ContentStructureDetailDTO) 
	{
		LMSContentStructureDetailDTO ContentStructureDetailDTO2 = contentStructureDetailServ.newLMSContentStructureDetail(ContentStructureDetailDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(ContentStructureDetailDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectContentStructureDetail", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSContentStructureDetailDTO>> getSelectLMSContentStructureDetail(@RequestBody ArrayList<Long> ids)
	{
		ArrayList<LMSContentStructureDetailDTO> ContentStructureDetailDTOs = contentStructureDetailServ.getSelectLMSContentStructureDetail(ids);
		return new ResponseEntity<>(ContentStructureDetailDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllContentStructureDetail", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSContentStructureDetailDTO>> getAllLMSContentStructureDetails() {
		ArrayList<LMSContentStructureDetailDTO> ContentStructureDetailDTOs = contentStructureDetailServ.getAllLMSContentStructureDetails();
		return new ResponseEntity<>(ContentStructureDetailDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectContentStructureDetailByParents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSContentStructureDetailDTO>> getSelectLMSContentStructureDetailByParents(
			@RequestBody ArrayList<Long> ContentStructureDetailSeqNos) {
		ArrayList<LMSContentStructureDetailDTO> ContentStructureDetailDTOs = contentStructureDetailServ
				.getSelectLMSContentStructureDetailbyParents(ContentStructureDetailSeqNos);
		return new ResponseEntity<>(ContentStructureDetailDTOs, HttpStatus.OK);
	}

	
	@GetMapping(value = "/getById/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSContentStructureDetailDTO> getLMSContentStructureDetailById(
			@RequestBody LMSContentStructureDetailDTO lmsContentStructureDetailDTO) 
	{
		LMSContentStructureDetailDTO ContentStructureDetailAccNoDTOs = contentStructureDetailServ
				.getLMSContentStructureDetailById(lmsContentStructureDetailDTO);
		return new ResponseEntity<>(ContentStructureDetailAccNoDTOs, HttpStatus.OK);
	}

	@PutMapping("/updContentStructureDetail")
	public void updateContentStructureDetail(@RequestBody LMSContentStructureDetailDTO ContentStructureDetailDTO) {
		contentStructureDetailServ.updLMSContentStructureDetail(ContentStructureDetailDTO);
		return;
	}

	@DeleteMapping("/delContentStructureDetail")
	public void deleteContentStructureDetail(@RequestBody LMSContentStructureDetailDTO lmsContentStructureDetailDTO)
	{
		contentStructureDetailServ.delLMSContentStructureDetail(lmsContentStructureDetailDTO);
	}

	@DeleteMapping("/delSelectContentStructureDetail")
	public void deleteSelectContentStructureDetail(@RequestBody ArrayList<Long> ContentStructureDetailSeqNoList) {
		contentStructureDetailServ.getSelectLMSContentStructureDetail(ContentStructureDetailSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectContentStructureDetailByParents")
	public void deleteSelectContentStructureDetailByParents(@RequestBody ArrayList<Long> ContentStructureDetailSeqNoList) {
		contentStructureDetailServ.delSelectLMSContentStructureDetailByParents(ContentStructureDetailSeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllContentStructureDetail")
	public void deleteAllContentStructureDetail() {
		contentStructureDetailServ.delAllLMSContentStructureDetails();
		;
		return;
	}
}