package prog;

public class Botanist extends Human {
    double moneyParent;
    int grade;
    String father_name;
    String name;
    String gender;
    int age;
//    Human human;



    public Botanist(Human human, String father_name, int grade) {

        this.age = human.age;
        this.gender = human.gender;
        this.name = human.name;
        this.grade = grade;
        this.father_name = father_name;
        this.moneyParent = Math.pow(10, this.grade);
    }

    public String toString() {
        String res = String.format("Это ботаник: возраст=%d, пол=%s, имя=%s, оценка=%d", this.age, this.gender, this.name, this.grade);
        return res;
    }

    public Great_parent createPair() {
        String GTO_name = this.father_name;
        Human human = new Human(GTO_name, this.gender, this.age + 20);
        return new Great_parent(human, "m", this.moneyParent);
    }
}