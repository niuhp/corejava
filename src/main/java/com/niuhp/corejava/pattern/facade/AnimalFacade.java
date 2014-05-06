package com.niuhp.corejava.pattern.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AnimalFacade {

	private Collection<Animal> animals;

	public boolean addAnimal(Animal animal) {
		if (animals == null) {
			animals = new ArrayList<>();
			Collections.synchronizedCollection(animals);
		}
		return animals.add(animal);
	}

	public boolean removeAnimal(Animal animal) {
		if (animals == null) {
			return false;
		}
		return animals.remove(animal);
	}

	public void allSpeak() {
		if (animals == null) {
			return;
		}
		for (Animal animal : animals) {
			animal.speak();
		}
	}
}
