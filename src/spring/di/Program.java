package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {
	public static void main(String[] args) {
		// ExamConsole console = new InlineExamConsole(exam);
		// ExamConsole console = new GridExamConsole(exam);
		
		/* InlineExamConsole()가 exam 객체를 조립 => DI 
		 *  => GridExamConsole을 외부 설정으로 빼
		 *     스프링을 통해 소스 코드 변경 없이 두 객체를 바꿔 사용할 수 있도록 함
		 */
		
		/* 
		Exam exam = new NewlecExam();
		ExamConsole console = new GridExamConsole();
		
		console.setExam(exam);
		// 일반적인 형태의 결합관계, setter를 통해 injection 

		=> 위 코드를 스프링에게 지시하는 방법으로 코드를 변경
			exam의 생성과 결합을 스프링에서 하는 것 
			setting.xml를 통해 지시서 작성
		*/
		
		/* ApplicationContext를 통해 지시사항 전달 
		  ; 스프링에서 DI 또는 지시서를 읽어 생성 및 조립하는 스프링의 객체 = IoC*/
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
			
		// ExamConsole console = (ExamConsole)context.getBean("console");
		// setting.xml에서 bean class를 inLine<->grid로 바꾸면 각각의 코드가 실행됨
		ExamConsole console = context.getBean(ExamConsole.class);
		
		console.print();
	}
}
