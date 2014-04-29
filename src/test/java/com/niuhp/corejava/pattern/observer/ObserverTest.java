package com.niuhp.corejava.pattern.observer;

import java.util.Observer;

import org.junit.Test;

public class ObserverTest {

	@Test
	public void testObserver() {
		NewsPaper np = new NewsPaper();

		Observer no = new NewsObserver();

		np.addObserver(no);

		np.publishNews("阿森纳重磅引援");
		np.publishNews("阿森纳4:1大胜切尔西");
		np.publishNews("阿森纳8年后再次登顶英超");
	}
}
