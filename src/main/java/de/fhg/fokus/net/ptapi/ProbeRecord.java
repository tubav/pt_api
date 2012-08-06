package de.fhg.fokus.net.ptapi;


/**
 * Data exported from probes must implement this interface. 
 * 
 * @author FhG-FOKUS NETwork Research
 *
 */
public interface ProbeRecord extends BaseRecord {
	/**
	 * @return observation domain id.
	 */
	public long getOid();
	/**
	 * @param oid
	 */
	public void setOid( long oid);
	/**
	 * Time in seconds since 0000 UTC Jan 1st 1970, at which the 
	 * IPFIX Message Header leaves the Exporter.
	 * 
	 * @return export time 
	 */
	public long getExportTime();
	/**
	 * 
	 * @param exportTime
	 */
	public void setExportTime( long exportTime );
	/**
	 * Milliseconds since 0000 UTC Jan 1st 1970 data was observation.
	 * 
	 * @return observation time in milliseconds
	 */
	public void setObservationTimeMilliseconds( long observationTimeMilliseconds );
}
