package com.powerschool.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

import com.powerschool.model.TrieNode;
import com.powerschool.util.FileReader;
import com.powerschool.util.Trie;

@Service
public class AutocompleteService {

	private Trie trie;

	public HashSet<String> getMatches(String body) throws IOException {
		if (trie == null) {
			trie=new Trie();
			FileReader fileReader = new FileReader();
			trie.insertSet(fileReader.read());
		}
		return trie.getSuggestions(body);
	}
}
