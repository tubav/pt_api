package de.fhg.fokus.net.ptapi;

import java.math.BigInteger;
import java.util.Locale;

/**
 * Probe statistics.
 * 
 * @author FhG-FOKUS NETwork Research
 * 
 */
public class PtProbeStats implements ProbeRecord {
	private static final long serialVersionUID = 1L;
	/**
	 * Observation Domain Id.
	 */
	public long oid;
	public long exportTime;

	/**
	 * Observation time in milliseconds. Its encoded according to
	 * dateTimeMilliseconds(RFC5101). The data type dateTimeMilliseconds
	 * represents a time value in units of milliseconds normalized to the GMT
	 * timezone. It contains the number of milliseconds since 0000 UTC Jan 1,
	 * 1970.
	 */
	public long observationTimeMilliseconds;
	/**
	 * System idle CPU, see "man mpstat" for more information.
	 */
	public float systemCpuIdle;
	/**
	 * System free memory in kilobytes, see "man pidstat" for more information.
	 */
	public BigInteger systemMemFree;
	/**
	 * percentage of CPU used in user level (application), see "man pidstat" for
	 * more information"
	 */
	public float processCpuUser;
	/**
	 * percentage of CPU used in system level (kernel), see "man pidstat" for
	 * more information"
	 */
	public float processCpuSys;
	/**
	 * the process virtual memory used in kilobytes, see "man pidstat" for more
	 * information"
	 */
	public BigInteger processMemVzs;
	/**
	 * the process resident set size in kilobytes, see "man pidstat" for more
	 * information"
	 */
	public BigInteger processMemRss;

	public PtProbeStats() {
	}

	public PtProbeStats(long oid, long observationTimeMilliseconds,
			float systemCpuIdle, BigInteger systemMemFree,
			float processCpuUser, float processCpuSys,
			BigInteger processMemVzs, BigInteger processMemRss) {
		super();
		this.oid = oid;
		this.observationTimeMilliseconds = observationTimeMilliseconds;
		this.systemCpuIdle = systemCpuIdle;
		this.systemMemFree = systemMemFree;
		this.processCpuUser = processCpuUser;
		this.processCpuSys = processCpuSys;
		this.processMemVzs = processMemVzs;
		this.processMemRss = processMemRss;
	}

	@Override
	public long getOid() {
		return oid;
	}

	@Override
	public long getExportTime() {
		return exportTime;
	}

	public void setExportTime(long exportTime) {
		this.exportTime = exportTime;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public float getSystemCpuIdle() {
		return systemCpuIdle;
	}

	public void setSystemCpuIdle(float systemCpuIdle) {
		this.systemCpuIdle = systemCpuIdle;
	}

	public BigInteger getSystemMemFree() {
		return systemMemFree;
	}

	public void setSystemMemFree(BigInteger systemMemFree) {
		this.systemMemFree = systemMemFree;
	}

	public float getProcessCpuUser() {
		return processCpuUser;
	}

	public void setProcessCpuUser(float processCpuUser) {
		this.processCpuUser = processCpuUser;
	}

	public float getProcessCpuSys() {
		return processCpuSys;
	}

	public void setProcessCpuSys(float processCpuSys) {
		this.processCpuSys = processCpuSys;
	}

	public BigInteger getProcessMemVzs() {
		return processMemVzs;
	}

	public void setProcessMemVzs(BigInteger processMemVzs) {
		this.processMemVzs = processMemVzs;
	}

	public BigInteger getProcessMemRss() {
		return processMemRss;
	}

	public void setProcessMemRss(BigInteger processMemRss) {
		this.processMemRss = processMemRss;
	}

	@Override
	public long getObservationTimeMilliseconds() {
		return observationTimeMilliseconds;
	}

	public void setObservationTimeMilliseconds(long observationTimeMilliseconds) {
		this.observationTimeMilliseconds = observationTimeMilliseconds;
	}

	@Override
	public String toString() {
		return String
				.format("{oid: %d, exportTime: %d, observationTimeMilliseconds: %d, "
						+ "systemCpuIdle: \"%f\", systemMemFree: %d, "
						+ "processCpuUser: \"%f\", processCpuSys: \"%f\", processMemVzs: %d, "
						+ "processMemRss: %d}", oid, exportTime,
						observationTimeMilliseconds, systemCpuIdle,
						systemMemFree, processCpuUser, processCpuSys,
						processMemVzs, processMemRss);
	}

	private static final String CSV_FIELDS = "oid, exportTime, observationTimeMilliseconds, systemCpuIdle, "
			+ "systemMemFree, processCpuUser, processCpuSys, processMemVzs, processMemRss";

	@Override
	public String csvData() {
		return String.format(Locale.ENGLISH,
				"%d, %d, %d, %f, %d, %f, %f, %d, %d", oid, exportTime,
				observationTimeMilliseconds, systemCpuIdle, systemMemFree,
				processCpuUser, processCpuSys, processMemVzs, processMemRss);

	}

	@Override
	public String csvFields() {
		return CSV_FIELDS;
	}

}
