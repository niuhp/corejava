package com.niuhp.corejava.features.java8.annotations;

public class Example {

}

@Anns({ @Ann(1), @Ann(2) })
class Old {

}

@Ann(1)
@Ann(2)
class New {

}
