package haagahelia.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class BookController {
    

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String bookForm(Model model) {
	
	//Book book = new Book("Kirja", "Janne", 12, "isbn", 23);
	

	model.addAttribute("message", "Hello");

        return "index";
    }

    @RequestMapping(value="/index", method=RequestMethod.POST)
    public String bookSubmit(Model model) {

        return "index";
    }
    
}