package repositiories;
import java.util.List;
import domain.User;

public interface UserRepository {
	User getUserByUsername(String username);
	void add(User user);
	List<User> getAllUsers();
	int count();
}