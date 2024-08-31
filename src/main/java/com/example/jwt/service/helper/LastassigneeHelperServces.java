package com.example.jwt.service.helper;

import com.example.jwt.repository.EmpDepartmentListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
@Service
public class LastassigneeHelperServces {
    @Autowired
    EmpDepartmentListRepository empDepartmentListRepository;

    public List<Map<String, Object>> getAssigneeList(int departmentId, int internalRoleId)  throws IOException {

            return empDepartmentListRepository.getAssigneeList(departmentId,internalRoleId);

    }

}
