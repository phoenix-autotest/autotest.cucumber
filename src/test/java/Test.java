import cucumber.api.cli.Main;
import cucumber.api.java.ObjectFactory;
import cucumber.runtime.java.spring.SpringFactory;

public class Test {
    public static void main(String[] args) throws Throwable {
        System.setProperty(ObjectFactory.class.getName(), "com.surenpi.autotest.cucumber.PhoenixObjectFactory");
        Main.main(new String[]{"-g", "com.surenpi.autotest", "target/test-classes/"});
    }
}