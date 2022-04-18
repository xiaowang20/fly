package com.wg.pms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Employeetrain implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "员工编号")
    private Integer eid;

    @ApiModelProperty(value = "培训日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date traindate;

    @ApiModelProperty(value = "培训内容")
    private String traincontent;

    @ApiModelProperty(value = "备注")
    private String remark;
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public String toString() {
        return "Employeetrain{" +
                "id=" + id +
                ", eid=" + eid +
                ", traindate=" + traindate +
                ", traincontent='" + traincontent + '\'' +
                ", remark='" + remark + '\'' +
                ", employee=" + employee +
                '}';
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

    public Date getTraindate() {
        return traindate;
    }

    public void setTraindate(Date traindate) {
        this.traindate = traindate;
    }

    public String getTraincontent() {
        return traincontent;
    }

    public void setTraincontent(String traincontent) {
        this.traincontent = traincontent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}