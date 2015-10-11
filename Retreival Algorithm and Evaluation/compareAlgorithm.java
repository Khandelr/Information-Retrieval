package com.lucene.assignment2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.search.similarities.DefaultSimilarity;
import org.apache.lucene.search.similarities.LMDirichletSimilarity;
import org.apache.lucene.search.similarities.LMJelinekMercerSimilarity;
import org.apache.lucene.store.FSDirectory;

public class compareAlgorithm {
	public static void bm25ShortQuery(int no, String sQuery) throws IOException, ParseException {
		//String pathToIndex = "C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\index\\default";
		//String queryString = "Satellite Launch Contracts";
		File file = new File("C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\output\\BM25shortQuery.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
        
		IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(
				searchTrecTopics.pathToIndex)));
		IndexSearcher searcher = new IndexSearcher(reader);
		searcher.setSimilarity(new BM25Similarity()); 
		// You need to explicitly specify the
		// ranking algorithm using the respective Similarity class
		Analyzer analyzer = new StandardAnalyzer();
		QueryParser parser = new QueryParser("TEXT", analyzer);
		Query query = parser.parse(sQuery);
		TopScoreDocCollector collector = TopScoreDocCollector
				.create(1000, true);
		searcher.search(query, collector);
		ScoreDoc[] docs = collector.topDocs().scoreDocs;
		for (int i = 0; i < docs.length; i++) {
			Document doc = searcher.doc(docs[i].doc);
			//System.out.println(no+"\t"+0+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"BM25_short");
			output.write(no+"\t"+0+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"BM25_short");
			output.write("\n");
			
		}
		output.close();
		reader.close();
		
	}
	
	public static void lmdsShortQuery(int no, String sQuery) throws IOException, ParseException{
		//String pathToIndex = "C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\index\\default";
		//String queryString = "";
		File file = new File("C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\output\\LMDSshortQuery.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
        
		IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(
				searchTrecTopics.pathToIndex)));
		IndexSearcher searcher = new IndexSearcher(reader);
		searcher.setSimilarity(new LMDirichletSimilarity()); 
		// You need to explicitly specify the
		// ranking algorithm using the respective Similarity class
		Analyzer analyzer = new StandardAnalyzer();
		QueryParser parser = new QueryParser("TEXT", analyzer);
		Query query = parser.parse(sQuery);
		TopScoreDocCollector collector = TopScoreDocCollector
				.create(1000, true);
		searcher.search(query, collector);
		ScoreDoc[] docs = collector.topDocs().scoreDocs;
		for (int i = 0; i < docs.length; i++) {
			Document doc = searcher.doc(docs[i].doc);
			//System.out.println(no+"\t"+0+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"LMDS_short");
			output.write(no+"\t"+0+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"LMDS_short");
			output.write("\n");
			
		}
		output.close();
		reader.close();

	}

	public static void lmdsLongQuery(int no, String lQuery) throws IOException, ParseException{
		//String pathToIndex = "C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\index\\default";
		//String queryString = "";
		File file = new File("C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\output\\LMDSlongQuery.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
        
		IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(
				searchTrecTopics.pathToIndex)));
		IndexSearcher searcher = new IndexSearcher(reader);
		searcher.setSimilarity(new LMDirichletSimilarity()); 
		// You need to explicitly specify the
		// ranking algorithm using the respective Similarity class
		Analyzer analyzer = new StandardAnalyzer();
		QueryParser parser = new QueryParser("TEXT", analyzer);
		Query query = parser.parse(lQuery);
		TopScoreDocCollector collector = TopScoreDocCollector
				.create(1000, true);
		searcher.search(query, collector);
		ScoreDoc[] docs = collector.topDocs().scoreDocs;
		for (int i = 0; i < docs.length; i++) {
			Document doc = searcher.doc(docs[i].doc);
			//System.out.println(no+"\t"+0+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"LMDS_long");
			output.write(no+"\t"+1+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"LMDS_long");
			output.write("\n");
			
		}
		output.close();
		reader.close();
	}
	
	public static void lmjmsShortQuery(int no, String sQuery) throws IOException, ParseException{
		File file = new File("C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\output\\LMJMSshortQuery.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
        
		IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(
				searchTrecTopics.pathToIndex)));
		IndexSearcher searcher = new IndexSearcher(reader);
		searcher.setSimilarity(new LMJelinekMercerSimilarity(0.7f)); 
		// You need to explicitly specify the
		// ranking algorithm using the respective Similarity class
		Analyzer analyzer = new StandardAnalyzer();
		QueryParser parser = new QueryParser("TEXT", analyzer);
		Query query = parser.parse(sQuery);
		TopScoreDocCollector collector = TopScoreDocCollector
				.create(1000, true);
		searcher.search(query, collector);
		ScoreDoc[] docs = collector.topDocs().scoreDocs;
		for (int i = 0; i < docs.length; i++) {
			Document doc = searcher.doc(docs[i].doc);
			//System.out.println(no+"\t"+0+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"LMJMS_short");
			output.write(no+"\t"+0+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"LMJMS_short");
			output.write("\n");
			
		}
		output.close();
		reader.close();
	}
	
	public static void lmjmsLongQuery(int no, String lQuery) throws IOException, ParseException{
		File file = new File("C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\output\\LMJMSlongQuery.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
        
		IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(
				searchTrecTopics.pathToIndex)));
		IndexSearcher searcher = new IndexSearcher(reader);
		searcher.setSimilarity(new LMJelinekMercerSimilarity(0.7f)); 
		// You need to explicitly specify the
		// ranking algorithm using the respective Similarity class
		Analyzer analyzer = new StandardAnalyzer();
		QueryParser parser = new QueryParser("TEXT", analyzer);
		Query query = parser.parse(lQuery);
		TopScoreDocCollector collector = TopScoreDocCollector
				.create(1000, true);
		searcher.search(query, collector);
		ScoreDoc[] docs = collector.topDocs().scoreDocs;
		for (int i = 0; i < docs.length; i++) {
			Document doc = searcher.doc(docs[i].doc);
			//System.out.println(no+"\t"+0+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"LMJMS_long");
			output.write(no+"\t"+1+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"LMJMS_long");
			output.write("\n");
			
		}
		output.close();
		reader.close();
	}
	public static void vsmShortQuery(int no, String sQuery) throws IOException, ParseException{
		File file = new File("C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\output\\VSMshortQuery.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
        
		IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(
				searchTrecTopics.pathToIndex)));
		IndexSearcher searcher = new IndexSearcher(reader);
		searcher.setSimilarity(new DefaultSimilarity()); 
		// You need to explicitly specify the
		// ranking algorithm using the respective Similarity class
		Analyzer analyzer = new StandardAnalyzer();
		QueryParser parser = new QueryParser("TEXT", analyzer);
		Query query = parser.parse(sQuery);
		TopScoreDocCollector collector = TopScoreDocCollector
				.create(1000, true);
		searcher.search(query, collector);
		ScoreDoc[] docs = collector.topDocs().scoreDocs;
		for (int i = 0; i < docs.length; i++) {
			Document doc = searcher.doc(docs[i].doc);
			//System.out.println(no+"\t"+0+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"VSM_short");
			output.write(no+"\t"+0+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"VSM_short");
			output.write("\n");
			
		}
		output.close();
		reader.close();
	}
	public static void vsmLongQuery(int no, String lQuery) throws IOException, ParseException{
		File file = new File("C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\output\\VSMlongQuery.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
        
		IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(
				searchTrecTopics.pathToIndex)));
		IndexSearcher searcher = new IndexSearcher(reader);
		searcher.setSimilarity(new DefaultSimilarity()); 
		// You need to explicitly specify the
		// ranking algorithm using the respective Similarity class
		Analyzer analyzer = new StandardAnalyzer();
		QueryParser parser = new QueryParser("TEXT", analyzer);
		Query query = parser.parse(lQuery);
		TopScoreDocCollector collector = TopScoreDocCollector
				.create(1000, true);
		searcher.search(query, collector);
		ScoreDoc[] docs = collector.topDocs().scoreDocs;
		for (int i = 0; i < docs.length; i++) {
			Document doc = searcher.doc(docs[i].doc);
			//System.out.println(no+"\t"+0+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"VSM_long");
			output.write(no+"\t"+1+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"VSM_long");
			output.write("\n");
			
		}
		output.close();
		reader.close();
	}
	public static void bm25LongQuery(int no, String lQuery) throws IOException, ParseException{
		//String pathToIndex = "C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\index\\default";
		//String queryString = "";
		File file = new File("C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 2\\output\\BM25longQuery.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
        
		IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(
				searchTrecTopics.pathToIndex)));
		IndexSearcher searcher = new IndexSearcher(reader);
		searcher.setSimilarity(new BM25Similarity()); 
		// You need to explicitly specify the
		// ranking algorithm using the respective Similarity class
		Analyzer analyzer = new StandardAnalyzer();
		QueryParser parser = new QueryParser("TEXT", analyzer);
		Query query = parser.parse(lQuery);
		TopScoreDocCollector collector = TopScoreDocCollector
				.create(1000, true);
		searcher.search(query, collector);
		ScoreDoc[] docs = collector.topDocs().scoreDocs;
		for (int i = 0; i < docs.length; i++) {
			Document doc = searcher.doc(docs[i].doc);
			//System.out.println(no+"\t"+0+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"BM25_long");
			output.write(no+"\t"+1+"\t"+doc.get("DOCNO")+"\t"+(i+1)+"\t"+docs[i].score+"\t"+"BM25_long");
			output.write("\n");
			
		}
		output.close();
		reader.close();
	}

}
