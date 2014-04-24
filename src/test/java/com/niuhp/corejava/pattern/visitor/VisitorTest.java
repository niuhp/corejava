package com.niuhp.corejava.pattern.visitor;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

public class VisitorTest extends TestCase{

	public void testVisitor(){
		
		Collection<Object> c=new ArrayList<Object>();
		
		Visitable v1=new StringElement("str1");
		Visitable v2=new StringElement("str1");
		
		Visitable v3=new FloatElement(1.23f);
		Visitable v4=new FloatElement(123.22143f);
		
		Visitable v5=new ObjectElement("obj1");		
		Visitable v6=new ObjectElement("obj2");
		
		c.add(v1);
		c.add(v2);
		
		c.add("string1");
		c.add("string2");
		c.add(v3);
		c.add(v4);
		
		c.add(1.2547f);
		c.add(true);
		c.add(v5);
		c.add(v6);
		
		Visitor v=new VisitorImpl();
		
		v.visitCollection(c);
	}
}
