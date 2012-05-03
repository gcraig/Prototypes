package com.csr.common.ejb;

import com.csr.clients.ejb.dto.*;
import com.csr.common.ejb.BaseEntityBean;
import java.rmi.*;
import java.util.*;
import java.sql.*;
import javax.naming.*;
import javax.ejb.*;
import javax.rmi.*;

public abstract class BaseEntityBean
{
	protected Object lookup(String binding)
	{
		try
		{
			Context context = new InitialContext();
			Object ref = context.lookup( binding );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}