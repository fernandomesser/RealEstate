package RealEstate;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResidentialTest {

	@Test
	void testGetBeds() {
		Residential p = new House("25 South", "84104", 2, 3, 4, 1);
		assertEquals(p.getBeds(), 2);
	}

	@Test
	void testSetBeds() {
		Residential p = new House("25 South", "84104", 2, 3, 4, 1);
		p.setBeds(5);
		assertEquals(p.getBeds(), 5);
	}

	@Test
	void testGetBaths() {
		Residential p = new House("25 South", "84104", 2, 3, 4, 1);
		assertEquals(p.getBaths(), 3);
	}

	@Test
	void testSetBaths() {
		Residential p = new House("25 South", "84104", 2, 3, 4, 1);
		p.setBaths(7);
		assertEquals(p.getBaths(), 7);
	}

	@Test
	void testGetSize() {
		Residential p = new House("25 South", "84104", 2, 3, 4, 1);
		assertEquals(p.getSize(), 4, 0);
	}

	@Test
	void testSetSize() {
		Residential p = new House("25 South", "84104", 2, 3, 4, 1);
		p.setSize(8);
		assertEquals(p.getSize(), 8, 0);
	}

}
