package RealEstate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HouseTest {

	@Test
	void testGetYardAcres() {
		House p = new House("25 South", "84104", 1, 2, 300, 3.5);
		assertEquals(p.getYardAcres(), 3.5);
	}

	@Test
	void testSetYardAcres() {
		House p = new House("25 South", "84104", 1, 2, 300, 3.5);
		p.setYardAcres(5.3);
		assertEquals(p.getYardAcres(), 5.3);
	}

	@Test
	void testCalculateAppraisalPrice() {
		House p = new House("25 South", "84104", 10, 10, 10, 10);
		p.calculateAppraisalPrice();
		assertEquals(p.getApraisalPrice(), 4820970);
	}
}
