package icesi.johann.practicodosappsmoviles.model;

public class Register {

    private String group;

    private String hero;

    public Register(){

    }

    public Register(String group, String hero) {
        this.group = group;
        this.hero = hero;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public String getGroup() {
        return group;
    }

    public String getHero() {
        return hero;
    }
}
