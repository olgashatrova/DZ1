import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        User[] allUsers = new User[10];
        allUsers [0] = new User();
        allUsers[1] = new User("Максим", 27, "00001", "max@mail.ru", "MaxSuper", sdf.parse("25-12-2021"));
        allUsers[2] = new User("Оксана", 18, "00008", "oxana@mail.ru", "OxanaSuper", sdf.parse("11-07-2021"));
        allUsers[3] = new User("Олег", 45, "00002", "oleg@mail.ru", "OlegSuper", sdf.parse("01-12-2021"));
        allUsers[4] = new User("Алексей", 28, "00003", "alexey@mail.ru", "AlexeySuper", sdf.parse("03-11-2021"));
        allUsers[5] = new User("Марина", 18, "00004", "marina@mail.ru", "MarinaSuper", sdf.parse("15-05-2021"));
        allUsers[6] = new User("Алсу", 36, "00005", "alsu@mail.ru", "AlsuSuper", sdf.parse("26-07-2021"));
        allUsers[7] = new User("Карина", 42, "00005", "karina@mail.ru", "KarinaSuper", sdf.parse("12-11-2021"));
        allUsers[8] = new User("Сергей", 27, "00006", "sergei@mail.ru", "SergeiSuper", sdf.parse("01-02-2021"));
        allUsers[9] = new User("Александр", 51, "00007", "alex@mail.ru", "AlexSuper", sdf.parse("09-07-2021"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Вам надо зарегестрироваться!");

        boolean checkName = true;
        while (checkName){
            try {
                System.out.println("Введите ваше имя");
                allUsers[0].setName(scanner.next());
                scanner.nextLine();
                checkName=false;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        boolean checkAge = true;
        while (checkAge){
            try {
                System.out.println("Введите ваш возраст");
                allUsers[0].setAge(scanner.nextInt());
                scanner.nextLine();
                checkAge=false;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        boolean checkEmail = true;
        while (checkEmail){
            try {
                System.out.println("Введите ваш Email");
                allUsers [0].setEmail(scanner.next());
                scanner.nextLine();
                checkEmail=false;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        boolean checkPassword = true;
        while (checkPassword){
            try {
                System.out.println("Введите ваш пароль");
                allUsers [0].setPassword(scanner.next());
                scanner.nextLine();
                checkPassword=false;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        boolean checkID = true;
        while (checkID){
            try {
                System.out.println("Введите ваш ID");
                allUsers [0].setId(scanner.next());
                scanner.nextLine();
                checkID=false;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        boolean checkDate = true;
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        while (checkDate){
            try {
                System.out.println("Введите дату регистрации в формате дд-мм-гггг");
                allUsers [0].setRegDate(formater.parse(scanner.nextLine()));
                checkDate = false;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        System.out.println(allUsers [0].getName()+", Вы зарегистрированы! ");
        System.out.println("Всего в базе 10 пользователей. ");

        System.out.println("Что вы хотите сделать со списком пользователей?");
        System.out.println("1. Сортировка по возрасту");
        System.out.println("2. Сортировка по дате регистрации");
        System.out.println("3. Поиск по имени");
        System.out.println("4. Поиск по Email");

        int i = scanner.nextInt();
        if (i == 1) {
            Arrays.sort(allUsers, User.AgeComparator);
            System.out.println("Сортировка по возрасту " + Arrays.toString(allUsers));
        } else if (i == 2) {
            Arrays.sort(allUsers, User.RegDateComparator);
            System.out.println("Сортировка по дате регистрации: " + Arrays.toString(allUsers));
        } else if (i == 3) {
            System.out.println("Введите имя пользователя, которого хотите найти");
            boolean foundCheck = false;
            while (!foundCheck){
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
        } else if (i == 4) {
            System.out.println("Введите Email пользователя, которого хотите найти");
            boolean foundCheck = false;
            while (!foundCheck){
                scanner.nextLine();
                String searchEmail = scanner.next();
                for (User user : allUsers) {
                    if (user.getEmail().equals(searchEmail)) {
                        foundCheck = true;
                        System.out.println("Вы нашли пользователя " + user);
                        break;
                    }
                }
                if (!foundCheck) {
                    System.out.println("Пользователь с таким именем не найден. Попробуйте еще раз.");
                }
            }
        }
    }
}

