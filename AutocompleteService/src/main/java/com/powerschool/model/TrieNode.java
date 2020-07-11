package com.powerschool.model;

import java.util.HashMap;

public class TrieNode {
private HashMap<Character,TrieNode> children=new HashMap<Character,TrieNode>();
private boolean isEndOfWord;
public HashMap<Character, TrieNode> getChildren() {
	return children;
}
public void setChildren(HashMap<Character, TrieNode> children) {
	this.children = children;
}

public boolean isEndOfWord() {
	return isEndOfWord;
}
public void setEndOfWord(boolean isEndOfWord) {
	this.isEndOfWord = isEndOfWord;
}

}
