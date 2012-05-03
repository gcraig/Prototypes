public class DAOFactory
{
	private static DAOFactory instance;

	private DAOFactory()
	{
	}

	public DAOFactory instance()
	{
		if (instance==null)
		{
			instance = new DAOFactory();
		}
		return instance;
	}

	public DAO createDAO(String daoName, 
}