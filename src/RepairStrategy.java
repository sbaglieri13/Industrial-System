public class RepairStrategy implements AbstractStrategy {

    private static RepairStrategy INSTANCE = null;
    private RepairStrategy(){}

    public static RepairStrategy getInstance(){
        if(INSTANCE==null){
            INSTANCE = new RepairStrategy();
        }
        return INSTANCE;
    }

    @Override
    public void resolve(IndustrialSystem industrialSystem) {
        for(int i=0; i<industrialSystem.getSize(); i++) {
            if (industrialSystem.getChild(i) instanceof ElementaryItem){
                ElementaryItem ei = (ElementaryItem)industrialSystem.getChild(i);
                if(!ei.isState()){
                    System.out.println("Riparo componente "+ei.getName());
                    ei.repair();
                }
            }else resolve(industrialSystem.getChild(i));
        }
    }

}
