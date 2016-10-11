import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wk.mybatis.inter.IUserOperation;
import com.wk.mybatis.model.User;

public class SpringTest {
	private static ApplicationContext context;
	static{
		context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUserOperation mapper = (IUserOperation) context.getBean("userMapper");
		User user = mapper.selectUserByID(1);
		System.out.println(user);
		List<User> list = mapper.selectUserList("jacky");
		for (User user2 : list) {
			System.out.println(user2);
		}
	}

}
