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
- 注意: 使用PageHelp分页插件时遇到一个麻烦的问题。搞了好久。。。。
> - 使用这个分页插件虽然简单，只需要配置当前页、每页数量不需要总数时可以将count设置为false.
> - 就是这个count把我给搞怕了，我是在xml文件中配置的SQL查询。pageHelper插件自动添加SQL语句。
> - 查询总数时在SQL中添加count（0），同时要在select标签中配置resultType=Long。
> - 很无语就是没加这个resultType= Long，使得count（0）执行错误。
> - 还有也会报错：ONLY_FULL_GROUP_BY。在数据库设置set @@GLOBAL.sql_mode= '其中写去掉ONLY_FULL_GROUP_BY之后的内容即可'。
> - 查询 sql_mode语句：进入数据库，select @@GLOBAL.sql_mode。
- 总之，遇到问题不要慌，相信自己一定能搞定，哪怕要花很久的时间。。。。
3. 在employee实体类中加入其他几个实体类
> 为了偷懒，直接导入vhr的数据库，可以看到他的数据库是多么不规范。。。
 - 还有就是要注意mybatis中xml文件使用<collection>时
>   - ofType : 实体为List集合
>   - javaType : 为实体
### 添加员工、更新员工
1. 添加成功后，记录mail日志，然后使用Rabbitmq消息中间件传送消息。
2. 前端表单填写后更新。
### Excel导入导出数据
1. 导出
>- 又是一个无语难题,又他妈的搞了两天。归根结底还是基础不牢靠呀！
>- 我是使用POI依赖工具导出Excel文件，后端做了排版，style。前端多省事。。。。
>- request参数，查询出当前页面的数据，再进行导出。
>- return结果，返回的是一个ResponseEntity<byte[]>,是一个Excel文件。
>- 将字节流、header、status全部封装，返回的就是Excel文件。
> - **问题：**一开始搞了好久就是不知道返回的是一个excel文件，有一点一直在迷惑我，就是使用swagger测试的时候，下载的文件乱码的。就是纠结这个。。。。让我无语。
> - 不清楚在浏览器下载的时候返回的是一个乱码的文件，但是在vue代码中调用这个接口竟然返回的是正常的。。。待解。
2. 上传
> - 需要解析excel表格
> - 需要员工的各种参数
> - 员工的参数必须表格里面的参数一一对应
> - 最后添加到数据库里面。
> - **问题** 注意有跨域问题，查询部门表时，因为部门表是一张有关联的表，查询所有时出来的时候是一张树形结构，
>  经过测试，list里面套list只能通过索引来取里面的list，然后获取实体类的参数。直接查询的时候返回的只能是列表的第一组数据，
>  他的子数据不能查询到，也就是说不能查到子list里面的实体类参数。
 