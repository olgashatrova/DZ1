import java.util.Comparator;
import java.util.Date;
import java.util.regex.Pattern;

class User {
    private String name;
    private int age;
    private String id;
    private String email;
    private String password;
    private Date regDate;

    public User() {
    }

    public User(String name, int age, String id, String email, String password, Date regDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.email = email;
        this.password = password;
        this.regDate = regDate;
    }

    public void setName(String name) throws Exception {
        if (name.isEmpty() || name.equals("")) {
            throw new Exception("Имя не может быть пустым!");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) throws Exception {
        if (age >= 100) {
            throw new Exception("Вы уже должно быть мертвы! Вам больше 100 лет!");
        }
        if (age <= 0) {
            throw new Exception("Возраст введен некорректно! Возраст не может быть меньше нуля.");
        }
            this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setId(String id) throws Exception {
        char[] array = id.toCharArray();
        boolean matches = true;
        if (id.matches("[0-9]{5}")) {
            this.id = id;
            matches = false;
        } else {
            throw new Exception("ID должен содержать только пять цифр.");
        }
    }

    public String getId() {
        return id;
    }

    public void setEmail(String email) throws Exception {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if (email.matches(regex)) {
            this.email = email;
        } else {
            throw new Exception("Email введен некорректно.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) throws Exception {
        if (password.length() < 8) {
            throw new Exception("Пароль должен быть длиннее 8 символов.");
        } else {
            this.password = password;
        }
        boolean result = true;
        char[] array = password.toCharArray();
        for (char x : array) {
            if (Character.isUpperCase(x)) {
                result = false;
                this.password = password;
                break;
            } else {
                throw new Exception("Пароль должен содержать заглавную букву.");
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public void setRegDate(Date regDate) throws Exception {
        Date dateNow = new Date();
        regDate.compareTo(dateNow); //сравнивает дату regDate с dateNow.
        if (regDate.compareTo(dateNow) > 0) {
            throw new Exception("Дата регистрации не может быть больше текущего числа.");
        } else if (regDate.compareTo(dateNow) == 0) {
            this.regDate = regDate;
        } else {
            this.regDate = regDate;
        }
        /*Возвращает 0, если значения равны. Возвращает отрицательное значение,
        если объект вызова является более ранним, чем дата.
        Возвращает положительное значение, если объект вызова позже даты.*/
    }

    public Date getRegDate() {
        return regDate;
    }

    public String toString() {
        return "[Имя: " + this.name +
                ". Возраст: " + this.age +
                ". Email: " + this.email +
                ". Пароль: " + this.password +
                ". ID: " + this.id +
                ". Дата регистрации: " + this.regDate + "]";
    }

    public static Comparator<User> AgeComparator = new Comparator<User>() {
        public int compare(User o1, User o2) {
            return o1.getAge() - o2.getAge();
        }
    };

    public static Comparator<User> RegDateComparator = new Comparator<User>() {
        public int compare(User o1, User o2) {
            return o1.getRegDate().compareTo(o2.getRegDate());
        }

        ;
    };
}
