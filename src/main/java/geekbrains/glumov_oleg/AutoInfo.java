package geekbrains.glumov_oleg;

import org.springframework.stereotype.Service;

@Service
public class AutoInfo {

    public void notifyUser(User user) {
        System.out.println("Новый пользователь создан: " + user.getName());
    }


}
