package com.examen.mercadolibre.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.mercadolibre.examen.dto.StatsDto;
import com.examen.mercadolibre.examen.entity.Adn;
import com.examen.mercadolibre.examen.service.AdnService;

@RestController
@RequestMapping(value = "/stats")
public class StatsController {

	@Autowired
	private AdnService adnService;

	@GetMapping
	public StatsDto listAdn() {
		List<Adn> adn = adnService.listAllAdn();

		return setStatsDto(adn);
	}

	protected StatsDto setStatsDto(List<Adn> adn) {

		int countIsMutant = (int) adn.parallelStream().filter(a -> a.isMutant() == true).count();
		int countIsHuman = (int) adn.parallelStream().filter(a -> a.isMutant() == false).count();


		double factor = greatestCommonFactor(countIsMutant, countIsHuman);

		double mutantRatio = countIsMutant / factor;
		double humanRatio = countIsHuman / factor;
		double ratio = mutantRatio / humanRatio; 
		
		return new StatsDto(countIsMutant,countIsHuman,ratio);
	}
	
	protected int greatestCommonFactor(int width, int height) {
	    return (height == 0) ? width : greatestCommonFactor(height, width % height);
	}

}
