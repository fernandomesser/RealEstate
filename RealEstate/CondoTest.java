package RealEstate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CondoTest {

	@Test
	void testGetFloorLvl() {
		Condo p = new Condo("25 South", "84104", 1, 2, 300, 1);
		assertEquals(p.getFloorLvl(), 1);
	}

	@Test
	void testSetFloorLvl() {
		Condo p = new Condo("25 South", "84104", 1, 2, 300, 1);
		p.setFloorLvl(1.5);
		assertEquals(p.getFloorLvl(), 1.5);
	}

	@Test
	void testCalculateAppraisalPrice() {
		Condo p = new Condo("25 South", "84104", 10, 10, 10, 10);
		p.calculateAppraisalPrice();
		assertEquals(p.getApraisalPrice(), 230880);
	}

}
