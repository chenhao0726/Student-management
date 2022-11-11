package test;

import com.chen.domain.User;
import com.chen.service.IUserService;
import com.chen.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {
    private IUserService service = new UserServiceImpl();

    @Test
    public void selectByName() {
        User user = service.selectByName("admin");
        System.out.println(user);
    }
}
