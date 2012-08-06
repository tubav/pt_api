package de.fhg.fokus.net.ptapi;

import java.io.Serializable;

import java.net.Inet4Address;

/**
 * Represents a packet track. This type is used in export.
 *  
 * @author FhG-FOKUS NETwork Research
 *
 */
public class PacketTrackRecord implements Serializable, BaseRecord {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * Probe ids where the packet has been seen (oids)
     */
    public long[] oids;
    /**
     * Time stamp in milliseconds since Unix epoch
     * 
     */
    public long[] ts;
    /**
     * Time-to-live
     */
    public int[] ttl;
    /**
     * Packet Id (gotten from probe via hash-based packet selection)
     */
    public int pktid;
    /**
     * Track Id (computed by the packet matcher)
     */
    public int trackid;
    /**
     * Packet size. 
     */
    public int size;
    /**
     * IP version.
     */
    public byte ipVersion;
    /**
     * Protocol number;
     */
    public short protocolIdentifier;
    /**
     * Source address
     */
    public Inet4Address sourceAddress;
    /**
     * Source port
     */
    public int sourcePort;
    /**
     * Destination address
     */
    public Inet4Address destinationAddress;
    /**
     * Destination port
     */
    public int destinationPort;
    
    /**
     * Rule identifier
     */
    public long ruleId;

    public PacketTrackRecord(int size) {
        oids = new long[size];
        ts = new long[size];
        ttl = new int[size];
    }

    @Override
    public String csvData() {
        StringBuffer line = new StringBuffer();
        line.append(pktid).append(", ").append(trackid).append(", ")
                .append(ruleId).append(", ").append(size).append(", ")
                .append(ipVersion).append(", ").append(protocolIdentifier);

        for (int i = 0; i < oids.length; i++) {
            line.append(", (").append(oids[i]).append(", ")
                    .append(ts[i]).append(", ").append(ttl[i]).append(")");
        }
        return line.toString();
    }
    private static final String CSV_FIELDS = "pktId, trackid, ruleId, size, ipVersion, protocol, (oid1, ts1, ttl1), (oid2, ts2, ttl2), ..";

    @Override
    public String csvFields() {
        return CSV_FIELDS;
    }

    @Override
    public String toString() {
        return csvData();
    }

    /**
     * Returs the first timestamp of track 
     * 
     */
    @Override
    public long getObservationTimeMilliseconds() {
        return ts[0];
    }
}
