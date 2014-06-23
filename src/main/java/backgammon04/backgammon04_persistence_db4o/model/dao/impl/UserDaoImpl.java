package backgammon04.backgammon04_persistence_db4o.model.dao.impl;

import java.util.List;

import backgammon04.model.User;
import backgammon04.model.dao.UserDao;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;

public class UserDaoImpl implements UserDao {

	private ObjectContainer db;

	public UserDaoImpl() {
		db = Db4oEmbedded
				.openFile(Db4oEmbedded.newConfiguration(), "user.data");
	}

	public void delete(User user) {
		db.delete(user);

	}

	public User get(final long id) {
		List<User> users = db.query(new Predicate<User>() {

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

	public User getByEmail(final String email) {
		List<User> users = db.query(new Predicate<User>() {

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

	public User getUser(final String username) {
		List<User> users = db.query(new Predicate<User>() {

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

	public void save(User user) {
		db.store(user);
	}

	public void closeDb() {
		db.close();
	}

}
