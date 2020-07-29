import java.util.ArrayList;
import java.util.List;

public class ControlSystem {

    public ControlSystem(){}

    public boolean control(IndustrialSystem industrialSystem){
        List<Boolean> status = new ArrayList<>();
        updateStatus(industrialSystem,status);
        return isFailure(status);
    }

    public void updateStatus(IndustrialSystem industrialSystem,List<Boolean> status){
        for(int i=0; i<industrialSystem.getSize(); i++) {
            if (industrialSystem.getChild(i) instanceof ElementaryItem){
                ElementaryItem ei = (ElementaryItem)industrialSystem.getChild(i);
                status.add(ei.isState());
            }else updateStatus(industrialSystem.getChild(i),status);
        }
    }

    public boolean isFailure(List<Boolean> status){
        int failure = 0;
        for (Boolean aBoolean : status) {
            if (!aBoolean) {
                failure++;
            }
        }
        if(failure==0){
            return true;
        }
        return ((failure * 100) / status.size()) < 40;
    }







}
