package com.yeahmobi.rundemo.guavaexample.function;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.base.Function;

public class DateFormatFunction implements Function<Date, String> {
	public String apply(Date input) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		return dateFormat.format(input);
	}
}