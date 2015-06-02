package com.yeahmobi.rundemo.guavaexample.function;

import com.google.common.base.Predicate;

public class PopulationPredicate implements Predicate<City> {
	public boolean apply(City input) {
		return input.getPopulation() <= 500000;
	}
}