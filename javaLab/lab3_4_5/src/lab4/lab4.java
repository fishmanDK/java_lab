package lab4;

import prog.Human;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class lab4 {
//    int N;
    public Logger logger;
    public Level level;
    public lab4(Logger logger, Level level){
        this.logger = logger;
        this.level = level;
    }

    public double[] arrayList(int count, double[] data) {
        logger_lab4 loggerLab4 = new logger_lab4(this.logger, this.level);

        loggerLab4.log("Start program");
        loggerLab4.log("ArrayList");

        ArrayList<Human> arr = new ArrayList<>();

        double unitOfTime = 1.0;

        long totalTime = System.nanoTime();
        long sr_Time = 0;
        for (int j = 1; j <= count; j++){
            long startTime = System.nanoTime();

            Human human = new Human();
            human.gender = generateGender();
            human.age = generateAge();
            human.name = generateName();
            arr.add(human);

            long endTime = System.nanoTime();
            double createHumanTime = (endTime - startTime) / unitOfTime;
            String srt_add = String.format("add, ind-%d:  %.3f ArrayList", j, createHumanTime);
            loggerLab4.log(srt_add);

//            if (j == arr.size()) {
//                int oldCapacity = arr.size();
//                int newCapacity = (oldCapacity * 3) / 2 + 1;
//                arr.ensureCapacity(newCapacity);
//            }

//            List<Long> arrayListAddTimes = new ArrayList<>();
//            for (double d : arr) {
//                arrayListAddTimes.add((long) d);
//            }

            sr_Time += endTime - startTime;

            data[j-1] = createHumanTime;
        }

        long end_totalTime = System.nanoTime();
        String srt_totalTime = String.format("totalTime: %.3f ArrayList", (end_totalTime - totalTime) / unitOfTime);
        loggerLab4.log(srt_totalTime);


        long startTime = System.nanoTime();
        int countRemove = (count / 100) * 10;
        for (int i = 1; i <= countRemove; i++){
            Random rn = new Random();
            int randomInd = rn.nextInt(arr.size() - 0 + 1) + 0;
            arr.remove(randomInd);
        }
        long endTime = System.nanoTime();
        String srt_remove_Time = String.format("remove ArrayList: %.3f", (endTime - startTime) / unitOfTime);
        loggerLab4.log(srt_remove_Time);


        String str_ArrayList = String.format("srTime ArrayList: %.3f", (sr_Time/count) / unitOfTime);
        loggerLab4.log(str_ArrayList);

        return data;
    }


    public double[] hashMap(int count, double[] data) {
        HashMap<Integer, Human> map = new HashMap<Integer, Human>();

        logger_lab4 loggerLab4 = new logger_lab4(this.logger, this.level);

        loggerLab4.log("Start program");
        loggerLab4.log("ArrayList");

        double unitOfTime = 1.0;

        long totalTime = System.nanoTime();
        long sr_Time = 0;
        for (int j = 1; j <= count; j++){
            long startTime = System.nanoTime();

            Human human = new Human();

            human.gender = generateGender();
            human.age = generateAge();
            human.name = generateName();
            map.put(j, human);

            long endTime = System.nanoTime();
            double createHumanTime = (endTime - startTime) / unitOfTime;
            String srt_add = String.format("add, ind-%d:  %.3f HashMap", j, createHumanTime);
            loggerLab4.log(srt_add);

            sr_Time += endTime - startTime;

            data[j-1] = createHumanTime;
        }

        long end_totalTime = System.nanoTime();
        String srt_totalTime = String.format("totalTime: %.3f HashMap", (end_totalTime - totalTime) / unitOfTime);
        loggerLab4.log(srt_totalTime);


        long startTime = System.nanoTime();
        int countRemove = (count / 100) * 10;
        for (int i = 1; i <= countRemove; i++){
            Random rn = new Random();
            int randomInd = rn.nextInt(map.size() - 0 + 1) + 0;
            map.remove(randomInd);
        }
        long endTime = System.nanoTime();
        String srt_remove_Time = String.format("remove ArrayList: %.3f HashMap", (endTime - startTime) / unitOfTime);
        loggerLab4.log(srt_remove_Time);


        String str_ArrayList = String.format("srTime: %.3f HashMap", (sr_Time/count) / unitOfTime);
        loggerLab4.log(str_ArrayList);

        return data;
    }

    static String generateName(){
        Random rand = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = rand.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }


    static int generateAge(){
        double randomNum = Math.random() * 40 + 20;
        int randomInt = (int) randomNum;
        return randomInt;
    }

    static String generateGender(){
        Random rand = new Random();
        int randomGender = rand.nextInt(2);
        String randomString;
        if (randomGender == 0) {
            return "m";
        } else {
            return "w";
        }
    }
}
