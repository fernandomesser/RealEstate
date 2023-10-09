package RealEstate;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PropertyTest {

	@Test
	void testGetStreetAddress() {
		Property p = new House("25 South", "84604", 10, 3, 2, 1);
		assertEquals(p.getStreetAddress(), "25 South");
	}

	@Test
	void testSetStreetAddress() {
		Property p = new House("25 South", "84604", 10, 3, 2, 1);
		p.setStreetAddress("25 North");
		assertEquals(p.getStreetAddress(), "25 North");
	}

	@Test
	void testGetZip() {
		Property p = new House("25 South", "84604", 10, 3, 2, 1);
		assertEquals(p.getZip(), "84604");
	}

	@Test
	void testSetZip() {
		Property p = new House("25 South", "84604", 10, 3, 2, 1);
		p.setZip("84560");
		assertEquals(p.getZip(), "84560");
	}

	@Test
	void testGetListPrice() {
		Property p = new House("25 South", "84604", 10, 3, 2, 1);
		assertEquals(p.getListPrice(), 0, 0);
	}

	@Test
	void testSetListPrice() {
		Property p = new House("25 South", "84604", 10, 3, 2, 1);
		p.setListPrice(1000);
		assertEquals(p.getListPrice(), 1000, 0);
	}

	@Test
	void testGetApraisalPrice() {
		Property p = new House("25 South", "84604", 10, 3, 2, 1);
		assertEquals(p.getApraisalPrice(), 1000, 0);
	}

}
