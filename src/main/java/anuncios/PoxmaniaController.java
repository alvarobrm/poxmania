package anuncios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PoxmaniaController {
	
	private static final String FILES_FOLDER = "files";
	
	@Autowired
	private User user;
	
	@Autowired
	private CustomerRepository repository; 
	
	Product p1= new Product ("Lavadora AEG", "/img/lavadoraAEG.jpg", "Lavadora de ultima generacion", 799.85);
	Product p2= new Product ("Aspirador AEG", "/img/aspirador_2.jpg", "aspirador de ultima generacion", 499.85);
	
	@RequestMapping("/")
	public ModelAndView inicio(){
		repository.save(p1);
		repository.save(p2);
		return new ModelAndView("index").addObject("products", repository.findAll());
	}

	
	@RequestMapping("/add") 
	public ModelAndView addToCart(@RequestParam long idproduct) {
		Product product= repository.findOne(idproduct);
		user.addToCart(p1);
		int numProd= user.CartSize();
		return new ModelAndView("index").addObject("products", repository.findAll()).addObject("numProd", numProd);
	}
	
	@RequestMapping("/productos") 
	public ModelAndView iteration(@RequestParam long idproduct) {
		Product product= repository.findOne(idproduct);
		return new ModelAndView("productos")
		    .addObject("product", product);
	}
}