package backgammon04.backgammon04_persistence_db4o.model.dao.impl;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class AbstractDb4oDao {

	private ObjectContainer db;

	public ObjectContainer getdb() {
		if (db == null) {
			db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
					"user.data");
		}
		return db.ext().openSession();
	}

}
