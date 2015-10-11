package com.lucene.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.queryparser.classic.ParseException;
/*
 * The object represents the short, long query along with the number for that document.
 */
class Query{
	String shortQuery;
	String longQuery;
	int number;
	public Query(String shortQuery, String longQuery, int number) {
		super();
		this.shortQuery = shortQuery;
		this.longQuery = longQuery;
		this.number = number;
	}
	
}
/*
 * This class has an arraylist of class query.
 */
		
public class searchTrecTopics {
	ArrayList<Query> parseDoc=new ArrayList<Query>();
	static String pathToIndex="C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\index\\default";
	/*
	 * This method is used to parse the document topics.51-100
	 * and stores the object in the arraylist
	 */
	public void parseDocuments(){
		BufferedReader br = null;
		String docNo="";
		String sQuery="";
		String lQuery="";
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("C:/Users/Ramakant Khandel/Desktop/Course/Information Retrieval/Assignment 2/topics.51-100"));
			// String data="";
			while ((sCurrentLine = br.readLine()) != null) {
				// data+=sCurrentLine+"\n";
				if (sCurrentLine.contains("<num>")) {
					docNo = sCurrentLine.split(":")[1].trim();
				}
				if (sCurrentLine.contains("<title>")) {
					sQuery += sCurrentLine.substring(sCurrentLine.indexOf(":")+1) + "\n";
					while ((sCurrentLine = br.readLine()) != null) {
						if (sCurrentLine.contains("<desc>")) {
							break;
						} else {
							sQuery += sCurrentLine + "\n";
						}
					}
				}
				
				if (sCurrentLine.contains("<desc>")) {
					//sQuery += sCurrentLine.substring(14) + "\n";
					while ((sCurrentLine = br.readLine()) != null) {
						if (sCurrentLine.contains("<smry>")) {
							break;
						} else {
							lQuery += sCurrentLine + "\n";
						}
					}
				}
				
				if(docNo.length()>0 && sQuery.length()>0 && lQuery.length()>0){
					//System.out.println(docNo.trim());
					//System.out.println(sQuery.trim());
					//System.out.println(lQuery.trim());
					Query q=new Query(sQuery.trim(),lQuery.trim(),Integer.parseInt(docNo.trim()));
					parseDoc.add(q);
					docNo="";
					sQuery="";
					lQuery="";
				}
			}
		}
	
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
	}
	/*
	 * traverses through the arraylist and calls the respective similarity functions.
	 */
	public static void main(String args[]){
		searchTrecTopics t=new searchTrecTopics();
		t.parseDocuments();
		//System.out.println(Math.log10(2));
		//Query q=t.parseDoc.get(0);
		try {
			for(int i=0;i<t.parseDoc.size();i++){
				Query q=t.parseDoc.get(i);
				System.out.println(q.number+" : "+q.shortQuery);
				//easySearch.easySearch(q.number, q.shortQuery, 0);
				//String a="What Backing Does the National Rifle Association Have?";
				easySearch.easySearch(q.number, q.shortQuery.replaceAll("[/?]", ""), 0);
				easySearch.easySearch(q.number,q.longQuery.replaceAll("[/?]", " "),1);
				compareAlgorithm.bm25ShortQuery(q.number, q.shortQuery.replaceAll("/","//"));
				compareAlgorithm.bm25LongQuery(q.number, q.longQuery.replaceAll("/","//"));
				compareAlgorithm.lmdsShortQuery(q.number, q.shortQuery.replaceAll("/","//"));
				compareAlgorithm.lmdsLongQuery(q.number, q.longQuery.replaceAll("/","//"));
				compareAlgorithm.lmjmsShortQuery(q.number, q.shortQuery.replaceAll("/","//"));
				compareAlgorithm.lmjmsLongQuery(q.number, q.longQuery.replaceAll("/","//"));
				compareAlgorithm.vsmShortQuery(q.number, q.shortQuery.replaceAll("/","//"));
				compareAlgorithm.vsmLongQuery(q.number, q.longQuery.replaceAll("/","//"));
				
			}
			
		//}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
