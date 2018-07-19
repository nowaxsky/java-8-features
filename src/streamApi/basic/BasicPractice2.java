package streamApi.basic;

import java.util.List;
import java.util.stream.Collectors;
import functionalInterface.builtIn.User;

public class BasicPractice2 {

  public static void main(String[] args) {

    List<User> users = User.createList();

    // 印出所有人所有資訊
    users.stream().forEach(System.out::println);
    
    // 印出所有人的年齡
    users.stream().map(User::getAge).forEach(System.out::println);
    
    // 蒐集所有人的ID並存成List
    List<String> ids = users.stream().map(User::getId).peek(System.out::println).collect(Collectors.toList());
    
    // 蒐集所有年齡>=18的人並存成List
    List<User> adults = users.stream().filter(u -> u.getAge() >= 18).peek(System.out::println).collect(Collectors.toList());
    
    // 蒐集所有年齡>=18的人的id並存成List
    List<String> adultIds = users.stream().filter(u -> u.getAge() >= 18).map(User::getName).peek(System.out::println).collect(Collectors.toList());

  }
}
