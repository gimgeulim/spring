package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {
	public static void main(String[] args) {
		Exam exam = new NewlecExam();
		ExamConsole console = new InlineExamConsole(exam);
		// ExamConsole console = new GridExamConsole(exam);
		/* InlineExamConsole()가 exam 객체를 조립 => DI 
		 *  => GridExamConsole을 외부 설정으로 빼
		 *     스프링을 통해 소스 코드 변경 없이 두 객체를 바꿔 사용할 수 있도록 함
		 */
		
		console.print();
	}
}
