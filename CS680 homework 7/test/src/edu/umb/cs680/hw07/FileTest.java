package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class FileTest {
	private LocalDateTime date1 = LocalDateTime.now();
	private LocalDateTime date2 = LocalDateTime.now();
	Directory root = new Directory(null, "Root", 0, date1);
	Directory home = new Directory(root, "Home", 0, date1);
	Directory applications = new Directory(root, "Applications", 0, date1);
	Directory code = new Directory(home, "Code", 0, date2);
	File a = new File(applications, "a", 1, date1);
	File b = new File(applications, "b", 2, date2);
	File c = new File(home, "c", 3, date1);
	File d = new File(home, "d", 4, date2);
	File e = new File(code, "e", 5, date2);
	File f = new File(code, "f", 6, date2);

	private String[] fileToStringArray(File f) {
		String[] fileInfo = { String.valueOf(f.isFile()), f.getName(), Integer.toString(f.getSize()),
				f.getCreationTime().toString(), f.getParent().getName(), String.valueOf(f.isDirectory()) };
		return fileInfo;
	}

	@Test
	public void verifyFileEqualityA() {
		String[] expected = { "true", "a", "1", date1.toString(), "Applications", "false" };
		File file = this.a;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void verifyFileEqualityB() {
		String[] expected = { "true", "b", "2", date2.toString(), "Applications", "false" };
		File file = this.b;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void verifyFileEqualityC() {
		String[] expected = { "true", "c", "3", date1.toString(), "Home", "false" };
		File file = this.c;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void verifyFileEqualityD() {
		String[] expected = { "true", "d", "4", date2.toString(), "Home", "false" };
		File file = this.d;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void verifyFileEqualityE() {
		String[] expected = { "true", "e", "5", date2.toString(), "Code", "false" };
		File file = this.e;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void verifyFileEqualityF() {
		String[] expected = { "true", "f", "6", date2.toString(), "Code", "false" };
		File file = this.f;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(actual, expected);
	}
}