package com.examen.mercadolibre.examen.service;

import java.util.List;

import com.examen.mercadolibre.examen.entity.Adn;

public interface AdnService {
	public List<Adn> listAllAdn();
	public Adn createAdn(Adn adn);
	public boolean validateIsMutant(String[] adn);
}
