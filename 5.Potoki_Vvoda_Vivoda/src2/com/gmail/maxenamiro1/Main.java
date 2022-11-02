package com.gmail.maxenamiro1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		Student student1 = new Student("Taras", "Shevchenko", Gender.Male, 1, "Writer");
		Student student2 = new Student("Ivan", "Franko", Gender.Male, 2, "Writer");
		Student student3 = new Student("Lesya", "Ukrainka", Gender.Female, 3, "Writer");
		Student student4 = new Student("Grugoriy", "Skovoroda", Gender.Male, 4, "Writer");
		Student student5 = new Student("Lina", "Kostenko", Gender.Female, 5, "Writer");
		Student student6 = new Student("Valerian", "Pidmohulniy", Gender.Male, 6, "Writer");
		Student student7 = new Student("Myhailo", "Kociubinskiy", Gender.Male, 7, "Writer");
		Student student8 = new Student("Mykola", "Khviloviy", Gender.Male, 8, "Writer");
		Student student9 = new Student("Volodymyr", "Vinnichenko", Gender.Male, 9, "Writer");
		Student student10 = new Student("Oleksandr", "Dovzhenko", Gender.Male, 10, "Writer");

		Group group1 = new Group("Writer");

		try {
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student4);
			group1.addStudent(student5);
			group1.addStudent(student6);
			group1.addStudent(student7);
			group1.addStudent(student8);
			group1.addStudent(student9);
			group1.addStudent(student10);

		} catch (GroupOverflowException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}

		GroupFileStorage gfs = new GroupFileStorage();
		gfs.saveGroupToCSV(group1);
		System.out.println();

		File groupsFolder = new File("/Users/a1/Documents/Papka/groups/");
		String groupToSearch = ("Writer");
		File searchGroup = gfs.findFileByGroupName(groupToSearch, groupsFolder);
		{
			if (searchGroup != null) {
				System.out.println("Found: " + searchGroup.getName());
				System.out.println();
			} else {
				System.out.println("Group is not exist: " + groupToSearch);
			}

			String groupToLoad = "Writer";
			File groupsDirectory = new File("/Users/a1/Documents/Papka/groups/Writer.csv");
			Group tempGroup = new Group("");
			try {
				tempGroup = gfs.loadGroupFromCSV(groupsDirectory);
			} catch (FileNotFoundException e) {
				System.out.println("File " + groupToLoad + ".csv not exists!");
			} catch (IOException b) {
				b.printStackTrace();
			}

			System.out.println("Students: " + tempGroup.getGroupName() + ":");
			System.out.println();
			System.out.println(tempGroup);
		}
	}
}