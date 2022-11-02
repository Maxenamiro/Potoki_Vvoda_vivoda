package com.gmail.maxenamiro1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GroupFileStorage {
	CSVStringConvertor convert = new CSVStringConvertor();

	public void saveGroupToCSV(Group group) {

		File fileGroupName = new File("/Users/a1/Documents/Papka/groups/" + group.getGroupName() + ".csv");

		try (PrintWriter pw = new PrintWriter(fileGroupName)) {
			for (int i = 0; i < group.getStudents().length; i++) {
				Student student = group.getStudents()[i];
				if (student != null) {
					pw.println(convert.toStringRepresentation(student));
				}
			}
			System.out.println("Saved in file " + group.getGroupName() + ".csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Group loadGroupFromCSV(File file) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String tempString = "";
			Group result = new Group(file.getName());
			for (;;) {
				tempString = br.readLine();
				if (tempString == null) {
					break;
				}
				try {
					result.addStudent(convert.fromStringRepresentation(tempString));
				} catch (GroupOverflowException e) {
					e.printStackTrace();
				}
			}
			return result;
		}
	}

	public File findFileByGroupName(String groupName, File workFolder) {

		File[] tempFiles = workFolder.listFiles();
		if (tempFiles != null) {
			for (int i = 0; i < tempFiles.length; i++) {
				if (tempFiles[i].isFile() && tempFiles[i].getName().equals(groupName + ".csv")) {
					return tempFiles[i];
				}
			}
		}
		return null;
	}
}
