package edu.umb.cs680.hw14.apfs;

import java.time.LocalDateTime;
import edu.umb.cs680.hw14.fs.FSElement;
import edu.umb.cs680.hw14.fs.FileSystem;

public class APFS extends FileSystem {

	private static LocalDateTime localTime = LocalDateTime.now();
	private static APFS instance = null;

	private APFS() {
	}

	public static APFS getAPFSFileSystem() {
		if (instance == null) {
			instance = new APFS();
		}
		return instance;
	}

	@Override
	protected FSElement createDefaultRoot() {
		ApfsDirectory root = new ApfsDirectory(null, "root", 0, localTime, "Shreyansh", localTime);
		return root;
	}

}
