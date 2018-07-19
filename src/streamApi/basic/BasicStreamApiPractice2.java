package streamApi.basic;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import functionalInterface.builtIn.User;

public class BasicStreamApiPractice2 {

	public static void main(String[] args) {
		
		List<User> users = User.createList();
		
		//印出所有人所有資訊
		
		//印出所有人的年齡
		
		//蒐集所有人的ID並存成List
		
		//蒐集所有年齡>=18的人並存成List
		
		//蒐集所有年齡>=18的人的id並存成List
		
		//計算所有人年齡總和
		
		//計算所有人年齡平均數
		
		//找出年齡最大和最小的人
//		users.stream().max(Comparator.comparing(User::getAge));
		
		//依性別做分類
		
		//
	}
}
