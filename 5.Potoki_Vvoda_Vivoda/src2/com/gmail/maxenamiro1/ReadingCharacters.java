package com.gmail.maxenamiro1;

import java.util.Scanner;
import java.util.Random;

public class ReadingCharacters {

	Scanner sc = new Scanner(System.in);
	Random rannum = new Random();

	public Student newStudent() {

		Student student = new Student(null, null, null, 0, null);

		System.out.println("Name: ");
		student.setName(sc.nextLine());

		System.out.println("Last name: ");
		student.setLastName(sc.nextLine());

		System.out.println("Gender: ");
		String studentGender = sc.nextLine();

		if (studentGender.equals("male")) {
			student.setGender(Gender.Male);
		} else if (studentGender.equals("female")) {
			student.setGender(Gender.Female);
		} else {
			System.out.println("");
			System.out.println("Error");
			System.out.println("");
		}

		student.setId(rannum.nextInt(200, 500));
		System.out.println("");

		System.out.println("Group num: ");
		student.setGroupName(sc.nextLine());

		return student;
	}

	public static void addStudentToGroup(Student student, Group group) {

		try {
			group.addStudent(student);
		} catch (GroupOverflowException e) {
			System.out.println(student.gender.getFilePermissions() + student.getName() + " " + student.getLastName()
					+ " Group " + student.getGroupName() + " overflow :(");
		}
	}
}