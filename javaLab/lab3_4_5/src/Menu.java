import lab4.lab4;
import lab5.DrawGraphic;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import prog.Program;
import tests.Great_parentTest;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {

    public Logger logger;
    public Level level;
    public String autoTest;
    public Menu(Logger logger, Level level, String autoTest){
        this.logger = logger;
        this.level = level;
        this.autoTest = autoTest;
    }
    public boolean debugging;
    public User user;

    public void Start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input login: ");
        String login = scanner.nextLine();
        System.out.println("Input password: ");
        String password = scanner.nextLine();

        Db db = new Db();

        this.user = db.Check(login, password);
        this.debugging = false;

        if (this.user != null){
            String str = String.format("Добро пожаловать %s", this.user.name);
            System.out.println(str);
            while (true){
                if (Objects.equals(this.user.role, "root")){
                    boolean ok = RootUser(db);
                    if (!ok){break;}
                } else {
                    boolean ok = OrdinaryUser(db);
                    if (!ok){break;}
                }
            }
        } else {
            logger.info("ошибка входа в систему");
        }
    }

    private boolean RootUser(Db db){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1) Запуск основной программы");
        System.out.println("2) Создать пользователя");
        System.out.println("3) Отладка");
        System.out.println("4) Автотесты");
        System.out.println("5) Завершить");
        System.out.println("6) Lab 5");


        System.out.println("Выбирите опцию");
        String choice = scanner.nextLine();

        switch (choice){
            case "1":
                Program prog = new Program();
                prog.Start();
                return true;
            case "2":
                System.out.println("Какое количество пользователей вы хотите добвить");
                int val = scanner.nextInt();
                scanner.nextLine();
                for (int i = 1; i <= val; i++){
                    String str = String.format("%d-й пользователь:", i);
                    System.out.println(str);
                    System.out.println("Введите имя пользователя: ");
                    String name = scanner.nextLine();
                    System.out.println("Введите пороль пользователя: ");
                    String password = scanner.nextLine();

                    String role = "";
                    while (true){
                        System.out.println("Введите роль пользователя: ");
                        role = scanner.nextLine();
                        if (Objects.equals(role, "root") || Objects.equals(role, "user")){
                            break;
                        } else {
                            System.out.print(" -> Роль должен быть: 'user' или 'root'\n");
                        }
                    }

                    User user = new User(name, password, role);
                    db.CreateUser(user);
                }
                if (this.debugging){
                    String str = String.format("Пользователь %s создал %d новых учетных записей.", this.user.name, val);
                    logger.log(this.level, str);
                }
                return true;
            case "3":
                this.debugging = !this.debugging;
                if (debugging){
                    System.out.println("Отладка запущенна");
                } else {
                    System.out.println("Отладка выключенна");
                }
                return true;
            case "4":
                if (Objects.equals(this.autoTest, "true")){
                    Result result = JUnitCore.runClasses(Great_parentTest.class);
                    for (Failure failure : result.getFailures()) {
                        System.out.println(failure.toString());
                    }
                    System.out.println(result.wasSuccessful());
                } else {
                    System.out.println("Тесты не доступны");
                }
                return true;
            case "5":
                return false;
            case "6":
                lab4 lab4 = new lab4(this.logger, this.level);

                int[] arr = {10, 100};
//                int[] arr = {10, 100, 1000, 10000, 100000};
                for (int i : arr){
                    double[] arr_graphic = new double[i];
                    double[] data_arr = lab4.arrayList(i, arr_graphic);
                    double[] data_map = lab4.hashMap(10, arr_graphic);
                    System.out.println(data_arr.length);
                    System.out.println(data_map.length);

                    double[] slice = Arrays.copyOfRange(data_arr, 1, data_arr.length);

                    String str_arr = String.format("Array: %d", i);
                    new DrawGraphic(slice, str_arr);
                    System.out.println("нажмите на кнопку чтобы продолжить");
                    scanner.nextLine();;

                    String str_map = String.format("HashMap: %d", i);
                    new DrawGraphic(data_map, str_map);
                    System.out.println("нажмите на кнопку чтобы продолжить");
                    scanner.nextLine();
                }
                return true;
            default:
                System.out.println("Данной команды не существует");
                return true;
        }
    }

    private static boolean OrdinaryUser(Db db){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1) Запуск основной программы");
        System.out.println("2) Создать пользователя");
        System.out.println("3) Завершить");

        System.out.println("Выбирите опцию");
        String choice = scanner.nextLine();

        switch (choice){
            case "1":
                Program prog = new Program();
                prog.Start();
                return true;
            case "2":
                System.out.println("Какое количество пользователей вы хотите добвить");
                int val = scanner.nextInt();
                scanner.nextLine();
                for (int i = 1; i <= val; i++){
                    String str = String.format("%d-й пользователь:", i);
                    System.out.println(str);
                    System.out.println("Введите имя пользователя: ");
                    String name = scanner.nextLine();
                    System.out.println("Введите пороль пользователя: ");
                    String password = scanner.nextLine();

                    String role = "";
                    while (true){
                        System.out.println("Введите роль пользователя: ");
                        role = scanner.nextLine();
                        if (Objects.equals(role, "root") || Objects.equals(role, "user")){
                            break;
                        } else {
                            System.out.print(" -> Роль должен быть: 'user' или 'root'\n");
                        }
                    }

                    User user = new User(name, password, role);
                    db.CreateUser(user);
                }
                return true;
            case "3":
                return false;
            default:
                System.out.println("Данной команды не существует");
                return true;
        }
    }
}
