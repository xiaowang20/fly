package com.wg.pms.controller.excel;

import com.wg.pms.common.CommonResult;
import com.wg.pms.common.ResponseResult;
import com.wg.pms.entity.*;
import com.wg.pms.entity.vo.EmployeeQueryParams;
import com.wg.pms.mapper.DepartmentMapper;
import com.wg.pms.service.*;
import com.wg.pms.util.POIUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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
    @ApiOperation("导出普通为Excel")
    @GetMapping("/export1")
    public ResponseEntity<byte[]> exportData1(@RequestParam(value = "pageNum",defaultValue = "1") Integer page,
                                                            @RequestParam(value = "pageSize",defaultValue = "10") Integer size,
                                                            @RequestParam(value = "keyword",required = false) String keyword){
        List<Employee> allEmp = employeeService.getAllEmp(page, size, keyword);
        System.out.println("数据："+allEmp);
        ResponseEntity<byte[]> responseEntity = POIUtils.employee2Excel(allEmp);
        return responseEntity;
    }
    @ApiOperation("导出高级为Excel")
    @GetMapping("/export2")
    public ResponseEntity<byte[]> exportData2(@RequestParam(value = "pageNum",defaultValue = "1") Integer page,
                                             @RequestParam(value = "pageSize",defaultValue = "10") Integer size,
                                              EmployeeQueryParams queryParams){
        List<Employee> allEmp = employeeService.list(page, size, queryParams);
        System.out.println("导出数据成功");
        ResponseEntity<byte[]> responseEntity = POIUtils.employee2Excel(allEmp);
        return responseEntity;
    }
    @ApiOperation("上传")
    @PostMapping(value = "/upload")
    public CommonResult upload(MultipartFile file) throws IOException {
        List<Employee> employeeList = POIUtils.excel2Employee(file, nationService.getAllNations(),
                politicsStatusService.getAllPoliticsStatus(),
                departmentService.selectAll(new DepartmentExample()),
                positionService.getAllPositions(),
                jobLevelService.getAllJobLevels());
        System.out.println("导入成功"+employeeList);

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

    @ApiOperation("获取政治面貌信息")
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
    @ApiOperation("获取职位信息")
    @GetMapping("/position")
    public CommonResult<List<Position>>  getAllPositions() {
        List<Position> positionsList  = positionService.getAllPositions();
        if (positionsList.size()>0){
            return CommonResult.success(positionsList);
        }
        return CommonResult.failed(positionsList);
    }

    @ApiOperation("获取职称信息")
    @GetMapping("/jobLevel")
    public CommonResult<List<Joblevel>> getAllJobLevels(){
        List<Joblevel> jobLevelList  = jobLevelService.getAllJobLevels();
        if (jobLevelList.size()>0){
            return CommonResult.success(jobLevelList);
        }
        return CommonResult.failed(jobLevelList);
    }

}
