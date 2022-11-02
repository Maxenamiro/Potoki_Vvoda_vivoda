package com.gmail.maxenamiro1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Group {

	private String groupName;
	private Student[] students;

	public Group(String groupName) {
		super();
		students = new Student[10];
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudents() {
		return students;
	}

	public void addStudent(Student student) throws GroupOverflowException {

		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
			
				return;
			}
		}

		throw new GroupOverflowException(student.gender.getFilePermissions() + student.getName() + " "
				+ student.getLastName() + " не добавлен,\nгруппа " + student.getGroupName() + " переполнена :(");
	}

	
	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {

		for (int j = 0; j < students.length; j++) {
			if (students[j] != null) {
				if (students[j].getLastName().equals(lastName)) {
					return students[j];
				}
			}
		}
		throw new StudentNotFoundException("Not found :(");
	}

	
	public boolean removeStudentByID(int id) {

		for (int k = 0; k < students.length; k++) {
			if (students[k] != null) {
				if (students[k].getId() == id) {
					students[k] = null;
					System.out.println("Student " + id + " deleted!");
					return true;
				}
			}
		}
		System.out.println("Student  " + id + " not found :(");
		return false;
	}

	public void sortStudentsByLastName() {
		Arrays.sort(students, Comparator.nullsFirst(new StudentLastNameComparator()));
	}


	@Override
	public String toString() {
		String listOfStudents = "";
		String[] arrayOfStudents = new String[10];

		for (int i = 0; i < arrayOfStudents.length; i++) {
			if (students[i] != null)
				arrayOfStudents[i] = students[i].getLastName() + " " + students[i].getName();
			else
				arrayOfStudents[i] = "";
		}

		Arrays.sort(arrayOfStudents);
		for (int i = 0; i < arrayOfStudents.length; i++) {
			if (arrayOfStudents[i] != "") {
				listOfStudents += arrayOfStudents[i] + "\n";
			}
		}

		return listOfStudents;
	}
}