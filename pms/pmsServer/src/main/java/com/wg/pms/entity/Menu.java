package com.wg.pms.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Menu implements Serializable {
    private Integer id;

    private String url;

    private String path;

    private String component;

    private String name;

    private String iconcls;

    private Boolean keepAlive;

    private Boolean requireauth;

    private Integer parentid;

    private Boolean enabled;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconcls;
    }

    public void setIconCls(String iconCls) {
        this.iconcls = iconCls;
    }

    public Boolean getKeepalive() {
        return keepAlive;
    }

    public void setKeepalive(Boolean keepalive) {
        this.keepAlive = keepalive;
    }

    public Boolean getRequireAuth() {
        return requireauth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireauth = requireAuth;
    }

    public Integer getParentId() {
        return parentid;
    }

    public void setParentId(Integer parentId) {
        this.parentid = parentId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconcls + '\'' +
                ", keepalive=" + keepAlive +
                ", requireAuth=" + requireauth +
                ", parentId=" + parentid +
                ", enabled=" + enabled +
                '}';
    }
}