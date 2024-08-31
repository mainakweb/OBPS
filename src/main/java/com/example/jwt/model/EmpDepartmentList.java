package com.example.jwt.model;

import jakarta.persistence.*;

@Entity
public class EmpDepartmentList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    @Column(name = "internal_role_id")
    private Integer internalRoleId;

    @Column(name = "emp_id", length = 12)
    private String empId;

    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "sub_dept_id")
    private Integer subDeptId;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getInternalRoleId() {
        return internalRoleId;
    }

    public void setInternalRoleId(Integer internalRoleId) {
        this.internalRoleId = internalRoleId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getSubDeptId() {
        return subDeptId;
    }

    public void setSubDeptId(Integer subDeptId) {
        this.subDeptId = subDeptId;
    }

}
