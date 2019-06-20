package com.usa.federal.gov.ssa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usa.federal.gov.ssa.service.SsaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/rest")

@Api(value = "SsnNumber Validation System ", description = "Taking ssn number and validation after successful validation returns ssn id and state")
/**
 * SsnRestController , check the request is valid 
 * or not and returns the response with state name .
 * @author laksh
 *
 */
@NoArgsConstructor
public class SsnRestController {
	/**
	 * Service interface implement insatnitiation to use service layer .
	 */
	@Autowired
	private SsaService service;
	/**
	 * Response entity variable 
	 */
	private ResponseEntity<String> resEntity = null;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
/**
 * This method authenticate the ssn number is 
 * associated with any state or not and return responce on it .
 * @param ssnId
 * @return
 */
	@PostMapping("/authenticate/{ssnid}")
	public ResponseEntity<String> getClientAuthintication(@PathVariable("ssnid") final int ssnId) {
		try {
			if (!(service.getStateBySsid(ssnId).isEmpty())) {
				resEntity = new ResponseEntity<>(Integer.toString(ssnId) + service.getStateBySsid(ssnId),
						HttpStatus.OK);}
		} catch (Exception e) {
			resEntity = new ResponseEntity<>(Integer.toString(ssnId) + " is not associated anywhere ",
					HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}

}
