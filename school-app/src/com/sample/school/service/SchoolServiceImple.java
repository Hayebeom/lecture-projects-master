package com.sample.school.service;

import com.sample.school.exception.EmailDuplicatedException;
import com.sample.school.exception.SubjectDuplicatedException;
import com.sample.school.exception.UserNotFoundException;
import com.sample.school.repository.CourseRepository;
import com.sample.school.repository.ProfessorRepository;
import com.sample.school.repository.RegistrationRepository;
import com.sample.school.repository.SubjectRepository;
import com.sample.school.vo.Professor;
import com.sample.school.vo.Subject;

public class SchoolServiceImple implements SchoolService {

	private CourseRepository courseRepo = new CourseRepository();
	private ProfessorRepository professorRepo = new ProfessorRepository();
	private RegistrationRepository registrationRepo = new RegistrationRepository();
	private SubjectRepository subjectRepo = new SubjectRepository();
	
	@Override
	public void addNewProfessor(Professor professor) {
		boolean isExist = false;
		Professor[] professors = professorRepo.getAllProfessor();
		for (Professor prof : professors) {
			if (prof.getEmail().equals(professor.getEmail())) {
				isExist = true;
				break;
			}
		}
		if (!isExist) {
			professorRepo.insertProfessor(professor);
		} else {
			throw new EmailDuplicatedException(professor.getEmail());
		}
		
	}
	@Override
	public void addNewSubject(Subject subject) {
		boolean isExist = false;
		Subject[] subjects = subjectRepo.getAllSubject();
		for (Subject sub : subjects) {
			if (sub.getTitle().equals(subject.getTitle())) {
				isExist = true;
				break;
			}
		}
		if (isExist) {
			subjectRepo.insertSubject(subject);
		} else {
			throw new SubjectDuplicatedException(subject.getTitle());
		}
	}
	
	@Override
	public void printSubjectByProfessorNo(int professorNo) {
		Professor professor = professorRepo.getProfessorByNo(professorNo);
		if (professor == null) {
			throw new UserNotFoundException(String.valueOf(professorNo));
		}
		
		System.out.println("===========================================");
		System.out.println("과목번호	과목명	학과		학점");
		System.out.println("===========================================");
		Subject[] subjects = subjectRepo.getAllSubject();
		for (Subject subject : subjects) {
			if (subject.getDept().equals(professor.getDept())) {
				System.out.print(subject.getNo() + "\t");
				System.out.print(subject.getTitle() + "\t");
				System.out.print(subject.getDept() + "\t");
				System.out.println(subject.getCredit());
			}
		}
	}
	
}
