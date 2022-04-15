package com.wg.pms.controller.employee;

import com.wg.pms.service.EmployeeEcService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "员工奖罚")
@RestController
@RequestMapping("Ec")
public class EmployeeEcController {
    @Autowired
    EmployeeEcService employeeEcService;

}
