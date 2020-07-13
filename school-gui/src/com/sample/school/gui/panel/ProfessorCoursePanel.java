package com.sample.school.gui.panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.sample.school.gui.SchoolTable;
import com.sample.school.gui.model.CourseTableModel;
import com.sample.school.gui.model.ProfessorComboBoxModel;
import com.sample.school.repository.ProfessorRepository;
import com.sample.school.repository.SubjectRepository;

public class ProfessorCoursePanel extends JPanel {

	private SchoolTable table;
	private CourseTableModel courseTableModel;
	private ProfessorComboBoxModel professorComboBoxModel;
	
	public ProfessorCoursePanel(ProfessorRepository professorRepository, 
			SubjectRepository subjectRepository) {
		
		
		setLayout(new BorderLayout());
		
		
	}
}
