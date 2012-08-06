package de.fhg.fokus.net.ptapi;

import java.io.Serializable;

import java.net.Inet4Address;

public final class PtBearerInformation implements ProbeRecord {

    private static final long serialVersionUID = 1L;
    
    private long oid; 
    private long exportTime;
    
    public long observationTimeMilliseconds;
    public short ruleFlag;
    public long ruleId;
    public String apn;   
    public String ruleName; 
    public String imsi;
    
    public long qci;
    public long maxDl;
    public long maxUl;
    public long guaDl;
    public long guaUl;
    public long apnDl;
    public long apnUl;
    
    public Inet4Address srcIp;
    public int srcPort;
    public Inet4Address dstIp;
    public int dstPort;

    public PtBearerInformation() {
    }
    
    public PtBearerInformation(long oid, long observationTimeMilliseconds,
            short ruleFlag, long ruleId, String apn, String ruleName, 
            String imsi, long qci, long maxDl, long maxUl, long guaDl,
            long guaUl, long apnDl, long apnUl, Inet4Address srcIp,
            int srcPort, Inet4Address dstIp, int dstPort) {
        
        super();
        this.oid = oid;
        this.observationTimeMilliseconds = observationTimeMilliseconds;
        this.ruleFlag = ruleFlag;
        this.ruleId = ruleId;
        this.apn = apn;
        this.ruleName = ruleName;
        this.imsi = imsi;
        this.qci = qci;
        this.maxDl = maxDl;
        this.maxUl = maxUl;
        this.guaDl = guaDl;
        this.guaUl = guaUl;
        this.apnDl = apnDl;
        this.apnUl = apnUl;
        this.srcIp = srcIp;
        this.srcPort = srcPort;
        this.dstIp = dstIp;
        this.dstPort = dstPort;    
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
    
    @Override
    public long getObservationTimeMilliseconds() {
        return observationTimeMilliseconds;
    }

    @Override
    public void setObservationTimeMilliseconds(long observationTimeMilliseconds) {
        this.observationTimeMilliseconds = observationTimeMilliseconds;
    }

    @Override
    public String csvData() {
        return String.format("%d, %d, %d, %d, %s, %s, %s, %d,"
                + " %d, %d, %d, %d, %d, %d %s, %d, %s, %d",
                oid,
                observationTimeMilliseconds,
                ruleFlag,
                ruleId,
                apn,
                ruleName,
                imsi,
                qci,
                maxDl,
                maxUl,
                guaDl,
                guaUl,
                apnDl,
                apnUl,
                srcIp,
                srcPort,
                dstIp,
                dstPort);
    }
    
    private static final String CSV_FIELDS = "oid, "
            + "observationTimeMilliseconds,"
            + "ruleFlag, "
            + "ruleId, "
            + "apn, "
            + "ruleName, "
            + "imsi, "
            + "qci, "
            + "maxDl, "
            + "maxUl, "
            + "guaDl, "
            + "guaUl, "
            + "apnDl, "
            + "apnUl, "
            + "srcIp,"
            + "srcPort, "
            + "dstIp, "
            + "dstPort";

    @Override
    public String csvFields() {
        return CSV_FIELDS;
    }

    @Override
    public String toString() {
        return csvData();
    }
}
