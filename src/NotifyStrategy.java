public class NotifyStrategy implements AbstractStrategy {

    private static NotifyStrategy INSTANCE = null;
    private NotifyStrategy(){}

    public static NotifyStrategy getInstance(){
        if(INSTANCE==null){
            INSTANCE = new NotifyStrategy();
        }
        return INSTANCE;
    }

    @Override
    public void resolve(IndustrialSystem industrialSystem) {
        for(int i=0; i<industrialSystem.getSize(); i++) {
            if (industrialSystem.getChild(i) instanceof ElementaryItem){
                ElementaryItem ei = (ElementaryItem)industrialSystem.getChild(i);
                if(!ei.isState()){
                    System.out.println("-"+ei.getName());
                }
            }else resolve(industrialSystem.getChild(i));
        }
    }

}
