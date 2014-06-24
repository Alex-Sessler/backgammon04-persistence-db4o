package backgammon04.backgammon04_persistence_db4o.model.dao.impl;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import backgammon04.backgammon04_persistence_db4o.model.impl.UserImpl;
import backgammon04.backgammon04_persistence_interface.model.User;
import backgammon04.backgammon04_persistence_interface.model.dao.UserDao;

@Ignore
public class UserTest {

	@Test
	public void a() {
		UserDao userDao = new UserDaoImpl();
	}

	@Test
	public void test() {
		UserDao userDao = new UserDaoImpl();

		User user = new UserImpl();
		user.setEmail("test@test.de");
		user.setPassword("test");
		user.setUsername("test");

		userDao.save(user);

		User byEmail = userDao.getByEmail("test@test.de");
		Assert.assertEquals(byEmail.getEmail(), "test@test.de");
	}

}
