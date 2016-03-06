package org.millr.slick.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;

/**
 * The Class FormatDate.
 * Inject a Java date and format it based on a front-end supplied SimpleDateFormat.
 */
@Model(adaptables=SlingHttpServletRequest.class)
public class FormatDate {
	
	/** The date format. */
	@Inject
	private String dateFormat;
	
	/** The date. */
	@Inject
	private Calendar date;
	
	/** The formatted value. */
	public String formattedValue;
	
	/**
	 * Inits the.
	 */
	@PostConstruct
	protected void init() {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		// TODO: Pull timezone from OSGI config.
		formatter.setTimeZone(TimeZone.getTimeZone("America/Denver"));
	    formattedValue = formatter.format(date.getTime());
	}
}