public class DigitalTwin implements Observer {

    private String name;
    private boolean state;
    private ElementaryItem physicalTwin;

    public DigitalTwin(String name, boolean state, ElementaryItem ei){
        this.name = name+"Twin";
        this.state = state;
        physicalTwin = ei;
        ei.attach(this);
    }

    public String getName() {
        return name;
    }

    public boolean isState() {
        return state;
    }

    @Override
    public void update(IndustrialSystem is) {
        if(is==physicalTwin){
            System.out.println(name+" ha ricevuto notifica!");
            this.state = physicalTwin.isState();
        }
    }

}
