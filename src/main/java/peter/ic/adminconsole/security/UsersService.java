package peter.ic.adminconsole.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import peter.ic.adminconsole.entity.Users;
import peter.ic.adminconsole.repository.UsersRepository;

import java.util.Collections;
import java.util.List;

/**
 * Класс формирующий сведения о пользователе, проходящем авторизацию, посредством запроса через клиент
 * к записям о зарегистрированных пользователях, содержащихся в базе данных
 */

@Service
public class UsersService implements UserDetailsService {

    /**
     * Объявление клиента, формирующего HTTP-запросы к серверной части приложения. Используется для получения
     * сведений о пользователе
     */

    final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Метод запрашивающий экземпляр класса {@link Users}, по совпадению имени пользователя,
     * введенного в форму авторизации
     *
     * @param username имя пользователя, передается из формы авторизации
     * @return экземпляр класса {@link UserDetails}, содержащий сведения о пользователе для дальнейшей аутентификации
     * @throws UsernameNotFoundException исключение, если по имени пользователя, нет соответствующей записи
     *                                   в базе данных зарегистрированных пользователей
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /*
          Создание экземпляра класса {@link Users}, поиск по имени пользователя, и присвоение значений экземпляра
          записи о пользователе
         */

        Users user = usersRepository.findByUsername(username);

        /*
          Проверка на null значение переменной user
         */

        if (user == null) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        if (!user.isActive() || !user.getDepartment().isActive()) {
            throw new UsernameNotFoundException("Пользователь заблокирован");
        }

        /*
        Создание единичного массива из значения о роли пользователя
         */

        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()));
        return new User(user.getUsername(), user.getPasswd(), authorities);
    }
}
