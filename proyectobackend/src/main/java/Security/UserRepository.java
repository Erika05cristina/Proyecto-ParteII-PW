package Security;

import java.util.Optional;

import Dao.UserDao;
import Model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class UserRepository {

	@Inject
	private UserDao userDao;

	public Optional<User> findByUsEmail(String email) {
		User user = userDao.searchEmailUser(email);
		return user != null ? Optional.of(user) : Optional.empty();
	}
	
}