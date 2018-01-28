package cn.spring.onlyo.aopTest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.spring.onlyo.util.propertyUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 利用aop操作日志的处理组件
 *
 */
@Component
@Aspect
public class LoggerBean {

    @Pointcut("within(cn.spring..*)")
    public void mypoint() {

    }

    // 采用环绕通知
    @Around("mypoint()")
    public Object logger(ProceedingJoinPoint pjp) throws Throwable {

        // 获取要执行的目标组件类名
        String className = pjp.getTarget().getClass().getName();
        System.out.println(className);
        String methodName = pjp.getSignature().getName();
        System.out.println(methodName);
        Object obj = pjp.proceed();
        System.out.println(propertyUtils.getValue("coss"));
        // 根据类名和方法名给用户提示具体
        System.out.println("记录日志");

        return obj;
    }

    @AfterThrowing(pointcut = "mypoint()",throwing = "ex")
    public void afterT(Exception ex) {
        System.out.println("最后");
    }
}
