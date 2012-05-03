package com.csr.common.dto;

import java.util.*;
import java.io.*;

public abstract class BaseDTO implements Serializable, Listable, Orderable /* Auditable */
{
	private Date dateCreated;
	private Date dateUpdated;
	private String /*User*/ userCreated;
	private String /*User*/ userUpdated;

    public BaseDTO()
    {
        super();
    }

	// Mapped /////////////////////////////////////////////////////

	public void setProperty(String key, String value)
	{
		set(key, value);
	}

	public String getProperty(String key)
	{
		Object obj = get(key);		
		return (obj == null) ? "" : obj.toString();
	}

	public void put(String key, Object value)
	{
		set(key, value);
	}

	public void setValue(String key, Object value) {
		set(key, value);
    }

    public Object getValue(String key) {
        return get(key);
    }

	private final List values = new ArrayList();

    public void setValue(int key, Object value) {
        values.set(key, value);
    }

    public Object getValue(int key) {
        return values.get(key);
    }

	////////////////////////////////////////////////////////////////////////

	public void set(String key, Object value)
	{
		map.put(key, value);
	}

	public Object get(String key)
	{
		return map.get(key);
	}

	public Map getMap()
	{
		return map;
	}

	// Listable /////////////////////////////////////////////////////

	protected String rownumber;

	public void setRownumber(String r)
	{
		this.rownumber = r;
		map.put("Rownumber", rownumber);
	}

	public String getRownumber()
	{
		return this.rownumber;
	}

	// Orderable ////////////////////////////////////////////////

	protected Map map = new LinkedHashMap();

	public abstract Map getOrder();

	public Map getValues()
	{
		/*
		HashMap hm = new LinkedHashMap();

		for ( Object o : getOrder() )
		{
			hm.put( o, map.get(o.toString()) );
		}
		
		return hm;
		*/
		return map;
	}

	public Iterator iterator()
	{
		return map.keySet().iterator();
	}

	// To String ////////////////////////////////////////////////

	public String toString()
	{
		String res = "";
		res = this.getClass().getName() + "\n";
		Map o = getOrder();
		
		Iterator it = o.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			String name = (String) o.get(key);
			Object value = map.get(key);
			res += name + ": " + value + "\n";
		}

		return res;
	}
}