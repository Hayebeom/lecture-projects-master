package com.sample.school.gui.model;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.sample.school.repository.CourseRepository;
import com.sample.school.vo.Course;

public class CourseTableModel extends AbstractTableModel {

	private Vector<Course> courses = new Vector<Course>();
	private String[] columnNames = {"과정번호", "과정명", "과목명", "담당교수", "정원"};
	
	public CourseTableModel(CourseRepository courseRepository) {
		courses.addAll(Arrays.asList(courseRepository.getAllCourse()));
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
		return courses.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
