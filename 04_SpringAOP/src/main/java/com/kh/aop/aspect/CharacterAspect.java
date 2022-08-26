package com.kh.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // 일반적인 자바 클래스가 아니라 에스팩트임을 나타낸다.
public class CharacterAspect {
	// @Pointcut으로 필요할 때마다 참조하 수 있는 포인트커트를 정의한다.
	@Pointcut("execution(* com.kh.aop.character.Character.quest(..)) && args(questName)")
	public void questPointcut(String questName) {
	}
	
//	@Before("execution(* com.kh.aop.character.Character.quest(..))")
	public void beforeQuest(JoinPoint jp) {
		String questName = (String) jp.getArgs()[0];
		
//		System.out.println(jp.getSignature().getName());
//		System.out.println(jp.getSignature().getDeclaringType());
		
		System.out.println(questName + " 퀘스트 준비중..");
	}
	
//	@After("execution(* com.kh.aop.character.Character.quest(..)) && args(questName)") // 2. 방법
	public void afterQuest(String questName) {
		System.out.println(questName + "퀘스트 수행 완료..");
	}
	
//	@AfterReturning(
//			value = "questPointcut(questName)",
//			returning = "result"
//	)
	public void questSuccess(String questName, String result) {
//		System.out.println(result);
		System.out.println(questName + " 퀘스트 수행 완료..");
	}
	
//	@AfterThrowing(
//			value = "questPointcut(questName)",
//			throwing = "exception"
//	)
	
	public void questFail(String questName, Exception exception) {
		System.out.println(questName + "수행 중 에러가 발생하였습니다.");
		System.out.println(exception.getMessage());
	}
	
	@Around("execution(* com.kh.aop.character.Character.quest(..))")
	public String aroundQuest(ProceedingJoinPoint jp) {
		String result = null;
		String questName = (String) jp.getArgs()[0];
		try {
			// before 어드바이스에 대한 기능을 수행
			System.out.println(questName + "퀘스트 준비중..");
			
			// 대상 객체의 메소드를 실행시킨다.
//			jp.proceed();
			
			// 대상 객체의 메소드에 리턴값이 있는 경우
			result = (String) jp.proceed();
			
			
			// after-returning 어드바이스에 대한 기능을 수행
			System.out.println(questName + "퀘스트 수행 완료..");
			
		} catch (Throwable e) {
			// after-throwing  어드바이스에 대한 기능을 수행
			System.out.println(questName + "수행 중 에러가 발생하였습니다.");
			
		}
		
		return result;
		
	}
		
}
