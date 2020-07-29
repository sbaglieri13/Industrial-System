import java.util.ArrayList;
import java.util.List;

public abstract class IndustrialSystem {

    private List<Observer> twins = new ArrayList<>();
    private ControlSystem controlSystem = new ControlSystem();
    private AbstractStrategy abstractStrategy;

    public void attach(Observer obs){
        twins.add(obs);
    }

    public void detach(Observer obs){
        twins.remove(obs);
    }

    public void notify(ElementaryItem ei){
        for(Observer obs:twins){
            obs.update(ei);
        }
    }

    public void add(IndustrialSystem is) throws IllegalAccessError{
        throw new IllegalAccessError("You cannot access this method for the specified object");
    }

    public void remove(IndustrialSystem is) throws IllegalAccessError{
        throw new IllegalAccessError("You cannot access this method for the specified object");
    }

    public IndustrialSystem getChild(int i) throws IllegalAccessError{
        throw new IllegalAccessError("You cannot access this method for the specified object");
    }

    public int getSize() throws IllegalAccessError{
        throw new IllegalAccessError("You cannot access this method for the specified object");
    }

    public void evaluate(){
        boolean systemState = controlSystem.control(this);
        if(systemState){
            System.out.println("Numero di componenti guasti superiore al 40% \nAvvio startegia di riparazione...");
        }else System.out.println("Numero di componenti guasti inferiore al 40% \nAvvio startegia di notifica..." +
                "\nElenco dei componenti guasti:");
        setStrategy(systemState);
        abstractStrategy.resolve(this);
    }

    public void setStrategy(boolean state){
        if(!state){
            abstractStrategy = RepairStrategy.getInstance();
        }else abstractStrategy = NotifyStrategy.getInstance();
    }



}
