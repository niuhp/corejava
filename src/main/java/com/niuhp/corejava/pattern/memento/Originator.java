package com.niuhp.corejava.pattern.memento;

public class Originator implements Cloneable {

	private int number;

	private String name;

	// create a memento
	public Memento getMemento() {
		return new Memento(this);
	}

	// revert to previous
	public void revertByMemento(Memento memento) {
		number = memento.getNumber();
		name = memento.getName();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Originator clone() {
		try {
			return (Originator) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Originator other = (Originator) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Originator [number=" + number + ", name=" + name + "]";
	}
}
