package com.wg.pms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Employeeec implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "员工编号")
    private Integer eid;

    @ApiModelProperty(value = "奖罚日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ecdate;

    @ApiModelProperty(value = "奖罚原因")
    private String ecreason;

    @ApiModelProperty(value = "奖罚分")
    private Integer ecpoint;

    @ApiModelProperty(value = "奖罚类别，0：奖，1：罚")
    private Integer ectype;

    @ApiModelProperty(value = "备注")
    private String remark;

    private Employee employee;

    @Override
    public String toString() {
        return "Employeeec{" +
                "id=" + id +
                ", eid=" + eid +
                ", ecdate=" + ecdate +
                ", ecreason='" + ecreason + '\'' +
                ", ecpoint=" + ecpoint +
                ", ectype=" + ectype +
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

    public Date getEcdate() {
        return ecdate;
    }

    public void setEcdate(Date ecdate) {
        this.ecdate = ecdate;
    }

    public String getEcreason() {
        return ecreason;
    }

    public void setEcreason(String ecreason) {
        this.ecreason = ecreason;
    }

    public Integer getEcpoint() {
        return ecpoint;
    }

    public void setEcpoint(Integer ecpoint) {
        this.ecpoint = ecpoint;
    }

    public Integer getEctype() {
        return ectype;
    }

    public void setEctype(Integer ectype) {
        this.ectype = ectype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}