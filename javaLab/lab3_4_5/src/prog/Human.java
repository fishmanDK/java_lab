package prog;

public class Human {
//    public int grade = 0;
public String name;
        public String gender;
        public int age;

    public Human() {
        // default constructor
    }
        public Human(String name, String gender, int age){
            this.name = name;
            this.gender = gender;
            this.age = age;
        }
    public String toString(){
            String str = String.format("Human: name:%s, gender: %s, age: %d", this.name, this.gender, this.age);
            return str;
    }
}
