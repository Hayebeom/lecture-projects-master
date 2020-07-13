package com.sample.school.gui.model;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

import com.sample.school.repository.ProfessorRepository;
import com.sample.school.vo.Professor;

public class ProfessorComboBoxModel extends DefaultComboBoxModel<Professor> {

	private ProfessorRepository professorRepository;
	private Vector<Professor> professors;
	
	public ProfessorComboBoxModel(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
		professors = new Vector<Professor>();
		professors.addAll(Arrays.asList(professorRepository.getAllProfessor()));
	}
	
	@Override
	public Professor getElementAt(int index) {
		return professors.get(index);
	}
	
	@Override
	public int getSize() {
		return professors.size();
	}
}
