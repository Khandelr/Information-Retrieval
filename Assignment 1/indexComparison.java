package com.lucene.assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.Version;


public class indexComparison {
	static String docNo = "";
	static String head = "";
	static String byline = "";
	static String dateline = "";
	static String text = "";

	
	/*
	 * prints the docno, head, byline, dateline and text for a particular docno
	 */
	public static void printDetails() {
		System.out.println("docNo: " + docNo);
		System.out.println("head : " + head);
		System.out.println("byline : " + byline);
		System.out.println("dateline : " + dateline);
		System.out.println("text : " + text);
		System.out.println("---------------------------------------------------------------------------------------------------------------");
	}
	/*
	 * It initializes the head, text, dateline, byline and docno to their default values
	 */
	public static void getInitialize() {
		docNo = "";
		head = "";
		byline = "";
		dateline = "";
		text = "";
	}
	/*
	 * It traverses the entire trectext file to find the docno, head, byline, dateline and text
	 * And then stores it in a Document 
	 */
	static void indexFileWithIndexWriter(IndexWriter indexWriter, File f,
			String suffix) throws IOException {

		if (f.isHidden() || f.isDirectory() || !f.canRead() || !f.exists()) {
			return;
		}
		if (suffix != null && !f.getName().endsWith(suffix)) {
			return;
		}
		BufferedReader br = null;
		 
		try {	
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(f));
			//String data="";
			while ((sCurrentLine = br.readLine()) != null) {
				//data+=sCurrentLine+"\n";
				if(sCurrentLine.contains("<DOCNO>") && sCurrentLine.contains("</DOCNO>")){
					docNo=sCurrentLine.substring(7,sCurrentLine.length()-8);
				}
				if(sCurrentLine.contains("<HEAD>")){
					if(sCurrentLine.contains("</HEAD")){
						head+=sCurrentLine.substring(6,sCurrentLine.length()-7)+" ";
					}
					else{
						head+=sCurrentLine.substring(6)+"\n";
						while((sCurrentLine = br.readLine()) != null){
							if(sCurrentLine.contains("<HEAD>")){
								head+=sCurrentLine.substring(6)+"\n";
							}
							else if (sCurrentLine.contains("</HEAD>")){
								head+=sCurrentLine.substring(0,sCurrentLine.length()-7)+"\n";
								break;
							}
							else{
								head+=sCurrentLine+"\n";
							}
						}
					}
				}
				if(sCurrentLine.contains("<BYLINE>")){
					if(sCurrentLine.contains("</BYLINE>")){
						byline+=sCurrentLine.substring(8,sCurrentLine.length()-9)+" ";
					}
					else{
						byline+=sCurrentLine.substring(8)+"\n";
						while((sCurrentLine = br.readLine()) != null){
							if(sCurrentLine.contains("<BYLINE>")){
								byline+=sCurrentLine.substring(8)+"\n";
							}
							else if (sCurrentLine.contains("</BYLINE>")){
								byline+=sCurrentLine.substring(0,sCurrentLine.length()-9)+"\n";
								break;
							}
							else{
								byline+=sCurrentLine+"\n";
							}
						}
					}
				}
				if(sCurrentLine.contains("<DATELINE>")){
					if(sCurrentLine.contains("</DATELINE>")){
						dateline+=sCurrentLine.substring(10,sCurrentLine.length()-11)+" ";
					}
					else{
						dateline+=sCurrentLine.substring(10)+"\n";
						while((sCurrentLine = br.readLine()) != null){
							if(sCurrentLine.contains("<DATELINE>")){
								dateline+=sCurrentLine.substring(10)+"\n";
							}
							else if (sCurrentLine.contains("</DATELINE>")){
								dateline+=sCurrentLine.substring(0,sCurrentLine.length()-11)+"\n";
								break;
							}
							else{
								dateline+=sCurrentLine+"\n";
							}
						}
					}
				}
				if(sCurrentLine.contains("<TEXT>")){
					if(sCurrentLine.contains("</TEXT>")){
						text+=sCurrentLine.substring(6,sCurrentLine.length()-7)+" ";
					}
					else{
						text+=sCurrentLine.substring(6)+"\n";
						while((sCurrentLine = br.readLine()) != null){
							if(sCurrentLine.contains("<TEXT>")){
								text+=sCurrentLine.substring(6)+"\n";
							}
							else if (sCurrentLine.contains("</TEXT>")){
								text+=sCurrentLine.substring(0,sCurrentLine.length()-7)+"\n";
								break;
							}
							else{
								text+=sCurrentLine+"\n";
							}
						}
					}
				}
				if(sCurrentLine.contains("</DOC>")){
					//printDetails();
					Document doc = new Document();
					if (docNo.length() > 0) {
						doc.add(new StringField("DOCNO", docNo.toString(),
								Field.Store.YES));
					}
					if (head.length() > 0) {
						doc.add(new TextField("HEAD", head.toString(),
								Field.Store.YES));
					}
					if (byline.length() > 0) {
						doc.add(new TextField("BYLINE", byline.toString(),
								Field.Store.YES));
					}
					if (dateline.length() > 0) {
						doc.add(new TextField("DATELINE",
								dateline.toString(), Field.Store.YES));
					}
					if (text.length() > 0) {
						doc.add(new TextField("TEXT", text.toString(),
								Field.Store.YES));
					}
					indexWriter.addDocument(doc);
			
					getInitialize();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/*
	 * This method accepts data directory and traverses through all the 
	 * files in the data directory
	 */
	static void indexDirectory(IndexWriter indexWriter, File dataDir,
			String suffix) throws IOException {

		File[] files = dataDir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			//long startTime = System.nanoTime();
			
			indexFileWithIndexWriter(indexWriter, f, suffix);
			//long endTime = System.nanoTime();
			//System.out.println(endTime-startTime);
			
			//System.out.println(f.getCanonicalPath());

		}

	}
	/*
	 * This method accepts index directory path
	 * Traverses the index to print the details 
	 */
	public static void readData(String pathToIndex) throws IOException{
		IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(pathToIndex)));
		
		//Print the total number of documents in the corpus
		System.out.println("Total number of documents in the corpus:"+reader.maxDoc());
		
		//Print the number of documents containing the term "new" in<field>TEXT </field>.
		System.out.println("Number of documents containing the term\"new\" forfield\"TEXT\": "+reader.docFreq(new Term("TEXT","new")));
		
		//Print the total number of occurrences of the term "new" across all documents for <field>TEXT</field>.
		System.out.println("Number of occurences of\"new\" in the field\"TEXT\": "+reader.totalTermFreq(new Term("TEXT","new")));
		
		Terms vocabulary = MultiFields.getTerms(reader,"TEXT");
		
		//Print the size of the vocabulary for <field>content</field>, only available per -segment.
		System.out.println("Size of the vocabulary for this field:"+vocabulary.size());
		//Print the total number of documents that have at least one term for <field> TEXT</field>
		System.out.println("Number of documents that have at least one term for this field: " +vocabulary.getDocCount());
		//Print the total number of tokens for <field> TEXT</field>
		
		System.out.println("Number of tokens for this field:"+vocabulary.getSumTotalTermFreq());
		//Print the total number of postings for <field> TEXT </field>
		System.out.println("Number of postings for this field:"+vocabulary.getSumDocFreq());
		//Print the vocabulary for <field>TEXT</field>
		TermsEnum iterator =vocabulary.iterator(null);
		
//		BytesRef byteRef =null;
//		
//		System.out.println("\n*******Vocabulary-Start**********");
//		while((byteRef = iterator.next()) !=null) {
//			String term = byteRef.utf8ToString();
//			System.out.print(term+"\t");
//		}
//		
//		System.out.println("\n*******Vocabulary-End**********");
		
		reader.close();
	
	}
	/**
	 * Path for the index and data directory is set
	 * IndexWriterConfig is initialized depending upon the analyzer
	 * First the index is created for the corpus and then the index is read
	 * @param args
	 */
	public static void main(String args[]) {
		String indexPath = "C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 1\\index";
		String dataPath = "C:\\Users\\Ramakant Khandel\\Desktop\\Course\\Information Retrieval\\Assignment 1\\corpus\\corpus";
		Directory dir = null;
		try {
			dir = FSDirectory.open(new File(indexPath));
			File dataDir = new File(dataPath);
			Analyzer analyzer=null;
			Scanner sc = new Scanner(System.in);
		    System.out.println("Select :");
		    System.out.println("1: Standard Analyzer");
		    System.out.println("2: Simple Analyzer");
		    System.out.println("3: Keyword Analyzer");
		    System.out.println("4: Stopword Analyzer");
		    int no=Integer.parseInt(sc.nextLine());
		    if(no==1){
		    	analyzer = new StandardAnalyzer();
				
		    }
		    else if(no==2){
		    	analyzer = new SimpleAnalyzer();
				
		    }
		    else if(no==3){
		    	analyzer = new KeywordAnalyzer();
				
		    }else {
		    	analyzer = new StopAnalyzer();
				
		    }
			IndexWriterConfig iwc = new IndexWriterConfig(
					Version.LUCENE_4_10_0, analyzer);
			iwc.setOpenMode(OpenMode.CREATE);
			IndexWriter writer = new IndexWriter(dir, iwc);
			indexDirectory(writer, dataDir, "trectext");
			writer.forceMerge(1);
			writer.commit();
			writer.close();
			readData(indexPath);	

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
