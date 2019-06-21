package com.usa.federal.gov.ssa.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.federal.gov.ssa.model.SsnMasterEntity;
import com.usa.federal.gov.ssa.model.SsnModel;
import com.usa.federal.gov.ssa.repository.StatesMasterRepository;
import com.usa.federal.gov.ssa.service.SsaService;

/**
 * 
 * @author laksh This is Controller class it controls all ssn methods
 */
@Controller
@RequestMapping("/ssn")
public class SsaController {
	/**
	 * Instantiating logger class . For using logger in controller
	 */
	static Logger logger = Logger.getLogger(SsaController.class);
	/**
	 * Instantiating StatesMasterRepository via Spring Auto wiring .
	 */
	@Autowired
	private StatesMasterRepository repository;
	/**
	 * Instantiating SsaService via Spring Auto wiring . To Use Service layer and
	 * it's method.
	 */
	@Autowired
	private SsaService ssaService;

	/**
	 * This is ssnRegiste() to show register page and binded with model object.
	 * 
	 * @param model
	 * @return
	 */

	@GetMapping("/register")
	public String ssnRegister(final Model model) {
		/**
		 * This method displays the SSN registration page .
		 */
		logger.info("An Register Page ssnRegister() started execution ......");
		try {

			model.addAttribute("ssnRegEntity", new SsnModel());
			model.addAttribute("states", repository.findAll());
		} catch (Exception e) {

			logger.error("Exception occurred in ssnRegister() method " + e.getStackTrace());
		}
		logger.info("An Register Page ssnRegister() ended execution ......");
		return "SsnRegPage";

	}

	/**
	 * This method saves the info of country citizen and gives it unique ssn Number
	 * 
	 * @param ssnModel
	 * @param file
	 * @param session
	 * @return
	 */
	@PostMapping("/save")
	public String saveSsnDetail(@ModelAttribute("ssnRegEntity") final SsnModel ssnModel,
			@RequestParam final MultipartFile file, final HttpSession session, RedirectAttributes attributes,
			Model model) {
		logger.info("An Register Page saveSsnDetail() started execution ......");
		/**
		 * Creating SsnMaster object.
		 */
		final SsnMasterEntity entity = new SsnMasterEntity();
		/**
		 * Copy ssnModel to entity .
		 */
		BeanUtils.copyProperties(ssnModel, entity);
		/**
		 * Getting root path of project by using Servlet
		 * getServletContext().getRealPath().
		 */
		final String path = session.getServletContext().getRealPath("/") + "/resources/images/";
		/**
		 * Creating file name using some rule like 4 ch first name 4 ch last name and
		 * last 4 ch before file extension .
		 */
		final String filename = entity.getFname().substring(0, 4) + entity.getLname()
				+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.') - 4,
						file.getOriginalFilename().lastIndexOf('.'))
				+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));

		try {
			/**
			 * Writing byte[] to data to file .
			 */
			final byte barr[] = file.getBytes();

			final Path path2 = Paths.get(path + "/" + filename);

			Files.write(path2, barr);

		} catch (Exception e) {
			logger.error("Exception occurred in saveSsnDetail() method " + e.getStackTrace());
		}

		/**
		 * Call setter method setCreateDate(); , setUpdateDate(); to set current date
		 * setPhotopath(); to custom file name defined above .
		 */
		entity.setCreateDate();
		entity.setUpdateDate();
		entity.setPhotopath(filename);
		/**
		 * Integer ssnId variable to send back the Newly created SSN Number of the Usa
		 * States Citizen .
		 */
		final Integer ssnId = ssaService.saveSsn(entity);
		attributes.addFlashAttribute("ssn", "Id :" + ssnId + "saved Successfully ");
		model.addAttribute("states", repository.findAll());
		logger.info("An Register Page saveSsnDetails() ended execution ......");
		return "redirect:/ssn/prgmethod";
	}

	@GetMapping("/prgmethod")
	public String prgMethod(Model model) {
		model.addAttribute("ssnRegEntity", new SsnModel());
		model.addAttribute("states", repository.findAll());
		return "SsnRegPage";

	}

	/**
	 * This method is showing all SSN
	 * 
	 * @return
	 */
	@GetMapping("/showSsn")
	public ModelAndView showSsn() {
		logger.info("showSnn() : started execution ..................");
		final ModelAndView view = new ModelAndView();
		try {
			view.addObject("data", ssaService.getAllSsn());
			view.setViewName("SsnData");
		} catch (Exception ex) {
			logger.error("Error in showSsn() method with stack trace" + ex.getStackTrace());
		}
		logger.info("showSnn() : stoped execution ..................");
		return view;
	}
}