#项目开发流程
***
##第一步
### 使用security框架实现认证和授权。
> 代码封装在 pmsServer的security中

***
## 第二步
### 员工基本资料
#### 实现分页查询
1. 需要用到的表
- employee 员工详情表
- nation 民族
- politicsstatus 政治面貌
- department 所属部门
- joblevel 职称等级
- position 职位
2. 使用mybatis分页插件PageHelper
- 根据姓名查询
> - 使用mybatis联表查询，姓名条件为空和不为空使用<cloose><when><otherwise>。
> - 因为mybatis中没有if else。
> - 此次联表不是单查询一张表的内容，所以编写SQL语句简单些。
