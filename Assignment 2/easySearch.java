package com.lucene.assignment2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.AtomicReaderContext;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.DocsEnum;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.similarities.DefaultSimilarity;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

public class easySearch {
	/*
	 * This method computes the relevance score for the doc based on tf-idf values.
	 * 
	 */
	public static void easySearch(int no,String queryString,int s) throws IOException, ParseException {

		// Get the preprocessed query terms
		//String pathToIndex = "C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\index\\default";
		//String queryString = "man take browser";
		
		Analyzer analyzer = new StandardAnalyzer();
		QueryParser parser = new QueryParser("TEXT", analyzer);
		Query query = parser.parse(queryString);
		Set<Term> queryTerms = new LinkedHashSet<Term>();
		query.extractTerms(queryTerms);
//		for (Term t : queryTerms) {
//			System.out.println(t.text());
//		}
		IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(
				searchTrecTopics.pathToIndex)));
		// Use DefaultSimilarity.decodeNormValue(…) to decode normalized
		// document length
		DefaultSimilarity dSimi = new DefaultSimilarity();
		// Get the segments of the index
		// int count=1;
		List<AtomicReaderContext> leafContexts = reader.getContext().reader()
				.leaves();
		HashMap<Integer,Integer> queryDocs = new HashMap<Integer,Integer>();
		HashMap<String,HashMap<Integer,Float>> hm=new HashMap<String,HashMap<Integer,Float>>(); 
		int numberOfDoc = 0;
		for (int i = 0; i < leafContexts.size(); i++) {
			AtomicReaderContext leafContext = leafContexts.get(i);
			int startDocNo = leafContext.docBase;
			numberOfDoc += leafContext.reader().maxDoc();
			int count = 0;
			for (Term t : queryTerms) {

				DocsEnum de = MultiFields.getTermDocsEnum(leafContext.reader(),
						MultiFields.getLiveDocs(leafContext.reader()), "TEXT",
						new BytesRef(t.text()));
				if (de != null) {
					int doc;
					while ((doc = de.nextDoc()) != DocsEnum.NO_MORE_DOCS) {
						float normDocLeng = dSimi.decodeNormValue(leafContext.reader().getNormValues("TEXT")
								.get(de.docID()));
						//System.out.println(leafContext.reader().document(de.docID()).get("DOCNO"));
						
						if(hm.get(leafContext.reader().document(de.docID()).get("DOCNO"))==null){
							HashMap<Integer,Float> h=new HashMap<Integer,Float>();
							h.put(count, (float)de.freq()/normDocLeng);
							hm.put(leafContext.reader().document(de.docID()).get("DOCNO"), h);
						}
						else{
							HashMap<Integer,Float> h=hm.get(leafContext.reader().document(de.docID()).get("DOCNO"));
							h.put(count, (float)de.freq()/normDocLeng);
						}
						if (queryDocs.get(count) !=null) {
							int f=queryDocs.get(count);
							//queryDocs.remove(count);
							queryDocs.put(count,  f+ 1);
						} else {
							queryDocs.put(count, 1);

						}
					}
				}
				count++;
			}
		}
//		for(int key:hm.keySet()){
//			System.out.print(key +" : ");
//			for(int k:hm.get(key).keySet()){
//				System.out.print(hm.get(key).get(k)+"\t");
//			}
//			System.out.println();
//		}
		HashMap<String,Float> queryScore=new HashMap<String,Float>();
		for(String h:hm.keySet()){
			HashMap<Integer,Float> hValue=hm.get(h);
			float queryScr=0;
			for(int key:hValue.keySet()){
				float f=(float)numberOfDoc/(float)queryDocs.get(key);
				queryScr+=hValue.get(key)*Math.log10(1+(f));
			}
			queryScore.put(h, queryScr);
		}
//		for(int key: queryScore.keySet()){
//			System.out.println(key +" : "+queryScore.get(key));
//		}
//		System.out.println(hm.get(1));
		queryScore=sortByComparator(queryScore);
		printMap(queryScore, no, s);
	}
	/*
	 * This method prints the result in the respective files based on the short or long query
	 */
	public static void printMap(HashMap<String, Float> map, int no, int s) throws IOException {
		File file = null;
        int i=1;
        String easy="";
        if(s==1){
        	easy="easySearch_long";
        	file = new File("C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\output\\EasySearchLongQuery.txt");
        }
        else{
        	file = new File("C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\output\\EasySearchShortQuery.txt");
        	easy="easySearch_short";
        }
        BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
        int iCounter=1;
        for (Map.Entry<String, Float> entry : map.entrySet()) {
			//System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
			output.write(no+"\t"+s+"\t"+entry.getKey()+"\t"+(iCounter++)+"\t"+entry.getValue()+"\t"+easy);
			output.write("\n");
			if(iCounter==1001){
				break;
			}
		}
        output.close();
	}
	
	/*
	 * Sort the hashmap based on the values and returns the sorted hashmap.
	 */
	public static HashMap<String, Float> sortByComparator(Map<String, Float> unsortMap) {
		 
		List<Map.Entry<String, Float>> list = 
			new LinkedList<Map.Entry<String, Float>>(unsortMap.entrySet());
 
		Collections.sort(list, new Comparator<Map.Entry<String, Float>>() {
			public int compare(Map.Entry<String, Float> o1,
                                           Map.Entry<String, Float> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
 
		HashMap<String, Float> sortedMap = new LinkedHashMap<String, Float>();
		for (Iterator<Map.Entry<String, Float>> it = list.iterator(); it.hasNext();) {
			Map.Entry<String, Float> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
 
}
