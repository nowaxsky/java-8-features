package streamApi.basic;

import java.util.List;
import java.util.stream.Collectors;
import functionalInterface.builtIn.User;

public class BasicPractice2 {

  public static void main(String[] args) {

    List<User> users = User.createList();

    // �L�X�Ҧ��H�Ҧ���T
    users.stream().forEach(System.out::println);
    
    // �L�X�Ҧ��H���~��
    users.stream().map(User::getAge).forEach(System.out::println);
    
    // �`���Ҧ��H��ID�æs��List
    List<String> ids = users.stream().map(User::getId).peek(System.out::println).collect(Collectors.toList());
    
    // �`���Ҧ��~��>=18���H�æs��List
    List<User> adults = users.stream().filter(u -> u.getAge() >= 18).peek(System.out::println).collect(Collectors.toList());
    
    // �`���Ҧ��~��>=18���H��id�æs��List
    List<String> adultIds = users.stream().filter(u -> u.getAge() >= 18).map(User::getName).peek(System.out::println).collect(Collectors.toList());

  }
}
