package tests;

import org.junit.Assert;
import org.junit.Test;
import prog.Botanist;
import prog.Great_parent;
import prog.Human;

public class Great_parentTest {
    public String name;
    public String gender;
    public String childName;
    public int age;
    public int pocket_money;


    @Test
    public void сreatePair(){
        Human human_greatParent = new Human("Dmitry", "m", 39);
        Great_parent greatParent = new Great_parent(human_greatParent, "Ivan", 100000000);

        Human human_botanist = new Human("Ivan", "m", 19);
        Botanist botanist = new Botanist(human_botanist, "Dmitry", 5);

        Botanist compare_botanist = greatParent.сreatePair();
        String str = "Это ботаник: возраст=19, пол=m, имя=Ivan, оценка=5";

        Assert.assertEquals(str, compare_botanist.toString());

    }

}
