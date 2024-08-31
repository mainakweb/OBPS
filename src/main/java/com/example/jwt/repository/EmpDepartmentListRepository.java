package com.example.jwt.repository;

import com.example.jwt.model.EmpDepartmentList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface EmpDepartmentListRepository  extends JpaRepository<EmpDepartmentList, Integer> {

    String getAssigneeListQuery = "SELECT t1.emp_id, t2.cname as name FROM emp_department_list AS t1"+
            " LEFT JOIN"+
            " pa0002 AS t2"+
            " ON"+
            " t1.emp_id= t2.pernr  :: character varying WHERE"+
            " t1.dept_id = ?1 AND t1.internal_role_id = ?2";

    @Query(value = getAssigneeListQuery, nativeQuery = true)
    List<Map<String, Object>> getAssigneeList(int departmentId, int internalRoleId);


}
