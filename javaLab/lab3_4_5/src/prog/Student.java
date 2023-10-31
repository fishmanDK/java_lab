package prog;

public class Student extends Human {
    int age;
    String name;
    String gender;
    String father_name;
    int grade;
    public Student(Human human,  String father_name, int grade){
        this.name = human.name;
        this.gender = human.gender;
        this.age = human.age;
        this.grade = grade;
        this.father_name = father_name;
    }

    public String toString() {
        String res = String.format("Это студент: age=%d, gender=%s, name=%s, grade=%d, у него нет карманных деняк :(", this.age, this.gender, this.name, this.grade);
        return res;
    }

    public Parent createPair() {
        String parentName = this.father_name;
        Human human = new Human(this.name, this.gender, this.age+ 20);
        return new Parent(human, parentName);
    }
}
