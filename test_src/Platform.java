import java.util.ResourceBundle;

public class Platform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String platform = System.getProperties().getProperty("os.name");
		String platform = System.getProperty("os.name");
		System.out.println(platform);
		if(System.getProperty("os.name").toUpperCase().indexOf("MAC OS")!=-1){
			System.out.println("true");
		}
		
		String userdir = System.getProperty("user.dir");//当前工作目录
		System.out.println("userdir:"+userdir);
		
		//ResourceBundle用来国际化，和Properties类作用差不多，比他更有用，语言国际化
		String teString = ResourceBundle.getBundle("test").getString("cc");
		System.out.println(teString);
	}

}
