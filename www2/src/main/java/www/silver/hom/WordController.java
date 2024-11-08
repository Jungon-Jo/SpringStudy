package www.silver.hom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WordController {
	
	private static final Logger logger = LoggerFactory.getLogger(WordController.class);
	
	@RequestMapping(value="mainWindow", method=RequestMethod.GET)
	public String mainWindow(Model model) {
		WordDAO wordDAO = WordDAO.getInstance();
		model.addAttribute("wordList",wordDAO.wordList);
		return "Word/index";
	}
	
	@RequestMapping(value="wordInsert", method=RequestMethod.POST)
	public String wordInsert(@RequestParam String word, @RequestParam String wordMeaning, Model model) {
		WordDAO wordDAO = WordDAO.getInstance();
		wordDAO.insertWord(word, wordMeaning);

//		model.addAttribute("word", word);
//		model.addAttribute("wordMeaning", wordMeaning);
		return "Word/index";
	}
	
	@RequestMapping(value="wordList", method=RequestMethod.GET)
	public String wordList(Model model) {
		WordDAO wordDAO = WordDAO.getInstance();
		model.addAttribute("wordList",wordDAO.wordList);
		
		return "Word/index";
	}

	
	
}
