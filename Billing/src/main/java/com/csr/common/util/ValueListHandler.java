package com.csr.common.util;

import java.util.*;
import com.csr.common.dao.*;

// ValueList 
// small footprint, easily stored in memory

public class ValueListHandler
{	
	private DAO dao;

	private int pgPtr;
	private int pgPtrSize = 0;
	private int pageSize;
	private int totalRecords;
	private int start;
	private int end;

	public int getStart() {  return start; }
	public int getEnd() { return end; }
	public int getTotal() { 	return totalRecords; }
	public int getPgPtr() { return pgPtr; }
	public int getPgPtrSize() { 	return pgPtrSize; }

	public ValueListHandler(DAO dao) throws Exception
	{
		this(dao, 10);
	}

	public ValueListHandler(DAO dao, int pageSize) throws Exception
	{
		this.dao = dao;
		this.pgPtr = 1;
		this.pageSize = pageSize;
		this.totalRecords = dao.countAll();

		if (pgPtrSize == 0)
			pgPtrSize = getPtrSize(this.totalRecords, this.pageSize);
	}

	public List page(int pgPtr) throws Exception
	{
		if (pgPtrSize == 0)
			pgPtrSize = getPtrSize(this.totalRecords, this.pageSize);

		if (pgPtr < 1)
			pgPtr = 1;

		if (pgPtr > pgPtrSize)
			pgPtr = pgPtrSize;

		this.pgPtr = pgPtr;
		start = calcStart();
		end = calcEnd();

//		if (start > totalRecords)
//			start = calcLastStartPage();

		if (pgPtr == pgPtrSize)
			end = totalRecords;

		String szStart = (start - 1) + "";
		List records = dao.search(szStart, pageSize);
		return records;
	}

	private int calcStart()
	{
		return ((pgPtr -1) * pageSize) + 1;
	}

	private int calcEnd()
	{
		return pgPtr * pageSize;
	}

	private int calcLastStartPage()
	{
		return ((pgPtrSize - 1) * pageSize) + 1;
	}

	private int getPtrSize(int totalRecords, int pageSize)
	{
		double ftotal = (double) totalRecords;
		double fpageSize = (double) pageSize;
		double result = ftotal / fpageSize;
		result = Math.ceil( result );
		return (int) result;
	}
}