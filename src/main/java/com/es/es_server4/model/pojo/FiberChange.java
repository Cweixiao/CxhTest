package com.es.es_server4.model.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class FiberChange {
    private String objId;

    private String name;

    private String fullName;

    private String abbrName;

    private String fiberType;

    private String fiberTypeDesc;

    private BigDecimal lineNumber;

    private BigDecimal stationNumber;

    private String sn;

    private String aRestype;

    private String aRestypeName;

    private String aResobjid;

    private String aResName;

    private String zRestype;

    private String zRestypeName;

    private String zResobjid;

    private String zResName;

    private String producerId;

    private String producerName;

    private String isInstation;

    private String isInstationDesc;

    private Double length;

    private Date begTime;

    private Date retTime;

    private String ismaintenance;

    private String dspLevel;

    private String dspLevelName;

    private String parZone;

    private String parZoneName;

    private String maintenanceDept;

    private String maintenanceDeptName;

    private String propertyDept;

    private String propertyDeptName;

    private String authorityUnit;

    private String authorityUnitName;

    private String topoDisplay;

    private String sourceObjId;

    private String remark;

    public FiberChange(String objId, String name, String fullName, String abbrName, String fiberType, String fiberTypeDesc, BigDecimal lineNumber, BigDecimal stationNumber, String sn, String aRestype, String aRestypeName, String aResobjid, String aResName, String zRestype, String zRestypeName, String zResobjid, String zResName, String producerId, String producerName, String isInstation, String isInstationDesc, Double length, Date begTime, Date retTime, String ismaintenance, String dspLevel, String dspLevelName, String parZone, String parZoneName, String maintenanceDept, String maintenanceDeptName, String propertyDept, String propertyDeptName, String authorityUnit, String authorityUnitName, String topoDisplay, String sourceObjId, String remark) {
        this.objId = objId;
        this.name = name;
        this.fullName = fullName;
        this.abbrName = abbrName;
        this.fiberType = fiberType;
        this.fiberTypeDesc = fiberTypeDesc;
        this.lineNumber = lineNumber;
        this.stationNumber = stationNumber;
        this.sn = sn;
        this.aRestype = aRestype;
        this.aRestypeName = aRestypeName;
        this.aResobjid = aResobjid;
        this.aResName = aResName;
        this.zRestype = zRestype;
        this.zRestypeName = zRestypeName;
        this.zResobjid = zResobjid;
        this.zResName = zResName;
        this.producerId = producerId;
        this.producerName = producerName;
        this.isInstation = isInstation;
        this.isInstationDesc = isInstationDesc;
        this.length = length;
        this.begTime = begTime;
        this.retTime = retTime;
        this.ismaintenance = ismaintenance;
        this.dspLevel = dspLevel;
        this.dspLevelName = dspLevelName;
        this.parZone = parZone;
        this.parZoneName = parZoneName;
        this.maintenanceDept = maintenanceDept;
        this.maintenanceDeptName = maintenanceDeptName;
        this.propertyDept = propertyDept;
        this.propertyDeptName = propertyDeptName;
        this.authorityUnit = authorityUnit;
        this.authorityUnitName = authorityUnitName;
        this.topoDisplay = topoDisplay;
        this.sourceObjId = sourceObjId;
        this.remark = remark;
    }

    public String getObjId() {
        return objId;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAbbrName() {
        return abbrName;
    }

    public String getFiberType() {
        return fiberType;
    }

    public String getFiberTypeDesc() {
        return fiberTypeDesc;
    }

    public BigDecimal getLineNumber() {
        return lineNumber;
    }

    public BigDecimal getStationNumber() {
        return stationNumber;
    }

    public String getSn() {
        return sn;
    }

    public String getaRestype() {
        return aRestype;
    }

    public String getaRestypeName() {
        return aRestypeName;
    }

    public String getaResobjid() {
        return aResobjid;
    }

    public String getaResName() {
        return aResName;
    }

    public String getzRestype() {
        return zRestype;
    }

    public String getzRestypeName() {
        return zRestypeName;
    }

    public String getzResobjid() {
        return zResobjid;
    }

    public String getzResName() {
        return zResName;
    }

    public String getProducerId() {
        return producerId;
    }

    public String getProducerName() {
        return producerName;
    }

    public String getIsInstation() {
        return isInstation;
    }

    public String getIsInstationDesc() {
        return isInstationDesc;
    }

    public Double getLength() {
        return length;
    }

    public Date getBegTime() {
        return begTime;
    }

    public Date getRetTime() {
        return retTime;
    }

    public String getIsmaintenance() {
        return ismaintenance;
    }

    public String getDspLevel() {
        return dspLevel;
    }

    public String getDspLevelName() {
        return dspLevelName;
    }

    public String getParZone() {
        return parZone;
    }

    public String getParZoneName() {
        return parZoneName;
    }

    public String getMaintenanceDept() {
        return maintenanceDept;
    }

    public String getMaintenanceDeptName() {
        return maintenanceDeptName;
    }

    public String getPropertyDept() {
        return propertyDept;
    }

    public String getPropertyDeptName() {
        return propertyDeptName;
    }

    public String getAuthorityUnit() {
        return authorityUnit;
    }

    public String getAuthorityUnitName() {
        return authorityUnitName;
    }

    public String getTopoDisplay() {
        return topoDisplay;
    }

    public String getSourceObjId() {
        return sourceObjId;
    }

    public String getRemark() {
        return remark;
    }
}