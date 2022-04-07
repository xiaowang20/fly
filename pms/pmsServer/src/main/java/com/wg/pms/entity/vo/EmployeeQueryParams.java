package com.wg.pms.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询参数类
 */
@Data
public class EmployeeQueryParams{
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("政治身份ID")
    private Integer politicId;
    @ApiModelProperty("民族ID")
    private Integer nationId;
    @ApiModelProperty("部门ID")
    private Integer departmentId;
    @ApiModelProperty("工作级别ID")
    private Integer jobLevelId;
    @ApiModelProperty(value = "聘用形式")
    private String engageForm;
    @ApiModelProperty("职位ID")
    private Integer positionId;
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @ApiModelProperty("入职时间")
//    private Date beginDate;

}
