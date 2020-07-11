package com.powerschool.util;

import java.util.HashSet;

import com.powerschool.model.TrieNode;

public class Trie {
	private TrieNode root = new TrieNode();

	public void insert(String word) {
		TrieNode current = root;
		for (char k : word.toCharArray()) {
			current = current.getChildren().computeIfAbsent(k, c -> new TrieNode());
		}
		current.setEndOfWord(true);
	}
	
	public void insertSet(HashSet<String> valueSet) {
		for(String word:valueSet) {
		TrieNode current = root;
		for (char k : word.toCharArray()) {
			current = current.getChildren().computeIfAbsent(k, c -> new TrieNode());
		}
		current.setEndOfWord(true);
	}
	}
	public boolean find(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode node = current.getChildren().get(word.charAt(i));
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.isEndOfWord();
	}

	public TrieNode findNode(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode node = current.getChildren().get(word.charAt(i));
			if (node == null) {
				return null;
			}
			current = node;
		}
		return current;
	}

	public HashSet<String> getSuggestions(String word) {
		HashSet<String> suggestions = new HashSet<String>();
		TrieNode node = findNode(word);
		if (node != null) {
			getsubtree(node, suggestions, "",word);
			//suggestions.forEach(o -> o = word.concat(o));
			return suggestions;
		}
		return null;

	}

	private void getsubtree(TrieNode node, HashSet<String> suggestions, String suggestion, String word) {

		if (node != null && node.getChildren().size() > 0) {
			for (Character ch : node.getChildren().keySet()) {
				String temp = suggestion.concat(ch.toString());
				TrieNode tempnode = node.getChildren().get(ch);
				if (tempnode.isEndOfWord()) {
					suggestions.add(word+temp);
				}
				getsubtree(tempnode, suggestions, temp,word);
			}
		} else {
			suggestions.add(word+suggestion);
		}
	}
}
