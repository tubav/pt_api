package de.fhg.fokus.net.ptapi;

import java.math.BigInteger;

/**
 * Sampling
 * 
 * @author FhG-FOKUS NETwork Research
 * 
 */
public class PtInterfaceStats implements ProbeRecord {

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
     * Sampling Size (n)
     */
    public long samplingSize;
    /**
     * Packet Delta Count (N)
     */
    public BigInteger packetDeltaCount;
    /**
     * number of packets received by pcap
     */
    public long pcapStatRecv;
    /**
     * number of packets dropped by pcap
     */
    public long pcapStatDrop;
    /**
     * A short name uniquely describing an interface, e.g. "eth0". May be the
     * string "not available" on decoding failures.
     */
    public String interfaceName;
    /**
     * A generic description of the interface, e.g. "Ethernet (10.0.0.1/24)" May
     * be the string "not available" on decoding failures.
     */
    public String interfaceDescription;

    public PtInterfaceStats() {
    }

    public PtInterfaceStats(long oid, long observationTimeMilliseconds,
            long samplingSize, BigInteger packetDeltaCount, long pcapStatRecv,
            long pcapStatDrop, String interfaceName, String interfaceDescription) {
        super();
        this.oid = oid;
        this.observationTimeMilliseconds = observationTimeMilliseconds;
        this.samplingSize = samplingSize;
        this.packetDeltaCount = packetDeltaCount;
        this.pcapStatRecv = pcapStatRecv;
        this.pcapStatDrop = pcapStatDrop;
        this.interfaceName = interfaceName;
        this.interfaceDescription = interfaceDescription;
    }

    @Override
    public long getOid() {
        return oid;
    }

    @Override
    public void setOid(long oid) {
        this.oid = oid;
    }

    @Override
    public long getExportTime() {
        return exportTime;
    }

    @Override
    public void setExportTime(long exportTime) {
        this.exportTime = exportTime;
    }

    public long getSamplingSize() {
        return samplingSize;
    }

    public void setSamplingSize(long samplingSize) {
        this.samplingSize = samplingSize;
    }

    public BigInteger getPacketDeltaCount() {
        return packetDeltaCount;
    }

    public void setPacketDeltaCount(BigInteger packetDeltaCount) {
        this.packetDeltaCount = packetDeltaCount;
    }

    @Override
    public long getObservationTimeMilliseconds() {
        return observationTimeMilliseconds;
    }

    @Override
    public void setObservationTimeMilliseconds(long observationTimeMilliseconds) {
        this.observationTimeMilliseconds = observationTimeMilliseconds;
    }

    public long getPcapStatRecv() {
        return pcapStatRecv;
    }

    public void setPcapStatRecv(long pcapStatRecv) {
        this.pcapStatRecv = pcapStatRecv;
    }

    public long getPcapStatDrop() {
        return pcapStatDrop;
    }

    public void setPcapStatDrop(long pcapStatDrop) {
        this.pcapStatDrop = pcapStatDrop;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getInterfaceDescription() {
        return interfaceDescription;
    }

    public void setInterfaceDescription(String interfaceDescription) {
        this.interfaceDescription = interfaceDescription;
    }

    @Override
    public String toString() {
        return String.format("{oid: %d, observationTimeMilliseconds: %d, "
                + "samplingSize: %d, packetDeltaCount: %s, interfaceName: \"%s\", interfaceDescription: \"%s\" }",
                oid, observationTimeMilliseconds, samplingSize,
                packetDeltaCount.toString(), interfaceName,
                interfaceDescription);
    }
    private static final String CSV_FIELDS = "oid, exportTime, observationTimeMilliseconds, "
            + "samplingSize, packetDeltaCount, interfaceName, interfaceDescription";

    @Override
    public String csvFields() {
        return CSV_FIELDS;
    }

    @Override
    public String csvData() {
        String ifname = interfaceName == null ? "" : interfaceName.replaceAll(
                ",", "_");
        String ifdesc = interfaceDescription == null ? ""
                : interfaceDescription.replaceAll(",", "_");
        return String.format("%s, %d, %d, %d, %d, %s, %s, %s", "#", oid, exportTime,
                observationTimeMilliseconds, samplingSize,
                packetDeltaCount.toString(), ifname, ifdesc);
    }
}
