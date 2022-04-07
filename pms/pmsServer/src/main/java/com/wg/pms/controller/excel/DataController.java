package com.wg.pms.controller.excel;

import com.wg.pms.common.CommonResult;
import com.wg.pms.common.ResponseResult;
import com.wg.pms.entity.*;
import com.wg.pms.service.*;
import com.wg.pms.util.POIUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Api(tags = "数据处理")
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    NationService nationService;
    @Autowired
    PoliticsStatusService politicsStatusService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    PositionService positionService;
    @Autowired
    JobLevelService jobLevelService;
    @ApiOperation("导出为Excel")
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData(){
        List<Employee> allEmp = employeeService.getAllEmp(0, 0, null);
        return POIUtils.employee2Excel(allEmp);
    }

    @ApiOperation("上传")
    @PostMapping("/upload")
    public CommonResult upload(MultipartFile file) throws IOException {
        List<Employee> employeeList = POIUtils.excel2Employee(file, nationService.getAllNations(),
                politicsStatusService.getAllPoliticsStatus(),
                departmentService.getAllDepartments(),
                positionService.getAllPositions(),
                jobLevelService.getAllJobLevels());
        Integer integer = employeeService.addEmps(employeeList);
        if (integer>0){
            return CommonResult.success(ResponseResult.UPLOAD_SUCCESS);
        }else {
            return CommonResult.success(ResponseResult.UPLOAD_FAILED);
        }
    }

    @ApiOperation("获取民族信息")
    @GetMapping("/nations")
    public CommonResult<List<Nation> > getAllNations() {
        List<Nation> nationList = nationService.getAllNations();
        if (nationList.size()>0){
            return CommonResult.success(nationList);
        }
        return CommonResult.failed(nationList);
    }

    @ApiOperation("获取民族信息")
    @GetMapping("/politicsStatus")
    public CommonResult<List<Politicsstatus>> getAllPoliticsStatus() {
        List<Politicsstatus> politicsStatusList  = politicsStatusService.getAllPoliticsStatus();
        if (politicsStatusList.size()>0){
            return CommonResult.success(politicsStatusList);
        }
        return CommonResult.failed(politicsStatusList);
    }

    @ApiOperation("获取部门信息")
    @GetMapping("/department")
    public CommonResult<List<Department>> getAllDepartments() {
        List<Department> departmentList  = departmentService.getAllDepartments();
        if (departmentList.size()>0){
            return CommonResult.success(departmentList);
        }
        return CommonResult.failed(departmentList);
    }
    @ApiOperation("获取部门信息")
    @GetMapping("/position")
    public CommonResult<List<Position>>  getAllPositions() {
        List<Position> positionsList  = positionService.getAllPositions();
        if (positionsList.size()>0){
            return CommonResult.success(positionsList);
        }
        return CommonResult.failed(positionsList);
    }

    @ApiOperation("获取职业级别信息")
    @GetMapping("/jobLevel")
    public CommonResult<List<Joblevel>> getAllJobLevels(){
        List<Joblevel> jobLevelList  = jobLevelService.getAllJobLevels();
        if (jobLevelList.size()>0){
            return CommonResult.success(jobLevelList);
        }
        return CommonResult.failed(jobLevelList);
    }

}
