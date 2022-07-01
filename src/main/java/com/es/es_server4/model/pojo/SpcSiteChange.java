package com.es.es_server4.model.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class SpcSiteChange {
    private String tmsSn;

    private String objId;

    private String name;

    private String fullName;

    private String abbr;

    private String stationType;

    private String stationTypeName;

    private String voltageClass;

    private String voltageClassName;

    private String dspLevel;

    private String dspLevelName;

    private String containCommdev;

    private String containCommdevName;

    private Date begTime;

    private String time;

    private String principal;

    private String phone;

    private String addr;

    private String postcode;

    private String innerPhone;

    private String sourceObjId;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private BigDecimal longitudX;

    private BigDecimal latitudeY;

    private String parZone;

    private String zoneName;

    private String authorityUnit;

    private String authorityUnitName;

    private String maintenanceDept;

    private String maintenanceDeptName;

    private String fatherMaintenanceDeptName;

    private String propertyDept;

    private String propertyDeptName;

    public SpcSiteChange(String tmsSn, String objId, String name, String fullName, String abbr, String stationType, String stationTypeName, String voltageClass, String voltageClassName, String dspLevel, String dspLevelName, String containCommdev, String containCommdevName, Date begTime, String time, String principal, String phone, String addr, String postcode, String innerPhone, String sourceObjId, BigDecimal longitude, BigDecimal latitude, BigDecimal longitudX, BigDecimal latitudeY, String parZone, String zoneName, String authorityUnit, String authorityUnitName, String maintenanceDept, String maintenanceDeptName, String fatherMaintenanceDeptName, String propertyDept, String propertyDeptName) {
        this.tmsSn = tmsSn;
        this.objId = objId;
        this.name = name;
        this.fullName = fullName;
        this.abbr = abbr;
        this.stationType = stationType;
        this.stationTypeName = stationTypeName;
        this.voltageClass = voltageClass;
        this.voltageClassName = voltageClassName;
        this.dspLevel = dspLevel;
        this.dspLevelName = dspLevelName;
        this.containCommdev = containCommdev;
        this.containCommdevName = containCommdevName;
        this.begTime = begTime;
        this.time = time;
        this.principal = principal;
        this.phone = phone;
        this.addr = addr;
        this.postcode = postcode;
        this.innerPhone = innerPhone;
        this.sourceObjId = sourceObjId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.longitudX = longitudX;
        this.latitudeY = latitudeY;
        this.parZone = parZone;
        this.zoneName = zoneName;
        this.authorityUnit = authorityUnit;
        this.authorityUnitName = authorityUnitName;
        this.maintenanceDept = maintenanceDept;
        this.maintenanceDeptName = maintenanceDeptName;
        this.fatherMaintenanceDeptName = fatherMaintenanceDeptName;
        this.propertyDept = propertyDept;
        this.propertyDeptName = propertyDeptName;
    }

    public String getTmsSn() {
        return tmsSn;
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

    public String getAbbr() {
        return abbr;
    }

    public String getStationType() {
        return stationType;
    }

    public String getStationTypeName() {
        return stationTypeName;
    }

    public String getVoltageClass() {
        return voltageClass;
    }

    public String getVoltageClassName() {
        return voltageClassName;
    }

    public String getDspLevel() {
        return dspLevel;
    }

    public String getDspLevelName() {
        return dspLevelName;
    }

    public String getContainCommdev() {
        return containCommdev;
    }

    public String getContainCommdevName() {
        return containCommdevName;
    }

    public Date getBegTime() {
        return begTime;
    }

    public String getTime() {
        return time;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddr() {
        return addr;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getInnerPhone() {
        return innerPhone;
    }

    public String getSourceObjId() {
        return sourceObjId;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitudX() {
        return longitudX;
    }

    public BigDecimal getLatitudeY() {
        return latitudeY;
    }

    public String getParZone() {
        return parZone;
    }

    public String getZoneName() {
        return zoneName;
    }

    public String getAuthorityUnit() {
        return authorityUnit;
    }

    public String getAuthorityUnitName() {
        return authorityUnitName;
    }

    public String getMaintenanceDept() {
        return maintenanceDept;
    }

    public String getMaintenanceDeptName() {
        return maintenanceDeptName;
    }

    public String getFatherMaintenanceDeptName() {
        return fatherMaintenanceDeptName;
    }

    public String getPropertyDept() {
        return propertyDept;
    }

    public String getPropertyDeptName() {
        return propertyDeptName;
    }
}