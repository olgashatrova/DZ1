import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Console {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        User[] allUsers = new User[10];

        allUsers[0] = new User();
        allUsers[1] = new User("Максим", 27, "00001", "max@mail.ru", "MaxSuper", sdf.parse("25-12-2021"));
        allUsers[2] = new User("Оксана", 18, "00008", "oxana@mail.ru", "OxanaSuper", sdf.parse("11-07-2021"));
        allUsers[3] = new User("Олег", 45, "00002", "oleg@mail.ru", "OlegSuper", sdf.parse("01-12-2021"));
        allUsers[4] = new User("Алексей", 28, "00003", "alexey@mail.ru", "AlexeySuper", sdf.parse("03-11-2021"));
        allUsers[5] = new User("Марина", 18, "00004", "marina@mail.ru", "MarinaSuper", sdf.parse("15-05-2021"));
        allUsers[6] = new User("Алсу", 36, "00005", "alsu@mail.ru", "AlsuSuper", sdf.parse("26-07-2021"));
        allUsers[7] = new User("Карина", 42, "00005", "karina@mail.ru", "KarinaSuper", sdf.parse("12-11-2021"));
        allUsers[8] = new User("Сергей", 27, "00006", "sergei@mail.ru", "SergeiSuper", sdf.parse("01-02-2021"));
        allUsers[9] = new User("Александр", 51, "00007", "alex@mail.ru", "AlexSuper", sdf.parse("09-07-2021"));

        System.out.println("Вам надо зарегестрироваться!");
        while (true) {
            try {
                allUsers[0].setName(parseString("Введите ваше имя"));
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        while (true){
            try{
                allUsers[0].setAge(parseInt("Введите ваш возраст"));
                break;
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }

        while (true){
            try{
                allUsers[0].setEmail(parseString("Введите ваш Email"));
                break;
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }

        while (true){
            try{
                allUsers[0].setPassword(parseString("Введите ваш пароль"));
                break;
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }

        while (true) {
            try{
                allUsers[0].setId(parseString("Введите ваш ID"));
                break;
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        while (true) {
            try{
                System.out.println("Введите дату регистрации в формате дд-мм-гггг");
                allUsers[0].setRegDate(formater.parse(scanner.nextLine()));
                break;
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }

        System.out.println(allUsers[0].getName() + ", Вы зарегистрированы! ");
        System.out.println("Всего в базе 10 пользователей. ");

        System.out.println("Что вы хотите сделать со списком пользователей?");
        System.out.println("1. Сортировка по возрасту");
        System.out.println("2. Сортировка по дате регистрации");
        System.out.println("3. Поиск по имени");
        System.out.println("4. Поиск по Email");

        int i = scanner.nextInt();
        switch (i) {
            case (1):
                Arrays.sort(allUsers, User.AgeComparator);
                System.out.println("Сортировка по возрасту " + Arrays.toString(allUsers));
                break;
            case (2):
                Arrays.sort(allUsers, User.RegDateComparator);
                System.out.println("Сортировка по дате регистрации: " + Arrays.toString(allUsers));
                break;
            case(3):
                System.out.println("Введите имя пользователя, которого хотите найти");
                boolean foundCheck = false;
                while (!foundCheck) {
                    scanner.nextLine();
                    String searchName = scanner.next();
                    for (User user : allUsers) {
                        if (user.getName().equals(searchName)) {
                            foundCheck = true;
                            System.out.println("Вы нашли пользователя " + user);
                            break;
                        }
                    }
                    if (!foundCheck) {
                        System.out.println("Пользователь с таким именем не найден. Попробуйте еще раз.");
                    }
                }
                break;
            case (4):
                System.out.println("Введите Email пользователя, которого хотите найти");
                boolean foundCheck1 = false;
                while (!foundCheck1) {
                    scanner.nextLine();
                    String searchEmail = scanner.next();
                    for (User user : allUsers) {
                        if (user.getEmail().equals(searchEmail)) {
                            foundCheck1 = true;
                            System.out.println("Вы нашли пользователя " + user);
                            break;
                        }
                    }
                    if (!foundCheck1) {
                        System.out.println("Пользователь с таким именем не найден. Попробуйте еще раз.");
                    }
                }
                break;
        }
    }

    private static String parseString(String inputMessage) {
        boolean incorrectInputFlag = true;
        String input = "Данные не считаны.";
        while (incorrectInputFlag) {
            try {
                System.out.println(inputMessage);
                input = scanner.next();
                scanner.nextLine();
                incorrectInputFlag = false;
                return input;
            } catch (Exception e) {
                System.err.println(e.getMessage());
                scanner.nextLine();
            }
        }
        return input;
    }

    private static Integer parseInt(String inputMessage) {
        boolean incorrectInputFlag = true;
        int input = 0;
        while (incorrectInputFlag) {
            try {
                System.out.println(inputMessage);
                input = scanner.nextInt();
                scanner.nextLine();
                incorrectInputFlag = false;
            } catch (Exception e) {
                System.err.println("Введено не число!");
                scanner.nextLine();
            }
        }
        return input;
    }
}
