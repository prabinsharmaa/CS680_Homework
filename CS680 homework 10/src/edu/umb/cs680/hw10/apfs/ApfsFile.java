package edu.umb.cs680.hw10.apfs;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {

	public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String OwnerName,
			LocalDateTime LD) {
		super(parent, name, size, creationTime, OwnerName, LD);
		parent.appendChild(this);
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

	@Override
	public void accept(ApfsVisitor v) {
		v.visit(this);
	}
}