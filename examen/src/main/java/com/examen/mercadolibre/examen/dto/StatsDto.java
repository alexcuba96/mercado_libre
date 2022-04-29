package com.examen.mercadolibre.examen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatsDto {

	private int count_mutant_dna;
	private int count_human_dna;
	private double ratio;
}
