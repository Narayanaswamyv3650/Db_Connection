package com.mfno.ns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class synchronizeArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<String> namelist=Collections.synchronizedList(new ArrayList<String>());  or 
		CopyOnWriteArrayList<String> namelist = new CopyOnWriteArrayList<String>();

		namelist.add("Narayana");
		namelist.add("swamy");

		synchronized(namelist) {
			Iterator<String> iterator = namelist.iterator();
					while(iterator.hasNext()){
						System.out.println(iterator.next());
					}
		} 
	
	}

}
