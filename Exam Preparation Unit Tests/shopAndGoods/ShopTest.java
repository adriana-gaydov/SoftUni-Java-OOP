package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    private static Shop testShop;

    @Before
    public void setUp() {
        testShop = new Shop();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowIfDoesntContainShelf() throws OperationNotSupportedException {
        testShop.addGoods("test", new Goods("testGood", "1111"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowIfShelfAlreadyTaken() throws OperationNotSupportedException {
        Shop testShop = new Shop();

        testShop.addGoods("Shelves1", new Goods("testGood", "1111"));

        testShop.addGoods("Shelves1", new Goods("anotherOne", "1111"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsShouldThrowIfItemAlreadyExists() throws OperationNotSupportedException {
        Shop testShop = new Shop();
        Goods good = new Goods("testGood", "1111");

        testShop.addGoods("Shelves1", good);
        testShop.addGoods("Shelves2", good);
    }

    @Test
    public void testAddGoodsAddsGoodSuccessfully() throws OperationNotSupportedException {
        Shop testShop = new Shop();
        Goods good = new Goods("testGood", "1111");

        testShop.addGoods("Shelves1", good);

        Assert.assertEquals(good, testShop.getShelves().get("Shelves1"));
    }

    @Test
    public void testAddGoodsAddsGoodSuccessfullyReturnStr() throws OperationNotSupportedException {
        Shop testShop = new Shop();
        Goods good = new Goods("testGood", "1111");

        String shelves1 = testShop.addGoods("Shelves1", good);

        Assert.assertEquals("Goods: 1111 is placed successfully!", shelves1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldThrowIfShelfDoesntExist() {
        testShop.removeGoods("test", new Goods("testGood", "1111"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldThrowIfGoodsShelfDoesntExist() throws OperationNotSupportedException {
        Shop testShop = new Shop();
        Goods good = new Goods("testGood", "1111");

        testShop.addGoods("Shelves1", good);

        testShop.removeGoods("Shelves1", new Goods("x", "x"));
    }

    @Test
    public void testRemoveGoodsRemovesGoodSuccessfully() throws OperationNotSupportedException {
        Shop testShop = new Shop();
        Goods good = new Goods("testGood", "1111");

        testShop.addGoods("Shelves1", good);
        testShop.removeGoods("Shelves1", good);

        Assert.assertNull(testShop.getShelves().get("Shelves1"));
    }

    @Test
    public void testRemoveGoodsRemovesGoodSuccessfullyReturnStr() throws OperationNotSupportedException {
        Shop testShop = new Shop();
        Goods good = new Goods("testGood", "1111");

        testShop.addGoods("Shelves1", good);
        String shelves1 = testShop.removeGoods("Shelves1", good);

      Assert.assertEquals(shelves1, "Goods: 1111 is removed successfully!");
    }


}