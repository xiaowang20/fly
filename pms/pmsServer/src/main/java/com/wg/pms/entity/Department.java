package com.wg.pms.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
public class Department implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "部门名称")
    private String name;

    private Integer parentid;

    private String deppath;

    private Boolean enabled;

    private Boolean isparent;
    //下属部门
    private List<Department> children = new ArrayList<>();


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private static final long serialVersionUID = 1L;


}