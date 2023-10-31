package prog;

public class Parent extends Human{
    int age;
    String name;
    String gender;
    String childName;

    public Parent(Human human, String childName){
        this.name = human.name;
        this.gender = human.gender;
        this.age = human.age;
        this.childName = childName;
    }

    public String toString() {
        String res = String.format("Это родитель: age=%d, gender=%s, name=%s, он не дает деньги бедному студенту :(", this.age, this.gender, this.name);
        return res;
    }

    public Student сreatePair() {
        String studentName = this.childName;
        Human human = new Human(studentName, this.gender, this.age - 20);
        return new Student(human, this.name, 5);
    }
}
