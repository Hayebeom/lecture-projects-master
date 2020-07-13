package com.sample.school.gui.model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CourseDialog extends JDialog {
	
	private JTextField titleField;
	private JTextField professorField;
	private JTextField subjectField;
	
	private JButton addCourseButton = new JButton("등록");
	
	public CourseDialog() {
	
		getContentPane().setLayout(new BorderLayout());
		
		// 패널 헤더
		JPanel headerPanel = new JPanel();
		JLabel headerTitleLabel = new JLabel("교수별 과목 조회");
		headerTitleLabel.setFont(new Font("굴림", Font.BOLD, 30));
		headerPanel.add(headerTitleLabel);
		getContentPane().add(headerPanel, BorderLayout.NORTH);
	
		JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
		
		JPanel formPanel = new JPanel();
		JLabel titleLabel = new JLabel("과정명");
		titleLabel.setSize(88, 30);
		titleLabel.setLocation(14, 34);
		titleLabel.setFont(new Font("굴림", Font.BOLD, 23));
		
		formPanel.add(titleLabel);
		formPanel.setLayout(null);
		
		getContentPane().add(formPanel, BorderLayout.CENTER);
		
		JLabel titleLabel_1 = new JLabel("담당교수");
		titleLabel_1.setFont(new Font("굴림", Font.BOLD, 23));
		titleLabel_1.setBounds(14, 76, 96, 30);
		formPanel.add(titleLabel_1);
		
		JLabel titleLabel_1_1 = new JLabel("과목명");
		titleLabel_1_1.setFont(new Font("굴림", Font.BOLD, 23));
		titleLabel_1_1.setBounds(14, 121, 88, 30);
		formPanel.add(titleLabel_1_1);
		
		titleField = new JTextField();
		titleField.setBounds(144, 34, 386, 30);
		formPanel.add(titleField);
		titleField.setColumns(10);
		
		professorField = new JTextField();
		professorField.setEditable(false);
		professorField.setColumns(10);
		professorField.setBounds(144, 77, 386, 30);
		formPanel.add(professorField);
		
		subjectField = new JTextField();
		subjectField.setEditable(false);
		subjectField.setColumns(10);
		subjectField.setBounds(144, 125, 386, 30);
		formPanel.add(subjectField);
		
		centerPanel.add(formPanel, BorderLayout.CENTER);
		centerPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "신규 과정 등록폼", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, new Font("굴림", Font.BOLD, 17)));
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		addCourseButton.setPreferredSize(new Dimension(100, 35));
		addCourseButton.setFont(new Font("굴림", Font.PLAIN, 20));
		bottomPanel.add(addCourseButton);
		
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
	}
}
