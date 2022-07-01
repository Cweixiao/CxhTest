package com.es.es_server4.model;

import java.math.BigDecimal;
import java.util.Date;

/**
    * ODF配线模块
    */
public class TEqpModule {
    /**
    * 对象ID
    */

    private String objId;

    /**
    * 配线模块名称
    */
    private String name;

    /**
    * 所在机柜
    */
    private String parRack;

    /**
    * 模块类型:1.ODF模块 2.DDF模块 3.VDF模块 4.MDF模块 5.OBD模块
    */
    private String moduleType;

    /**
    * 总行数
    */
    private BigDecimal totalRow;

    /**
    * 总列数
    */
    private BigDecimal totalCol;

    /**
    * 投运日期
    */
    private Date begTime;

    /**
    * 退运日期
    */
    private Date retTime;

    /**
    * 使用状态:1.故障 2.空闲 3.占用 4.预占
    */
    private String serviceState;

    /**
    * 维护人
    */
    private String principal;

    /**
    * 联系电话
    */
    private String telephone;

    /**
    * 全局名称
    */
    private String fullName;

    /**
    * 模块序号
    */
    private String sn;

    /**
    * 容量
    */
    private BigDecimal capacity;

    /**
    * 生产厂家
    */
    private String manufacturer;

    /**
    * 简称
    */
    private String abbr;

    /**
    * 起始U数
    */
    private BigDecimal startUNo;

    /**
    * 模块容量（U）
    */
    private BigDecimal uCapacity;

    /**
    * 机架占用
    */
    private BigDecimal rackUsed;

    /**
    * 方向
    */
    private String direction;

    /**
    * 用途
    */
    private String purpose;

    /**
    * 维护站点
    */
    private String maintenanceSite;

    /**
    * 队列样式
    */
    private String termSortType;

    /**
    * 子框编号
    */
    private String cDisplaySn;

    /**
    * 开始的容量
    */
    private BigDecimal kCapacity;

    /**
    * 起始K数
    */
    private BigDecimal startKNo;

    /**
    * 模块图形（行列）
    */
    private String uGraphType;

    /**
    * 权限管辖单位
    */
    private String authorityUnit;

    /**
    * 产权单位
    */
    private String propertyDept;

    /**
    * 源资源对象ID
    */
    private String sourceObjId;

    /**
    * 通信管理系统标识
    */
    private String tmsSn;

    /**
    * 更新人
    */
    private String updateperson;

    /**
    * 更新日期
    */
    private Date updatedate;

    /**
    * 备注
    */
    private String remark;

    /**
    * 维护单位
    */
    private String maintenanceDept;

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParRack() {
        return parRack;
    }

    public void setParRack(String parRack) {
        this.parRack = parRack;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public BigDecimal getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(BigDecimal totalRow) {
        this.totalRow = totalRow;
    }

    public BigDecimal getTotalCol() {
        return totalCol;
    }

    public void setTotalCol(BigDecimal totalCol) {
        this.totalCol = totalCol;
    }

    public Date getBegTime() {
        return begTime;
    }

    public void setBegTime(Date begTime) {
        this.begTime = begTime;
    }

    public Date getRetTime() {
        return retTime;
    }

    public void setRetTime(Date retTime) {
        this.retTime = retTime;
    }

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public BigDecimal getStartUNo() {
        return startUNo;
    }

    public void setStartUNo(BigDecimal startUNo) {
        this.startUNo = startUNo;
    }

    public BigDecimal getuCapacity() {
        return uCapacity;
    }

    public void setuCapacity(BigDecimal uCapacity) {
        this.uCapacity = uCapacity;
    }

    public BigDecimal getRackUsed() {
        return rackUsed;
    }

    public void setRackUsed(BigDecimal rackUsed) {
        this.rackUsed = rackUsed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getMaintenanceSite() {
        return maintenanceSite;
    }

    public void setMaintenanceSite(String maintenanceSite) {
        this.maintenanceSite = maintenanceSite;
    }

    public String getTermSortType() {
        return termSortType;
    }

    public void setTermSortType(String termSortType) {
        this.termSortType = termSortType;
    }

    public String getcDisplaySn() {
        return cDisplaySn;
    }

    public void setcDisplaySn(String cDisplaySn) {
        this.cDisplaySn = cDisplaySn;
    }

    public BigDecimal getkCapacity() {
        return kCapacity;
    }

    public void setkCapacity(BigDecimal kCapacity) {
        this.kCapacity = kCapacity;
    }

    public BigDecimal getStartKNo() {
        return startKNo;
    }

    public void setStartKNo(BigDecimal startKNo) {
        this.startKNo = startKNo;
    }

    public String getuGraphType() {
        return uGraphType;
    }

    public void setuGraphType(String uGraphType) {
        this.uGraphType = uGraphType;
    }

    public String getAuthorityUnit() {
        return authorityUnit;
    }

    public void setAuthorityUnit(String authorityUnit) {
        this.authorityUnit = authorityUnit;
    }

    public String getPropertyDept() {
        return propertyDept;
    }

    public void setPropertyDept(String propertyDept) {
        this.propertyDept = propertyDept;
    }

    public String getSourceObjId() {
        return sourceObjId;
    }

    public void setSourceObjId(String sourceObjId) {
        this.sourceObjId = sourceObjId;
    }

    public String getTmsSn() {
        return tmsSn;
    }

    public void setTmsSn(String tmsSn) {
        this.tmsSn = tmsSn;
    }

    public String getUpdateperson() {
        return updateperson;
    }

    public void setUpdateperson(String updateperson) {
        this.updateperson = updateperson;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMaintenanceDept() {
        return maintenanceDept;
    }

    public void setMaintenanceDept(String maintenanceDept) {
        this.maintenanceDept = maintenanceDept;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", objId=").append(objId);
        sb.append(", name=").append(name);
        sb.append(", parRack=").append(parRack);
        sb.append(", moduleType=").append(moduleType);
        sb.append(", totalRow=").append(totalRow);
        sb.append(", totalCol=").append(totalCol);
        sb.append(", begTime=").append(begTime);
        sb.append(", retTime=").append(retTime);
        sb.append(", serviceState=").append(serviceState);
        sb.append(", principal=").append(principal);
        sb.append(", telephone=").append(telephone);
        sb.append(", fullName=").append(fullName);
        sb.append(", sn=").append(sn);
        sb.append(", capacity=").append(capacity);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", abbr=").append(abbr);
        sb.append(", startUNo=").append(startUNo);
        sb.append(", uCapacity=").append(uCapacity);
        sb.append(", rackUsed=").append(rackUsed);
        sb.append(", direction=").append(direction);
        sb.append(", purpose=").append(purpose);
        sb.append(", maintenanceSite=").append(maintenanceSite);
        sb.append(", termSortType=").append(termSortType);
        sb.append(", cDisplaySn=").append(cDisplaySn);
        sb.append(", kCapacity=").append(kCapacity);
        sb.append(", startKNo=").append(startKNo);
        sb.append(", uGraphType=").append(uGraphType);
        sb.append(", authorityUnit=").append(authorityUnit);
        sb.append(", propertyDept=").append(propertyDept);
        sb.append(", sourceObjId=").append(sourceObjId);
        sb.append(", tmsSn=").append(tmsSn);
        sb.append(", updateperson=").append(updateperson);
        sb.append(", updatedate=").append(updatedate);
        sb.append(", remark=").append(remark);
        sb.append(", maintenanceDept=").append(maintenanceDept);
        sb.append("]");
        return sb.toString();
    }
}