package edu.umb.cs680.hw12.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReverseAlphabeticalComparatorTest {
	static LocalDateTime localTime = LocalDateTime.now();

	private String[] ApfsEleToString(LinkedList<ApfsElement> l) {
		String[] info = new String[l.size()];
		int i = 0;
		for (ApfsElement e : l) {
			info[i] = e.getName();
			i++;
		}
		return info;

	}

	private String[] APFSFileToString(LinkedList<ApfsFile> l) {
		String[] info = new String[l.size()];
		int i = 0;
		for (ApfsFile e : l) {
			info[i] = e.getName();
			// System.out.println(info[i]);
			i++;
		}
		return info;
	}

	@SuppressWarnings("unused")
	@BeforeAll
	public static void setUpFileStructure() {
		APFS apfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) apfsFileSystem.initFileSystem("root", 3500);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "Prabin", localTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "Prabin", localTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "Prabin", localTime);
		ApfsDirectory pics = new ApfsDirectory(home, "pics", 0, localTime, "Prabin", localTime);
		ApfsFile a = new ApfsFile(applications, "a", 350, localTime, "Prabin", localTime);
		ApfsFile b = new ApfsFile(home, "b", 700, localTime, "Prabin", localTime);
		ApfsFile c = new ApfsFile(code, "c", 800, localTime, "Prabin", localTime);
		ApfsFile d = new ApfsFile(code, "d", 80, localTime, "Prabin", localTime);
		ApfsFile e = new ApfsFile(pics, "e", 700, localTime, "Prabin", localTime);
		ApfsFile f = new ApfsFile(pics, "f", 870, localTime, "Prabin", localTime);
		ApfsFile g = new ApfsFile(home, "g", 1, localTime, "Prabin", localTime);
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "Prabin", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "Prabin", localTime, a);
	}

	@Test
	public void ChildrenHomeDiretoryComparatorTest() {
		String[] expected = { "x", "pics", "g", "code", "b" };
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) FilesystemApfs.getRootDir();
		String[] actual = ApfsEleToString((LinkedList<ApfsElement>) root.findDirectoryByName("home")
				.getChildren(new ReverseAlphabeticalComparator()));
		assertArrayEquals(expected, actual);
	}

	@Test
	public void FilesInCodeDirectoryComparatorTest() {
		String[] expected = { "d", "c" };
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) FilesystemApfs.getRootDir();
		String[] actual = APFSFileToString(
				(LinkedList<ApfsFile>) root.findDirectoryByName("code").getFiles(new ReverseAlphabeticalComparator()));
		assertArrayEquals(expected, actual);
	}

	@Test
	public void FileInPicsDirectoryComparatorTest() {
		String[] expected = { "f", "e" };
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) FilesystemApfs.getRootDir();
		String[] actual = APFSFileToString(
				(LinkedList<ApfsFile>) root.findDirectoryByName("pics").getFiles(new ReverseAlphabeticalComparator()));
		assertArrayEquals(expected, actual);
	}

	@Test
	public void FileInRootDirectoryComparatorTest() {
		String[] expected = { "home", "applications" };
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) FilesystemApfs.getRootDir();
		String[] actual = ApfsEleToString((LinkedList<ApfsElement>) root.findDirectoryByName("root")
				.getChildren(new ReverseAlphabeticalComparator()));
		assertArrayEquals(expected, actual);
	}

	@Test
	public void FileInHomeDirectoryComparatorTest() {
		String[] expected = { "g", "b" };
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory) FilesystemApfs.getRootDir();
		String[] actual = APFSFileToString(
				(LinkedList<ApfsFile>) root.findDirectoryByName("home").getFiles(new ReverseAlphabeticalComparator()));
		assertArrayEquals(expected, actual);
	}
}
