package com.wg.pms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Employee implements Serializable {
    @ApiModelProperty(value = "员工编号")
    private Integer id;

    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "出生日期")
    private Date birthday;

    @ApiModelProperty(value = "身份证号")
    private String idcard;

    @ApiModelProperty(value = "婚姻状况")
    private String wedlock;

    @ApiModelProperty(value = "民族")
    private Integer nationid;

    @ApiModelProperty(value = "籍贯")
    private String nativeplace;

    @ApiModelProperty(value = "政治面貌")
    private Integer politicid;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "联系地址")
    private String address;

    @ApiModelProperty(value = "所属部门")
    private Integer departmentid;

    @ApiModelProperty(value = "职称ID")
    private Integer joblevelid;

    @ApiModelProperty(value = "职位ID")
    private Integer posid;

    @ApiModelProperty(value = "聘用形式")
    private String engageform;

    @ApiModelProperty(value = "最高学历")
    private String tiptopdegree;

    @ApiModelProperty(value = "所属专业")
    private String specialty;

    @ApiModelProperty(value = "毕业院校")
    private String school;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "入职日期")
    private Date begindate;

    @ApiModelProperty(value = "在职状态")
    private String workstate;

    @ApiModelProperty(value = "工号")
    private String workid;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "合同期限")
    private Double contractterm;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "转正日期")
    private Date conversiontime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "离职日期")
    private Date notworkdate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "合同起始日期")
    private Date begincontract;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "合同终止日期")
    private Date endcontract;

    @ApiModelProperty(value = "工龄")
    private Integer workage;

    /**
     * 引入
     */
//    private List<Nation> nation;
//    private List<Politicsstatus> politicsstatus;
//    private List<Department> department;
//    private List<Joblevel> jobLevel;
//    private List<Position> position;
//    private List<Salary> salary;

        private Nation nation;
        private Politicsstatus politicsstatus;
        private Department department;
        private Joblevel joblevel;
        private Position position;
        private Salary salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getWedlock() {
        return wedlock;
    }

    public void setWedlock(String wedlock) {
        this.wedlock = wedlock;
    }

    public Integer getNationid() {
        return nationid;
    }

    public void setNationid(Integer nationid) {
        this.nationid = nationid;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public Integer getPoliticid() {
        return politicid;
    }

    public void setPoliticid(Integer politicid) {
        this.politicid = politicid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getJoblevelid() {
        return joblevelid;
    }

    public void setJoblevelid(Integer joblevelid) {
        this.joblevelid = joblevelid;
    }

    public Integer getPosid() {
        return posid;
    }

    public void setPosid(Integer posid) {
        this.posid = posid;
    }

    public String getEngageform() {
        return engageform;
    }

    public void setEngageform(String engageform) {
        this.engageform = engageform;
    }

    public String getTiptopdegree() {
        return tiptopdegree;
    }

    public void setTiptopdegree(String tiptopdegree) {
        this.tiptopdegree = tiptopdegree;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public String getWorkstate() {
        return workstate;
    }

    public void setWorkstate(String workstate) {
        this.workstate = workstate;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public Double getContractterm() {
        return contractterm;
    }

    public void setContractterm(Double contractterm) {
        this.contractterm = contractterm;
    }

    public Date getConversiontime() {
        return conversiontime;
    }

    public void setConversiontime(Date conversiontime) {
        this.conversiontime = conversiontime;
    }

    public Date getNotworkdate() {
        return notworkdate;
    }

    public void setNotworkdate(Date notworkdate) {
        this.notworkdate = notworkdate;
    }

    public Date getBegincontract() {
        return begincontract;
    }

    public void setBegincontract(Date begincontract) {
        this.begincontract = begincontract;
    }

    public Date getEndcontract() {
        return endcontract;
    }

    public void setEndcontract(Date endcontract) {
        this.endcontract = endcontract;
    }

    public Integer getWorkage() {
        return workage;
    }

    public void setWorkage(Integer workage) {
        this.workage = workage;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public Politicsstatus getPoliticsstatus() {
        return politicsstatus;
    }

    public void setPoliticsstatus(Politicsstatus politicsstatus) {
        this.politicsstatus = politicsstatus;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", idcard='" + idcard + '\'' +
                ", wedlock='" + wedlock + '\'' +
                ", nationid=" + nationid +
                ", nativeplace='" + nativeplace + '\'' +
                ", politicid=" + politicid +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", departmentid=" + departmentid +
                ", joblevelid=" + joblevelid +
                ", posid=" + posid +
                ", engageform='" + engageform + '\'' +
                ", tiptopdegree='" + tiptopdegree + '\'' +
                ", specialty='" + specialty + '\'' +
                ", school='" + school + '\'' +
                ", begindate=" + begindate +
                ", workstate='" + workstate + '\'' +
                ", workid='" + workid + '\'' +
                ", contractterm=" + contractterm +
                ", conversiontime=" + conversiontime +
                ", notworkdate=" + notworkdate +
                ", begincontract=" + begincontract +
                ", endcontract=" + endcontract +
                ", workage=" + workage +
                ", nation=" + nation +
                ", politicsstatus=" + politicsstatus +
                ", department=" + department +
                ", joblevel=" + joblevel +
                ", position=" + position +
                ", salary=" + salary +
                '}';
    }

    private static final long serialVersionUID = 1L;


}