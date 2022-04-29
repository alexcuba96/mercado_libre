package com.examen.mercadolibre.examen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examen.mercadolibre.examen.entity.Adn;
import com.examen.mercadolibre.examen.repository.AdnRepository;
import com.examen.mercadolibre.examen.utils.AdnUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdnServiceImpl implements AdnService {

	private final AdnRepository adnRepository;

	@Override
	public List<Adn> listAllAdn() {
		return adnRepository.findAll();
	}

	@Override
	public Adn createAdn(Adn adn) {
		return adnRepository.save(adn);
	}

	@Override
	public boolean validateIsMutant(String[] adn) {
		int totalAdn = 0;

		for (int i = 0; i < adn.length; i++) {

			for (int j = 0; j < adn[i].length(); j++) {

				if (j < adn[i].length() - 3)
					totalAdn = AdnUtils.validateLandscapeControl(totalAdn, adn, i, j);

				if (i < adn.length - 3)
					totalAdn = AdnUtils.validateVerticalControl(totalAdn, adn, i, j);

				if (i < adn.length - 3 && j < adn[i].length() - 3)
					totalAdn = AdnUtils.validateDiagonalControl(totalAdn, adn, i, j);

				if (i >= 3 && j < adn[i].length() - 3)
					totalAdn = AdnUtils.validateReverseDiagonalControl(totalAdn, adn, i, j);

				if (totalAdn > 1)
					return true;

			}

		}

		return false;
	}

}
