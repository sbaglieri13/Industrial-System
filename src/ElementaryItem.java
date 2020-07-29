public class ElementaryItem extends IndustrialSystem {

    private boolean state;
    private String name;

    public ElementaryItem(String name){
        this.name = name;
        this.state = true;
        new DigitalTwin(name, true,this);
    }

    public boolean isState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public void fail(){
        state = false;
        System.out.println("Il componente "+getName()+" adesso è guasto!");
        notify(this);
    }

    public void repair(){
        state = true;
        System.out.println("Il componente "+getName()+" è stato ripatato!");
        notify(this);
    }

}

