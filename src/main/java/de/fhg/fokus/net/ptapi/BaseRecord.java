package de.fhg.fokus.net.ptapi;

import java.io.Serializable;

/**
 * 
 * Base record. Every class defined in pt-api should implement this interface.
 * 
 * @author FhG-FOKUS NETwork Research
 * 
 */

public interface BaseRecord extends Serializable {
	/**
	 * @return comma separated representation
	 */
	public String csvData();

	/**
	 * @return description of csv fields
	 */
	public String csvFields();

	/**
	 * Milliseconds since 0000 UTC Jan 1st 1970 data was observation.
	 * 
	 * @return observation time in milliseconds
	 */
	public long getObservationTimeMilliseconds();

}
