public class Main {

    public static void main(String[] args) {

        ElementaryItem item1 = new ElementaryItem("ItemType1");
        ElementaryItem item2 = new ElementaryItem("ItemType2");
        ElementaryItem item3 = new ElementaryItem("ItemType3");
        ElementaryItem item4 = new ElementaryItem("ItemType4");

        CompositeItem compositeItem1 = new CompositeItem();
        CompositeItem compositeItem2 = new CompositeItem();
        CompositeItem compositeItem3 = new CompositeItem();

        compositeItem1.add(item1);
        compositeItem1.add(item2);
        compositeItem2.add(item3);
        compositeItem3.add(compositeItem2);

        IndustrialSystem industrialSystem = new CompositeItem();
        industrialSystem.add(compositeItem1);
        industrialSystem.add(item4);
        industrialSystem.add(compositeItem2);


        System.out.println("\nTEST REPAIR STRATEGY\n");
        item1.fail();
        item3.fail();
        industrialSystem.evaluate();



        System.out.println("\nTEST NOTIFY STRATEGY\n");
        item2.fail();
        industrialSystem.evaluate();

    }
}
