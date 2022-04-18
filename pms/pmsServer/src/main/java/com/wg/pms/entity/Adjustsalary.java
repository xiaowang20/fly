package com.wg.pms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Adjustsalary implements Serializable {
    private Integer id;

    private Integer eid;

    @ApiModelProperty(value = "调薪日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date asdate;

    @ApiModelProperty(value = "调前薪资")
    private Integer beforesalary;

    @ApiModelProperty(value = "调后薪资")
    private Integer aftersalary;

    @ApiModelProperty(value = "调薪原因")
    private String reason;

    @ApiModelProperty(value = "备注")
    private String remark;
    private Employee employee;

    @Override
    public String toString() {
        return "Adjustsalary{" +
                "id=" + id +
                ", eid=" + eid +
                ", asdate=" + asdate +
                ", beforesalary=" + beforesalary +
                ", aftersalary=" + aftersalary +
                ", reason='" + reason + '\'' +
                ", remark='" + remark + '\'' +
                ", employee=" + employee +
                '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getAsdate() {
        return asdate;
    }

    public void setAsdate(Date asdate) {
        this.asdate = asdate;
    }

    public Integer getBeforesalary() {
        return beforesalary;
    }

    public void setBeforesalary(Integer beforesalary) {
        this.beforesalary = beforesalary;
    }

    public Integer getAftersalary() {
        return aftersalary;
    }

    public void setAftersalary(Integer aftersalary) {
        this.aftersalary = aftersalary;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}