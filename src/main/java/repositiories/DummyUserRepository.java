package repositiories;

import java.util.ArrayList;
import java.util.List;

import domain.User;
import domain.UserRank;

public class DummyUserRepository implements UserRepository {
	
	private static List<User> db
		= new ArrayList<User>();
	
	public DummyUserRepository(){
		if(db.size() == 0){
			User user = new User();
			user.setUsername("user");
			user.setPassword("user");
			user.setEmail("user@xd.pl");
			user.setRank(UserRank.USER);
			db.add(user);
			
			User premium = new User();
			premium.setUsername("premium");
			premium.setPassword("premium");
			premium.setEmail("premium@xd.pl");
			premium.setRank(UserRank.PREMIUM);
			db.add(premium);
			
			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword("admin");
			admin.setEmail("admin@xd.pl");
			admin.setRank(UserRank.ADMIN);
			db.add(admin);
		}
	}

	@Override
	public User getUserByUsername(String username) {
		for(User user: db){
			if(user.getUsername().equalsIgnoreCase(username))
				return user;
		}
		return null;
	}

	@Override
	public void add(User user) {
		db.add(user);
	}

	@Override
	public int count() {
		return db.size();
	}

	@Override
	public List<User> getAllUsers() {
		return this.db;
	}

}