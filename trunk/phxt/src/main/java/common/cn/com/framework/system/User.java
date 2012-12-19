/*******************************************************************************
 * @(#)User.java Oct 18, 2007
 *
 * Copyright 2007 Neusoft Group Ltd. All rights reserved.
 * Neusoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package cn.com.framework.system;

public class User {

    private String id;

    private String password;

    private String status;

    private String name;

    private String email;

    private String roleId;

    private String roleName;

    private String createTime;

    private String creater;

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * @return Returns the username.
     */
    public String getUsername() {
        return name;
    }

    /**
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.name = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return Returns the roleId.
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId The roleId to set.
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return Returns the roleName.
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName The roleName to set.
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
