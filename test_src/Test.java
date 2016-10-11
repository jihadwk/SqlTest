import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wk.mybatis.inter.IUserOperation;
import com.wk.mybatis.model.User;

public class Test {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static {
		try{
			reader = Resources.getResourceAsReader("config/configration.xml");//代码配置mybatis 配置,可以在spring里配置sqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSession(){
		return sqlSessionFactory;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//mybatis配置文件
//		String resource = "Configration.xml";
		SqlSession session = sqlSessionFactory.openSession();
//		User user = session.selectOne("com.wk.mapper.UserMapper.selectUserByID",1);
		
		
		IUserOperation userOperation = session.getMapper(IUserOperation.class);
//		User user = userOperation.selectUserByID(3);
		User adduser = new User();
		adduser.setUserName("jacky");
		adduser.setUserAge(30);
		adduser.setUserAddress("任命广场");
		userOperation.addUser(adduser);
		session.commit();//增加和删除都要提交数据
		 System.out.println("当前增加的用户 id为:"+adduser.getId());
//		List<User>users = userOperation.selectUserList("summer");
//		for (User user2 : users) {
//			System.out.println("list:"+user2);
//		}
//		System.out.println(user);
		session.close();
	}

}
