import static org.junit.jupiter.api.Assertions.*;

class Test {

    @org.junit.jupiter.api.Test
    void testFakeImplementation(){
        IndustrialSystem isTest = new ElementaryItem("test");
        assertThrows(IllegalAccessError.class, ()->isTest.getChild(5));
        assertThrows(IllegalAccessError.class, ()->isTest.add(isTest));
        assertThrows(IllegalAccessError.class, ()->isTest.remove(isTest));
    }

    @org.junit.jupiter.api.Test
    void testSingletonRepairStrategy(){
        AbstractStrategy instance1 = RepairStrategy.getInstance();
        AbstractStrategy instance2 = RepairStrategy.getInstance();
        assertEquals(instance1,instance2);
    }

    @org.junit.jupiter.api.Test
    void testSingletonNotifyStrategy(){
        AbstractStrategy instance1 = NotifyStrategy.getInstance();
        AbstractStrategy instance2 = NotifyStrategy.getInstance();
        assertEquals(instance1,instance2);
    }

    @org.junit.jupiter.api.Test
    void testRepairStrategy(){
        ElementaryItem item = new ElementaryItem("item");
        IndustrialSystem is = new CompositeItem();
        is.add(item);
        item.fail();
        is.evaluate();
        assertTrue(item.isState());
    }

    @org.junit.jupiter.api.Test
    void testRemoveItem(){
        ElementaryItem isTest = new ElementaryItem("test");
        IndustrialSystem is = new CompositeItem();
        is.add(isTest);
        is.remove(isTest);
        assertThrows(IndexOutOfBoundsException.class, ()->is.getChild(0));
    }

    @org.junit.jupiter.api.Test
    void testAddItem(){
        ElementaryItem isTest = new ElementaryItem("test");
        IndustrialSystem is = new CompositeItem();
        is.add(isTest);
        assertEquals(isTest,is.getChild(0));
    }

    @org.junit.jupiter.api.Test
    void testStateItem(){
        ElementaryItem isTest = new ElementaryItem("test");
        assertTrue(isTest.isState());
    }

    @org.junit.jupiter.api.Test
    void testControlSystem(){
        ElementaryItem isTest = new ElementaryItem("test");
        IndustrialSystem is = new CompositeItem();
        is.add(isTest);
        ControlSystem controlSystem = new ControlSystem();
        assertTrue(controlSystem.control(is));
        isTest.fail();
        assertFalse(controlSystem.control(is));
    }



}