package com.wg.pms.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.jn.sqlhelper.dialect.pagination.PagingRequest;
import com.jn.sqlhelper.dialect.pagination.SqlPaginations;
import com.wg.pms.common.RespPageBean;
import com.wg.pms.dao.EmployeeDao;
import com.wg.pms.entity.*;
import com.wg.pms.entity.dto.EmployeeParams;
import com.wg.pms.entity.vo.EmployeeQueryParams;
import com.wg.pms.entity.vo.MailConstants;
import com.wg.pms.mapper.*;
import com.wg.pms.service.EmployeeService;
import com.wg.pms.service.MailSendLogService;
import com.wg.pms.service.PoliticsStatusService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    NationMapper nationMapper;
    @Autowired
    PoliticsstatusMapper politicsstatusMapper;
    @Autowired
    JoblevelMapper joblevelMapper;
    @Autowired
    PositionMapper positionMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeecMapper employeeecMapper;
    @Autowired
    EmployeeremoveMapper employeeremoveMapper;
    @Autowired
    EmployeetrainMapper employeetrainMapper;
    @Autowired
    AdjustsalaryMapper adjustsalaryMapper;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    MailSendLogService mailSendLogService;
    @Autowired
    RabbitTemplate rabbitTemplate;
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    @Override
    public List<Employee> list(int page, int size, EmployeeQueryParams queryParams) {
        PageHelper.startPage(page,size,"workID DESC");
        Employee employee = new Employee();

        employee.setName(queryParams.getName());
        employee.setJoblevelid(queryParams.getJobLevelId());
        employee.setNationid(queryParams.getNationId());
        employee.setEngageform(queryParams.getEngageForm());
        employee.setPoliticid(queryParams.getPoliticId());
        employee.setPosid(queryParams.getPositionId());
        employee.setDepartmentid(queryParams.getDepartmentId());

        return  employeeDao.list(page, size, employee);

    }


    @Override
    public List<Employee> getAllEmp(Integer page, Integer size,String keyword) {

        PageHelper.startPage(page,size,"id");

        return  employeeDao.getAllEmp(page, size, keyword);
    }

    @Override
    public int delete(Integer id) {

        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(EmployeeParams employeeParams) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeParams,employee);
        //设置合同期限
        Date beginContract = employee.getBegincontract();
        Date endContract = employee.getEndcontract();
        double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 + (Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract)));
        employee.setContractterm(Double.parseDouble(decimalFormat.format(month / 12)));
        int result = employeeMapper.insertSelective(employee);

        if (result == 1) {
            Employee emp = employeeDao.getByPrimaryKey(employee.getId());
            Employeeec employeeec = new Employeeec();
            employeeec.setEid(emp.getId());
            employeeecMapper.insert(employeeec);//插入员工奖罚eid
            Employeeremove employeeremove = new Employeeremove();
            employeeremove.setEid(emp.getId());
            employeeremove.setAfterdepid(emp.getDepartmentid());
            employeeremove.setAfterjobid(emp.getJoblevelid());
            employeeremoveMapper.insert(employeeremove);//插入员工调动eid
            Employeetrain employeetrain = new Employeetrain();
            employeetrain.setEid(emp.getId());
            employeetrainMapper.insert(employeetrain);//插入员工培训eid
            Adjustsalary adjustsalary = new Adjustsalary();
            adjustsalary.setEid(emp.getId());
            adjustsalaryMapper.insert(adjustsalary);
            //生成消息的唯一id
            String msgId = UUID.randomUUID().toString();
            MailSendLog mailSendLog = new MailSendLog();
            mailSendLog.setMsgid(msgId);
            mailSendLog.setCreatetime(new Date());
            mailSendLog.setExchange(MailConstants.MAIL_EXCHANGE_NAME);
            mailSendLog.setRoutekey(MailConstants.MAIL_ROUTING_KEY_NAME);
            mailSendLog.setEmpid(emp.getId());
            mailSendLog.setTrytime(new Date(System.currentTimeMillis() + 1000 * 60 * MailConstants.MSG_TIMEOUT));
            mailSendLogService.insert(mailSendLog);
            //使用Rabbitmq发送消息
//            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME, emp, new CorrelationData(msgId));
        }
        return result;
    }

    @Override
    public int update(Integer id ,EmployeeParams employeeParams) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeParams,employee);
        employee.setId(id);
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    @Override
    public Integer addEmps(List<Employee> employeeList) {
        return employeeDao.addEmps(employeeList);
    }

    @Override
    public Employee getAllById(Integer id) {

        Employee employee = employeeMapper.selectByPrimaryKey(id);
// Employee emp = employeeDao.getByPrimaryKey(employee.getId());一样
        Nation nation = nationMapper.selectByPrimaryKey(employee.getNationid());
        Politicsstatus politicsstatus = politicsstatusMapper.selectByPrimaryKey(employee.getPoliticid());
        Joblevel joblevel = joblevelMapper.selectByPrimaryKey(employee.getJoblevelid());
        Position position = positionMapper.selectByPrimaryKey(employee.getPosid());
        Department department = departmentMapper.selectByPrimaryKey(employee.getDepartmentid());
        employee.setNation(nation);
        employee.setPoliticsstatus(politicsstatus);
        employee.setJoblevel(joblevel);
        employee.setPosition(position);
        employee.setDepartment(department);
        return employee;
    }

    @Override
    public Integer getIdByName(String name) {
        return employeeDao.getIdByName(name);
    }

    @Override
    public List<Integer> getIdNyName1(String name) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andNameEqualTo(name);
        List<Employee> list = employeeMapper.selectByExample(employeeExample);
        List<Integer> integers = list.stream()
                .map(Employee::getId)
                .collect(Collectors.toList());
        return integers;
    }


}
