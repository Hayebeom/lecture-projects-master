package com.sample.school.gui.model;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.sample.school.repository.SubjectRepository;
import com.sample.school.vo.Subject;

public class SubjectTableModel extends AbstractTableModel {
	
	private Vector<Subject> subjects = new Vector<Subject>();
	private Vector<Subject> selectedSubjects = new Vector<Subject>();
	private String[] columnNames = {"과정번호", "과정명", "학과", "학점"};

	public SubjectTableModel(SubjectRepository subjectRepository) {
		subjects.addAll(Arrays.asList(subjectRepository.getAllSubject()));
	}
	
	public void changeSelectedSubjects(String dept) {
		selectedSubjects.clear();
		for (Subject subject : subjects) {
			if (subject.getDept().equals(dept)) {
				selectedSubjects.add(subject);
			}
		}
		this.fireTableStructureChanged();
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public int getRowCount() {
		return selectedSubjects.size();
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Subject subject = selectedSubjects.get(rowIndex);
		
		if (columnIndex == 0) {
			return String.valueOf(subject.getNo());
		}
		if (columnIndex == 1) {
			return subject.getTitle();
		}
		if (columnIndex == 2) {
			return subject.getDept();
		}
		if (columnIndex == 3) {
			return String.valueOf(subject.getCredit());
		}
		return "";
	}
	
	
}
