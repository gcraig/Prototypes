package com.csr.common.action;

import org.apache.struts.action.DynaActionForm;
import org.apache.commons.collections.SequencedHashMap;
import java.util.LinkedHashMap;

public class CustomDynaActionForm extends DynaActionForm
{
	public CustomDynaActionForm()
	{
		super();
		//this.dynaValues = new SequencedHashMap();	
	}
}