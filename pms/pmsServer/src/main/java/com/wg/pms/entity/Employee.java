package com.wg.pms.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Employee implements Serializable {
    @ApiModelProperty(value = "员工编号")
    private Integer id;

    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String gender;

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

    @ApiModelProperty(value = "入职日期")
    private Date begindate;

    @ApiModelProperty(value = "在职状态")
    private String workstate;

    @ApiModelProperty(value = "工号")
    private String workid;

    @ApiModelProperty(value = "合同期限")
    private Double contractterm;

    @ApiModelProperty(value = "转正日期")
    private Date conversiontime;

    @ApiModelProperty(value = "离职日期")
    private Date notworkdate;

    @ApiModelProperty(value = "合同起始日期")
    private Date begincontract;

    @ApiModelProperty(value = "合同终止日期")
    private Date endcontract;

    @ApiModelProperty(value = "工龄")
    private Integer workage;

    /**
     * 引入
     */
    private List<Nation> nation;
    private List<Politicsstatus> politicsstatus;
    private List<Department> department;
    private List<Joblevel> jobLevel;
    private List<Position> position;
    private List<Salary> salary;

//        private Nation nation;
//        private Politicsstatus politicsstatus;
//        private Department department;
//        private Joblevel joblevel;
//        private Position position;

    private static final long serialVersionUID = 1L;


}