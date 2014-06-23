package backgammon04.backgammon04_persistence_db4o.model.dao.impl;

import java.util.List;

import backgammon04.model.User;
import backgammon04.model.dao.UserDao;

import com.db4o.query.Predicate;

public class UserDaoImpl extends AbstractDb4oDao implements UserDao {

	public UserDaoImpl() {

	}

	@Override
	public void delete(User user) {
		getdb().delete(user);

	}

	@Override
	public User get(final long id) {
		List<User> users = getdb().query(new Predicate<User>() {

			private static final long serialVersionUID = 1L;

			public boolean match(User user) {
				return user.getId().equals(id);
			}
		});
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public User getByEmail(final String email) {
		List<User> users = getdb().query(new Predicate<User>() {

			private static final long serialVersionUID = 1L;

			public boolean match(User user) {
				return user.getEmail().equals(email);
			}
		});
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public User getUser(final String username) {
		List<User> users = getdb().query(new Predicate<User>() {

			private static final long serialVersionUID = 1L;

			public boolean match(User user) {
				return user.getUsername().equals(username);
			}
		});
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public void save(User user) {
		getdb().store(user);
	}

}
