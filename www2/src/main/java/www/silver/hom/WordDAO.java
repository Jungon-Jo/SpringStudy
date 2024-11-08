package www.silver.hom;

import java.util.ArrayList;

public class WordDAO {
	private static WordDAO wordDAO = null;
	public ArrayList<WordDTO> wordList = new ArrayList<WordDTO>();
	private WordDAO() {
	}
	public static WordDAO getInstance() {
		if(wordDAO == null) {
			wordDAO = new WordDAO();
		}
		return wordDAO;
	}
	public ArrayList<WordDTO> insertWord(String word, String wordMeaning) {
		WordDTO DTO = new WordDTO();
		DTO.setWord(word);
		DTO.setWordMeaning(wordMeaning);

		wordList.add(DTO);
		return wordList;
	}
}
