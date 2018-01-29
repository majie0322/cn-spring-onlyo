1.aop
1)aop相关概念
a.方面（Aspect）:   指得是封装了共同处理的功能组件，组件可以作用到某一批目标组件的方法上
b.切入点（Pointcut）：用于指定目标组件的表达式
c.连接点（JoinPoint） 切入点是连接点的集合
d.通知（advice）用于指定方面组件和目标组件之间作用时机
e.目标（targer）利用切入点指定的组件和方法
f.动态代理（autoRroxy）


7.通知类型
通知决定方面组件和目标组件作用的关系。主要有一下几种类型的通知：
1）前置通知
方面组件在目标方法之前执行
2）后置通知
方面组件在目标方面之后执行，目标方法没有抛出异常才执行方面组件
3）最终通知
方面组件在目标方面之后执行
4）异常通知
方面组件在目标方法抛出异常后执行
5）环绕通知
方面组件在目标方法之前
try{
前置通知执行时机<aop:before>
执行目标方法
后置通知执行<aop:after-returning>
}catch（）{
异常通知执行<aop:after-throwing>
}finally{
//最终通知执行时机<aop:around>
}

8 切入点
execution（修饰符？，返回类型，方法名（参数列表），throws异常?）
1）匹配容器中所有public修饰的方法
eg：execution（public * * *（..））
2）匹配容器中方法名带set的
eg：execution（* set* （..））
3)匹配dao中所有方法
eg:execution(* org.dd.dao.CostDao.* (..))
4）匹配包
eg:execution(* org.dd.dao.* (..))


二 spirng对数据访问技术的支持
   1）spring提供了统一的异常处理类型DataAccessException
   2）Spring提供了编写Dao的支持
   类DaoSupport： JdbcDaoSupport,hibernateDaoSupport

   类Template：jdbcTemplate,HibernateTemplate

   3）spring提供了声明式事物管理方法（aop ）

   2 spring整合jdbc

   3spring整合hibernate
    1） 新建一个工程，引入spring开发包和配置文件
    2）

    4.spring整合struts2


5.事物管理
1）声明式事务管理（基于配置方式实现事物管理）
2）编程式事务管理（基于java编程实现事物管理）


6.反射机制

1）回顾反射的基本概念(不需要明确的对象，所有的对象使用Object表示)
可以直接利用Object与反射机制混合调用类中的方法

2）分析简单java类与反射联系

3）利用反射实例化对象
class类如果使用forName（）方法之后，就可以使用Class定义的newInstance（）默认去调用
类型中无参构造方法
整个编程中 即使不完全不知道类的结构，不导入包类 也可以实例化对象
如果使用反射对象，必须要求类中使用class类，newInstance只能使用无参构造
这时候只能取得类中的构造方法，传递所需要的参数后才可以执行。

7 web对反射的操作支持
