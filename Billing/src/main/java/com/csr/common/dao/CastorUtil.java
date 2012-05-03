package com.csr.stubs.dao;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.Marshaller;
import java.io.IOException;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import org.xml.sax.InputSource;
import com.csr.common.dao.DAO;
import java.util.*;

public class CastorUtil
{
	public CastorUtil()
	{
	}

	/*
	public void setMapping(String mappingFile, String dataFile)
	{
		this.mappingFile = mappingFile;
		this.dataFile = dataFile;
	}

	private String mappingFile;

	private String dataFile;
	*/

	public Object fetch(String mappingFile, String dataFile)
	{
		Mapping mapping = new Mapping();
		Object obj = null;

		try {
            // 1. Load the mapping information from the file
            mapping.loadMapping( mappingFile );

            // 2. Unmarshal the data
            Unmarshaller unmar = new Unmarshaller(mapping);
            obj = unmar.unmarshal(new InputSource(new FileReader(dataFile)));

            // 4. marshal the data with the total price back and print the XML in the console
            //Marshaller marshaller = new Marshaller(new OutputStreamWriter(System.out));
            //marshaller.setMapping(mapping);
            //marshaller.marshal(order);
        } catch (Exception e) {

			e.printStackTrace();
            //System.out.println(e);
	    }

		return obj;
	}
}