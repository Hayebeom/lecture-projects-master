package com.sample.school;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import javax.swing.JPanel;
import com.sample.school.gui.panel.ProfessorSubjectPanel;
import com.sample.school.repository.CourseRepository;
import com.sample.school.repository.ProfessorRepository;
import com.sample.school.repository.RegistrationRepository;
import com.sample.school.repository.StudentRepository;
import com.sample.school.repository.SubjectRepository;


public class SchoolApp {

	private JFrame frame;
	CourseRepository courseRepository = new CourseRepository();
	ProfessorRepository professorRepository = new ProfessorRepository();
	RegistrationRepository registrationRepository = new RegistrationRepository();
	StudentRepository studentRepository = new StudentRepository();
	SubjectRepository subjectRepository = new SubjectRepository();		
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchoolApp window = new SchoolApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SchoolApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setTitle("수강신청 프로그램");
		frame.setBounds(100, 100, 1056, 636);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu professorMenu = new JMenu("교수");
		menuBar.add(professorMenu);
		
		JMenuItem addSubjectMenuItem = new JMenuItem("신규과목 등록");
		professorMenu.add(addSubjectMenuItem);
		
		JMenuItem addCourseMenuItem = new JMenuItem("신규 과정 등록");
		professorMenu.add(addCourseMenuItem);
		
		JMenuItem getMySubjectMenuItem = new JMenuItem("담당 과목 조회");
		professorMenu.add(getMySubjectMenuItem);
		
		JMenuItem getMyCourseMenuItem = new JMenuItem("담당 과정 조회");
		professorMenu.add(getMyCourseMenuItem);
		
		JMenuItem getRegistrationStudentsMenuItem = new JMenuItem("수강신청 학생 조회");
		professorMenu.add(getRegistrationStudentsMenuItem);
		
		JMenuItem setScoreMenuItem = new JMenuItem("성적입력");
		professorMenu.add(setScoreMenuItem);
		
		JMenu studentMenu = new JMenu("학생");
		menuBar.add(studentMenu);
		
		JMenuItem getOpenedCourseMenuItem = new JMenuItem("개설 과정 조회");
		studentMenu.add(getOpenedCourseMenuItem);
		
		JMenuItem addRegistrationMenuItem = new JMenuItem("수강신청");
		studentMenu.add(addRegistrationMenuItem);
		
		JMenuItem getRegistrationMenuItem = new JMenuItem("수강신청 과정 조회");
		studentMenu.add(getRegistrationMenuItem);
		
		JMenuItem cancelRegistrationMenuItem = new JMenuItem("수강신청 취소");
		studentMenu.add(cancelRegistrationMenuItem);
		
		JMenuItem getScoreMenuItem = new JMenuItem("성적조회");
		studentMenu.add(getScoreMenuItem);
		
		JMenu exitMenu = new JMenu("종료");
		menuBar.add(exitMenu);
		frame.getContentPane().setLayout(new CardLayout(20, 10));
		
		
		
		//table.setBounds(14, 107, 704, 413);
		//panel.add(table);
		
		
		
		ProfessorSubjectPanel professorSubjectPanel = new ProfessorSubjectPanel(professorRepository, subjectRepository);
		frame.getContentPane().add(professorSubjectPanel, "1");
		
		frame.setVisible(true);
	}
}
