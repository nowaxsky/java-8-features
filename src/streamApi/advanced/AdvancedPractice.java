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

    // �p���`�@���h�֤H
    long count = users.stream().count();
    System.out.println("How many users? " + count);

    // �p��Ҧ��H�~���`�M
    int sum = users.stream().mapToInt(User::getAge).sum();
    System.out.println("Sum age of all users= " + sum);

    // �p��Ҧ��H�~�֥�����
    OptionalDouble average = users.stream().mapToInt(User::getAge).average();
    System.out.println("Average age of all users= " + average.getAsDouble());

    // ��X�Ҧ��H���̤p���~��
    OptionalInt min = users.stream().mapToInt(User::getAge).min();
    System.out.println("Minimal age of all users= " + min.getAsInt());

    // ��X�~�ֳ̤j�M�̤p���H
    Optional<User> eldest = users.stream().max(Comparator.comparing(User::getAge));
    System.out.println("The eldest user: " + eldest.get());

    Optional<User> youngest = users.stream().min(Comparator.comparing(User::getAge));
    System.out.println("The youngest user: " + youngest.get());

    // �̩ʧO������
    Map<Gender, List<User>> genderGroupBy =
        users.stream().collect(Collectors.groupingBy(User::getGender));
    genderGroupBy.forEach((g, u) -> System.out
        .println(g + ":\t" + u.stream().map(User::getName).collect(Collectors.joining(", "))));

    // �̬O�_���k�ͨӰ�����
    Map<Boolean, List<User>> genderPartitionBy =
        users.stream().collect(Collectors.partitioningBy(u -> u.getGender() == Gender.F));
    genderPartitionBy.forEach((b, u) -> System.out
        .println(b + ":\t" + u.stream().map(User::getName).collect(Collectors.joining(", "))));

    // �̩ʧO�Ӱ������åHUserBrief����`��
    Map<Gender, List<UserBrief>> collect =
        users.stream().collect(Collectors.groupingBy(User::getGender,
            Collectors.mapping(u -> new UserBrief(u.getName(), u.getAge()), Collectors.toList())));
    collect.forEach((g, u) -> System.out
        .println(g + ":\t" + u.stream().map(UserBrief::getName).collect(Collectors.joining(", "))));

    // �N�Ҧ��H���W�r�s�����@�Ӧr��ÿ�X
    String nameJoining = users.stream().map(User::getName).collect(Collectors.joining(""));
    System.out.println("Joining every name: " + nameJoining);

    // �N�Ҧ��H���~���ഫ��Double�íp�⥭����
    Double average2 = users.stream().collect(Collectors.averagingDouble(User::getAge));

    // �Ш̦~�֥Ѥj�ܤp�i��Ƨ�
    users.stream().sorted(Comparator.comparing(User::getAge).reversed())
        .forEach(System.out::println);

    // �Х��̩m�W�Ƨǫ�A�H�~�֥Ѥp�ܤj�Ƨ�
    users.stream().sorted(Comparator.comparing(User::getName).thenComparing(User::getAge))
        .forEach(System.out::println);;

    // �O�_�Ҧ��H���W�r������b�o�Ӧr��?
    boolean allMatch = users.stream().allMatch(u -> u.getName().contains("b"));

    // �O�_�����@�ӤH���W�r��Annie?
    boolean anyMatch = users.stream().anyMatch(u -> u.getName().equals("Annie"));
  }

}
