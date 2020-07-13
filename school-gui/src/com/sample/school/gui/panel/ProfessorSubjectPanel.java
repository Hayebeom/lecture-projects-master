package com.sample.school.gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.sample.school.gui.SchoolTable;
import com.sample.school.gui.model.CourseDialog;
import com.sample.school.gui.model.ProfessorComboBoxModel;
import com.sample.school.gui.model.SubjectTableModel;
import com.sample.school.repository.ProfessorRepository;
import com.sample.school.repository.SubjectRepository;
import com.sample.school.vo.Professor;

public class ProfessorSubjectPanel extends JPanel {

	private Professor selectedProfessor;
	

	private ProfessorComboBoxModel professorComboBoxModel;
	private SubjectTableModel subjectTableModel;
	private SchoolTable table;

	private JButton findSubjectButton = new JButton("조회");
	private JButton addCourseButton = new JButton("과정 등록");
	
	public ProfessorSubjectPanel(ProfessorRepository professorRepository, 
			SubjectRepository subjectRepository) {
		
		setLayout(new BorderLayout());
		
		subjectTableModel = new SubjectTableModel(subjectRepository);
		professorComboBoxModel = new ProfessorComboBoxModel(professorRepository);
		
		// 패널 헤더
		JPanel headerPanel = new JPanel();
		JLabel headerTitleLabel = new JLabel("교수별 과목 조회");
		headerTitleLabel.setFont(new Font("굴림", Font.BOLD, 30));
		headerPanel.add(headerTitleLabel);
		this.add(headerPanel, BorderLayout.NORTH);
		
		// 패널 센터
		JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
		
		// 콤보박스
		JPanel comboBoxPanel = new JPanel();
		JLabel comboBoxLabel = new JLabel("담당교수");
		comboBoxLabel.setFont(new Font("굴림", Font.BOLD, 23));
		JComboBox<Professor> professorListComboBox = new JComboBox<>(professorComboBoxModel);
		professorListComboBox.setPreferredSize(new Dimension(500, 35));
		professorListComboBox.setFont(new Font("굴림", Font.PLAIN, 20));
		professorListComboBox.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
					selectedProfessor = (Professor) e.getItem();
			}
		});
		
		comboBoxPanel.add(comboBoxLabel, BorderLayout.WEST);
		comboBoxPanel.add(professorListComboBox, BorderLayout.CENTER);
		findSubjectButton.setPreferredSize(new Dimension(100, 35));
		findSubjectButton.setFont(new Font("굴림", Font.PLAIN, 20));
		findSubjectButton.addActionListener(e -> {
			if (selectedProfessor == null) {
				JOptionPane.showMessageDialog(null, "담당교수를 선택하세요", "오류", JOptionPane.ERROR_MESSAGE);
			} else {
				subjectTableModel.changeSelectedSubjects(selectedProfessor.getDept());
			}
		});
		comboBoxPanel.add(findSubjectButton, BorderLayout.EAST);		
		
		// 테이블
		table = new SchoolTable(subjectTableModel);
		
		centerPanel.add(comboBoxPanel, BorderLayout.NORTH);
		centerPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		centerPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "과목 리스트", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, new Font("굴림", Font.BOLD, 17)));
		
		this.add(centerPanel, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		addCourseButton.setPreferredSize(new Dimension(200, 35));
		addCourseButton.setFont(new Font("굴림", Font.PLAIN, 20));
		addCourseButton.addActionListener(e -> {
			int selectedRowIndex = table.getSelectedRow();
			if (selectedRowIndex == -1) {
				JOptionPane.showMessageDialog(null, "과정을 개설할 과목을 선택하세요", "오류", JOptionPane.ERROR_MESSAGE);
			} else {
				CourseDialog courseDialog = new CourseDialog();
				courseDialog.setBounds(400, 340, 580, 350);
				courseDialog.setVisible(true);
			}
		});
		bottomPanel.add(addCourseButton);
		this.add(bottomPanel, BorderLayout.SOUTH);
	}
}
