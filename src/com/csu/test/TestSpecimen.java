package com.csu.test;

import java.util.ArrayList;

import org.junit.Test;

import com.csu.dao.SpecimenDAO;
import com.csu.entity.Specimen;

public class TestSpecimen {

	
	@Test
	public void getSpecimenByUid() {
		SpecimenDAO sd = new SpecimenDAO();
		int pid = 46;
		ArrayList<Specimen> sp = sd.getSpecimenByUid(pid);
		for(Specimen s :sp) {
			System.out.println(s.toString());
		}
	}
	
	@Test
	public void getSpecimenInfo() {
		Specimen sp = new Specimen();
		SpecimenDAO sd = new SpecimenDAO();
		int id = 23237;
		sp = sd.getSpecimenInfo(id);
		System.out.println(sp.toString());
	}
	
	@Test
	public void addSpecimen() {
		Specimen sp = new Specimen();
		sp.setConcentration("12313");
		sp.setPatientId(13);
		sp.setDesc("test");
		sp.setLatestTime("2018-1-1");
		SpecimenDAO sd = new SpecimenDAO();
		sd.addSpecimen(sp);
	}
	
	@Test
	public void editSpecimenInfo() {
		Specimen sp = new Specimen();
		sp.setConcentration("12313");
		sp.setPatientId(13);
		sp.setDesc("test");
		sp.setSpecimen_name("sdfsdfsdf");
		sp.setLatestTime("2018-1-1");
		sp.setId(23238);
		SpecimenDAO sd = new SpecimenDAO();
		sd.editSpecimenInfo(sp);
	}
	
	@Test
	public void deleteSpecimen() {
		int id = 23238;
		SpecimenDAO sd = new SpecimenDAO();
		sd.deleteSpecimen(id);
	}
}
