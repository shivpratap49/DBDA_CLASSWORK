package com.sunbeam;

import java.util.Objects;

public class Box {
	private int length;
	private int breadth;
	private int height;
	public Box() {
	}
	public Box(int length, int breadth, int height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	/*
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if(!(obj instanceof Box))
			return false;
		Box other = (Box) obj;
		if(this.length == other.length && this.breadth == other.breadth && this.height == other.height)
			return true;
		return false;
	}
	*/
	
	/*
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if(!(obj instanceof Box))
			return false;
		Box other = (Box) obj;
		if(Objects.equals(this.length, other.length) && Objects.equals(this.breadth, other.breadth) && Objects.equals(this.height, other.height))
			return true;
		return false;
	}
	*/
	
	/*
	@Override
	public int hashCode() {
		int hash = this.length + 31 * this.breadth + 31 * 31 * this.height;
		return hash;
	}
	*/
	/*
	@Override
	public int hashCode() {
		int hash = Objects.hash(this.length, this.breadth, this.height);
		return hash;
	}
	*/
	
	
	
	@Override
	public String toString() {
		return "Box [length=" + length + ", breadth=" + breadth + ", height=" + height + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + breadth;
		result = prime * result + height;
		result = prime * result + length;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Box))
			return false;
		Box other = (Box) obj;
		if (breadth != other.breadth)
			return false;
		if (height != other.height)
			return false;
		if (length != other.length)
			return false;
		return true;
	}
}
