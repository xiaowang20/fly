package com.wg.pms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Employeeremove implements Serializable {
    private Integer id;

    private Integer eid;

    @ApiModelProperty(value = "调动后部门")
    private Integer afterdepid;

    @ApiModelProperty(value = "调动后职位")
    private Integer afterjobid;

    @ApiModelProperty(value = "调动日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date removedate;

    @ApiModelProperty(value = "调动原因")
    private String reason;

    private String remark;
    private Employee employee;
    private Department department;
    private Joblevel joblevel;

    @Override
    public String toString() {
        return "Employeeremove{" +
                "id=" + id +
                ", eid=" + eid +
                ", afterdepid=" + afterdepid +
                ", afterjobid=" + afterjobid +
                ", removedate=" + removedate +
                ", reason='" + reason + '\'' +
                ", remark='" + remark + '\'' +
                ", employee=" + employee +
                ", department=" + department +
                ", joblevel=" + joblevel +
                '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Joblevel getJoblevel() {
        return joblevel;
    }

    public void setJoblevel(Joblevel joblevel) {
        this.joblevel = joblevel;
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

    public Integer getAfterdepid() {
        return afterdepid;
    }

    public void setAfterdepid(Integer afterdepid) {
        this.afterdepid = afterdepid;
    }

    public Integer getAfterjobid() {
        return afterjobid;
    }

    public void setAfterjobid(Integer afterjobid) {
        this.afterjobid = afterjobid;
    }

    public Date getRemovedate() {
        return removedate;
    }

    public void setRemovedate(Date removedate) {
        this.removedate = removedate;
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