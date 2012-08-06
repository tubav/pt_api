package de.fhg.fokus.net.ptapi;

import java.net.Inet4Address;

/**
 *
 * @author FhG-FOKUS NETwork Research
 */
public final class PtProbeLocation implements ProbeRecord{
        private static final long serialVersionUID = 1L;
	/**
	 * Observation Domain Id. Note that if you are using ipfix4java as transport
	 * you'll currently need to get this value from the ipfix message;
	 */
	public long oid;

	public long exportTime;

	/**
	 * The time the record was created. Its encoded according to
	 * dateTimeMilliseconds(RFC5101). The data type dateTimeMilliseconds
	 * represents a time value in units of milliseconds normalized to the GMT
	 * timezone. It contains the number of milliseconds since 0000 UTC Jan 1,
	 * 1970.
	 */
	public long observationTimeMilliseconds;

        /**
	 * The Ipv4 source address received from the probe
	 */
        public Inet4Address sourceIpv4Address;

        /**
	 * The latitude received from the probe
	 */
	public String latitude;

	/**
	 * The longitude received from the probe
	 */
	public String longitude;

        /**
	 * The name received from the probe
	 */
	public String probeName;
	/**
	 * The location name received from the probe
	 */
	public String probeLocationName;

        public PtProbeLocation() {
	}

        public PtProbeLocation(long oid, long observationTimeMilliseconds,
                Inet4Address sourceIpv4Address,String latitude, String longitude,
                String probeName, String probeLocationName) {
		super();
		this.oid = oid;
		this.observationTimeMilliseconds = observationTimeMilliseconds;
                this.sourceIpv4Address = sourceIpv4Address;
		this.latitude = latitude;
                this.longitude = longitude;
                this.probeName = probeName;
                this.probeLocationName = probeLocationName;
	}

        @Override
	public long getOid() {
		return oid;
	}

        @Override
	public void setOid(long oid) {
		this.oid = oid;
	}

        public Inet4Address getSourceIpv4Address(){
                return sourceIpv4Address;
        }

        public void setSourceIpv4Address(Inet4Address sourceIpv4Address){
                this.sourceIpv4Address = sourceIpv4Address;
        }

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
        
        public String getProbeName() {
		return probeName;
	}

	public void setProbeName(String probeName) {
		this.probeName = probeName;
	}

	public String getProbeLocationName() {
		return probeLocationName;
	}

	public void setProbeLocationName(String probeLocationName) {
		this.probeLocationName = probeLocationName;
	}

        @Override
	public long getObservationTimeMilliseconds() {
		return observationTimeMilliseconds;
	}

        @Override
	public void setObservationTimeMilliseconds(
			long observationTimeMilliseconds) {
		this.observationTimeMilliseconds = observationTimeMilliseconds;
	}

        @Override
	public String toString() {
		return String.format("{oid: %d, observationTimeMilliseconds: %d, "
				+ "latitude: %s, longitude: %s }", oid,
				observationTimeMilliseconds,
				latitude,longitude
		);
	}

        @Override
	public long getExportTime() {
		return exportTime;
	}

        @Override
	public void setExportTime(long exportTime) {
		this.exportTime = exportTime;
	}

        private static final String CSV_FIELDS = "oid, exportTime, observationTimeMilliseconds, "
			+ "latitude, longitude";

	@Override
	public String csvFields() {
		return CSV_FIELDS;
	}

	@Override
	public String csvData() {
		return String.format("%d, %d, %d, %s, %s", oid, exportTime,
				observationTimeMilliseconds, latitude, longitude);
	}
        
}
