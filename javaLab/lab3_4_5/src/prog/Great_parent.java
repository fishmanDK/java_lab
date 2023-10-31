package prog;

public class Great_parent extends Human{
    int age;
    String name;
    String gender;
    String childName;
    long gradeChild;
    int resGradeChild;
    public double pocket_money;


    public Great_parent(Human human,  String childName, double pocket_money){
        this.name = human.name;
        this.gender = human.gender;
        this.age = human.age;
        this.childName = childName;
        this.pocket_money = pocket_money;
    }

    public String toString() {
        String res = String.format("Это GPO: age=%d, gender=%s, name=%s", this.age, this.gender, this.name);
        return res;
    }

    public Botanist сreatePair() {
        gradeChild = Math.round(Math.log10(this.pocket_money));
        if (gradeChild >= 5){
            resGradeChild = 5;
        }
        Human human = new Human(this.childName, this.gender, this.age-20);
        return new Botanist(human, this.name, resGradeChild);
    }
}
