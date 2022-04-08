package lesson15;

import java.util.*;

public class MapLesson {
    public static void main(String[] args) {
        // коллекции
        // элемент1
        // элемент2
        // элемент3
        // элемент4

        // мапы
        // ключ1 - элемент1
        // ключ2 - элемент2
        // ключ3 - элемент3
        // ключ4 - элемент4

        // Map хранят данные в парах ключ - значение
        // Особенности map:
        // 1. ключи мапы должны быть уникальны
        // 2. каждому ключу соответствует только одно значение
        // 3. Map не являются коллекциями

        // наиболее популярные HashMap<K, V>, TreeMap<K, V>, EnumMap<K, V>, LinkedHashMap<K, V>

        // Особенности HashMap:
        // 1. хранит ключи в hash таблице (на основе hash кода)
        // 2. equals и hashCode
        // 2. обладает хорошей производительностью
        // 3. в качестве ключа можно использовать null
        // 4. порядок хранения элементов может отличаться от порядка добавления

        // создание экземпляра HashMap:
        // в <> сначала указываем типа данных ключей, затем тип данных значений
        HashMap<String, Integer> hashMap = new HashMap<>();

        // добавление элементов
        hashMap.put("Москва", 790);
        hashMap.put("Ростов", 270);
        hashMap.put("Великий Новгород", 75);
        hashMap.put("Тверь", 12);
        hashMap.put(null, null);
        System.out.println(hashMap);

        // удаление пары
        hashMap.remove(null); // по ключу
        hashMap.remove("Москва", 5); // по ключу и значению
        hashMap.remove("Ростов", 270); // по ключу и значению
        System.out.println(hashMap);

        // замена
        hashMap.replace("Великий Новгород", 100); // по ключу
        hashMap.replace("Тверь", 12, 22); // по ключу и значению
        System.out.println(hashMap);

        // получение
        System.out.println(hashMap.get("Тверь"));
        System.out.println(hashMap.get("Москва"));
        // если ключ не найден, вернет значение по умолчанию
        System.out.println(hashMap.getOrDefault("Санкт-Петербург", 0));
        System.out.println(hashMap.getOrDefault("Великий Новгород", 0));

        // проверить, содержится ли в мапе ключ
        System.out.println(hashMap.containsKey("Санкт-Петербург")); // false
        // проверить, содержится ли в мапе значение
        System.out.println(hashMap.containsValue(1000)); // false

        System.out.println("---Перебор мап---");
        // hashMap.keySet(); - только ключи (Set)
        // hashMap.values(); - только значения (Collection)
        for (Map.Entry<String, Integer> pair: hashMap.entrySet()){
            System.out.println("город (ключ): " + pair.getKey());
            System.out.println("количество покупателей (значение): " + pair.getValue());
        }
        // hashMap.keySet(); // только ключи (Set)
        // hashMap.values(); // только значения (Collection)
        // hashMap.entrySet(); // ключи + значения (Map.Entry)


        // TODO: ЗАДАЧИ
        //  1. Создать несколько экземпляров класса User с повторяющимися значениями свойства age
        User user1 = new User("a", "a1", Role.ADMIN, 18);
        User user2 = new User("b", "b1", Role.USER, 22);
        User user3 = new User("c", "c1", Role.USER, 22);
        User user4 = new User("d", "d1", Role.USER, 44);
        User user5 = new User("f", "f1", Role.ADMIN, 18);

        //  2. Создать HashMap, где ключи - логины пользователей,
        //  значения - экземпляры класса User
        HashMap<String, User> userHashMap = new HashMap<>();

        //  3. Добавить данные
        userHashMap.put(user1.getLogin(), user1); // Entry(key, value)
        userHashMap.put(user2.getLogin(), user2); // Entry(key, value)
        userHashMap.put(user3.getLogin(), user3); // Entry(key, value)
        userHashMap.put(user4.getLogin(), user4); // Entry(key, value)
        userHashMap.put(user5.getLogin(), user5); // Entry(key, value)

        //  4. Логины всех пользователей, старше 20 лет скопировать в отдельный List
        ArrayList<String> logins = new ArrayList<>();
        for (Map.Entry<String, User> pair : userHashMap.entrySet()) {
            if (pair.getValue().getAge() > 20) {
                logins.add(pair.getKey());
            }
        }

        //  5. Вывести логины и пароли пользователей с ролью ADMIN
        for (User user : userHashMap.values()) {
            if (user.getRole() == Role.ADMIN) {
                System.out.println(user.getLogin());
                System.out.println(user.getPwd());
            }
        }

        //  6. На основе существующей мапы создать новую, где ключи - возраст пользователей
        //  значения - списки пользователей соответствующего возраста
        HashMap<Integer, ArrayList<User>> ageMap = new HashMap<>();
        for (User user : userHashMap.values()) {
            if (!ageMap.containsKey(user.getAge())) {
                ArrayList<User> users = new ArrayList<>();
                users.add(user);
                ageMap.put(user.getAge(), users);
            } else {
                ageMap.get(user.getAge()).add(user);
            }
        }

        // LinkedHashMap аналогична HashMap, но позволяет сохранять
        //порядок элементов (из-за чего менее производительна, чем HashMap)

        // Особенности EnumMap:
        // 1. использует перечисления (enum - перечисление) в качестве ключей
        // 2. нельзя использовать null в качестве ключа
        // 3. все ключи должны быть одного типа перечисления
        // 4. все значения содержит в массиве (размер массива - количество элементов перечисления)
        // 5. порядок хранения элементов соответствует порядку элементов enum
        // 6. для извлечения значений использует индекс ключа: vals[key.ordinal()]

        // при создании объекта в конструктор необходимо передать ссылку на класс перечисления,
        // например, Role.class
        EnumMap<Role, String> map = new EnumMap<>(Role.class);
        map.put(Role.ADMIN, "Администратор");
        map.put(Role.USER, "Пользователь");
        // values = ["Пользователь", "Администратор"]
        map.get(Role.ADMIN); // "Администратор"
        // values[Role.ADMIN.ordinal()]

        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);
        ArrayList<User> admins = new ArrayList<>(Arrays.asList(user1, user5));
        ArrayList<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user3);
        users.add(user4);


        // TODO: ЗАДАЧИ
        // 1. Создать несколько экземпляров класса User
        // 2. Создать EnumMap, где ключи - роли, значения - списки пользователей
        // 3. Добавить данные в мапу
        enumMap.put(Role.ADMIN, admins);
        enumMap.put(Role.USER, users);
        // 4. Вывести в консоль логины всех пользователей с ролью USER
        for (User user : enumMap.get(Role.USER)) {
            System.out.println(user.getLogin());
        }
        // 5. Создать еще один экземпляр класса User, добавить его в мапу,
        // представляя, что роль пользователя Вам неизвестна
        User user6 = new User("z", "z1", Role.ADMIN, 33);
        Role userRole = user6.getRole();
        ArrayList<User> usersFromMap = enumMap.get(userRole);
        usersFromMap.add(user6);

        enumMap.get(user6.getRole()).add(user6);

        // Особенности TreeMap:
        // 1. хранит элементы в отсортированном по ключам порядке
        // 2. основан на красно-черном дереве
        // 3. null нельзя использовать в качестве ключей
        // 4. класс, объекты которого будут использоваться в качестве ключей
        // должен реализовывать интерфейс Comparable
        // или в конструктор мапы необходимо передать Comparator

        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
        treeMap.put("Анапа", 45);

        System.out.println(treeMap);
    }
}
