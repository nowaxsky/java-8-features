package streamApi.advanced;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import functionalInterface.builtIn.Gender;
import functionalInterface.builtIn.User;

public class AdvancedPractice {

  public static void main(String[] args) {
    List<User> users = User.createList();

    // 計算總共有多少人
    long count = users.stream().count();
    System.out.println("How many users? " + count);

    // 計算所有人年齡總和
    int sum = users.stream().mapToInt(User::getAge).sum();
    System.out.println("Sum age of all users= " + sum);

    // 計算所有人年齡平均數
    OptionalDouble average = users.stream().mapToInt(User::getAge).average();
    System.out.println("Average age of all users= " + average.getAsDouble());

    // 找出所有人中最小的年齡
    OptionalInt min = users.stream().mapToInt(User::getAge).min();
    System.out.println("Minimal age of all users= " + min.getAsInt());

    // 找出年齡最大和最小的人
    Optional<User> eldest = users.stream().max(Comparator.comparing(User::getAge));
    System.out.println("The eldest user: " + eldest.get());

    Optional<User> youngest = users.stream().min(Comparator.comparing(User::getAge));
    System.out.println("The youngest user: " + youngest.get());

    // 依性別做分類
    Map<Gender, List<User>> genderGroupBy =
        users.stream().collect(Collectors.groupingBy(User::getGender));
    genderGroupBy.forEach((g, u) -> System.out
        .println(g + ":\t" + u.stream().map(User::getName).collect(Collectors.joining(", "))));

    // 依是否為女生來做分類
    Map<Boolean, List<User>> genderPartitionBy =
        users.stream().collect(Collectors.partitioningBy(u -> u.getGender() == Gender.F));
    genderPartitionBy.forEach((b, u) -> System.out
        .println(b + ":\t" + u.stream().map(User::getName).collect(Collectors.joining(", "))));

    // 依性別來做分類並以UserBrief物件蒐集
    Map<Gender, List<UserBrief>> collect =
        users.stream().collect(Collectors.groupingBy(User::getGender,
            Collectors.mapping(u -> new UserBrief(u.getName(), u.getAge()), Collectors.toList())));
    collect.forEach((g, u) -> System.out
        .println(g + ":\t" + u.stream().map(UserBrief::getName).collect(Collectors.joining(", "))));

    // 將所有人的名字連結成一個字串並輸出
    String nameJoining = users.stream().map(User::getName).collect(Collectors.joining(""));
    System.out.println("Joining every name: " + nameJoining);

    // 將所有人的年齡轉換為Double並計算平均數
    Double average2 = users.stream().collect(Collectors.averagingDouble(User::getAge));

    // 請依年齡由大至小進行排序
    users.stream().sorted(Comparator.comparing(User::getAge).reversed())
        .forEach(System.out::println);

    // 請先依姓名排序後再以年齡由小至大排序
    users.stream().sorted(Comparator.comparing(User::getName).thenComparing(User::getAge))
        .forEach(System.out::println);;

    // 是否所有人的名字中均有b這個字母?
    boolean allMatch = users.stream().allMatch(u -> u.getName().contains("b"));

    // 是否有任一個人的名字為Annie?
    boolean anyMatch = users.stream().anyMatch(u -> u.getName().equals("Annie"));
  }

}
