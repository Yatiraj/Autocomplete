package com.powerschool.controller;

import java.io.IOException;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.powerschool.model.*;
import com.powerschool.service.AutocompleteService;

@CrossOrigin(origins = "*")
@RestController
public class AutocompleteController {
	@Autowired
	AutocompleteService acService;

	@PostMapping(value = "/matches") // consumes = "application/json", produces = "application/json"
	public HashSet<String> getMatches(@RequestBody Request body) throws IOException {
		if (body.input != null & !body.input.isEmpty()) {
			return acService.getMatches(body.input);
		} else {
			return null;
		}
	}
}
