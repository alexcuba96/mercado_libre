package com.examen.mercadolibre.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.mercadolibre.examen.entity.Adn;
import com.examen.mercadolibre.examen.service.AdnService;
import com.examen.mercadolibre.examen.utils.AdnUtils;

@RestController
@RequestMapping(value = "/mutant/")
public class AdnController {

	@Autowired
	private AdnService adnService;

	@PostMapping
	public ResponseEntity<String> validateIsMutant(@RequestBody Adn adn) {

		try {

			if (AdnUtils.isValidAdn(adn.getAdn()))

				return adnService.validateIsMutant(adn.getAdn()) ? isMutant(adn) : isNotMutant(adn);
			else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		} catch (RuntimeException e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	protected ResponseEntity<String> isMutant(Adn adn) {
		adn.setMutant(true);
		adnService.createAdn(adn);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	protected ResponseEntity<String> isNotMutant(Adn adn) {
		adn.setMutant(false);
		adnService.createAdn(adn);
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@GetMapping
	public ResponseEntity<List<Adn>> listAdn() {
		List<Adn> adn = adnService.listAllAdn();
		if (adn.isEmpty())
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(adn);
	}

}
