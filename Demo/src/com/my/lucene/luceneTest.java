package com.my.lucene;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;


/**
 * Author：Jiang
 * Date：2020/1/12
 * Time：22:34
 * lucene演示
 */
public class luceneTest {

    private final static Logger logger = Logger.getLogger(luceneTest.class);

    /**
     * 创建索引
     * @throws IOException
     */
    @Test
    public void luceneCreate() throws IOException {
        //1.创建Director对象，指定索引库保存的位置
        //Directory directory =new RAMDirectory(); //保存到内存中

        //保存到磁盘中
        Directory directory = FSDirectory.open(new File("D:\\lucene\\index").toPath());

        //2.基于Directory创建一个IndexWriter对象
        IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig());//默认StandardAnalyzer
        //IndexWriter indexWriter = new IndexWriter(directory,new IndexWriterConfig(new IKAnalyzer()));可以修改

        //3.读取磁盘的文件，对应每个文件创建一个文档对象
        File dir = new File("D:\\lucene\\searchsource");
        File[] files = dir.listFiles();
        //遍历所有文件
        for (File f : files) {
            //文件名
            String fName = f.getName();
            //路径
            String fPath = f.getPath();
            //大小
            long size = FileUtils.sizeOf(f);
            //内容
            String fContent = FileUtils.readFileToString(f,"utf-8");

            //4.创建Field--每个属性对应一个
            //域名称+域内容+是否存储
            TextField fieldName = new TextField("name",fName,Field.Store.YES);
            TextField fieldPath = new TextField("path",fPath,Field.Store.YES);
            TextField fieldSize = new TextField("size",size+"",Field.Store.YES);
            TextField fieldContent = new TextField("content",fContent,Field.Store.YES);

            //5.创建文档对象
            Document document = new Document();
            document.add(fieldName);
            document.add(fieldPath);
            document.add(fieldSize);
            document.add(fieldContent);

            //6.文档写入索引库
            indexWriter.addDocument(document);
        }
        //7.关闭indexWriter
        indexWriter.close();
    }

    /**
     * 查询索引
     * @throws IOException
     */
    @Test
    public void luceneQuery() throws  IOException{
        //1.创建Directory
        Directory directory = FSDirectory.open(new File("D:\\lucene\\index").toPath());

        //2.创建IndexReader对象
        IndexReader indexReader = DirectoryReader.open(directory);

        //3.创建IndexSearcher对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        //4.创建一个Query对象 TermQuery      要查询的域名称+域内容
        Query query = new TermQuery(new Term("content","spring"));

        //5.执行查询-》TopDocs对象
        TopDocs topDocs = indexSearcher.search(query, 10);//最大记录数
        System.out.println("总记录数："+topDocs.totalHits);

        //6.得到文档列表
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        //7.遍历所有文档
        for (ScoreDoc doc:scoreDocs) {
            //得到文档id
            int docId = doc.doc;
            //根据文档id——>Document对象
            Document document = indexSearcher.doc(docId);
            System.out.println("name："+document.get("name"));
            System.out.println("path："+document.get("path"));
            System.out.println("size："+document.get("size"));
          //System.out.println(document.get("name"));
        }
        //关闭indexReader
        indexReader.close();
    }

    /**
     * 标准分析器
     * @throws IOException
     */
    @Test
    public void lunceneTokenStream() throws IOException {
        //1.创建Analyzer对象
//        Analyzer analyzer = new Standarnalyzer();
        Analyzer analyzer = new IKAnalyzer(); //中文分析器

        //2.创建TokenStream对象
//        TokenStream tokenStream = analyzer.tokenStream("", "God is a girl");
        //中文分析器会先加载hotword：配置成一个词       stopword：停用词，过滤掉这个词
        TokenStream tokenStream = analyzer.tokenStream("", "2017年12月14日 - 传智播客Lucene概述公安局Lucene是一款高性能的、可扩展的信息检索(IR)工具库。信息检索是指文档搜索、文档内信息搜索或者文档相关的元数据搜索等操作。");

        //3.设置引用
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);

        //4.调用reset()，否则抛异常
        tokenStream.reset();

        //5.遍历TokenStream
        while (tokenStream.incrementToken()){
            System.out.println(charTermAttribute.toString());
        }

        //6.关闭tokenStream
        tokenStream.close();
    }

    /**
     * 删除索引
     */
    //indexWriter.deleteAll();

    /**
     * 根据条件删除
     */
    //indexWriter.deleteDocuments(new Term("name","spring"));

    /**
     *更新索引（先删除后添加）
     */
    //indexWriter.updateDocument(new Term("name","spring"),document); 修改后新增的document对象

    /**
     * 查询索引
     * 1.Query子类   TermQuery     RangeQuery
     * 2.QueryParse(自动分词后查询)
     */
    //QueryParse queryParse = new QueryParse("name",new IKAnalyzer()); 默认域+分析器对象
    //Query query = queryParse.parse("我左手一只太极拳");
}
