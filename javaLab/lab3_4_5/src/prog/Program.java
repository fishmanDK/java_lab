package prog;

public class Program {
    public static void Start() {
        prog.Human human_student1 = new Human("Denis", "m", 18);
        prog.Student student1 = new prog.Student(human_student1, "Onizuka",  5);
        prog.Parent parent1 = student1.createPair();
        System.out.println(parent1.toString());
        System.out.println(student1.toString());

        System.out.println();

        prog.Human human_parent2 = new Human("Dora", "w", 40);
        prog.Parent parent2 = new prog.Parent(human_parent2, "Denis");
        prog.Student student2 = parent2.сreatePair();
        System.out.println(student2.toString());
        System.out.println(parent2.toString());

        System.out.println();

        prog.Human human_botanist1 = new Human("Stas", "m", 20);
        prog.Botanist botanist1 = new prog.Botanist(human_botanist1, "Oleg", 5);
        prog.Great_parent greatParent1 = botanist1.createPair();
        System.out.println(botanist1.toString());
        System.out.println(greatParent1.toString());
        String formattedMoney = String.format("количество денег у крутого родителя: %.2f", greatParent1.pocket_money);
        System.out.println(formattedMoney);

        System.out.println();

        prog.Human human_greatParent2 = new Human("Dmitry", "m",  39);
        prog.Great_parent greatParent2 = new prog.Great_parent(human_greatParent2, "Ivan", 100000000);
        prog.Botanist botanist2 = greatParent2.сreatePair();
        System.out.println(greatParent2.toString());
        System.out.println(botanist2.toString());
        String formattedGrade = String.format("оценка у ботаника: %d", botanist2.grade);
        System.out.println(formattedGrade);
    }
}
